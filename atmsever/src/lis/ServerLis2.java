package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import comm.Card;
import comm.ConnDb;
import comm.InCard;
import comm.Msg;

public class ServerLis2 implements Runnable{
	Card currCard,traCard;
	BufferedReader br;
	PrintWriter pw;
	String time;
	public ServerLis2(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	public void init(){
		new Thread(this).start();
	}
	@Override
	public void run(){
		// TODO Auto-generated method stub
		String strHead;
		int i=0;   	 

		while(true){
			//连接数据库
			ConnDb ConnDb=new ConnDb();
			ConnDb.getConn();//调用此方法
			ConnDb ConnDb1=new ConnDb();
			ConnDb1.getConn();//调用此方法
			ConnDb ConnDb2=new ConnDb();
			ConnDb2.getConn();//调用此方法
			//获取当前时间，精确到秒
			  Date date=new Date();
			  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		      time=format.format(date);
			try {
				strHead=br.readLine();//接收消息头
				if(strHead.equals("take")){
				    int takeMoney=Integer.parseInt(br.readLine());
				    currCard.setMoney(currCard.getMoney()-takeMoney);//更新卡
				    //执行sql
				    String sql="update Card set money="+currCard.getMoney()+" where account='"+currCard.getAccount()+"'";
				    String sql1="insert into Mingxi  (time,type,account,money) values ('"+time+"','take','"+currCard.getAccount()+"','"+takeMoney+"')";
				    //得到结果
				    int flag=ConnDb.updateCard(sql);
				    int flag1=ConnDb1.updateCard(sql1);
				    if(flag==1){
				    	pw.write("takeSuccess\r\n");
				    	pw.flush();
				    }else{
				    	pw.write("takeFailure\r\n");
				    	pw.flush();
				    }
				    if(flag1==1){
				    	System.out.println("ok");
				    }else
				    	JOptionPane.showOptionDialog(null,"数据记载失败！","记载失败", JOptionPane.DEFAULT_OPTION, 
								JOptionPane.INFORMATION_MESSAGE,null, null, null);
						
					
				}else if(strHead.equals("save")){
					
					System.out.println("save money");
					int saveMoney=Integer.parseInt(br.readLine());
					currCard.setMoney(currCard.getMoney()+saveMoney);//更新卡
					String sql="update Card set money="+currCard.getMoney()+" where account='"+currCard.getAccount()+"'";
				    String sql1="insert into Mingxi (time,type,account,money) values ('"+time+"','save','"+currCard.getAccount()+"','"+saveMoney+"')";

					System.out.print(sql);
					int flag=ConnDb.updateCard(sql);
					
					int flag1=ConnDb1.updateCard(sql1);
					if(flag==1){
						pw.write("saveSuccess\r\n");
						pw.flush();
					}else{
						pw.write("saveFailure\r\n");
						pw.flush();
					}
					
					
				}else if(strHead.equals("Communi")){
					String num=br.readLine();
					float pMoney=Float.parseFloat(br.readLine());
					System.out.println(pMoney);

					String sql2="select * from Card where phone='"+num+"'";
					Card myCard=ConnDb.querryByphone(sql2);
					
					if(myCard!=null){
					myCard.setPMoney(myCard.getpMoney()+pMoney);//更新卡
					currCard.setMoney(currCard.getMoney()-pMoney);
					String sql="update Card set money="+currCard.getMoney()+" where account= '"+currCard.getAccount()+"'";
					String sql3="update Card set pmoney="+myCard.getpMoney()+" where account= '"+myCard.getAccount()+"'";
					String sql1="insert into Mingxi  (time,type,account,money) values ('"+time+"','Communi','"+currCard.getAccount()+"','"+pMoney+"')";
					
					int flag=ConnDb.updateCard(sql);
					ConnDb.updateCard(sql1);
					ConnDb.updateCard(sql3);
					
					if(flag==1){
						pw.write("CommuniSuccess\r\n");
						pw.flush();
					}else{
						pw.write("CommuniFailure\r\n");
						pw.flush();
					}
					
					}
					else{
						pw.write("noCard\r\n");	
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
					    String sql3="insert into Mingxi  (time,type,account,money) values ('"+time+"','Tranfer','"+currCard.getAccount()+"','"+money+"')";
					    String sql4="insert into Mingxi  (time,type,account,money) values ('"+time+"','Transfered','"+account+"','"+money+"')";

						int flag=ConnDb.updateCard(sql1);
						int flag1=ConnDb1.updateCard(sql2);
						ConnDb.updateCard(sql3);
						ConnDb1.updateCard(sql4);

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
					String account=br.readLine();
					String sql="select * from mingxi";
					List<InCard> cardlist=ConnDb.checkAll1(sql);
					Iterator<InCard> it=cardlist.iterator();
					while(it.hasNext()){
						InCard InCard=it.next();
						 if(account.equals(InCard.getAccount())){ 
							 pw.write(InCard.getTime()+"#"+InCard.getType()+"#"+InCard.getMoney()+"\r\n");  
						 }
					}

					pw.write("break\r\n");
					pw.flush();
					

					}

				
				else if(strHead.equals("Cptc")){
					//定期理财金额会变化
					String type=br.readLine();		
					float money=Float.parseFloat(br.readLine());
					    //执行sql
					int flag=0;
					int flag1=0;

					 if(type.equals("Ytake")){
						    currCard.setMoney(currCard.getMoney()+money);//更新卡
						    String sql="update Card set money="+currCard.getMoney()+" where account='"+currCard.getAccount()+"'";
						    String sql1="insert into Mingxi (time,type,account,money,istake) values ('"+time+"','ytake','"+currCard.getAccount()+"','"+money+"','isok')";
						 	
						    flag=ConnDb.updateCard(sql);
						    flag1=ConnDb1.updateCard(sql1);
						    
					 }
					 else if(type.equals("Ysave")){
							System.out.println("Ysave money");

						 	String sql="select * from Mingxi where type='Ytake'";
						 	Date  date1=ConnDb.getOldTime(sql);
							Calendar c1=Calendar.getInstance();
							long day=(date.getTime()-date1.getTime())/(1000*60*60*24);
							 System.out.print(day);
							
							if(day>180){
							    float nowmoney=money+(float) (0.001*day*money);
							    currCard.setMoney(currCard.getMoney()+nowmoney);//更新卡
							    String sql2="update Card set money="+currCard.getMoney()+" where account='"+currCard.getAccount()+"'";
							    String sql3="insert into Mingxi (time,type,account,money) values ('"+time+"','ysave','"+currCard.getAccount()+"','"+money+"')";
							    String sql4="update Mingxi set istake=issave where account='"+currCard.getAccount()+"'";

							    flag=ConnDb.updateCard(sql2);
							    flag1=ConnDb1.updateCard(sql3);
							    ConnDb1.updateCard(sql4);
							    System.out.print(sql);
							}
							else
								flag=9;
							
					 }
					  else if(type.equals("Donate")){
						  	String account=br.readLine();
						  	String sql="select * from card where account= '"+account+"'";
						  	System.out.println(money);
							Card myCard=ConnDb.querryByAccount(sql);
						  	currCard.setMoney(currCard.getMoney()-money);
							myCard.setMoney(myCard.getMoney()+money);
							String sql1="update card set money= '"+currCard.getMoney()+"' where account= '"+currCard.getAccount()+"'";
							String sql2="update card set money= '"+myCard.getMoney()+"' where account= '"+myCard.getAccount()+"'";
						    String sql3="insert into Mingxi  (time,type,account,money) values ('"+time+"','Donate','"+currCard.getAccount()+"','"+money+"')";
						    String sql4="insert into Mingxi  (time,type,account,money) values ('"+time+"','Donated','"+account+"','"+money+"')";

						     flag=ConnDb.updateCard(sql1);
							 flag1=ConnDb1.updateCard(sql2);
							 ConnDb.updateCard(sql3);
							 ConnDb1.updateCard(sql4);
					}
					  else if(type.equals("Baiduren")){
						 	String account=br.readLine();
						  	String sql="select * from card where account= '"+account+"'";

							Card myCard=ConnDb.querryByAccount(sql);
						  	currCard.setMoney(currCard.getMoney()-money);
							myCard.setMoney(myCard.getMoney()+money);
							String sql1="update card set money= '"+currCard.getMoney()+"' where account= '"+currCard.getAccount()+"'";
							String sql2="update card set money= '"+myCard.getMoney()+"' where account= '"+myCard.getAccount()+"'";
						    String sql3="insert into Mingxi  (time,type,account,money) values ('"+time+"','Baiduren','"+currCard.getAccount()+"','"+money+"')";
						    String sql4="insert into Mingxi  (time,type,account,money) values ('"+time+"','Baidurened','"+account+"','"+money+"')";

						     flag=ConnDb.updateCard(sql1);
							 flag1=ConnDb1.updateCard(sql2);
							 ConnDb.updateCard(sql3);
							 ConnDb1.updateCard(sql4);
					 }
					  else if(type.equals("Xingzou")){
						 	String account=br.readLine();
						  	String sql="select * from card where account= '"+account+"'";

							Card myCard=ConnDb.querryByAccount(sql);
						  	currCard.setMoney(currCard.getMoney()-money);
							myCard.setMoney(myCard.getMoney()+money);
							String sql1="update card set money= '"+currCard.getMoney()+"' where account= '"+currCard.getAccount()+"'";
							String sql2="update card set money= '"+myCard.getMoney()+"' where account= '"+myCard.getAccount()+"'";
						    String sql3="insert into Mingxi  (time,type,account,money) values ('"+time+"','Xingzou','"+currCard.getAccount()+"','"+money+"')";
						    String sql4="insert into Mingxi  (time,type,account,money) values ('"+time+"','Xingzoued','"+account+"','"+money+"')";

						     flag=ConnDb.updateCard(sql1);
							 flag1=ConnDb1.updateCard(sql2);
							 ConnDb.updateCard(sql3);
							 ConnDb1.updateCard(sql4);
					 }
						 
					 
					    //得到结果
					    if(flag==1){
					    	pw.write("Success\r\n");
					    	System.out.print(flag);
					    	pw.flush();
					    }else{
					    	if(flag==9){
					    	pw.write("timeno\r\n");	
					    	System.out.print(flag);

					    	pw.flush();
					    	}
					    	else{
					    	pw.write("Failure\r\n");
					    	pw.flush();
					    	}
					    }

				}
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
	
	
	

