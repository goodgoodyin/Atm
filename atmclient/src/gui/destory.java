package gui;

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

public class destory extends JFrame {

     JTextField tfName,tfId,tfPhone,tfPwd,tfaccount;
     String account,id,phone,pwd,name;
     JButton btOk,btCancel,btRetry;
     JLabel ts1,ts2,ts3,ts4,ts5;
     boolean ispwd,isname,isid,isphone;
	 String newAccount;
	 
	 Card currCard;
		BufferedReader br;
		PrintWriter pw;
		
		public destory(BufferedReader br,PrintWriter pw,Card currCard){
			this.br=br;
			this.pw=pw;
			this.currCard=currCard;
		}

	public void init(){
		
		
		JPanel  panelDestory = new JPanel(null);
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
		
		tfaccount=new JTextField();
		 tfName=new JTextField();
		 tfId=new JTextField();
		 tfPhone=new JTextField();
		 tfPwd=new JPasswordField();
		
		 panelDestory.add(lAccount);
		lAccount.setBounds(10,25,300,30);
		panelDestory.add(tfaccount);
		tfaccount.setBounds(100,25,100,30);
		
						
		panelDestory.add(lName);		
		lName.setBounds(10,65,70,30);
		panelDestory.add(tfName);
		tfName.setBounds(100,65,100,30);
		panelDestory.add(ts1);
		ts1.setBounds(210,65,200,30);
		
		panelDestory.add(lPwd);
		lPwd.setBounds(10,105,70,30);
		panelDestory.add(tfPwd);
		tfPwd.setBounds(100,105,100,30);
		panelDestory.add(ts2);
		ts2.setBounds(210,105,200,30);
		
		panelDestory.add(lId);
		lId.setBounds(10,145,120,30);
		panelDestory.add(tfId);
		tfId.setBounds(100,145,100,30);
		panelDestory.add(ts3);
		ts3.setBounds(210,145,200,30);
		
		panelDestory.add(lPhone);
		lPhone.setBounds(10,185,70,30);
		panelDestory.add(tfPhone);
		tfPhone.setBounds(100,185,100,30);
		panelDestory.add(ts4);
		ts4.setBounds(210,185,200,30);
		
		btOk=new JButton("确定");
		panelDestory.add(btOk);
		btOk.setBounds(10,250,80,30);
		
		btRetry=new JButton("重输");
		panelDestory.add(btRetry);
		btRetry.setBounds(135,250,80,30);		
		
		btCancel=new JButton("返回");
		panelDestory.add(btCancel);
		btCancel.setBounds(225,250,80,30);		
		
		
		this.setTitle("02尹好  28肖瑞  31王婧");	
		this.setVisible(true);
		this.setSize(1366,723);	
		this.add(panelDestory);
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panelDestory.setOpaque(false);
		
		
		
		
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
						ts3.setText("请输入18位数证件号码");
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
				String account=tfaccount.getText();
				phone=tfPhone.getText();				
				int idLength=id.length();
				int phoneLength=phone.length();
				if(isid==true){					
					if(phoneLength!=11){
						ts4.setText("请输入11位手机号！");
					}else{
						
						//发送新的账户信息给服务器
						pw.write("destory\r\n");
						pw.write(account+"\r\n");
						pw.flush();
						//等待服务器响应
						String strEcho;
						try {
							strEcho=br.readLine();
							if(strEcho.equals("destorySuccess"))
							    JOptionPane.showMessageDialog(destory.this, "销卡成功");
							else if(strEcho.equals("destoryFailure"))
								JOptionPane.showMessageDialog(destory.this, "销卡失败，请重试");
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
					JOptionPane.showMessageDialog(destory.this, "信息有错误，请核对信息！");

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
				destory.this.dispose();
				new Admin(br, pw, currCard).init();
                   }
                
    	});
    	
	}


}
