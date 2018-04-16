package gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Comm.Card;




public class zhujiemian extends JFrame{
	JButton btkehu,btguanliyuan;
	
	public void init(){
		
		Font font= new Font("���μӴ�",Font.PLAIN,28);
		btkehu=new JButton("�û�");
		btguanliyuan=new JButton("����Ա");
		btguanliyuan.setMnemonic(KeyEvent.VK_ENTER); //�����ϵͳ�ṩ�İ������������Լ�д�ģ���ѡA����KeyEvent.VK_A,�����ʾ �����Ŀ�ݼ�ΪAlt+�س�
		//Font font = new Font("TimesRoman", Font.PLAIN, 20);//���������ʾЧ�� Font f = new Font(String ���壬int ���int �ֺ�);
		Container container=this.getContentPane();
		JPanel panel = new JPanel(null);
		panel = new JPanel();
		
		JLabel lblwel = new JLabel("��ӭʹ���й�����ATMϵͳ");
		lblwel.setBounds(30,45,420,50);
		panel.add(lblwel);
		lblwel.setFont(font);
		
		JLabel lblwel1 = new JLabel("��ѡ�����Ĳ���:");
		lblwel1.setBounds(260,95,300,50);
		panel.add(lblwel1);
		lblwel1.setFont(font);
		
		container.add(panel);
		panel.add(btkehu);
		panel.add(btguanliyuan);

		btkehu.setBounds(620,460,180,80);
		btguanliyuan.setBounds(620,260,180,80);	
		btkehu.setFont(font);//���������ǰʹ�õ����壺setFont(Font fn)
		btguanliyuan.setFont(font);
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panel.setOpaque(false);
		
		//�����С
		this.setSize(1366,723);   
		panel.setLayout(null);
		
		this.setResizable(false);  //���ò��ɸı䴰�ڴ�С
		this.setVisible(true);  //���ô���Ϊ�ɼ�
		this.setTitle("02����  28Ф��  31���");
		
		/*this.setLocation(350, 170);//����λ��*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );    //����ر�ʱ�����ķ�Ӧ
		
			  
	//ע�����
		//������ͻ�����ť���رյ�ǰ���ڣ��򿪿ͻ���½����
		btkehu.addActionListener(new ActionListener(){   
			public void actionPerformed(ActionEvent e){
				zhujiemian.this.dispose();
				new Login().init();
			}
		});
		
		btguanliyuan.addActionListener(new ActionListener(){   
			public void actionPerformed(ActionEvent e){
				zhujiemian.this.dispose();
				new Manager().init();
			}
		});
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new zhujiemian().init();
			new DemoWindow();

		 
		 			try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel") ;
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	
	}
}
