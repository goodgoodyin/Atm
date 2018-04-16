package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Comm.Card;

public class Consult extends JFrame{
	
	JButton btHuman,btQuery,btJindu,btSafe,btBao;
	JButton bt1,bt2,bt3;
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	public Consult(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	public void init(){
		Font font= new Font("仿宋加粗",Font.PLAIN,28);
		JPanel panel=new JPanel(null);
		btHuman=new JButton("人工服务");
		btHuman.setBounds(30,100,160,60);
		panel.add(btHuman);
		btHuman.setFont(font);
		btQuery=new JButton("交易查询");
		btQuery.setBounds(30,320,160,60);
		panel.add(btQuery);
		btQuery.setFont(font);
		btJindu=new JButton("进度中心");
		btJindu.setBounds(30,440,160,60);
		panel.add(btJindu);
		btSafe.setFont(font);
		btSafe=new JButton("账户安全");
		btSafe.setBounds(30,560,160,60);
		panel.add(btSafe);
		btSafe.setFont(font);
		
		btBao=new JButton("福     利");
		btBao.setBounds(650,350,160,60);
		panel.add(btBao);
		btBao.setFont(font);
		
		JLabel lhot=new JLabel("热   点   问   题");
		lhot.setBounds(1000,200,250,60);
		panel.add(lhot);
		lhot.setFont(font);
		bt1=new JButton("如何修改当前密码");
		bt1.setBounds(990,150,250,60);
		panel.add(bt1);
		bt1.setFont(font);
		bt2=new JButton("如何修改手机号");
		bt2.setBounds(0,440,250,60);
		panel.add(bt2);
		bt2.setFont(font);
		bt3=new JButton("收   费   问  题");
		bt3.setBounds(1000,560,250,60);
		panel.add(bt3);
		bt3.setFont(font);
		
		
		this.add(panel);
		this.setTitle("02尹好  28肖瑞  31王婧");
		this.setVisible(true);
		this.setSize(1366,723);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panel.setOpaque(false);
		
		
	}
	
	

}
