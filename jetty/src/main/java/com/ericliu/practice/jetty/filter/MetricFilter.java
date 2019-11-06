package com.ericliu.practice.jetty.filter;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.Timer;
import org.eclipse.jetty.http.HttpParser;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.codahale.metrics.MetricRegistry.name;
import static com.ericliu.practice.jetty.common.MerticUtil.metricRegistry;
import static com.ericliu.practice.jetty.common.MerticUtil.reqeust;

/**
 * @Author: liuhaoeric
 * Create time: 2019/11/06
 * Description:
 */
public class MetricFilter implements Filter {

    private final Histogram responseSizes = metricRegistry.histogram(name(HttpParser.RequestHandler.class, "response-sizes"));
    private final Timer timer = metricRegistry.timer(name(HttpParser.RequestHandler.class, "response-timer"));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        reqeust.mark();

        HttpServletResponse hsr = (HttpServletResponse) response;
        final Timer.Context context = timer.time();
        responseSizes.update(10);
        try {
            chain.doFilter(request, response);
        } finally {
            context.stop();
        }

    }

    @Override
    public void destroy() {
        System.out.println("Stopping filter");
    }
}
