package gui;

import java.awt.Color;
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

public class Take extends JFrame implements ActionListener{
	JTextField tfMoney;
	private JButton bt100;
	private JButton bt200;
	private JButton bt300;
	private JButton bt500;
	private JButton bt1000;
	private JButton bt001;
	private JButton bt002;
	private JButton bt003;
	private JButton bt004;
	private JButton bt005;
	private JButton bt006;
	private JButton bt007;
	private JButton bt008;
	private JButton bt009;
	private JButton bt000;
	private JButton btOk;
	private JButton btRetry;
	private JButton btCancel;
	
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	public Take(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	public void init(){
		//添加取款页面卡片
		        Font font= new Font("仿宋加粗",Font.PLAIN,28);
				JPanel panelTake = new JPanel(null);
				panelTake.setBackground(new Color(119,119,253));
				JLabel lblqukuan = new JLabel("请输入您的取款数额：");
				lblqukuan.setFont(font);
				panelTake.add(lblqukuan);
				lblqukuan.setBounds(160, 50, 350, 60);
				
				lblqukuan=new JLabel("提示：只能是100元或100元的整数倍。");
				panelTake.add(lblqukuan);
				lblqukuan.setFont(font);
				lblqukuan.setBounds(250, 160, 580, 60);
				
				tfMoney=new JTextField(12);
				tfMoney.setEnabled(false);
				panelTake.add(tfMoney);
				tfMoney.setFont(font);
				tfMoney.setBounds(480,55,240,40);
				
				bt100=new JButton("100");
				panelTake.add(bt100);
				bt100.setFont(font);
				bt100.addActionListener(this);
				bt100.setBounds(360,260,100,50);
				
				bt200=new JButton("200");
				panelTake.add(bt200);
				bt200.setFont(font);
				bt200.addActionListener(this);
				bt200.setBounds(520,260,100,50);
				
				bt300=new JButton("300");
				panelTake.add(bt300);
				bt300.setFont(font);
				bt300.addActionListener(this);
				bt300.setBounds(680,260,100,50);
				
				bt500=new JButton("500");
				panelTake.add(bt500);
				bt500.setFont(font);
				bt500.addActionListener(this);
				bt500.setBounds(840,260,100,50);
				
				bt1000=new JButton("1000");
				panelTake.add(bt1000);
				bt1000.setFont(font);
				bt1000.addActionListener(this);
				bt1000.setBounds(1000,260,100,50);
				
				bt001=new JButton("1");
				panelTake.add(bt001);
				bt001.setFont(font);
				bt001.addActionListener(this);
				bt001.setBounds(360,370,100,50);
				
				bt002=new JButton("2");
				panelTake.add(bt002);
				bt002.setFont(font);
				bt002.addActionListener(this);
				bt002.setBounds(520,370,100,50);
				
				bt003=new JButton("3");
				panelTake.add(bt003);
				bt003.setFont(font);
				bt003.addActionListener(this);
				bt003.setBounds(680,370,100,50);
				
				bt004=new JButton("4");
				panelTake.add(bt004);
				bt004.setFont(font);
				bt004.addActionListener(this);
				bt004.setBounds(840,370,100,50);
				
				bt005=new JButton("5");
				panelTake.add(bt005);
				bt005.setFont(font);
				bt005.addActionListener(this);
				bt005.setBounds(1000,370,100,50);
				
				bt006=new JButton("6");
				panelTake.add(bt006);
				bt006.setFont(font);
				bt006.addActionListener(this);
				bt006.setBounds(360,480,100,50);
				
				bt007=new JButton("7");
				panelTake.add(bt007);
				bt007.setFont(font);
				bt007.addActionListener(this);
				bt007.setBounds(520,480,100,50);
				
				bt008=new JButton("8");
				panelTake.add(bt008);
				bt008.setFont(font);
				bt008.addActionListener(this);
				bt008.setBounds(680,480,100,50);
				
				bt009=new JButton("9");
				panelTake.add(bt009);
				bt009.setFont(font);
				bt009.addActionListener(this);
				bt009.setBounds(840,480,100,50);
				
				bt000=new JButton("0");
				panelTake.add(bt000);
				bt000.setFont(font);
				bt000.addActionListener(this);
				bt000.setBounds(1000,480,100,50);
				
				btOk=new JButton("确定");
				panelTake.add(btOk);
				btOk.setFont(font);
				btOk.addActionListener(this);
				btOk.setBounds(480,600,100,50);
				
				btRetry=new JButton("重输");
				panelTake.add(btRetry);
				btRetry.setFont(font);
				btRetry.addActionListener(this);
				btRetry.setBounds(680,600,100,50);
				
				btCancel=new JButton("返回");
				panelTake.add(btCancel);
				btCancel.setFont(font);
	 			btCancel.addActionListener(this);
				btCancel.setBounds(880,600,100,50);
				
				this.setTitle("02尹好  28肖瑞  31王婧");
				this.add(panelTake);
				this.setSize(1366,723);
				this.setVisible(true);
				
				((JPanel) this.getContentPane()).setOpaque(false);
				URL url=MainFrame.class.getResource("1.jpg");
				 ImageIcon img = new ImageIcon(url);
				 JLabel background = new JLabel(img);
				 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
				 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
				 panelTake.setOpaque(false);
				
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==bt100||arg0.getSource()==bt200||arg0.getSource()==bt300||arg0.getSource()==bt500||arg0.getSource()==bt1000)
			tfMoney.setText(arg0.getActionCommand());
		else if(arg0.getSource()==bt000||arg0.getSource()==bt001||arg0.getSource()==bt002||arg0.getSource()==bt003||arg0.getSource()==bt004||arg0.getSource()==bt005||

arg0.getSource()==bt006||arg0.getSource()==bt007||arg0.getSource()==bt008||arg0.getSource()==bt009){
			tfMoney.setText(tfMoney.getText()+arg0.getActionCommand());
		}else if(arg0.getSource()==btOk){
			int takeMoney=Integer.parseInt(tfMoney.getText());
			if(takeMoney%100!=0)
				JOptionPane.showMessageDialog(Take.this,"对不起，请取整额");
			else{
			if(currCard.getMoney()<takeMoney){
				JOptionPane.showMessageDialog(Take.this, "对不起，您的余额不足！");
				tfMoney.setText("");
			}
			else{
				//发送新的账户信息给服务器
				pw.write("take\r\n");
				pw.write(takeMoney+"\r\n");
				pw.flush();
				//等待服务器响应
				String strEcho;
				try {
					strEcho=br.readLine();
					if(strEcho.equals("takeSuccess")){
						currCard.setMoney(currCard.getMoney()-takeMoney);
						JOptionPane.showMessageDialog(Take.this, "恭喜您取款"+takeMoney+"成功！\n您的当前卡账户余额为"+currCard.getMoney()+"元");
					}else if("takeFailure".equals(strEcho)){
						JOptionPane.showMessageDialog(Take.this, "取款失败，请重试");
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		}else if(arg0.getSource()==btCancel){
			Take.this.dispose();
			new MainFrame(br, pw, currCard).init();
		}else if(arg0.getSource()==btRetry){
			tfMoney.setText("");
		}
	}
}
