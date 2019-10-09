package com.softserve.itacademy.ToBuyList.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/itemPage")
public class ItemPageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession httpSession = req.getSession(false);

        if(httpSession==null||httpSession.getAttribute("id")==null){
            req.getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
        } else {
            filterChain.doFilter(req,resp);
        }


    }

    @Override
    public void destroy() {

    }
}
