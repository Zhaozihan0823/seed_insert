package com.oracle.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.vo.Emp;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	List<String> list = new ArrayList<String>();
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		Emp emp = (Emp)session.getAttribute("emp");
		
		String uri = req.getRequestURI();
		String path = req.getContextPath();
		uri = uri.replaceAll(path, "");
		
		
		if(emp!=null) {
			chain.doFilter(request, response);
		}else {
			if(list.contains(uri)) {
				chain.doFilter(request, response);
			}else {
				res.sendRedirect("login.html");
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		list.add("/login.html");
		list.add("/login.do");
		list.add("/image");
		list.add("/css");
		list.add("/images");
		list.add("/js");
		//list.add("/index.jsp");
	}

}
