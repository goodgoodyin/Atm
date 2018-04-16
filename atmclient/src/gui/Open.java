package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

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

public class Open extends JFrame {

     JTextField tfName,tfId,tfPhone,tfPwd;
     String account,id,phone,pwd,name;
     JButton btOk,btCancel,btRetry;
     JLabel ts1,ts2,ts3,ts4,ts5;
     boolean ispwd,isname,isid,isphone;
	 String newAccount;
	 
	 Card currCard;
		BufferedReader br;
		PrintWriter pw;
		
		public Open(BufferedReader br,PrintWriter pw,Card currCard){
			this.br=br;
			this.pw=pw;
			this.currCard=currCard;
		}

	public void init(){
		JPanel  panelOpen = new JPanel(null);
	   //newAccount=String.valueOf(Integer.parseInt(account)+1);
		JLabel lAccount=new JLabel("账号        ");
        JLabel lName=new JLabel("姓名");
		JLabel lPwd=new JLabel("密码");
		JLabel lPhone=new JLabel("手机号");
	    JLabel lId=new JLabel("身份证号码");


		ts1=new JLabel("");
		ts2=new JLabel("");
		ts3=new JLabel("");
		ts4=new JLabel("");
		
		 tfName=new JTextField();
		 tfId=new JTextField();
		 tfPhone=new JTextField();
		 tfPwd=new JPasswordField();
		
		panelOpen.add(lName);	
		lName.setBounds(10,65,70,30);
		panelOpen.add(tfName);
		tfName.setBounds(100,65,100,30);
		panelOpen.add(ts1);
		ts1.setBounds(210,65,200,50);
		
		panelOpen.add(lPwd);
		lPwd.setBounds(10,105,120,30);
		panelOpen.add(tfPwd);
		tfPwd.setBounds(100,105,100,30);
		panelOpen.add(ts2);
		ts2.setBounds(210,105,200,50);
		
		panelOpen.add(lId);
		lId.setBounds(10,145,70,30);
		panelOpen.add(tfId);
		tfId.setBounds(100,145,100,30);
		panelOpen.add(ts3);

		ts3.setBounds(210,145,200,50);
		
		panelOpen.add(lPhone);
		lPhone.setBounds(10,185,100,30);
		panelOpen.add(tfPhone);
		tfPhone.setBounds(100,185,100,30);
		panelOpen.add(ts4);
		ts4.setBounds(210,185,200,50);
		
		btOk=new JButton("确定");
        panelOpen.add(btOk);
		btOk.setBounds(10,250,100,50);
		
		btRetry=new JButton("重输");
        panelOpen.add(btRetry);
		btRetry.setBounds(135,250,100,50);		
		
		btCancel=new JButton("返回");
        panelOpen.add(btCancel);
		btCancel.setBounds(250,250,100,50);
		
		this.setTitle("02尹好 28肖瑞 31王婧");	
		this.setVisible(true);
		this.setSize(1366,723);
		this.add(panelOpen);
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panelOpen.setOpaque(false);
		
		
		tfName.addFocusListener(new FocusAdapter(){
			
		 	public void focusLost(FocusEvent e) {//没有焦点
		 	      name=tfName.getText();		 	     
		 		
		 			if(name.equals("")){
						ts1.setText("对不起，姓名不能为空！");
						tfName.setText("");
					}
					else{
							isname=true;
							ts1.setText("");
							//tfName.requestFocus();
							
							
						}
							
		 	}
		});
		
		tfPwd.addFocusListener(new FocusAdapter(){
		 	public void focusLost(FocusEvent e) {//没有焦点
		 	      pwd=tfPwd.getText();
		 	      int pl=pwd.length();	
		 	      if(isname==true){
			 	      if(pl!=6){
							ts2.setText("请输入6位数密码");
							tfPwd.setText("");
						}
			 	      else{
							ispwd=true;
							ts2.setText("");
							
							
			 	      }				
		 	      }
		 	}
		});
		
		tfId.addFocusListener(new FocusAdapter(){
		 	public void focusLost(FocusEvent e) {//没有焦点
		 	      id=tfId.getText();
		 	    int il=id.length();
		 		if(ispwd==true){			 	      		 	       
		 			if(il!=8){
						ts3.setText("请输入8位数证件号码");
						tfId.setText("");
					}
		 			else{
						isid=true;
						ts3.setText("");
						
					}
				}		
		 	}
		});
		
    	btOk.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub				
				phone=tfPhone.getText();				
				int idLength=id.length();
				int phoneLength=phone.length();
				if(isid==true){					
					if(phoneLength!=11){
						ts4.setText("请输入11位手机号！");
					}else{
						
						//发送新的账户信息给服务器
						
						//等待服务器响应
						pw.write("Open\r\n");
						pw.write(name+"\r\n");
						pw.write(pwd+"\r\n");
						pw.write(id+"\r\n");
						pw.write(phone+"r\n");
						pw.flush();
						
						
						String strEcho;
						try {
							strEcho=br.readLine();
							if(strEcho.equals("OpenSuccess"))
							    JOptionPane.showMessageDialog(Open.this, "开卡成功");
							else if(strEcho.equals("OpenFailure"))
								JOptionPane.showMessageDialog(Open.this, "开卡失败，请重试");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					 /*
			      		//将集合中数据转变成字符串
			             String str="";
			             
		           	str=newAccount+"#"+pwd+"#"+0+"#"+name+"#"+id+"#"+phone+"#"+0+"#"+0+"#"+0+"#"+0+"#"+0+"#"+0+"#"+0+"#"+true+"\r\n";
							try {
								//写入文件
								FileWriter out=new FileWriter("c:\\atm\\CardArray.txt",true);
								out.write(str);
								out.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}    		
						JOptionPane.showMessageDialog(Open.this, "恭喜您开户成功！");
						 Open.this.dispose();
			    		 new mMainFrame().init();
					}*/
				}		
				else{
					JOptionPane.showMessageDialog(Open.this, "信息有错误，请核对信息！");

				}
			
				   
			}
    	});
    	btRetry.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				      tfId.setText("");
				      tfName.setText("");
				      tfPhone.setText("");
				      tfPwd.setText("");

            }                
    	});    	
    	btCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Open.this.dispose();
				new Admin(br, pw, currCard).init();
                   }
                
    	});
    	
	}


}
