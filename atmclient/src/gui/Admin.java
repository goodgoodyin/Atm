package gui;


import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Comm.Card;


public class Admin extends JFrame{
	JTextField tfAccount;
	JButton btCancel,btOpen,btDestroy,btFreeze,btThaw;
	JLabel lAccount,lPutName,lPutAccount,lPutType;
	String account1;
	
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	
	public Admin(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	public void init(){
		Font font= new Font("���μӴ�",Font.PLAIN,28);
		JPanel panel=new JPanel(null);
		tfAccount=new JTextField();
		tfAccount.setFont(font);
		btCancel=new JButton("����");
		btCancel.setFont(font);
		btOpen=new JButton("����");
		btOpen.setFont(font);
		btDestroy=new JButton("ע��");
		btDestroy.setFont(font);
		btFreeze=new JButton("����");
		btFreeze.setFont(font);
		btThaw=new JButton("�ⶳ");
		btThaw.setFont(font);

		
		
		Container container=this.getContentPane();//this��ǰ��,getcontentPane()��ȡһ������,��һ������ڵ�ǰ���ȡһ������
		container.add(panel);           		
		JLabel lblwel = new JLabel("��ӭʹ���й�����ATMϵͳ");
		lblwel.setBounds(100,50,450,50);
		panel.add(lblwel);
		lblwel.setFont(font);
		
		JLabel lblwel1 = new JLabel("��ѡ�����Ĳ���");
		lblwel1.setBounds(220,150,350,50);
		panel.add(lblwel1);
		lblwel1.setFont(font);
		
		panel.add(btCancel);
		btCancel.setFont(font);
		btCancel.setBounds(680,560, 100,50);//��λ��,��λ��,��,��
		

		panel.add(btOpen);
		btOpen.setFont(font);
		btOpen.setBounds(520,370,100,50);//��λ��,��λ��,��,��
		
		panel.add(btDestroy);
		btDestroy.setFont(font);
		btDestroy.setBounds(520,450,100,50);
		btDestroy.setFont(font);
		
		
	
		panel.add(btFreeze);
		btFreeze.setBounds(920,370, 100,50);
		btFreeze.setFont(font);
		
		panel.add(btThaw);
		btThaw.setBounds(920,450,100,50);
		btThaw.setFont(font);
		
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panel.setOpaque(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		this.setSize(1366,723);    //�����С
		
		this.setResizable(false);  //���ò��ɸı䴰�ڴ�С
		this.setVisible(true);  //���ô���Ϊ�ɼ�
		this.setTitle("02����  28Ф��  31���");
		
		//ע�����
	
		btOpen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Admin.this.dispose();
				new Open(br,pw,currCard).init();
			}
		});
		btCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Admin.this.dispose();
				new zhujiemian().init();
			}
		});
		btDestroy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Admin.this.dispose();
				new destory(br,pw,currCard).init();
			}
		});
		
		btFreeze.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Admin.this.dispose();
				new lost(br, pw, currCard).init();
			}
		});
		btThaw.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Admin.this.dispose();
				new Thaw(br, pw, currCard).init();
			}
		});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new Admin(null,null,null).init();

		 
	
	}

}
