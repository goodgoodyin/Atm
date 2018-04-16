package comm;

import java.util.Date;


public class Msg {
	private String account;
	private String type;
	private int money;
	private Date time;
	public Msg(){
		
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Msg(String account,String type,int money,Date time){
		this.account=account;
		this.type=type;		
		this.money=money;
		this.time=time;
	}
}
