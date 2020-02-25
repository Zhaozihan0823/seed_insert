package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.common.PageInfo;
import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.service.CompanyService;
import com.oracle.vo.Company;

/**
 * Servlet implementation class CompanyServlet
 */
@WebServlet("/files/company.do")
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CompanyService cs = ServiceFactory.getObject(CompanyService.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");
		String flag = request.getParameter("flag");
		flag = flag == null?"list":flag;
		
		switch (flag) {
		 case "delete":
			 String[] ids=request.getParameterValues("delid");
			 cs.delete(ids);
			
			 response.sendRedirect("company.do?flag=list");
			 break;
		 
		 case "insert":
			 Company com = new Company();
			 String companyName = request.getParameter("companyName");
			 com.setCompanyName(companyName);
			 com.setLinkMan(request.getParameter("linkMan"));
			 com.setTel(request.getParameter("tel"));
			 com.setAddress(request.getParameter("address"));
			 com.setDescript(request.getParameter("descript"));
			 System.out.println(companyName);
			 System.out.println(com);
			 cs.insert(com);
			 response.sendRedirect("company.do?flag=list");
			 break;
		 
		 case "view":
			 cs.getCompanyById(Integer.valueOf(request.getParameter("companyId")));
			 request.getRequestDispatcher("viewkehuxinxi.jsp").forward(request, response);
			 break;
		 
		 default:
			 //List<Company> list = cs.getAllCompany();
			 
			 PageInfo pageInfo = new PageInfo(request);
			 cs.getCompanyForPage(pageInfo);
			 //request.setAttribute("list", list);
			 
			 request.getRequestDispatcher("listkehuxinxi.jsp").forward(request, response);
		}
		
		
	}

}
