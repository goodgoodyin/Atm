package gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Comm.Card;



public class Exit extends JFrame implements ActionListener{
	
	private JButton btOk;
	private JButton btCancel;
	
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	
	public Exit(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	
	
	public void init(){
		Font font= new Font("���μӴ�",Font.PLAIN,28);
		JPanel panelExit = new JPanel(null);
		((JPanel)this.getContentPane()).setOpaque(false);
		JLabel lbltuichu = new JLabel("���Ŀ����˳�����л����ʹ�ã�");
		panelExit.add(lbltuichu);
		lbltuichu.setFont(font);
		lbltuichu.setBounds(500, 280, 550, 50);
		
	
		
		btOk=new JButton("ȷ��");
		panelExit.add(btOk);
		btOk.setFont(font);
		btOk.addActionListener(this);
		btOk.setBounds(520,460,100,50);
		
		btCancel=new JButton("ȡ��");		
		panelExit.add(btCancel);
		btCancel.setFont(font);
		btCancel.addActionListener(this);
		btCancel.setBounds(760,460,100,50);
		
	
		this.setTitle("02����  28Ф��  31���");
		this.add(panelExit);
		this.setSize(1366,723);
		this.setVisible(true);
		this.setIconImage(this.getToolkit().getImage("1.jpg"));
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panelExit.setOpaque(false);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		 if(e.getSource()==btOk){
				Exit.this.dispose();
				new zhujiemian().init();
				
			}else if(e.getSource()==btCancel)
			{
				Exit.this.dispose();
				new MainFrame(br, pw, currCard).init();

			}
				
	}
	
}