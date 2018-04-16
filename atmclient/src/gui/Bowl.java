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

public class Bowl extends JFrame{

	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	JButton bt1,bt2,bt3,bt4;
	public Bowl(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	
	
	public void init(){
		Font font= new Font("仿宋加粗",Font.PLAIN,25);
		JPanel panel=new JPanel(null);
		JLabel lb1=new JLabel("理财总金额:1000");
		lb1.setBounds(620,100,300,50);
		panel.add(lb1);	
		lb1.setFont(font);
		
		JLabel lb2=new JLabel();
		lb2.setBounds(680,100,100,50);
		panel.add(lb2);
		lb2.setFont(font);
		JLabel lb3=new JLabel("昨日收益:100");
		lb3.setBounds(630,160,180,50);
		panel.add(lb3);
		lb3.setFont(font);
		JLabel lb4=new JLabel();
		lb4.setBounds(650,140,100,50);
		panel.add(lb4);
		lb4.setFont(font);

		JLabel lb5=new JLabel("六个月定期存款");
		lb5.setBounds(580,220,250,50);
		panel.add(lb5);
		lb5.setFont(font);
		JLabel lb51=new JLabel("利率：1.300%");
		lb51.setBounds(580,300,350,50);
		panel.add(lb51);
		lb51.setFont(font);
		bt1=new JButton("详情");
		bt1.setBounds(580, 550, 100, 50);
		panel.add(bt1);
		bt1.setFont(font);
		
		JLabel lb6=new JLabel("更多项目，敬请期待!");
		lb6.setBounds(570,450,280,50);
		panel.add(lb6);
		lb6.setFont(font);
				
		bt4=new JButton("返回");
		bt4.setBounds(760, 550, 100, 50);
		panel.add(bt4);
		bt4.setFont(font);
		this.add(panel);
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
		
		
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Yeahpay(br, pw, currCard).init();
			}
			
		});

		
	
		bt4.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				Bowl.this.dispose();
				new Cptc(br,pw,currCard).init();
				
			}
			
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Bowl(null, null, null).init();
	}

}
