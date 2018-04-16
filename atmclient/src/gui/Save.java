package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Comm.Card;

public class Save extends JFrame implements ActionListener{
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
	public Save(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	public void init(){
		//添加取款页面卡片
		
		        Font font= new Font("仿宋加粗",Font.PLAIN,28);

				JPanel panelSave = new JPanel(null);
				panelSave.setBackground(new Color(119,119,253));
				panelSave.setFont(font);
				JLabel lblsave = new JLabel("请输入您的存款数额：");
				panelSave.add(lblsave);
				lblsave.setFont(font);
				lblsave.setBounds(160, 50, 300, 60);
				
				lblsave=new JLabel("提示：只能是100元或100元的整数倍。");
				panelSave.add(lblsave);
				lblsave.setFont(font);
				lblsave.setBounds(250, 160, 580, 60);
				
				tfMoney=new JTextField(12);
				tfMoney.setEnabled(false);
				panelSave.add(tfMoney);
				tfMoney.setFont(font);
				tfMoney.setBounds(480,55,240,40);
				
				bt100=new JButton("100");
				panelSave.add(bt100);
				bt100.setFont(font);
				bt100.addActionListener(this);
				bt100.setBounds(360,260,100,50);
				
				bt200=new JButton("200");
				panelSave.add(bt200);
				bt200.setFont(font);
				bt200.addActionListener(this);
				bt200.setBounds(520,260,100,50);
				
				bt300=new JButton("300");
				panelSave.add(bt300);
				bt300.setFont(font);
				bt300.addActionListener(this);
				bt300.setBounds(680,260,100,50);
				
				bt500=new JButton("500");
				panelSave.add(bt500);
				bt500.setFont(font);
				bt500.addActionListener(this);
				bt500.setBounds(840,260,100,50);
				
				bt1000=new JButton("1000");
				panelSave.add(bt1000);
				bt1000.setFont(font);
				bt1000.addActionListener(this);
				bt1000.setBounds(1000,260,100,50);
				
				bt001=new JButton("1");
				panelSave.add(bt001);
				bt001.setFont(font);
				bt001.addActionListener(this);
				bt001.setBounds(360,370,100,50);
				
				bt002=new JButton("2");
				panelSave.add(bt002);
				bt002.setFont(font);
				bt002.addActionListener(this);
				bt002.setBounds(520,370,100,50);
				
				bt003=new JButton("3");
				panelSave.add(bt003);
				bt003.setFont(font);
				bt003.addActionListener(this);
				bt003.setBounds(680,370,100,50);
				
				bt004=new JButton("4");
				panelSave.add(bt004);
				bt004.setFont(font);
				bt004.addActionListener(this);
				bt004.setBounds(840,370,100,50);
				
				bt005=new JButton("5");
				panelSave.add(bt005);
				bt005.setFont(font);
				bt005.addActionListener(this);
				bt005.setBounds(1000,370,100,50);
				
				bt006=new JButton("6");
				panelSave.add(bt006);
				bt006.setFont(font);
				bt006.addActionListener(this);
				bt006.setBounds(360,480,100,50);
				
				bt007=new JButton("7");
				panelSave.add(bt007);
				bt007.setFont(font);
				bt007.addActionListener(this);
				bt007.setBounds(520,480,100,50);
				
				bt008=new JButton("8");
				panelSave.add(bt008);
				bt008.setFont(font);
				bt008.addActionListener(this);
				bt008.setBounds(680,480,100,50);
				
				bt009=new JButton("9");
				panelSave.add(bt009);
				bt009.setFont(font);
				bt009.addActionListener(this);
				bt009.setBounds(840,480,100,50);
				
				bt000=new JButton("0");
				panelSave.add(bt000);
				bt000.setFont(font);
				bt000.addActionListener(this);
				bt000.setBounds(1000,480,100,50);
				
				btOk=new JButton("确定");
				panelSave.add(btOk);
				btOk.setFont(font);
				btOk.addActionListener(this);
				btOk.setBounds(480,600,100,60);
				
				btRetry=new JButton("重输");
				panelSave.add(btRetry);
				btRetry.setFont(font);
				btRetry.addActionListener(this);
				btRetry.setBounds(680,600,100,60);
				
				btCancel=new JButton("返回");
				panelSave.add(btCancel);
				btCancel.setFont(font);
				btCancel.addActionListener(this);
				btCancel.setBounds(880,600,100,60);
				
				this.setTitle("02尹好  28肖瑞  31王婧");
				this.add(panelSave);
				this.setSize(1366,723);
				this.setVisible(true);
				
				((JPanel) this.getContentPane()).setOpaque(false);
				URL url=MainFrame.class.getResource("1.jpg");
				 ImageIcon img = new ImageIcon(url);
				 JLabel background = new JLabel(img);
				 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
				 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
				 panelSave.setOpaque(false);
				
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
			int saveMoney=Integer.parseInt(tfMoney.getText());
			if(saveMoney%100!=0)
				JOptionPane.showMessageDialog(Save.this,"对不起，请存整额");
			else{
			if(saveMoney>10000){
				JOptionPane.showMessageDialog(Save.this, "对不起，一次只能存入100张！");
				tfMoney.setText("");
			}
			else{
				//发送新的账户信息给服务器
				pw.write("save\r\n");
				pw.write(saveMoney+"\r\n");
				pw.flush();
				//等待服务器响应
				String strEcho;
				try {
					strEcho=br.readLine();
					if(strEcho.equals("saveSuccess")){
						currCard.setMoney(currCard.getMoney()+saveMoney);
						JOptionPane.showMessageDialog(Save.this, "恭喜您存款"+saveMoney+"成功！\n您的当前卡账户余额为"+currCard.getMoney()+"元");
					}else if(strEcho.equals("saveFailure"))
					{
						JOptionPane.showMessageDialog(Save.this, "存款失败，请重试");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		}else if(arg0.getSource()==btCancel){
			Save.this.dispose();
			new MainFrame(br, pw, currCard).init();
		}else if(arg0.getSource()==btRetry){
			tfMoney.setText("");
		}
	}
}
