package lis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ServerMain extends JFrame{
	JButton btStart,btStop;
	boolean startFlag;
	public void init(){
		
		JPanel ServerMain = new JPanel(null);
		JToolBar bar=new JToolBar();
		btStart=new JButton("启动");
		btStop=new JButton("关闭");
		bar.add(btStart);
		bar.add(btStop);
		this.add(bar,"North");
		this.setSize(300, 300);
		this.setVisible(true);
		this.setTitle("02尹好  28肖瑞  31王婧");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		btStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!startFlag){
					new Thread(new ServerLis()).start();
					ServerMain.this.dispose();
					startFlag=true;
				}
			
			}
			
			
		});
		btStop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new ServerMain().init();
	}

}
