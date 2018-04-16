package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Comm.Card;


public class lost extends JFrame {
	
	
        JTextField tfAccount,tfName,tfId,tfphone;
        JPasswordField tfPwd;
        JButton btOk,btCancel,btRetry,btPwd;
        String account,id,phone,name,pwd;
        Card currCard;
        JLabel ts1,ts2,ts3,ts4,ts5;
        boolean isPwd,isName,isId;
        BufferedReader br;
        PrintWriter pw;
    	public lost(BufferedReader br,PrintWriter pw,Card currCard){
			this.br=br;
			this.pw=pw;
			this.currCard=currCard;
		}
	public void init(){
		JPanel panel=new JPanel(null);
		Font font= new Font("仿宋",Font.PLAIN,28);
		
		JLabel lAccount=new JLabel("账号 ");
		lAccount.setFont(font);
		JLabel lName=new JLabel("姓名");
		lName.setFont(font);
		JLabel lPhone=new JLabel("手机号");
	    lPhone.setFont(font);
		JLabel lId=new JLabel("身份证号码");
		lId.setFont(font);
		JLabel lPwd=new JLabel("密码");
		lPwd.setFont(font);
		ts1=new JLabel("");
		ts1.setFont(font);
		ts2=new JLabel("");
		ts2.setFont(font);
		ts3=new JLabel("");
		ts3.setFont(font);
		ts4=new JLabel("");
		ts4.setFont(font);
		ts5=new JLabel("");
		ts5.setFont(font);

		 tfAccount=new JTextField();
		 tfName=new JTextField();
		 tfId=new JTextField();
		 tfphone=new JTextField();
		 tfPwd=new  JPasswordField();
		
		panel.add(lAccount);
		lAccount.setBounds(5,25,100,30);		
		panel.add(tfAccount);
		tfAccount.setBounds(150,25,135,30);	
		
		panel.add(lPwd);
		lPwd.setBounds(5,75,70,30);		
		panel.add(tfPwd);
		tfPwd.setBounds(150,75,135,30);
		
		panel.add(lName);		
		lName.setBounds(5,125,70,30);
		panel.add(tfName);
		tfName.setBounds(150,125,135,30);
		
		panel.add(lId);
		lId.setBounds(5,175,180,30);
		panel.add(tfId);
		tfId.setBounds(150,175,135,30);
		panel.add(ts4);
		ts4.setBounds(260,175,280,30);
		
		panel.add(lPhone);
		lPhone.setBounds(5,225,120,30);
		panel.add(tfphone);
		tfphone.setBounds(150,225,135,30);
		panel.add(ts5);
		ts5.setBounds(260,225,280,30);
		
		btOk=new JButton("确定");
		btOk.setFont(font);
		panel.add(btOk);
		btOk.setBounds(10,270,100,50);
		
		btRetry=new JButton("重输");
		btRetry.setFont(font);
		panel.add(btRetry);
		btRetry.setBounds(135,270,100,50);
		
		btCancel=new JButton("取消");
		btCancel.setFont(font);
		panel.add(btCancel);
		btCancel.setBounds(250,270,100,50);

		panel.setOpaque(false);
		
		
		 try{
		        Image img1=ImageIO.read(this.getClass().getResource("2.jpg"));
		        this.setIconImage(img1);
		        }catch(IOException e){
		        	e.printStackTrace();
		        }
		
        this.add(panel);
		this.setSize(1366,723);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		 //设置不可改变窗口大小
		this.setVisible(true);
		this.setResizable(false); 
		this.setTitle("02尹好 28肖瑞 31王婧");	
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panel.setOpaque(false);
	
	
		btOk.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 	String account=tfAccount.getText();
					String name=tfName.getText();
					String pwd=tfPwd.getText();
					String id=tfId.getText();
					String phone=tfphone.getText();
						pw.write("lost\r\n");
						pw.write(account+"\r\n");
						pw.write(name+"\r\n");
						pw.write(pwd+"\r\n");
						pw.write(id+"\r\n");
						pw.write(phone+"\r\n");
						pw.flush();
						
						try {
							String str=br.readLine();
							System.out.print(str);
							if(str.equals("LostSuccess")){
							    JOptionPane.showMessageDialog(lost.this, "挂失成功");

							} else if(str.equals("1"))
							    JOptionPane.showMessageDialog(lost.this, "姓名错误");
							else if(str.equals("2"))
							    JOptionPane.showMessageDialog(lost.this, "密码错误");
							else if(str.equals("3"))
							    JOptionPane.showMessageDialog(lost.this, "身份证号码错误");
							else if(str.equals("4"))
							    JOptionPane.showMessageDialog(lost.this, "手机号错误");
							else if(str.equals("5"))
							    JOptionPane.showMessageDialog(lost.this, "查无此卡");

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						}
		});
	btRetry.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfAccount.setText("");
				tfName.setText("");
				tfPwd.setText("");
				tfId.setText("");
				tfphone.setText("");

			}
	});
	
	btCancel.addActionListener(new ActionListener(){

		
		@Override
		public void actionPerformed(ActionEvent e) {
			//tfAccount.hasFocus();
          lost.this.dispose();
          new Admin(br, pw, currCard).init(); 
		}
	});		
	}
}
