package com.ericliu.practice.jetty.servlet;

import javax.servlet.Servlet;

/**
 * @Author: liuhaoeric
 * Create time: 2019/11/06
 * Description:
 */
public class ServletHandler  {
    protected String path;
    private Servlet servlet;

    public ServletHandler(String path, Servlet servlet) {
        this.path = path;
        this.servlet = servlet;
    }

    public String getPath() {
        return path;
    }

    public Servlet getServlet() {
        return servlet;
    }
}
