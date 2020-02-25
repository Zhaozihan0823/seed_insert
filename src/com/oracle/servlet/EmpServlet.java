package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.EmpService;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/files/emp.do")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmpService empService = new EmpService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		//ajax请求获得所有人员复选框
		if("getAllForAjax".equals(action)) {
			List<Emp> list = empService.getAll();
			request.setAttribute("list",list);
			request.getRequestDispatcher("empCheck.jsp").forward(request, response);
		}
	}

}
