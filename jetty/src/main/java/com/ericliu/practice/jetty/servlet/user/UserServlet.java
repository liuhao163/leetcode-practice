package com.ericliu.practice.jetty.servlet.user;

import com.alibaba.fastjson.JSONObject;
import com.codahale.metrics.Gauge;
import com.ericliu.practice.jetty.common.MerticUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: liuhaoeric
 * Create time: 2019/11/06
 * Description:
 */
public class UserServlet extends HttpServlet {

    private static Set<String> container = new HashSet<>();

    static {
        MerticUtil.registerGuage(container.getClass(), new Gauge<Integer>() {
            @Override
            public Integer getValue() {
                return container.size();
            }
        }, "userContainer", "size");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        String uid = req.getParameter("uid");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("get", uid);
        resp.getWriter().println(jsonObject.toJSONString());
        resp.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        String uid = req.getParameter("uid");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("post", uid);
        container.add(uid);
        resp.getWriter().println(jsonObject.toJSONString());

        resp.getWriter().flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        String uid = req.getParameter("uid");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("put", uid);
        resp.getWriter().println(jsonObject.toJSONString());
        resp.getWriter().flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        String uid = req.getParameter("uid");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("delete", uid);
        container.remove(uid);
        resp.getWriter().println(jsonObject.toJSONString());
        resp.getWriter().flush();
    }

}
