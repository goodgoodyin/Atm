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
import javax.swing.JPanel;

import Comm.Card;


public class Information extends JFrame{
	JButton btCancel;
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	public Information(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	public void init(){
		JPanel panel=new JPanel(null);
		Font font= new Font("仿宋",Font.PLAIN,25);
		JLabel lb1=new JLabel("悦生活");
	    lb1.setFont(font);
	    
	    JLabel lb2=new JLabel("金苑银行“悦生活”是立足于服务民生的全景化生活服务缴费平台，");
	    lb2.setFont(font);
	    
	    JLabel lb3=new JLabel("将各类服务应用与生活场景紧密结合，为客户提供多样化的生活缴费服");
	    lb3.setFont(font);
	    
	    JLabel lb4=new JLabel("务,以及商户支付、还款收款、投资理财产品在线交易等特色场景应用。");
	    lb4.setFont(font);
	    
	    JLabel lb5=new JLabel("  “我的悦生活”为网站会员提供个人信息设置、交易记录查询、电子");
	    lb5.setFont(font);
	    
	    JLabel lb6=new JLabel("账单查询、缴费项目定制和我的消息等服务。想要获取更多信息，请拨 ");
	    lb6.setFont(font);
	    
	    JLabel lb7=new JLabel("打金苑银行电话：95533, 或者登陆金苑银行官方网站，谢谢！");
	    lb7.setFont(font);
	    
	    panel.add(lb1);
		lb1.setBounds(30,25,560,50);
		
		panel.add(lb2);
		lb2.setBounds(30,85,570,50);
		
		panel.add(lb3);
		lb3.setBounds(20,115,570,50);
		
		panel.add(lb4);
		lb4.setBounds(20,145,570,50);
		
		panel.add(lb5);
		lb5.setBounds(20,195,570,50);
		
		panel.add(lb6);
	    lb6.setBounds(20,225,570,50);
	    panel.add(lb7);
	    lb7.setBounds(20,255,570,50);
        	    
	    btCancel=new JButton("返回");
	     btCancel.setFont(font);
	     btCancel.setBounds(600,350,90,50);
		 panel.add(btCancel);
			((JPanel) this.getContentPane()).setOpaque(false);
			URL url=MainFrame.class.getResource("1.jpg");
			 ImageIcon img = new ImageIcon(url);
			 JLabel background = new JLabel(img);
			 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
			 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
			 panel.setOpaque(false);
				
		 try{
		        Image img1=ImageIO.read(this.getClass().getResource("2.jpg"));
		        this.setIconImage(img1);
		        }catch(IOException e){
		        	e.printStackTrace();
		        }
		this.setTitle("02尹好  28肖瑞  31王婧");
		this.add(panel);
		this.setSize(1366,723);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		 //设置不可改变窗口大小
		this.setVisible(true);
		this.setResizable(false); 
		this.setTitle("02尹好05李璟31王婧");	
	
	btCancel.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Information.this.dispose();
			new MainFrame(br, pw, currCard).init();
		}
		
	});
	}
}