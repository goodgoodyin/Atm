package gui;


	
import java.awt.Container;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;





import Comm.Card;

	public class MainFrame extends JFrame{
		private static final long serialVersionUID = -2110640686325934505L;
		private JButton btTake;
		private JButton btModiPwd;
		private JButton btSave;
		private JButton btQuery;
		private JButton btTransfer;
		private JButton btCommuni;
		private JButton btconsult;
		private JButton btExit,btCptc;
		/**
		 * @param args
		 */
		String num;
		Card currCard;
		BufferedReader br;
		PrintWriter pw;
		
		public MainFrame(BufferedReader br,PrintWriter pw,Card currCard){
			this.br=br;
			this.pw=pw;
			this.currCard=currCard;
		}
		
		
		public void init(){
			//������
			Font font= new Font("���μӴ�",Font.PLAIN,28);

			Container container=this.getContentPane();
			JPanel panel = new JPanel(null);
			panel.setOpaque(false);
			JLabel lblwel = new JLabel("��ӭʹ���й�����ATMϵͳ");
			lblwel.setBounds(200,20,380,60);
			lblwel.setFont(font);
			panel.add(lblwel);
			
			JLabel lblwel1 = new JLabel("��ѡ������Ҫ�Ľ�������");
			lblwel1.setBounds(350,85,380,60);
			lblwel1.setFont(font);
			panel.add(lblwel1);

			btTake=new JButton("ȡ�����");
			btTake.setBounds(20,200,160,60);
			btTake.setFont(font);
			panel.add(btTake);
			
			btModiPwd=new JButton("�޸�����");
			btModiPwd.setBounds(20,320,160,60);
			btModiPwd.setFont(font);
			panel.add(btModiPwd);
			
			btSave=new JButton("������");
			btSave.setBounds(20,440,160,60);
			btSave.setFont(font);
			panel.add(btSave);
			
			btQuery=new JButton("��ѯ���");
			btQuery.setBounds(20,560,160,60);
			btQuery.setFont(font);
			panel.add(btQuery);
			
			btCptc=new JButton("��     ��");
			btCptc.setBounds(650,350,160,60);
			btCptc.setFont(font);
			panel.add(btCptc);
			
			btTransfer=new JButton("ת�˷���");
			btTransfer.setBounds(1170,200,160,60);
			btTransfer.setFont(font);
			panel.add(btTransfer);
			
			btCommuni=new JButton("ͨ�Ž���");
			btCommuni.setBounds(1170,320,160,60);
			btCommuni.setFont(font);
			panel.add(btCommuni);
			
			btconsult=new JButton("��ѯ����");
			btconsult.setBounds(1170,440,160,60);
			btconsult.setFont(font);
			panel.add(btconsult);
			
			btExit=new JButton("�˳�����");
			btExit.setBounds(1170,560,160,60);
			btExit.setFont(font);
			panel.add(btExit);
			
			((JPanel) this.getContentPane()).setOpaque(false);
			URL url=MainFrame.class.getResource("1.jpg");
			 ImageIcon img = new ImageIcon(url);
			 JLabel background = new JLabel(img);
			 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
			 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
			 panel.setOpaque(false);
			
			container.add(panel);
			this.setSize(1366,723);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			 //���ò��ɸı䴰�ڴ�С
			this.setResizable(false); 
			this.setTitle("02����  28Ф��  31���");	
			this.setVisible(true);
			//ע�����
		
			btTake.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Take(br,pw,currCard).init();
					MainFrame.this.dispose();
				}
			});
			btSave.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Save(br,pw,currCard).init();
					MainFrame.this.dispose();
				}
				
			});
			btQuery.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new Query(br,pw,currCard).init();
					MainFrame.this.dispose();
				}
				
			});
			btModiPwd.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new ModiPwd(br,pw,currCard).init();
					MainFrame.this.dispose();
				}
				
			});
			
			btCommuni.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new Communi(br,pw,currCard).init();
					MainFrame.this.dispose();
				}
				
			});
			btconsult.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new Information(br,pw,currCard).init();
					MainFrame.this.dispose();
				}
				
			});
			btCptc.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new Cptc(br,pw,currCard).init();
					MainFrame.this.dispose();
				}
				
			});
			btTransfer.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new Transfer(br,pw,currCard).init();
					MainFrame.this.dispose();
				}
				
			});
			btExit.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Exit(br, pw, currCard).init();
					MainFrame.this.dispose();

				}
				
			});
		}
	}


