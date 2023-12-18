package dao;

public interface ATMDaoIntrf {
	public boolean userValidate(String cardNumber,int pin);
	public double balanceCheck();
	public double withdrawal(double amount);
	public double deposit(double amount);
}
