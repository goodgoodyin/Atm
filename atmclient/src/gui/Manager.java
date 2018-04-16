package gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Comm.Card;

public class Manager extends JFrame {
	JTextField tfAccount;
	JPasswordField tfPwd;
	JButton btOk,btCancel;
	Card currCard;
	String strEcho;
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	private int count;
	public void init(){
		Font font= new Font("���μӴ�",Font.PLAIN,28);
		System.out.println("program is starting");
		JLabel lAccount,lPwd;
		lAccount=new JLabel("�˺�");
		lAccount.setFont(font);
		lAccount.setBounds(580,200,100,50);					
		lPwd=new JLabel("����");
		lPwd.setFont(font);
		lPwd.setBounds(580,300,100,50);


		tfAccount=new JTextField();
		tfAccount.setFont(font);
		tfPwd=new JPasswordField();
		tfPwd.setFont(font);
		
		tfAccount.setBounds(700,200,250,50);
		
		JPanel panelOne=new JPanel(null);
		tfPwd.setBounds(700,300,250,50);	
		
		panelOne.add(tfAccount);
		tfAccount.setFont(font);
		panelOne.add(lAccount);
		lAccount.setFont(font);
		panelOne.add(lPwd);
		lPwd.setFont(font);
		panelOne.add(tfPwd);
		tfPwd.setFont(font);
		btOk=new JButton("ȷ��");
	    btOk.setBounds(530,460,100,50);
	    btOk.setFont(font);
	    panelOne.add(btOk);
        btCancel=new JButton("ȡ��");
		btCancel.setBounds(835,460,100,50);
		btCancel.setFont(font);
		panelOne.add(btCancel);
		
		this.add(panelOne);
		this.setTitle("02����  28Ф��  31���");
		this.setSize(1366,723);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panelOne.setOpaque(false);
		
				
				btOk.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						String account=tfAccount.getText();
						String pwd=new String(tfPwd.getPassword());
						
						try {
							s=new Socket(InetAddress.getByName("127.0.0.1"),8011);
							
							InputStream ips=s.getInputStream();
							OutputStream ops=s.getOutputStream();
							br=new BufferedReader(new InputStreamReader(ips));
							pw=new PrintWriter(ops);
							//�������ݵ�������
							pw.write("Manager\r\n");;
							pw.write(account+"\r\n");
							pw.write(pwd+"\r\n");

							pw.flush();
							//�ȴ���������Ӧ
							String echo=br.readLine();
							if("1".equals(echo)){
								JOptionPane.showMessageDialog(Manager.this, "�����˺�����");
								tfAccount.setText("");
							}else if("2".equals(echo)){
								float money=Float.parseFloat(br.readLine());
								 String name=br.readLine();
			                     String id=br.readLine();
			                     String phone=br.readLine();
								currCard=new Card(account,name,pwd,money,id,phone);
								new Admin(br,pw,currCard).init();
								Manager.this.dispose();
							}else if("3".equals(echo)){//�������������֤
								count++;
								if(count==3){
									JOptionPane.showMessageDialog(Manager.this, "�����������3�Σ����̿���\n");
									tfAccount.setText("");
									tfPwd.setText("");
									count=0;
								}else{
									JOptionPane.showMessageDialog(Manager.this, "���������������������룡������"+(3-count)+"�λ��ᣡ\n");
									tfPwd.setText("");
								}
							}
							//end else if
							}catch(IOException e1){
								e1.printStackTrace();
							}
						}
					});//end actionPerformed
				
				    btCancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Manager.this.dispose();
						new zhujiemian().init();
					}
				});
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new zhujiemian().init();
	}

}
