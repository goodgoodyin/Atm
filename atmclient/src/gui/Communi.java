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

public class Communi extends JFrame implements ActionListener{
	BufferedReader br;
	PrintWriter pw;
	Card currCard;
	JButton btOk,btCancel,bt10,bt20,bt50,bt100,bt200;
	JTextField tfNum,tfMoney;
	float pMoney;
	public Communi(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	
	public void init(){
		Font font= new Font("仿宋加粗",Font.PLAIN,28);
		JPanel panel=new JPanel(null);
		JLabel lNum=new JLabel("请输入手机号码：");
		panel.add(lNum);
		lNum.setFont(font);
		lNum.setBounds(500, 160, 350, 50);
		JLabel lMoney=new JLabel("请选择缴费金额：");
		panel.add(lMoney);
		lMoney.setFont(font);
		lMoney.setBounds(500,240,350,50);
		tfNum=new JTextField();
		panel.add(tfNum);
		tfNum.setFont(font);
		tfNum.setBounds(720,160,300,50);	
		tfMoney=new JTextField();
		panel.add(tfMoney);
		tfMoney.setFont(font);
		tfMoney.setBounds(720,240,300,50);
		bt10=new JButton("10");
		panel.add(bt10);
		bt10.setFont(font);
		bt10.addActionListener(this);
		bt10.setBounds(520,370,120,50);		
		bt20=new JButton("20");
		panel.add(bt20);
		bt20.setFont(font);
		bt20.addActionListener(this);
		bt20.setBounds(720,400,120,50);
		bt50=new JButton("50");
		panel.add(bt50);
		bt50.setFont(font);
		bt50.addActionListener(this);
		bt50.setBounds(920,370,120,50);
		bt100=new JButton("100");
		panel.add(bt100);
		bt100.setFont(font);
		bt100.addActionListener(this);
		bt100.setBounds(520,450,120,50);
		bt200=new JButton("200");
		panel.add(bt200);
		bt200.setFont(font);
		bt200.addActionListener(this);
		bt200.setBounds(920,450,120,50);
		btOk=new JButton("确定");
		btOk.addActionListener(this);
		panel.add(btOk);
		btOk.setFont(font);
		btOk.setBounds(580,560,100,50);
		btCancel=new JButton("取消");
		panel.add(btCancel);
		btCancel.setFont(font);
		btCancel.addActionListener(this);
		btCancel.setBounds(880,560,100,50);
		this.add(panel);
		this.setSize(1366,723);
		this.setVisible(true);
		this.setTitle("02尹好  28肖瑞  31王婧");
		
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 panel.setOpaque(false);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt10||e.getSource()==bt20||e.getSource()==bt50||e.getSource()==bt100||e.getSource()==bt200){
			pMoney=Float.parseFloat(e.getActionCommand());
			tfMoney.setText(e.getActionCommand());
		}else if(e.getSource()==btOk){
			String num=tfNum.getText();
			if(currCard.getMoney()>pMoney){
				pw.write("Communi\r\n");
				pw.write(num+"\r\n");
				pw.write(pMoney+"\r\n");
				pw.flush();

				String strEcho;
				try {
					strEcho=br.readLine();
					if("CommuniSuccess".equals(strEcho)){
						JOptionPane.showMessageDialog(this, "缴费成功！");

					}else if("noCard".equals(strEcho))
						JOptionPane.showMessageDialog(this, "该号码不存在！");

					else
						JOptionPane.showMessageDialog(this, "缴费失败，请重试！");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else
				JOptionPane.showMessageDialog(this,"对不起，余额不足");
		}else if(e.getSource()==btCancel){
			Communi.this.dispose();
			new MainFrame(br,pw,currCard).init();
		}
	}
}
