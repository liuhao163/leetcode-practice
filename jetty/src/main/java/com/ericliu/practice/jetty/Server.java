package com.ericliu.practice.jetty;

import com.ericliu.practice.jetty.common.DemoHealthCheck;
import com.ericliu.practice.jetty.servlet.ServletHandler;
import com.ericliu.practice.jetty.filter.MetricFilter;
import com.ericliu.practice.jetty.servlet.metrics.RestrictedMetricsServlet;
import com.ericliu.practice.jetty.servlet.user.UserServlet;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

/**
 * @Author: liuhaoeric
 * Create time: 2019/11/06
 * Description:
 */
public class Server {

    public static void main(String[] args) throws Exception {
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server();

        ServerConnector http = new ServerConnector(server);
        http.setPort(4000);
        http.setHost("127.0.0.1");
        http.setIdleTimeout(4000L);
        server.addConnector(http);

        http.getConnectionFactories().stream()
                .filter(x -> x instanceof HttpConnectionFactory)
                .forEach(x -> ((HttpConnectionFactory) x).getHttpConfiguration().setSendServerVersion(false));

        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/");

        ErrorHandler errorHandler = new ErrorHandler();
        errorHandler.setShowStacks(true);
        servletContextHandler.setErrorHandler(errorHandler);

        // default error handler for resources out of "context" scope
        server.addBean(errorHandler);

        new DemoHealthCheck().register();
        List<ServletHandler> handlers=new ArrayList<>();
        handlers.add(new ServletHandler("/uid",new UserServlet()));
        handlers.add(new ServletHandler("/metric",new RestrictedMetricsServlet()));
        initHandler(servletContextHandler,handlers);

        servletContextHandler.addFilter(MetricFilter.class,"/uid/*", EnumSet.of(DispatcherType.REQUEST));

        server.setHandler(servletContextHandler);
        server.start();
        server.join();
    }

    private static void initHandler(ServletContextHandler servletContextHandler, Collection<ServletHandler> servlets) {
        servlets.forEach(handler -> servletContextHandler.addServlet(new ServletHolder(handler.getServlet()), handler.getPath()));
    }
}