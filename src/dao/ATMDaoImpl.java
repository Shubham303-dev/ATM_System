package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.ATM;
import connection.DBConnection;


public class ATMDaoImpl implements ATMDaoIntrf{
	Connection conn=DBConnection.createDBConnetion();;
	ATM atm=new ATM();
	
	//User validation
	@Override
	public boolean userValidate(String cardNumber, int pin) {
		boolean tf=false;
		try {
			String str="select id,amount from account where cardNumber='"+cardNumber+"' AND pin="+pin;
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(str);
			while(rs.next()) {
				int id=rs.getInt(1);
				atm.setId(id);
				atm.setCurrentBalance(rs.getDouble("amount"));
				tf=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tf;
	}
	
	
	//Balance Checking
	@Override
	public double balanceCheck() {
		try {
			PreparedStatement ps=conn.prepareStatement("select amount from account where id=?");
			ps.setInt(1, atm.getId());
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				atm.setCurrentBalance(rs.getDouble(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return atm.getCurrentBalance();
	}

	
	//Amount Withdrawal
	@Override
	public double withdrawal(double amount) {
		try {	
			double tempBalance=atm.getCurrentBalance()-amount;
			PreparedStatement ps=conn.prepareStatement("update account set amount="+tempBalance+" where id="+atm.getId());
			ps.executeUpdate();
			atm.setCurrentBalance(tempBalance);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return atm.getCurrentBalance();
	}

	@Override
	public double deposit(double amount) {
		try {	
			double tempBalance=atm.getCurrentBalance()+amount;
			PreparedStatement ps=conn.prepareStatement("update account set amount="+tempBalance+" where id="+atm.getId());
			ps.executeUpdate();
			atm.setCurrentBalance(tempBalance);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return atm.getCurrentBalance();
	}

}
