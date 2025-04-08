package models;

public class Owner {
	
	private String email;
	private String name;
	private String surname;
	private String pass;
	private String phone;
	private double income;
	
	public Owner() {
		
	}

	public Owner(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	public Owner(String email, String name, String surname, String pass, String phone) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.pass = pass;
		this.phone = phone;
		this.income = 0.00D;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "Owner [email=" + email + ", name=" + name + ", surname=" + surname + ", pass=" + pass + ", phone="
				+ phone + ", income=" + income + "]";
	}
	
	

}
