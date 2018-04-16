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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import Comm.Card;

public class Baiduren extends JFrame {
	JButton btm1,btExit;
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	
	public Baiduren(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	
	public  void init(){
		  Font font= new Font("���μӴ�",Font.PLAIN,18);
		    JPanel panel1=new JPanel(false);
			JLabel label11=new JLabel("���ڶ��ˡ�                                                                                   ");
			panel1.add(label11);
			label11.setFont(font);
			URL url1=Donate.class.getResource("b2.jpg");
			ImageIcon img1 = new ImageIcon(url1);
			JLabel background1 = new JLabel(img1);
			panel1.add(background1, new Integer(Integer.MIN_VALUE));
			background1.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());
			
			JLabel label13=new JLabel("Ŀ����3000�򣨳�ļ������5000��Ϊֹ��   ");
			panel1.add(label13);
			label13.setFont(font);
			panel1.setBounds(40,50,450,600);
			this.add(panel1);
			
			
			JPanel panel2=new JPanel();
			JLabel label21=new JLabel("                    [Ʊ���ֳ�˵��]                                  ");  
			panel2.add(label21);
            label21.setFont(font);
			JLabel label22=new JLabel("          ��ӰƱ���ﵽ                                       Ԥ��Ʊ��������");
			panel2.add(label22);
            label22.setFont(font);
			JLabel label23=new JLabel("          10�����ϣ���10�ڣ�                           6.00%                 ");
			panel2.add(label23);
            label23.setFont(font);
			JLabel label24=new JLabel("          8�����ϣ���8�ڣ�                                5.50%                 ");
			panel2.add(label24);
            label24.setFont(font);
			JLabel label25=new JLabel("          5�����ϣ���5�ڣ�                               5.00%                  ");
			panel2.add(label25);
            label25.setFont(font);
			JLabel label28=new JLabel("           3�����ϣ���3�ڣ�                                4.50%                  ");
			panel2.add(label28);
            label28.setFont(font);
			JLabel label26=new JLabel("              1�����ϣ���1�ڣ�                                 ����                     ");
			panel2.add(label26);
            label26.setFont(font);
			JLabel label27=new JLabel("                        С��1��                                                  ����                           ");
			panel2.add(label27);
            label27.setFont(font);
			JLabel label29=new JLabel("                                     ���         ");
			panel2.add(label29);
            label29.setFont(font);

			
			final JRadioButton jt1=new JRadioButton("���һ:88Ԫ           ");
			panel2.add(jt1);
            jt1.setFont(font);
			final JRadioButton jt2=new JRadioButton("�����:188Ԫ               ");
			panel2.add(jt2);
            jt2.setFont(font);
			panel2.setBounds(680,50,700,600);
			
			this.add(panel2);
			
			btm1=new JButton("����");
			panel2.add(btm1);
            btm1.setFont(font);
			btm1.setBounds(680,50,100,50);

			btExit=new JButton("�˳�");
			panel2.add(btExit);
            btExit.setFont(font);
			btExit.setBounds(800,50,100,50);

			
		
		
			
		JPanel panel6=new JPanel(false);
		URL url6=Donate.class.getResource("4.jpg");
		ImageIcon img6 = new ImageIcon(url6);
		JLabel background6 = new JLabel(img6);
		panel6.add(background6, new Integer(Integer.MIN_VALUE));
		background6.setBounds(0, 0, img6.getIconWidth(), img6.getIconHeight());
		this.add(panel6);
	 	
		 try{
		        Image img7=ImageIO.read(this.getClass().getResource("2.jpg"));
		        this.setIconImage(img7);
		        }catch(IOException e){
		        	e.printStackTrace();
		        }
			
		 
		this.setSize(1366,723);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		 //���ò��ɸı䴰�ڴ�С
		this.setResizable(false); 
		this.setTitle("02����  28Ф��  31���");	
		this.setVisible(true);
		
		
		
		btm1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int money=0;
				if(jt1.isSelected()){
					money=88;
				}
				 else if(jt2.isSelected()){
					money=188;
				}				
				pw.write("Cptc\r\n");
				pw.write("Baiduren\r\n");
				pw.write(money+"\r\n");
				pw.write("123459\r\n");

				pw.flush();
				
				String str;
				try {
					str = br.readLine();
					if(str.equals("Success"))
						JOptionPane.showMessageDialog(Baiduren.this, "�����ɹ�����ȴ�Ȩ�淢��");
					else
						JOptionPane.showMessageDialog(Baiduren.this, "����ʧ�ܣ������ԣ�");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
			
		});
		
		
	
	btExit.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Ent(br, pw, currCard).init();
			Baiduren.this.dispose();
		}
		
	});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Baiduren(null, null, null).init();
	}

}
