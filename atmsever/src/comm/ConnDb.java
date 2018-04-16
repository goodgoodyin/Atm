package comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

public class ConnDb {
	private Connection conn=null;
	private String Driver="jdbc:mysql://127.0.0.1:3306/test";
	private String Username="root";
	private String pwd="root";
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private Statement st=null;

	public void getConn(){
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动失败！");
		}
		//创建实例对象
		try {
			conn=DriverManager.getConnection(Driver, Username, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接失败！");
		}
		
		
	}
	//关闭连接状态
	public void Allclose(){
		
			try {
				if(rs!=null)
					rs.close();
				
				if(pstmt!=null)
					pstmt.close();
				if(st!=null)
					st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	//查询客户账户是否存在
	public Card checkLogin(String sql){
		Card currCard=null;
		try {
			//创建执行对象
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()){
				currCard=new Card();
				currCard.setAccount(rs.getString("account"));
				currCard.setName(rs.getString("name"));
				currCard.setPwd(rs.getString("pwd"));
				currCard.setMoney(Float.parseFloat(rs.getString("money")));
				currCard.setId(rs.getString("id"));
				currCard.setPhone(rs.getString("phone"));
				currCard.setUse(rs.getString("usess"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.Allclose();
		}
		
		return currCard;
	}
	//众筹
	public Card Cptc(String sql){
		Card currCard=null;
		try {
			//创建执行对象
			//pstmt=conn.prepareStatement();
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()){
				currCard=new Card();
				currCard.setAccount(rs.getString("account"));
				currCard.setName(rs.getString("name"));
				currCard.setPwd(rs.getString("pwd"));
				currCard.setMoney(Float.parseFloat(rs.getString("money")));
				currCard.setId(rs.getString("id"));
				currCard.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.Allclose();
		}
		
		return currCard;
	}
	
	public List<Msg> querryMsg(String sql){
		 List<Msg>  list=new ArrayList<Msg>();//定理list泛型集合，并实例化

		try {
			//创建执行对象
			//pstmt=conn.prepareStatement();
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){//游标后移一条记录，如果记录存在
				Msg msg=new Msg();//实例化 对象
				msg.setAccount(rs.getString("account"));
				msg.setType(rs.getString("type"));
				msg.setMoney(rs.getInt("money"));
				msg.setTime(rs.getDate("time"));

				list.add(msg);//添加对象msg到集合类中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.Allclose();
		}
		
		return list;
	}
	//查询管理员账户是否存在
		public Card checkManager(String sql1){
			Card currCard=null;
			try {
				//创建执行对象
				//pstmt=conn.prepareStatement();
				st=conn.createStatement();
				rs=st.executeQuery(sql1);
				if(rs.next()){
					currCard=new Card();
					currCard.setAccount(rs.getString("account"));
					currCard.setName(rs.getString("name"));
					currCard.setPwd(rs.getString("pwd"));
					currCard.setMoney(Float.parseFloat(rs.getString("money")));
					currCard.setId(rs.getString("id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("错误");
			}
			finally{
				this.Allclose();
			}
			
			return currCard;
		}
	
	//转账
	public Card querryByAccount(String sql){
		Card myCard=null;
		try {
			
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()){
				myCard=new Card();
				myCard.setAccount(rs.getString("account"));
				myCard.setMoney(Float.parseFloat(rs.getString("money")));
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.Allclose();
		}
		return myCard;
	}
	
	public Card querryByphone(String sql){
		Card myCard=null;
		try {
			
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()){
				myCard=new Card();
				myCard.setAccount(rs.getString("account"));
				myCard.setMoney(Float.parseFloat(rs.getString("money")));
				myCard.setPMoney(Float.parseFloat(rs.getString("pmoney")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.Allclose();
		}
		return myCard;
	}
	
	//查询号码
	//数据库更新
	
	public int updateCard(String sql){
		int flag=0;
		
		try {
			st=conn.createStatement();
			flag=st.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			JOptionPane.showOptionDialog(null,"更新的信息有误，请联系职员！！","更新错误", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE,null, null, null);
			e.printStackTrace();//打印错误
		}
		finally{
			this.Allclose();
		}
		return flag;
	}
	public int updateCard1(String sql){
		int flag=0;
		
		try {
			st=conn.createStatement();
			flag=st.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			JOptionPane.showOptionDialog(null,"更新的信息有误，请联系职员！！","更新错误", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE,null, null, null);
			e.printStackTrace();//打印错误
		}
		finally{
			this.Allclose();
		}
		return flag;
	}
		//数据库删除
	public int delectCard(String sql){
		int flag=0;
		try {
			st = conn.createStatement();
			flag=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			JOptionPane.showOptionDialog(null,"删除的信息有误，请重新输入！！","删除失败", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE,null, null, null);
		}finally{
			this.Allclose();
		}
		
		return flag;
	}
	public List<InCard> checkAll1(String sql){
		List<InCard>  cardlist=new ArrayList<InCard>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				InCard card=new InCard();
				card.setAccount(rs.getString("account"));
				card.setTime(rs.getString("time"));
				card.setType(rs.getString("type"));
				card.setMoney(rs.getString("money"));
				cardlist.add(card);
				System.out.print(card.getType());
			}
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			JOptionPane.showOptionDialog(null,"查询的信息有误，请重新输入！！","查询错误", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE,null, null, null);
		}
		finally{
			this.Allclose();
		}
		return cardlist;
		
	}
	//查询Card表信息，返回集合类
		public List<Card> checkAll(String sql){
			List<Card>  cardlist=new ArrayList<Card>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()){
					Card card=new Card();
					card.setAccount(rs.getString("account"));
					card.setName(rs.getString("name"));
					card.setPwd(rs.getString("pwd"));
					card.setMoney(Float.parseFloat(rs.getString("money")));
					card.setId(rs.getString("id"));
					card.setPhone(rs.getString("phone"));
				}
			} catch (SQLException e) {
				// TODO 自动生成 catch 块
				JOptionPane.showOptionDialog(null,"查询的信息有误，请重新输入！！","查询错误", JOptionPane.DEFAULT_OPTION, 
						JOptionPane.INFORMATION_MESSAGE,null, null, null);
			}
			finally{
				this.Allclose();
			}
			return cardlist;
			
		}
		public Date getOldTime(String sql){
			Date date1=null;
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				 date1=rs.getDate("time");
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				this.Allclose();
			}
			
			
			return date1;
		}
		
}
