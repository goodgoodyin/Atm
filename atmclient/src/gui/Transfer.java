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
		Font font= new Font("仿宋加粗",Font.PLAIN,28);
		JPanel Panel=new JPanel(null);
		JLabel laccount=new JLabel("账户：");
		laccount.setFont(font);
		laccount.setBounds(580,200,100,50);
		Panel.add(laccount);
		JLabel lMoney=new JLabel("金额：");
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
		btOk=new JButton("确定");
		Panel.add(btOk);
		btOk.setFont(font);
		btOk.setBounds(590,410,100,50);
		btCancel=new JButton("取消");
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
		this.setTitle("02尹好  28肖瑞  31王婧");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );

		
		btOk.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String account=tfAccount.getText();
				int money=Integer.parseInt(tfMoney.getText());
				if(currCard.getAccount().equals(account)){
					JOptionPane.showMessageDialog(Transfer.this, "您不能转账给自己");
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

							JOptionPane.showMessageDialog(Transfer.this, "恭喜您转账"+money+"成功！\n您的当前卡账户余额为"+currCard.getMoney()+"元");
						}
						else
							if(strEcho.equals("noCard"))
							JOptionPane.showMessageDialog(Transfer.this, "账号非法");
							else
								JOptionPane.showMessageDialog(Transfer.this, "转账失败");
	

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
					}	else
						JOptionPane.showMessageDialog(Transfer.this, "余额不足");
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