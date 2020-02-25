package com.oracle.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageCode {
	 //验证码个数
    private int count=4;
   //验证码宽度，且设置每个字的宽度
    private int width=count*25;
   //验证码高度
    private int height=43;
   //图片验证码key
    private String code="";
   public ImageCode() {
   }
   public ImageCode(int count, int width, int height) {
       this.count = count;
       this.width = width;
       this.height = height;
   }
   public int getCount() {
       return count;
   }
   public String getCode() {
       return code;
   }
   public int getWidth() {
       return width;
   }
   public int getHeight() {
       return height;
   }
   public void setCount(int count) {
       this.count = count;
       width=this.count*25;
   }

   public void setWidth(int width) {
       this.width = width;
   }

   public void setHeight(int height) {
       this.height = height;
   }
   //测试写入

   public BufferedImage getImage(){
       //图片缓冲区
       BufferedImage image = new BufferedImage(width,height,1);
       //获得笔
       Graphics graphics = image.getGraphics();
       //设置初始画笔为白色
       graphics.setColor(new Color(255,255,254));
       //画满整个图，也就是把图片先变为白色
       graphics.fillRect(0,0,width,height);
       Random rd=new Random();
       //设置字体
       Font font=new Font("宋体",Font.PLAIN,25+rd.nextInt(8));
       graphics.setFont(font);
       char[] chars="qweCRYHrtasdfBxy678934VTGopNUFKuighjklzSXEDLOP12cvbnmQAZWJMI50".toCharArray();
       //画验证码
       for (int i = 0; i <count ; i++) {
           String string="";
           string+=chars[rd.nextInt(chars.length)]+"";
           graphics.setColor(new Color(rd.nextInt(254),rd.nextInt(254),rd.nextInt(254)));
           graphics.drawString(string,25*i+rd.nextInt(10),27+rd.nextInt(10));
           code+=string;
       }
       //干扰点
       for (int i = 0; i <5*count ; i++) {
           graphics.setFont(new Font("宋体",Font.PLAIN,20));
           String string=".";
           graphics.setColor(new Color(rd.nextInt(255),rd.nextInt(255),rd.nextInt(255)));
           graphics.drawString(string,rd.nextInt(width),rd.nextInt(height));
       }
//       //干扰线
       for (int i = 0; i <count+count/2 ; i++) {
           graphics.setFont(new Font("宋体",Font.PLAIN,10));
           graphics.setColor(new Color(rd.nextInt(255),rd.nextInt(255),rd.nextInt(255)));
           graphics.drawLine(rd.nextInt(width),rd.nextInt(height),rd.nextInt(width),rd.nextInt(height));
       }
       //归还笔
       graphics.dispose();
    
       return image;
   }
}
