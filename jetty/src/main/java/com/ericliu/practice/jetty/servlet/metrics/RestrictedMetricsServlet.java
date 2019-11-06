package com.ericliu.practice.jetty.servlet.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.servlets.MetricsServlet;
import com.ericliu.practice.jetty.common.MerticUtil;
import org.apache.commons.io.output.WriterOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liuhaoeric
 * Create time: 2019/11/06
 * Description:
 */
public class RestrictedMetricsServlet extends MetricsServlet {

    public RestrictedMetricsServlet() {
        super(MerticUtil.metricRegistry);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Boolean.parseBoolean(req.getParameter("brief"))) {
            resp.setContentType("text/plain; charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Node mode: active.");
            ConsoleReporter reporter = ConsoleReporter.forRegistry(MerticUtil.metricRegistry)
                    .convertRatesTo(TimeUnit.SECONDS)
                    .convertDurationsTo(TimeUnit.MILLISECONDS)
                    .outputTo(new PrintStream(new WriterOutputStream(resp.getWriter(), StandardCharsets.UTF_8), false,
                            StandardCharsets.UTF_8.name()))
                    .build();
            reporter.report();
            resp.getWriter().flush();


        } else {
            super.doGet(req, resp);
        }
    }
}