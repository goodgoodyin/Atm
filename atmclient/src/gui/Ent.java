package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Comm.Card;

public class Ent extends JFrame {
	String num;
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	
	JButton btm1,btm2,btm3;
	public Ent(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	
	public void init(){
		    Font font= new Font("仿宋加粗",Font.PLAIN,18);
		    JPanel panel1=new JPanel(false);
			JPanel panelEnt = new JPanel(null);
			JLabel label11=new JLabel("娱乐分红");
			panel1.add(label11);
			label11.setFont(font);
			
			
			URL url1=Donate.class.getResource("b1.jpg");
			ImageIcon img1 = new ImageIcon(url1);
			JLabel background1 = new JLabel(img1);
			panel1.add(background1, new Integer(Integer.MIN_VALUE));
			background1.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());
			JLabel label12=new JLabel("  贺岁巨制《摆渡人》等你来做出品人 ");
			panel1.add(label12);
			label12.setFont(font);
			JLabel label13=new JLabel("       ");
			panel1.add(label13);
			label13.setFont(font);
			
			JLabel label14=new JLabel("目标 ：10000000000.00元 ");
			panel1.add(label14);
			label14.setFont(font);
			JLabel label15=new JLabel("       ");
			panel1.add(label15);
			label15.setFont(font);
			btm1=new JButton("详细信息");
			panel1.add(btm1);
			btm1.setFont(font);
			panel1.setBounds(350,80,300,550);
			this.add(panel1);
			
			JPanel panel2=new JPanel(false);
			JLabel label21=new JLabel("造梦坊");
			panel2.add(label21);
            label21.setFont(font);
			URL url2=Donate.class.getResource("z1.jpg");
			ImageIcon img2 = new ImageIcon(url2);
			JLabel background2 = new JLabel(img2);
			panel2.add(background2, new Integer(Integer.MIN_VALUE));
			background2.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());
			JLabel label22=new JLabel(" 触及心灵文化之旅      ");
			panel2.add(label22);
			label22.setFont(font);
			JLabel label23=new JLabel("   行走世界的文化课程       ");
			panel2.add(label23);
			label23.setFont(font);
			JLabel label27=new JLabel("         ");
			panel2.add(label27);
			label27.setFont(font);
			btm2=new JButton("我要支持");
			panel2.add(btm2);
			btm2.setFont(font);
			JLabel label24=new JLabel("目标 :1000000.00元  ");
			panel2.add(label24);
			label24.setFont(font);
			
			JLabel label25=new JLabel("          ");
			panel2.add(label25);
			label25.setFont(font);
			JLabel label26=new JLabel("        ");
			panel2.add(label26);
			label26.setFont(font);
			panel2.setBounds(750,80,300,550);
			this.add(panel2);
			
			
			
			JPanel panel6=new JPanel(false);
			URL url6=Donate.class.getResource("4.jpg");
			ImageIcon img6 = new ImageIcon(url6);
			JLabel background6 = new JLabel(img6);
			panel6.add(background6, new Integer(Integer.MIN_VALUE));
			background6.setBounds(0, 0, img6.getIconWidth(), img6.getIconHeight());
			//panel6.setBounds(10,100,10,10);
			this.add(panel6);
		 	JPanel panel10=new JPanel(); 
			btm3=new JButton("退出");
		 	panel10.add(btm3);
			panel10.setBounds(10,10,100,50);

			panel10.setBounds(680,650,100,100);
		 	this.add(panel10);
		 	
			 try{
			        Image img7=ImageIO.read(this.getClass().getResource("2.jpg"));
			        this.setIconImage(img7);
			        }catch(IOException e){
			        	e.printStackTrace();
			        }
				
			 
			 	
			 	//Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
			 	
				this.setSize(1366,723);	
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
				 //设置不可改变窗口大小
				this.setResizable(false); 
				this.setTitle("02尹好  28肖瑞  31王婧");	
				this.setVisible(true);
				
				((JPanel) this.getContentPane()).setOpaque(false);
				URL url=MainFrame.class.getResource("4.jpg");
				 ImageIcon img = new ImageIcon(url);
				 JLabel background = new JLabel(img);
				 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
				 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
			     panelEnt.setOpaque(false);
				
			
				btm1.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new Baiduren(br, pw, currCard).init();
						Ent.this.dispose();
					}
					
				});
				btm2.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new Xingzou(br, pw, currCard).init();
					}
					
				});
				btm3.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new Cptc(br, pw, currCard).init();
						Ent.this.dispose();
					}
					
				});

			
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ent(null, null, null).init();
	}

}
