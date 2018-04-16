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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Comm.Card;

public class Donate extends JFrame {
	String num;
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	JButton btJikun,btanlao,btjiuzai,btqiuxue,btExit;
	public Donate(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	
	public void init(){
		//Container container=this.getContentPane();
		Font font= new Font("仿宋加粗",Font.PLAIN,17);
		JPanel panel1=new JPanel(false);
		JLabel label11=new JLabel("济困");
		panel1.add(label11);
		label11.setFont(font);
		
		
		URL url1=Donate.class.getResource("d1.jpg");
		ImageIcon img1 = new ImageIcon(url1);
		JLabel background1 = new JLabel(img1);
		panel1.add(background1, new Integer(Integer.MIN_VALUE));
		background1.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());
		JLabel label12=new JLabel("       十元种下希望树        ");
		panel1.add(label12);
		label12.setFont(font);
		JLabel label13=new JLabel("   中国绿化基金会  ");
		panel1.add(label13);
		label13.setFont(font);
		final JRadioButton jk1=new JRadioButton("10");
		panel1.add(jk1);
        jk1.setFont(font);
		final JRadioButton jk2=new JRadioButton("30");
		panel1.add(jk2);
        jk2.setFont(font);
		final JRadioButton jk3=new JRadioButton("50");
		panel1.add(jk3);
        jk3.setFont(font);
		btJikun=new JButton("济困");
		panel1.add(btJikun);
		btJikun.setFont(font);
		panel1.setBounds(60,150,300,400);
		this.add(panel1);
		
		JPanel panel2=new JPanel(false);
		JLabel label21=new JLabel("安老");
		panel2.add(label21);
		label21.setFont(font);
		URL url2=Donate.class.getResource("d2.jpg");
		ImageIcon img2 = new ImageIcon(url2);
		JLabel background2 = new JLabel(img2);
		panel2.add(background2, new Integer(Integer.MIN_VALUE));
		background2.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());
		JLabel label22=new JLabel("    为失能老人送拐棍     ");
		panel2.add(label22);
		label22.setFont(font);
		JLabel label23=new JLabel(" 老人发展基金会");
		panel2.add(label23);
		label23.setFont(font);
		final JRadioButton ja1=new JRadioButton("10");
		panel2.add(ja1);
		ja1.setFont(font);
		final JRadioButton ja2=new JRadioButton("30");
		panel2.add(ja2);
		ja2.setFont(font);
		final JRadioButton ja3=new JRadioButton("50");
		panel2.add(ja3);
		ja3.setFont(font);
		btanlao=new JButton("安老");
		panel2.add(btanlao);
		btanlao.setFont(font);
		panel2.setBounds(340,150,300,400);
		this.add(panel2);
		
		JPanel panel3=new JPanel(false);
		JLabel label31=new JLabel("求学");
		panel3.add(label31);
		label31.setFont(font);
		URL url3=Donate.class.getResource("d3.jpg");
		ImageIcon img3 = new ImageIcon(url3);
		JLabel background3 = new JLabel(img3);
		panel3.add(background3, new Integer(Integer.MIN_VALUE));
		background3.setBounds(0, 0, img3.getIconWidth(), img3.getIconHeight());
		JLabel label32=new JLabel("         大山里的健康小桌         ");
		panel3.add(label32);
		label32.setFont(font);
		JLabel label33=new JLabel("   爱德基金会");
		panel3.add(label33);
		label33.setFont(font);
		final JRadioButton jq1=new JRadioButton("10");
		panel3.add(jq1);
		jq1.setFont(font);
		final JRadioButton jq2=new JRadioButton("30");
		panel3.add(jq2);
		jq2.setFont(font);
		final JRadioButton jq3=new JRadioButton("50");
		panel3.add(jq3);
		jq3.setFont(font);
		btqiuxue=new JButton("求学");
		panel3.add(btqiuxue);
		btqiuxue.setFont(font);
		panel3.setBounds(630,150,300,400);
		this.add(panel3);
		
