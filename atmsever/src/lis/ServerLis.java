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
	int count;//����������
	float money;
	Connection conn;
	BufferedReader br;
	PrintWriter pw;
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			//�����׽���
			ServerSocket ss=new ServerSocket(8011);
			System.out.println("�����ɹ�");

			Socket s; 
			while(true){
				//�ȴ��ͻ�������
				s=ss.accept();
				//���������
				InputStream ips=s.getInputStream();
				OutputStream ops=s.getOutputStream();
				br=new BufferedReader(new InputStreamReader(ips));
				pw=new PrintWriter(ops);
				
				//���տͻ�������
				String headstr=br.readLine();
				String account=br.readLine();
				String pwd=br.readLine();
				
				//�������ݿ�
				ConnDb ConnDb=new ConnDb();
				ConnDb.getConn();
				//����sql���
				if(headstr.equals("Client")){
				String sql="select * from card where account='"+account+"'";
				currCard=ConnDb.checkLogin(sql);
				}
				else if(headstr.equals("Manager")){
				String sql1="select * from mcard where account='"+account+"'";
				currCard=ConnDb.checkManager(sql1);
				}
				
				if(currCard==null){//�����Ϊ�գ��˺Ŵ���
					pw.write("1\r\n");
					pw.flush();
			}else {//�������Ϊ�գ��˺���ȷ������֤����
				if(pwd.equals(currCard.getPwd())){//�˺���ȷ������Ҳ��ȷ				
					pw.write("2\r\n");
					pw.write(currCard.getMoney()+"\r\n");
					pw.write(currCard.getName()+"\r\n");
					pw.write(currCard.getId()+"\r\n");
					pw.write(currCard.getPhone()+"\r\n");
					pw.write(currCard.getUse()+"\r\n");
					pw.flush();
					if(headstr.equals("Client"))
						new ServerLis2(br,pw,currCard).init();//�������߳�
					else if(headstr.equals("Manager"))
						new ServerLis3(br,pw,currCard).init();//�������߳�

					
				}else{//�˺���ȷ�����벻��ȷ
					pw.write("3\r\n");
					pw.flush(); 
				}
			}						
		}
	
		}catch(IOException e){
			e.printStackTrace();
		}finally{//�ر�����״̬
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
