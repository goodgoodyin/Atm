package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Comm.Card;

public class Transfer extends JFrame {
	BufferedReader br;
	PrintWriter pw;
	Card currCard;
	JTextField tfAccount,tfMoney;
	JButton btOk,btCancel;
	public Transfer(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	public void init(){
		Font font= new Font("���μӴ�",Font.PLAIN,28);
		JPanel Panel=new JPanel(null);
		JLabel laccount=new JLabel("�˻���");
		laccount.setFont(font);
		laccount.setBounds(580,200,100,50);
		Panel.add(laccount);
		JLabel lMoney=new JLabel("��");
		lMoney.setFont(font);
		lMoney.setBounds(580,300,100,50);
		Panel.add(lMoney);
		tfAccount=new JTextField();
		tfAccount.setBounds(700,200,150,50);
		Panel.add(tfAccount);
		tfAccount.setFont(font);
		tfMoney=new JTextField();
		Panel.add(tfMoney);
		tfMoney.setFont(font);
		tfMoney.setBounds(700,300,150,50);
		btOk=new JButton("ȷ��");
		Panel.add(btOk);
		btOk.setFont(font);
		btOk.setBounds(590,410,100,50);
		btCancel=new JButton("ȡ��");
		Panel.add(btCancel);
		btCancel.setFont(font);
		btCancel.setBounds(750,410,100,50);
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 Panel.setOpaque(false);
		
		this.add(Panel);
		this.setVisible(true);
		this.setSize(1366,723);
		this.setTitle("02����  28Ф��  31���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );

		
		btOk.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String account=tfAccount.getText();
				int money=Integer.parseInt(tfMoney.getText());
				if(currCard.getAccount().equals(account)){
					JOptionPane.showMessageDialog(Transfer.this, "������ת�˸��Լ�");
				}else{
					if(money<currCard.getMoney()){
					pw.write("Transfer\r\n");
					pw.write(account+"\r\n");
					pw.write(money+"\r\n");
					pw.flush();
					
					String strEcho;
					try {
						strEcho=br.readLine();
						if(strEcho.equals("TransferSuccess")){
							currCard.setMoney(currCard.getMoney()-money);
							tfAccount.setText("");
							tfMoney.setText("");

							JOptionPane.showMessageDialog(Transfer.this, "��ϲ��ת��"+money+"�ɹ���\n���ĵ�ǰ���˻����Ϊ"+currCard.getMoney()+"Ԫ");
						}
						else
							if(strEcho.equals("noCard"))
							JOptionPane.showMessageDialog(Transfer.this, "�˺ŷǷ�");
							else
								JOptionPane.showMessageDialog(Transfer.this, "ת��ʧ��");
	

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
					}	else
						JOptionPane.showMessageDialog(Transfer.this, "����");
				}
			}
			
		});
		btCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Transfer.this.dispose();
				new MainFrame(br, pw, currCard).init();
			}
			
		});
	}
}