		JPanel panel4=new JPanel(false);
		JLabel label41=new JLabel("救灾");
		panel4.add(label41);
		label41.setFont(font);
		URL url4=Donate.class.getResource("d4.jpg");
		ImageIcon img4 = new ImageIcon(url4);
		JLabel background4 = new JLabel(img4);
		panel4.add(background4, new Integer(Integer.MIN_VALUE));
		background4.setBounds(0, 0, img4.getIconWidth(), img4.getIconHeight());
		JLabel label42=new JLabel("     温暖冬天里的环卫工人       ");
		panel4.add(label42);
		label42.setFont(font);
		JLabel label43=new JLabel("     仁德基金会 ");
		panel4.add(label43);
		label43.setFont(font);
		final JRadioButton jjz1=new JRadioButton("10");
		panel4.add(jjz1);
		jjz1.setFont(font);
		final JRadioButton jjz2=new JRadioButton("30");
		panel4.add(jjz2);
		jjz2.setFont(font);
		final JRadioButton jjz3=new JRadioButton("50");
		panel4.add(jjz3);
		jjz3.setFont(font);
		btjiuzai=new JButton("救灾");
		panel4.add(btjiuzai);
		btjiuzai.setFont(font);
		panel4.setBounds(950,150,300,400);
		this.add(panel4);
		
		JPanel panel6=new JPanel(false);
		URL url6=Donate.class.getResource("1.jpg");
		ImageIcon img6 = new ImageIcon(url6);
		JLabel background6 = new JLabel(img6);
		panel6.add(background6, new Integer(Integer.MIN_VALUE));
		background6.setBounds(0, 0, img2.getIconWidth(), img2.getIconHeight());
		//panel6.setBounds(10,100,10,10);
		this.add(panel6);
	 	JPanel panel10=new JPanel();
		btExit=new JButton("退出");
		panel10.add(btExit);
		btExit.setFont(font);
		panel10.setBounds(680,650,100,50);
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
			
			
			btJikun.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					float money=0;
					if(jk1.isSelected()){
						money=10;
					}
					 else if(jk2.isSelected()){
						money=30;
					}
					 else if(jk3.isSelected()){
							money=50;
						}
					pw.write("Cptc\r\n");
					pw.write("Donate\r\n");
					pw.write(money+"\r\n");

					pw.write("123454\r\n");
					pw.flush();
					try {
						String str=br.readLine();
						if(str.equals("Success"))
							JOptionPane.showMessageDialog(Donate.this, "感谢您的捐赠！");
						else
							JOptionPane.showMessageDialog(Donate.this, "捐款失败，请重试");

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			
					
				
				
			});
			btanlao.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					float money=0;
					if(ja1.isSelected()){
						money=10;
					}
					 else if(ja2.isSelected()){
						money=30;
					}
					 else if(ja3.isSelected()){
							money=50;
					 }
					pw.write("Cptc\r\n");
					pw.write("Donate\r\n");
					pw.write(money+"\r\n");

					pw.write("123455\r\n");
					pw.flush();
							try {
								String str=br.readLine();
								if(str.equals("Success"))
									JOptionPane.showMessageDialog(Donate.this, "感谢您的捐赠！");
								else
									JOptionPane.showMessageDialog(Donate.this, "捐款失败，请重试");

							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							

					
				}
				
				
			});
			btjiuzai.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					float money=0;
					if(jjz1.isSelected()){
						money=10;
					}
					 else if(jjz2.isSelected()){
						money=30;
					}
					 else if(jjz3.isSelected()){
							money=50;
						}
					pw.write("Cptc\r\n");

					pw.write("Donate\r\n");
					pw.write(money+"\r\n");

					pw.write("123457\r\n");

					pw.flush();
					try {
						String str=br.readLine();
						if(str.equals("Success"))
							JOptionPane.showMessageDialog(Donate.this, "感谢您的捐赠！");
						else
							JOptionPane.showMessageDialog(Donate.this, "捐款失败，请重试");

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
				
				
			});
			btqiuxue.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					float money=0;
					if(jq1.isSelected()){
						money=10;
					}
					 else if(jq2.isSelected()){
						money=30;
					}
					 else if(jq3.isSelected()){
							money=50;
						}
					pw.write("Cptc\r\n");

					pw.write("Donate\r\n");
					pw.write(money+"\r\n");

					pw.write("123458\r\n");

					pw.flush();
					System.out.print(money);
					try {
						String str=br.readLine();
						if(str.equals("Success"))
							JOptionPane.showMessageDialog(Donate.this, "感谢您的捐赠！");
						else
							JOptionPane.showMessageDialog(Donate.this, "捐款失败，请重试");

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
					new Cptc(br, pw, currCard).init();
					Donate.this.dispose();
				}
				
			});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Donate(null, null, null).init();
	}

}
