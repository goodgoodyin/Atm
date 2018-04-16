 package gui;

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

import Comm.Card;
import Comm.TestMingxi;



public class Query extends JFrame {
	BufferedReader br;
	PrintWriter pw;
   	Card currCard;
	JButton btCancel;
	JButton btMingxi;
	public Query(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}	
	public void init(){
		
		 Font font= new Font("仿宋加粗",Font.PLAIN,28);
		 JPanel panelQuery = new JPanel(null);
		 JLabel lQuery=new JLabel("您当前账户余额为："+currCard.getMoney());
	     panelQuery.add(lQuery);
	     lQuery.setFont(font);
	     lQuery.setBounds(580, 350, 400, 50);
		 btMingxi=new JButton("明细");
	     panelQuery.add(btMingxi);
	     btMingxi.setFont(font);
		 btMingxi.setBounds(1250,50,100,50);
		 btCancel=new JButton("返回");
	     panelQuery.add(btCancel);
	     btCancel.setFont(font);
		 btCancel.setBounds(1250,120,100,50);			
		 
		    ((JPanel) this.getContentPane()).setOpaque(false);
			URL url=MainFrame.class.getResource("1.jpg");
			 ImageIcon img = new ImageIcon(url);
			 JLabel background = new JLabel(img);
			 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
			 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
			 panelQuery.setOpaque(false);
			
			
			this.add(panelQuery);
		    this.setVisible(true);
		    this.setSize(1366,723);
			this.setTitle("02尹好  28肖瑞  31王婧");	
		    this.setResizable(false);
		    btMingxi.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
						
						
					
				       new TestMingxi(br,pw,currCard).init();
				}
		    	
		    });
		    this.setResizable(false);
		    btCancel.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				    Query.this.dispose();
				    new MainFrame(br, pw, currCard).init();
				}
		    	
		    });
		    
	}
		
	

}
