package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;





import comm.Card;
import comm.ConnDb;

public class ServerLis implements Runnable{
	Card currCard;
	int count;//密码错误次数
	float money;
	Connection conn;
	BufferedReader br;
	PrintWriter pw;
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			//服务套接字
			ServerSocket ss=new ServerSocket(8011);
			System.out.println("启动成功");

			Socket s; 
			while(true){
				//等待客户端链接
				s=ss.accept();
				//输入输出流
				InputStream ips=s.getInputStream();
				OutputStream ops=s.getOutputStream();
				br=new BufferedReader(new InputStreamReader(ips));
				pw=new PrintWriter(ops);
				
				//接收客户端数据
				String headstr=br.readLine();
				String account=br.readLine();
				String pwd=br.readLine();
				
				//连接数据库
				ConnDb ConnDb=new ConnDb();
				ConnDb.getConn();
				//创建sql语句
				if(headstr.equals("Client")){
				String sql="select * from card where account='"+account+"'";
				currCard=ConnDb.checkLogin(sql);
				}
				else if(headstr.equals("Manager")){
				String sql1="select * from mcard where account='"+account+"'";
				currCard=ConnDb.checkManager(sql1);
				}
				
				if(currCard==null){//结果集为空，账号错误
					pw.write("1\r\n");
					pw.flush();
			}else {//结果集不为空，账号正确，则验证密码
				if(pwd.equals(currCard.getPwd())){//账号正确，密码也正确				
					pw.write("2\r\n");
					pw.write(currCard.getMoney()+"\r\n");
					pw.write(currCard.getName()+"\r\n");
					pw.write(currCard.getId()+"\r\n");
					pw.write(currCard.getPhone()+"\r\n");
					pw.write(currCard.getUse()+"\r\n");
					pw.flush();
					if(headstr.equals("Client"))
						new ServerLis2(br,pw,currCard).init();//调用子线程
					else if(headstr.equals("Manager"))
						new ServerLis3(br,pw,currCard).init();//调用子线程

					
				}else{//账号正确，密码不正确
					pw.write("3\r\n");
					pw.flush(); 
				}
			}						
		}
	
		}catch(IOException e){
			e.printStackTrace();
		}finally{//关闭连接状态
			if(pw!=null)
				pw.close();
			try {
				if(br!=null)
					br.close();
				//
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	
	}	


}
