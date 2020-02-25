package com.oracle.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageCode {
	 //��֤�����
    private int count=4;
   //��֤���ȣ�������ÿ���ֵĿ��
    private int width=count*25;
   //��֤��߶�
    private int height=43;
   //ͼƬ��֤��key
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
   //����д��

   public BufferedImage getImage(){
       //ͼƬ������
       BufferedImage image = new BufferedImage(width,height,1);
       //��ñ�
       Graphics graphics = image.getGraphics();
       //���ó�ʼ����Ϊ��ɫ
       graphics.setColor(new Color(255,255,254));
       //��������ͼ��Ҳ���ǰ�ͼƬ�ȱ�Ϊ��ɫ
       graphics.fillRect(0,0,width,height);
       Random rd=new Random();
       //��������
       Font font=new Font("����",Font.PLAIN,25+rd.nextInt(8));
       graphics.setFont(font);
       char[] chars="qweCRYHrtasdfBxy678934VTGopNUFKuighjklzSXEDLOP12cvbnmQAZWJMI50".toCharArray();
       //����֤��
       for (int i = 0; i <count ; i++) {
           String string="";
           string+=chars[rd.nextInt(chars.length)]+"";
           graphics.setColor(new Color(rd.nextInt(254),rd.nextInt(254),rd.nextInt(254)));
           graphics.drawString(string,25*i+rd.nextInt(10),27+rd.nextInt(10));
           code+=string;
       }
       //���ŵ�
       for (int i = 0; i <5*count ; i++) {
           graphics.setFont(new Font("����",Font.PLAIN,20));
           String string=".";
           graphics.setColor(new Color(rd.nextInt(255),rd.nextInt(255),rd.nextInt(255)));
           graphics.drawString(string,rd.nextInt(width),rd.nextInt(height));
       }
//       //������
       for (int i = 0; i <count+count/2 ; i++) {
           graphics.setFont(new Font("����",Font.PLAIN,10));
           graphics.setColor(new Color(rd.nextInt(255),rd.nextInt(255),rd.nextInt(255)));
           graphics.drawLine(rd.nextInt(width),rd.nextInt(height),rd.nextInt(width),rd.nextInt(height));
       }
       //�黹��
       graphics.dispose();
    
       return image;
   }
}
