package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import comm.Card;
import comm.ConnDb;

public class ServerLis3 implements Runnable{
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	String time;
	public ServerLis3(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	public void init(){
		new Thread(this).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String strHead;
		
		while(true){
			//连接数据库
			ConnDb ConnDb=new ConnDb();
			ConnDb.getConn();//调用此方法
			ConnDb ConnDb1=new ConnDb();
			ConnDb1.getConn();//调用此方法

			//获取当前时间，精确到秒
			  Date date=new Date();
			  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		      time=format.format(date);
			try {
				strHead=br.readLine();//接收消息头
				
				if(strHead.equals("Open")){
					String name=br.readLine();//接收消息头
					String pwd=br.readLine();//接收消息头
					String id=br.readLine();//接收消息头
					String phone=br.readLine();//接收消息头

				    //执行sql
					String sql="insert into card (name,pwd,money,id,phone)values ('"+name+"','"+pwd+"','0','"+id+"','"+phone+"')";
					
				  //  String sql1="select into Mingxi values ('"+time+"','take','"+currCard.getAccount()+"','"+takeMoney+"')";
				    //得到结果
				    int flag=ConnDb.updateCard(sql);
				    System.out.println(flag);

				   // int flag1=ConnDb1.updateCard(sql1);
				    if(flag==1){
				    	pw.write("OpenSuccess\r\n");
				    	pw.flush();
				    }else{
				    	pw.write("OpenFailure\r\n");
				    	pw.flush();
				    }
				  	
					
				}else if(strHead.equals("destory")){
					String account=br.readLine();
					System.out.println(account);
					String sql="delete from card where account='"+account+"'";
				    //String sql1="insert into Mingxi values ('"+time+"','take','"+currCard.getAccount()+"','"+saveMoney+"')";

					System.out.println(sql);
					int flag=ConnDb.updateCard(sql);
					
					//ConnDb1.updateCard(sql1);
					if(flag==1){
						pw.write("destorySuccess\r\n");
						pw.flush();
					}else{
						pw.write("destoryFailure\r\n");
						pw.flush();
					}
					
				}
				else if(strHead.equals("lost")){
					String account=br.readLine();
					String name=br.readLine();
					String pwd=br.readLine();
					String id=br.readLine();
					String phone=br.readLine();
					
					String sql="select *  from card  where account="+account;
					Card card=ConnDb.checkLogin(sql);
				if(card!=null){
					if(name.equals(card.getName())){
						if(pwd.equals(card.getPwd()))
						{
							if(id.equals(card.getId())){
								if(phone.equals(card.getPhone())){
									String sql1="update card set usess='no' where account="+account;
									int flag=ConnDb.updateCard1(sql1);
									System.out.print(flag);

									if(flag==1){
									pw.write("LostSuccess\r\n");
									pw.flush();
									}else{
										pw.write("LostFailuer\r\n");
										pw.flush();
									}
								}else{
									pw.write("4\r\n");
									pw.flush();
								}
									
							}else{
								pw.write("3\r\n");
								pw.flush();
							}
						}else{
							pw.write("2\r\n");
							pw.flush();
						}
							
					}else{
						pw.write("1\r\n");
						pw.flush();
					}
				}else	
					{
						pw.write("5\r\n");
						pw.flush();
					}
					
				}
				else if(strHead.equals("Thaw")){
					String account=br.readLine();
					String name=br.readLine();
					String pwd=br.readLine();
					String id=br.readLine();
					String phone=br.readLine();
					
					String sql="select *  from card  where account="+account;
					Card card=ConnDb.checkLogin(sql);
					System.out.println(phone);
				if(card!=null){
					if(name.equals(card.getName())){
						if(pwd.equals(card.getPwd()))
						{
							if(id.equals(card.getId())){
								if(phone.equals(card.getPhone())){
									String sql1="update card set usess='yes' where account="+account;
									int flag=ConnDb.updateCard1(sql1);

									if(flag==1){
									pw.write("ThawSuccess\r\n");
									pw.flush();
									}else{
										pw.write("ThawLostFailuer\r\n");
										pw.flush();
									}
								}else{
									pw.write("4\r\n");
									pw.flush();
								}
									
							}else{
								pw.write("3\r\n");
								pw.flush();
							}
						}else{
							pw.write("2\r\n");
							pw.flush();
						}
							
					}else{
						pw.write("1\r\n");
						pw.flush();
					}
				}else	
					{
						pw.write("5\r\n");
						pw.flush();
					}
					
				}/*else if(strHead.equals("Communi")){
					int pMoney=Integer.parseInt(br.readLine());
					currCard.setMoney(currCard.getMoney()+pMoney);//更新卡
					String sql="update Card set money="+currCard.getMoney()+" where account= '"+currCard.getAccount()+"'";
				    String sql1="insert into Mingxi values ('"+time+"','take','"+currCard.getAccount()+"','"+pMoney+"')";

					int flag=ConnDb.updateCard(sql);
					ConnDb.updateCard(sql1);
					if(flag==1){
						pw.write("CommuniSuccess\r\n");
						pw.flush();
					}else{
						pw.write("CommuniFailure");
						pw.flush();
					}
				
					
				}else if(strHead.equals("ModiPwd")){
					String pwd=br.readLine();
					currCard.setPwd(pwd);//更新卡
					String sql="update Card set pwd= '"+pwd+"'  where account= '"+currCard.getAccount()+"'";
					System.out.println(sql);
					int flag=ConnDb.updateCard(sql);
					if(flag==1){
						pw.write("ModiPwdSuccess\r\n");
						pw.flush();
					}else{
						pw.write("ModiPwdFailure");
						pw.flush();
					}
					
				}else if(strHead.equals("Transfer")){
					String account=br.readLine();
					float money=Float.parseFloat(br.readLine());
					String sql="select * from card where account= '"+account+"'";

					Card myCard=ConnDb.querryByAccount(sql);
					if(myCard!=null){
						//两张卡的更新
						currCard.setMoney(currCard.getMoney()-money);
						myCard.setMoney(myCard.getMoney()+money);
						String sql1="update card set money= '"+currCard.getMoney()+"' where account= '"+currCard.getAccount()+"'";
						String sql2="update card set money= '"+myCard.getMoney()+"' where account= '"+myCard.getAccount()+"'";
					    String sql3="insert into Mingxi values ('"+time+"','take','"+currCard.getAccount()+"','"+money+"')";

						int flag=ConnDb.updateCard(sql1);
						int flag1=ConnDb1.updateCard(sql2);
						ConnDb1.updateCard(sql3);
						if(flag==1&&flag1==1){
							pw.write("TransferSuccess\r\n");
							pw.flush();
						}else{
							pw.write("TransferFailure\r\n");
							pw.flush();
						}
					}
					else{
						pw.write("noCard\r\n");
						pw.flush();
					}
						
					
					
				}
				else if(strHead.equals("Mingxi")){
					
					
				}*/
				
				else if(strHead.equals("exit")){
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	
}
