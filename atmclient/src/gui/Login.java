package gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
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


public class Login extends JFrame {
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
		JPanel panel=new JPanel();
		
		JLabel lAccount,lPwd;
		lAccount=new JLabel("�˺�");
		lAccount.setBounds(520,220,150,90);
		lAccount.setFont(font);
		panel.add(lAccount);
		
		lPwd=new JLabel("����");
		lPwd.setBounds(520,300,150,90);
		lPwd.setFont(font);
		panel.add(lPwd);
		
		tfAccount=new JTextField();
		tfAccount.setBounds(680,225,260,60);  
		tfAccount.setFont(font);
		panel.add(tfAccount);
		tfPwd=new JPasswordField();
		tfPwd.setBounds(680,315,260,60);
		tfPwd.setFont(font);
		panel.add(tfPwd);
		btOk=new JButton("ȷ��");
	    btOk.setBounds(530,460,100,50);
	    btOk.setFont(font);
		panel.add(btOk);
        btCancel=new JButton("ȡ��");
		btCancel.setBounds(835,460,100,50);
		btCancel.setFont(font);
		panel.add(btCancel);
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panel.setOpaque(false);
		
		
		this.add(panel);
		panel.setLayout(null);
		this.setTitle("02����  28Ф��  31���");
		this.setFont(font);
		this.setSize(1366,723);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try{
	        Image img7=ImageIO.read(this.getClass().getResource("2.jpg"));
	        this.setIconImage(img7);
	        }catch(IOException e){
	        	e.printStackTrace();
	        }

		//ע�����
		btOk.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String account=tfAccount.getText();
				String pwd=new String(tfPwd.getPassword());
				try {
					s=new Socket(InetAddress.getByName("127.0.0.1"),8011);
					
					InputStream ips=s.getInputStream();
					OutputStream ops=s.getOutputStream();
					br=new BufferedReader(new InputStreamReader(ips));
					pw=new PrintWriter(ops);
					//�������ݵ�������
					pw.write("Client\r\n");
					pw.write(account+"\r\n");
					pw.write(pwd+"\r\n");

					pw.flush();
					//�ȴ���������Ӧ
					String echo=br.readLine();
					if("1".equals(echo)){
						JOptionPane.showMessageDialog(Login.this, "�����˺�����");
						tfAccount.setText("");
					}else if("2".equals(echo)){
						 float money=Float.parseFloat(br.readLine());
						 String name=br.readLine();
	                     String id=br.readLine();
	                     String phone=br.readLine();
	                     String use=br.readLine();
	                     
	                     if(use.equals("yes")){
						currCard=new Card(account,name,pwd,money,id,phone);
						new MainFrame(br,pw,currCard).init();
						Login.this.dispose();
	                     }else
	                     {
								JOptionPane.showMessageDialog(Login.this, "�����˻��ѱ���ʧ,����ȥ���");

	                     }
					}else if("3".equals(echo)){//�������������֤
						count++;
						if(count==3){
							JOptionPane.showMessageDialog(Login.this, "�����������3�Σ����̿���\n");
							tfAccount.setText("");
							tfPwd.setText("");
							count=0;
						}else{
							JOptionPane.showMessageDialog(Login.this, "���������������������룡������"+(3-count)+"�λ��ᣡ\n");
							tfPwd.setText("");
						}
					}
					//end else if
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			});//end actionPerformed
		btCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Login.this.dispose();
				new zhujiemian().init();
			}
			
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login().init();
	}

}
