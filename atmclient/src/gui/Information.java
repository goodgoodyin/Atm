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
		Font font= new Font("����",Font.PLAIN,25);
		JLabel lb1=new JLabel("������");
	    lb1.setFont(font);
	    
	    JLabel lb2=new JLabel("��Է���С�������������ڷ���������ȫ�����������ɷ�ƽ̨��");
	    lb2.setFont(font);
	    
	    JLabel lb3=new JLabel("���������Ӧ������������ܽ�ϣ�Ϊ�ͻ��ṩ������������ɷѷ�");
	    lb3.setFont(font);
	    
	    JLabel lb4=new JLabel("��,�Լ��̻�֧���������տͶ����Ʋ�Ʒ���߽��׵���ɫ����Ӧ�á�");
	    lb4.setFont(font);
	    
	    JLabel lb5=new JLabel("  ���ҵ������Ϊ��վ��Ա�ṩ������Ϣ���á����׼�¼��ѯ������");
	    lb5.setFont(font);
	    
	    JLabel lb6=new JLabel("�˵���ѯ���ɷ���Ŀ���ƺ��ҵ���Ϣ�ȷ�����Ҫ��ȡ������Ϣ���벦 ");
	    lb6.setFont(font);
	    
	    JLabel lb7=new JLabel("���Է���е绰��95533, ���ߵ�½��Է���йٷ���վ��лл��");
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
        	    
	    btCancel=new JButton("����");
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
		this.setTitle("02����  28Ф��  31���");
		this.add(panel);
		this.setSize(1366,723);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		 //���ò��ɸı䴰�ڴ�С
		this.setVisible(true);
		this.setResizable(false); 
		this.setTitle("02����05��Z31���");	
	
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