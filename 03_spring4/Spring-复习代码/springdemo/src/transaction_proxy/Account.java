package transaction_proxy;

public class Account {
	private Integer id;
	private String aname;
	private Double balance;
	
	public Account(String aname, Double balance) {
		this.aname = aname;
		this.balance = balance;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", aname=" + aname + ", balance=" + balance + "]";
	}
	
}
