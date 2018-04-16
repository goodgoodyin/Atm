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

public class Yeahpay extends JFrame {
	JButton bttake,btsave,btexit;
	BufferedReader br;
	PrintWriter pw;
	Card currCard;
	
	public Yeahpay(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	
	public void init(){
		Font font= new Font("仿宋加粗",Font.PLAIN,28);
		JPanel panel=new JPanel(null);
		
		
		bttake=new JButton("转入");
		bttake.setBounds(300,200,200,40);
		panel.add(bttake);
		bttake.setFont(font);
		btsave=new JButton("转出");
		btsave.setBounds(300,400,200,40);
		panel.add(btsave);
		btsave.setFont(font);
		btexit=new JButton("退出");
		btexit.setBounds(600,300,200,40);
		panel.add(btexit);
		btexit.setFont(font);
		this.add(panel);
		this.setSize(1366,723);		
		//this.setLocation(500, 250);
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
		
		
		bttake.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Ytake(br, pw, currCard).init();
				Yeahpay.this.dispose();
			}
			
		});
		btsave.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Ysave(br, pw, currCard).init();
				Yeahpay.this.dispose();
			}
			
		});
		btexit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MainFrame(br, pw, currCard).init();
				Yeahpay.this.dispose();
			}
			
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Yeahpay(null, null, null).init();
	}

}
