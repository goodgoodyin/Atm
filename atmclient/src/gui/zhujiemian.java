package gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Comm.Card;




public class zhujiemian extends JFrame{
	JButton btkehu,btguanliyuan;
	
	public void init(){
		
		Font font= new Font("仿宋加粗",Font.PLAIN,28);
		btkehu=new JButton("用户");
		btguanliyuan=new JButton("管理员");
		btguanliyuan.setMnemonic(KeyEvent.VK_ENTER); //填的是系统提供的按键，不是你自己写的，想选A建就KeyEvent.VK_A,这里表示 这样的快捷键为Alt+回车
		//Font font = new Font("TimesRoman", Font.PLAIN, 20);//设计字体显示效果 Font f = new Font(String 字体，int 风格，int 字号);
		Container container=this.getContentPane();
		JPanel panel = new JPanel(null);
		panel = new JPanel();
		
		JLabel lblwel = new JLabel("欢迎使用中国银行ATM系统");
		lblwel.setBounds(30,45,420,50);
		panel.add(lblwel);
		lblwel.setFont(font);
		
		JLabel lblwel1 = new JLabel("请选择您的操作:");
		lblwel1.setBounds(260,95,300,50);
		panel.add(lblwel1);
		lblwel1.setFont(font);
		
		container.add(panel);
		panel.add(btkehu);
		panel.add(btguanliyuan);

		btkehu.setBounds(620,460,180,80);
		btguanliyuan.setBounds(620,260,180,80);	
		btkehu.setFont(font);//设置组件当前使用的字体：setFont(Font fn)
		btguanliyuan.setFont(font);
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panel.setOpaque(false);
		
		//窗体大小
		this.setSize(1366,723);   
		panel.setLayout(null);
		
		this.setResizable(false);  //设置不可改变窗口大小
		this.setVisible(true);  //设置窗体为可见
		this.setTitle("02尹好  28肖瑞  31王婧");
		
		/*this.setLocation(350, 170);//窗体位置*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );    //点击关闭时发生的反应
		
			  
	//注册监听
		//点击“客户”按钮，关闭当前窗口，打开客户登陆界面
		btkehu.addActionListener(new ActionListener(){   
			public void actionPerformed(ActionEvent e){
				zhujiemian.this.dispose();
				new Login().init();
			}
		});
		
		btguanliyuan.addActionListener(new ActionListener(){   
			public void actionPerformed(ActionEvent e){
				zhujiemian.this.dispose();
				new Manager().init();
			}
		});
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new zhujiemian().init();
			new DemoWindow();

		 
		 			try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel") ;
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	
	}
}
