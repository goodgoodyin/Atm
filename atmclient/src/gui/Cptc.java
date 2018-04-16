package gui;

import java.awt.Container;
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

public class Cptc extends JFrame {

	private static final long serialVersionUID = -2110640686325934505L;
	private JButton btBowl;
	private JButton btDonate;
	private JButton btEnt;
	
	private JButton btExit;
	/**
	 * @param args
	 */
	String num;
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	
	public Cptc(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	
	
	public void init(){
		//主界面
	    Font font= new Font("仿宋加粗",Font.PLAIN,28);
		Container container=this.getContentPane();
		JPanel panel = new JPanel(null);
		panel.setOpaque(false);
		JLabel lblwel = new JLabel("欢迎使用中国银行ATM系统");
		lblwel.setBounds(50,15,350,50);
		panel.add(lblwel);
		lblwel.setFont(font);
		
		JLabel lblwel1 = new JLabel("请选择您需要的交易类型");
		lblwel1.setBounds(230,75,350,50);
		panel.add(lblwel1);
		lblwel1.setFont(font);


		btBowl=new JButton("聚宝盆");
		btBowl.setBounds(640,220,150,40);
		lblwel.setFont(font);
        btBowl.setFont(font);
		
		btDonate=new JButton("爱心捐");
		btDonate.setBounds(640,340,150,40);
		panel.add(btDonate);
        btDonate.setFont(font);
		
		
		btEnt=new JButton("娱乐宝");
		btEnt.setBounds(640,460,150,40);
		panel.add(btEnt);
        btEnt.setFont(font);
		
		btExit=new JButton("退出");
		btExit.setBounds(660,580,100,40);
		panel.add(btExit);
        btExit.setFont(font);
		
		container.add(panel);
		this.setSize(1366,723);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		 //设置不可改变窗口大小
		this.setResizable(false); 
		this.setTitle("02尹好  28肖瑞  31王婧");	
		this.setVisible(true);
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panel.setOpaque(false);
		//注册监听
	
		btBowl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Bowl(br,pw,currCard).init();
				Cptc.this.dispose();
			}
		});
		btDonate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Donate(br,pw,currCard).init();
				Cptc.this.dispose();
			}
			
		});
		btEnt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Ent(br,pw,currCard).init();
				Cptc.this.dispose();
			}
			
		});
	
	
		btExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Cptc.this.dispose();
				new MainFrame(br, pw, currCard).init();
			}
			
		});
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 new Cptc(null, null, null).init();
			
		
	}

}
