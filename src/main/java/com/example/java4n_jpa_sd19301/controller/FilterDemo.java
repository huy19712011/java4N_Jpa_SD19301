package com.example.java4n_jpa_sd19301.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(filterName = "FilterDemo")
@WebFilter(filterName = "FilterDemo", urlPatterns = "/filterInput")
public class FilterDemo implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String username = request.getParameter("name");
        String password = request.getParameter("password");

        // username == user; password == "123"
        if (username.equals("user") && password.equals("123")) {

            chain.doFilter(request, response);
        } else {

            out.println("Invalid username or password!");
        }

    }
}
