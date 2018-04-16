package comm;

public class Card {
	private String account;
	private String name;
	private String pwd;
	private float money;
	private String id;
	private String phone;
	private  String use;
	private float pmoney;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPMoney(float pmoney) {
		this.pmoney = pmoney;
	}
	public float getpMoney() {
		return pmoney;
	}
	public String getUse(){
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name= name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id= id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Card(){
		
	}
	public Card(String account,String name,String pwd,float money,String id,String phone){
		this.account=account;
		this.name =name;
		this.pwd=pwd;		
		this.money=money;
		this.id=id;
		this.phone=phone;
	}
}
