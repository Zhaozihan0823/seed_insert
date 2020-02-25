package com.oracle.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.common.ImageCode;

/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/image")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		///����ҳ������Ϊimage��ʽ
        response.setContentType("image/jpg");
        //��ֹ����
        response.setCharacterEncoding("UTF-8");
        //�����ȡ��֤��Ķ���
       ImageCode imageCode=new ImageCode();
        //�õ�ͼƬ������
        BufferedImage img = imageCode.getImage();
        //�õ�������֤��
        String code = imageCode.getCode();
        request.getSession().setAttribute("code", code);
        //����û�session
        HttpSession session = request.getSession();
        //��������֤�뱣�浽�ͻ���session,������֤
        session.setAttribute("imgcode",code);
        System.out.println("���ɵ���֤��Ϊ��"+code);
        //���sevlet�����
        OutputStream outputStream = response.getOutputStream();
        //д���ͻ���
        ImageIO.write(img,"jpg",outputStream);
        //�ر������
        if(outputStream!=null){
            outputStream.close();
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
