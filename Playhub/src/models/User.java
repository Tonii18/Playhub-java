package models;

public class User {
	
	private String mail;
	private String name;
	private String pass;
	private String phone;
	private double balance;
	
	public User() {
		
	}

	public User(String mail, String name, String pass, String phone) {
		super();
		this.mail = mail;
		this.name = name;
		this.pass = pass;
		this.phone = phone;
		this.balance = 0.00D;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [mail=" + mail + ", name=" + name + ", pass=" + pass + ", phone=" + phone + ", balance=" + balance
				+ "]";
	}
}
