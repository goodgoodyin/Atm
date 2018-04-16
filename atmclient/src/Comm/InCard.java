package Comm;

public class InCard {
	private String account;
	private String time;
	private String type;
	private String money;
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public InCard(String account,String time,String type,String money){
		this.account=account;
		this.time=time;	
		this.type=type;
		this.money=money;
		
	}
}