package Comm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;





import java.util.Calendar;
public class TestMingxi extends JFrame {
	JTable table;
	DefaultTableModel tableModel;
	Calendar cal;
	String time;
	String type;
	JButton btCancel;
	String money;	
	Card currCard;
	String account;
	BufferedReader br;
	PrintWriter pw;
	public TestMingxi(BufferedReader br,PrintWriter pw,Card currCard){
		this.br=br;
		this.pw=pw;
		this.currCard=currCard;
	}
	public TestMingxi(){
		
	}
	public void init(){
		
		cal=Calendar.getInstance();
		setBounds(0,0,400,300);
		 btCancel=new JButton("����");
		 this.add(btCancel);
		Vector<String> columnNames=new Vector<String>();//��������������
		columnNames.add("ʱ��");//�������
		columnNames.add("����");//�������
		columnNames.add("���");//�������
		Vector<Vector<String>> tableValues=new Vector<Vector<String>>();//��������������
	
		tableModel=new DefaultTableModel(tableValues,columnNames);
		table=new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(tableModel));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.setRowHeight(20);
		table.setForeground(Color.RED);//ǰ����ɫ
		JScrollPane scrollPane=new JScrollPane(table);
		this.add(scrollPane);
		
		this.setSize(1366,723);   
		this.setTitle("02����28Ф��31���");
		this.setVisible(true);
		this.setResizable(false);
		
		pw.write("Mingxi\r\n");
		pw.write(currCard.getAccount()+"\r\n");
		pw.flush();
				try {
					    String str=br.readLine();
						while(!str.equals("break")){
							String[] data=str.split("#");
							time=data[0];
							type=data[1];
							money=data[2];
							String[] rowValues={time,type,money};
							tableModel.addRow(rowValues);
						    str=br.readLine(); 
						}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				btCancel.addActionListener(new ActionListener(){

				
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						   TestMingxi.this.dispose();

					}
				
						
				});
			}
		
	
}





