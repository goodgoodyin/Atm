package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Comm.Card;

public class Consult extends JFrame{
	
	JButton btHuman,btQuery,btJindu,btSafe,btBao;
	JButton bt1,bt2,bt3;
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	public Consult(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	public void init(){
		Font font= new Font("���μӴ�",Font.PLAIN,28);
		JPanel panel=new JPanel(null);
		btHuman=new JButton("�˹�����");
		btHuman.setBounds(30,100,160,60);
		panel.add(btHuman);
		btHuman.setFont(font);
		btQuery=new JButton("���ײ�ѯ");
		btQuery.setBounds(30,320,160,60);
		panel.add(btQuery);
		btQuery.setFont(font);
		btJindu=new JButton("��������");
		btJindu.setBounds(30,440,160,60);
		panel.add(btJindu);
		btSafe.setFont(font);
		btSafe=new JButton("�˻���ȫ");
		btSafe.setBounds(30,560,160,60);
		panel.add(btSafe);
		btSafe.setFont(font);
		
		btBao=new JButton("��     ��");
		btBao.setBounds(650,350,160,60);
		panel.add(btBao);
		btBao.setFont(font);
		
		JLabel lhot=new JLabel("��   ��   ��   ��");
		lhot.setBounds(1000,200,250,60);
		panel.add(lhot);
		lhot.setFont(font);
		bt1=new JButton("����޸ĵ�ǰ����");
		bt1.setBounds(990,150,250,60);
		panel.add(bt1);
		bt1.setFont(font);
		bt2=new JButton("����޸��ֻ���");
		bt2.setBounds(0,440,250,60);
		panel.add(bt2);
		bt2.setFont(font);
		bt3=new JButton("��   ��   ��  ��");
		bt3.setBounds(1000,560,250,60);
		panel.add(bt3);
		bt3.setFont(font);
		
		
		this.add(panel);
		this.setTitle("02����  28Ф��  31���");
		this.setVisible(true);
		this.setSize(1366,723);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panel.setOpaque(false);
		
		
	}
	
	

}
