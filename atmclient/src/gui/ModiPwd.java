package gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;






import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import Comm.Card;




public class ModiPwd extends JFrame{
	
	JLabel jl1,jl2,jl3;
	Card currCard;
	BufferedReader br;
	PrintWriter pw;
	String pwd1;
	String pwd2;
	String pwd3;
	Boolean is1=false,is2=false,is3=false;
	public ModiPwd(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	public void init(){
		
        Font font= new Font("仿宋加粗",Font.PLAIN,28);
		JPanel PModi=new JPanel(null);
		JLabel jlb1=new JLabel("旧密码");
		jlb1.setFont(font);
		JLabel jlb2=new JLabel("新密码");
		jlb2.setFont(font);
		JLabel jlb3=new JLabel("请重输");
		jlb3.setFont(font);
		jl1=new JLabel("");
		jl1.setFont(font);
		jl2=new JLabel("");
		jl2.setFont(font);
		jl3=new JLabel("");
		jl3.setFont(font);
		final JPasswordField jf1=new JPasswordField();
		final JPasswordField jf2=new JPasswordField();
		final JPasswordField jf3=new JPasswordField();
		JButton btOk=new JButton("确认");
		btOk.setFont(font);
		JButton btCancel=new JButton("取消");
		btCancel.setFont(font);		
		jlb1.setBounds(100,120,150,50);
		PModi.add(jlb1);		
		jf1.setBounds(260,120,260,50);
		PModi.add(jf1);
		jl1.setBounds(260,120,260,50);
		PModi.add(jl1);
	
		jlb2.setBounds(100,230,150,50);
		PModi.add(jlb2);		
		jf2.setBounds(260,230,260,50);
		PModi.add(jf2);
		jl2.setBounds(260,230,200,50);
		PModi.add(jl2);
		
		jlb3.setBounds(100,320,150,50);
		PModi.add(jlb3);		
		jf3.setBounds(260,320,260,50);
		PModi.add(jf3);	
		jl3.setBounds(260,350,260,50);
		PModi.add(jl3);	
		
		btOk.setBounds(160,450,100,50);
		PModi.add(btOk);		
		btCancel.setBounds(350,450,100,50);
		PModi.add(btCancel);
		
		this.setTitle("02尹好  28肖瑞  31王婧");		
		this.add(PModi);		
		this.setVisible(true);
		this.setResizable(false); 
		this.setSize(1366,723);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		 
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=MainFrame.class.getResource("1.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		 PModi.setOpaque(false);
		 
		jf1.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				pwd1=new String(jf1.getPassword());
				if(currCard.getPwd().equals(pwd1)){
					jl1.setText("");
					is1=true;
					
				}
				else{
					is1=false;

					jl1.setText("密码错误");
					//jf1.requestFocus();
				}
			}
			

			
			
					
		});
		
		jf2.addFocusListener(new FocusAdapter(){

		
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				 pwd2=new String(jf2.getPassword());
				

				if(is1==true){
				if(currCard.getPwd().equals(pwd2)){
					jl2.setText("新旧密码不能一致");
					//jf2.requestFocus();
				}else
				{
					is2=true;
					jl2.setText("");
				}
			
			
				}
			}
			
			
					
		});
		jf3.addFocusListener(new FocusAdapter(){

			

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				 pwd3=new String(jf3.getPassword());
				if(is2==true){
				if(pwd3.equals(pwd2)){
					jl3.setText("");
					is3=true;
				}else
					jl3.setText("两次密码不相符");
					jf3.requestFocus();
				}

			}
			
					
		});
	btOk.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			
				
				if(is3==true){
					pw.write("ModiPwd\r\n");
					pw.write(pwd3+"\r\n");
					pw.flush();
					String strEcho;
					try {
						strEcho=br.readLine();
						if("ModiPwdSuccess".equals(strEcho)){
							currCard.setPwd(pwd3);
							JOptionPane.showMessageDialog(ModiPwd.this, "密码更改成功！");
						}
						else
							JOptionPane.showMessageDialog(ModiPwd.this, "密码更改失败！");

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(ModiPwd.this, "密码修改失败！");
				}
				
			}
			
			
		
		
	});	
	btCancel.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e) {
			ModiPwd.this.dispose();
			new MainFrame(br,pw,currCard).init();
			
		}
		
	});
}

}