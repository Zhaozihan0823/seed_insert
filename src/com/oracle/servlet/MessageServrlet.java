package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.service.ReceiveMessageService;
import com.oracle.service.SendMessageService;
import com.oracle.util.Tools;
import com.oracle.vo.Emp;
import com.oracle.vo.SendMessage;

/**
 * Servlet implementation class MessageServrlet
 */
@WebServlet("/files/message.do")
public class MessageServrlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	SendMessageService sm = ServiceFactory.getObject(SendMessageService.class);
    ReceiveMessageService rms = ServiceFactory.getObject(ReceiveMessageService.class);
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServrlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		Emp emp = (Emp)(request.getSession().getAttribute("emp"));
		
		//����Ϣ
		if("send".equals(action)) {
			SendMessage message = new SendMessage();
			message.setEmpId(emp.getEmpid());
			message.setPriority(Integer.valueOf(request.getParameter("priority")));
			message.setMessageTitle(request.getParameter("messageTitle"));
			message.setMessageContent(request.getParameter("messageContent"));
			//��������ռ��˵�id
			String[] receiveEmp = request.getParameterValues("receiveEmpId");
			//���������ݿ��в�������
			sm.send(message, Tools.covert(receiveEmp));
			
			response.sendRedirect("sendxiaoxi.jsp");
		//�ռ���
		}else if("listReceiveMessage".equals(action)) {
			List<Object[]> list = rms.getReceiveMessage(emp.getEmpid());
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("listtakexiaoxi.jsp").forward(request, response);
		//ɾ����Ϣ
		}else if("removeReceiveMessage".equals(action)) {
			Integer receiveId = Integer.valueOf(request.getParameter("receiveId"));
			System.out.println(receiveId);
			rms.removeReceiveMessage(receiveId);
			response.sendRedirect("message.do?action=listReceiveMessage");
		//��ʾ��Ϣ����
		}else if("viewReceiveMessage".equals(action)) {
			String open = request.getParameter("open");
			Integer receiveId = Integer.valueOf(request.getParameter("receiveId"));
			//���Ĵ�ʱ��
			if("no".equals(open)) {
				rms.updateOpenDate(receiveId);
			}
			//�鿴��Ϣ����
			Object[] message= rms.getReceiveMessageForId(receiveId);
			request.setAttribute("m", message);
			//ת������Ϣ����ҳ
			request.getRequestDispatcher("viewMessageInfo.jsp").forward(request, response);
			
		}else if("listSendMessage".equals(action)) {
			
			List<Object[]> list = sm.getSendMessageForEmpId(emp.getEmpid());
			request.setAttribute("list", list);
			request.getRequestDispatcher("listsendxiaoxi.jsp").forward(request, response);
			//response.sendRedirect("listsendxiaoxi.jsp");
			
		}else if("viewSendMessage".equals(action)) {
			Integer sendId = Integer.valueOf(request.getParameter("sendId"));
			Object[] obj = sm.getSendMessageForSendId(sendId);
			request.setAttribute("emp", emp);
			request.setAttribute("obj", obj);
			request.getRequestDispatcher("viewSendXiaoxi.jsp").forward(request, response);
			
		}else if("deleteSendMessage".equals(action)) {
			Integer sendId = Integer.valueOf(request.getParameter("sendId"));
			sm.removeSenMessage(sendId);
			request.getRequestDispatcher("message.do?action=listSendMessage").forward(request, response);
		}
		 
	}

}
