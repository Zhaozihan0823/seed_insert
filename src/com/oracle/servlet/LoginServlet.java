package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.service.EmpService;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmpService empservice = ServiceFactory.getObject(EmpService.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获得请求参数
		String empno = request.getParameter("empno");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("code");
		String code = (String)request.getSession().getAttribute("code");
		System.out.println(code);
		System.out.println(checkcode);
		PrintWriter out=response.getWriter();
		
		Emp emp = empservice.login(empno, password);
		
		if(emp == null) {
			//登陆失败
			if(checkcode==null) {
				out.print("<script>alert('请输入验证码');window.location.href='login.html';</script>");
			}else if(checkcode.equals(code)) {
				out.print("<script>alert('验证码错误');window.location.href='login.html';</script>");
//				response.sendRedirect("login.html");
			}else {
				out.print("<script>alert('账号或密码错误');window.location.href='login.html';</script>");
//				response.sendRedirect("login.html");
			}
			
		}else {
			//登陆成功，将emp存在session中
			request.getSession().setAttribute("emp", emp);
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
