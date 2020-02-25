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
		///设置页面内容为image形式
        response.setContentType("image/jpg");
        //防止乱码
        response.setCharacterEncoding("UTF-8");
        //定义获取验证码的对象
       ImageCode imageCode=new ImageCode();
        //得到图片缓冲区
        BufferedImage img = imageCode.getImage();
        //得到文字验证码
        String code = imageCode.getCode();
        request.getSession().setAttribute("code", code);
        //获得用户session
        HttpSession session = request.getSession();
        //将文字验证码保存到客户端session,方便验证
        session.setAttribute("imgcode",code);
        System.out.println("生成的验证码为："+code);
        //获得sevlet输出流
        OutputStream outputStream = response.getOutputStream();
        //写到客户端
        ImageIO.write(img,"jpg",outputStream);
        //关闭输出流
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
