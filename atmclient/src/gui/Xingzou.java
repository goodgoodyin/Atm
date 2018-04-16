package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


import javax.swing.JScrollPane;

import Comm.Card;

public class Xingzou extends JFrame {
	JButton btm1,btExit;
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	
	public Xingzou(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	
	public  void init(){
		   Font font= new Font("仿宋加粗",Font.PLAIN,20);
		   JPanel panel1=new JPanel(null);
			
			URL url1=Donate.class.getResource("z2.jpg");
			ImageIcon img1 = new ImageIcon(url1);
			JLabel background1 = new JLabel(img1);
			panel1.add(background1, new Integer(Integer.MIN_VALUE));
			background1.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());
			panel1.setBounds(40,50,img1.getIconWidth(),img1.getIconHeight());
	
			this.add(panel1);
			panel1.setBounds(30,40,600,600);
			JPanel panel2=new JPanel();
			JLabel label21=new JLabel("              行走的文化课，袁腾飞遥你同游美国                              ");  
			panel2.add(label21);
			label21.setFont(font);
			JLabel label22=new JLabel("                ");
			panel2.add(label22);
			label22.setFont(font);
			JLabel label23=new JLabel("            ");
			panel2.add(label23);
			label23.setFont(font);
			JLabel label24=new JLabel("        收益回报日期:2019/06/03               ");
			panel2.add(label24);
			label24.setFont(font);
			JLabel label25=new JLabel("      此项目需在2017/1/29之前，            ");
			panel2.add(label25);
			label25.setFont(font);
			JLabel label28=new JLabel("            需获得1000000.00的支持才能成功        ");
			panel2.add(label28);
			label28.setFont(font);
			
			JLabel label29=new JLabel("                 筹款            ");
			panel2.add(label29);
			label29.setFont(font);
			
			final JRadioButton jt1=new JRadioButton("礼包一:99");
			panel2.add(jt1);
			jt1.setFont(font);
			final JRadioButton jt2=new JRadioButton("礼包二:155          ");
			panel2.add(jt2);
			jt2.setFont(font);
			panel2.setBounds(650,40,600,600);
			this.add(panel2);
			
			btm1=new JButton("购买");
			panel2.add(btm1);
			btm1.setFont(font);
			btExit=new JButton("退出");
			panel2.add(btExit);
			btExit.setFont(font);
		
		JPanel panel6=new JPanel(false);
		URL url6=Donate.class.getResource("1.jpg");
		ImageIcon img6 = new ImageIcon(url6);
		JLabel background6 = new JLabel(img6);
		panel6.add(background6, new Integer(Integer.MIN_VALUE));
		background6.setBounds(0, 0, img6.getIconWidth(), img6.getIconHeight());
		this.add(panel6);
	 	
		 try{
		        Image img7=ImageIO.read(this.getClass().getResource("2.jpg"));
		        this.setIconImage(img7);
		        }catch(IOException e){
		        	e.printStackTrace();
		        }
		JScrollPane sp=new JScrollPane(panel1);
		getContentPane().add(sp,BorderLayout.CENTER);
		this.add(sp);
		this.setSize(1366,723);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		 //设置不可改变窗口大小
		this.setResizable(false); 
		this.setTitle("02尹好  28肖瑞  31王婧");	
		this.setVisible(true);
		
		btm1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int money=0;
				if(jt1.isSelected()){
					money=99;
				}
				 else if(jt2.isSelected()){
					money=155;
				}
				pw.write("Cptc\r\n");
				pw.write("Xingzou\r\n");
				pw.write(money+"\r\n");
				pw.write("123460\r\n");
				pw.flush();
				
				String str;
				try {
					str = br.readLine();
					if(str.equals("Success"))
						JOptionPane.showMessageDialog(Xingzou.this, "操作成功！");
					else
						JOptionPane.showMessageDialog(Xingzou.this, "操作失败，请重试！");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
			
		});
		
		
	
	btExit.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Ent(br, pw, currCard).init();
			Xingzou.this.dispose();
		}
		
	});
	}
	
}
