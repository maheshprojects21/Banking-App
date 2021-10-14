package com.s.pkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.s.pkg.Util.DatabaseUtil;

public class AccountService {
	
	
	Connection conn = null;
	PreparedStatement ps = null;

	
	
	
	public String createAccount(Account account) {
		
		String sql = null;
		int numRowsAffected = 0;
		try {
			conn = DatabaseUtil.getConnection();
			if (conn != null) {
				sql = "insert into Bank_Account(FirstName, LastName, Email, AccountPwd, Balance, AccountId) " +
					  "values(?, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, account.getFirstName());
				ps.setString(2, account.getLastName());
				ps.setString(3, account.getEmailId());
				ps.setString(4, account.getPassword());
				ps.setDouble(5, account.getBalance());
				ps.setString(6, account.getAccountId());
				
				numRowsAffected = ps.executeUpdate();
				
				if (numRowsAffected == 1) {
					return "Account created successfully";
				} else {
					return "failed to create account";
				}
			}
			
			
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return null;
	}
	
	public Account getAccountByEmailId(String emailId) {
		System.out.println("insdie get");
		String sql = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			if (conn != null) {
				sql = "select * from Bank_Account where Email=?";
				System.out.println("sql = " +sql);
				ps = conn.prepareStatement(sql);
				ps.setString(1, emailId);
				System.out.println("sql = " +sql);
				rs = ps.executeQuery();
				
				Account a = null;
				while(rs.next()) {
					String firstName = rs.getString(1);
					String lastName = rs.getString(2);
					String pwd = rs.getString(4);
					double balance = Double.parseDouble(rs.getString(5));
					String accountId = rs.getString(6);
					a = new Account(firstName, lastName, pwd, accountId, emailId, balance);
					System.out.println("account created");
					return a;
				}
			}
			
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return null;
	}
	
	
	public Account getAccountByAccountId(String accountId) {
		System.out.println("insdie get");
		String sql = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			if (conn != null) {
				sql = "select * from Bank_Account where AccountId=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, accountId);
				rs = ps.executeQuery();
				
				Account a = null;
				while(rs.next()) {
					String firstName = rs.getString(1);
					String lastName = rs.getString(2);
					String pwd = rs.getString(4);
					double balance = Double.parseDouble(rs.getString(5));
					String emailId = rs.getString(3);
					a = new Account(firstName, lastName, pwd, accountId, emailId, balance);
					System.out.println("account created");
					return a;
				}
			}
			
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return null;
	}
	
	
	public int deleteAccount(String accountId) {
		System.out.println("inside delete");
		System.out.println("acc id" + accountId);
		String sql = null;
		int numRowsAffected = 0;
		try {
			conn = DatabaseUtil.getConnection();
			if (conn != null) {
				sql = "delete from Bank_Account where AccountId=" + accountId;
				ps = conn.prepareStatement(sql);
				numRowsAffected = ps.executeUpdate();
				System.out.println("rows del =  " + numRowsAffected);
				return numRowsAffected;
			}
			
			
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			System.out.println(e);
		}
		return 0;
	}
	
	
	public String verifyAccountCredentials(String emailId, String pwd) {
		
		String sql = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			if (conn != null) {
				sql = "select count(*) from Bank_Account where email=? and accountpwd=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, emailId);
				ps.setString(2, pwd);
				
				rs = ps.executeQuery();
				int count = 0;
				while(rs.next()) {
					count = rs.getInt(1);
				}
				
				if(count == 1) {
					return "Verification successful";
				} else {
					return "Incorrect username and/or pwd";
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return null;
	}
	
	
	public int deposit(String accountId, double amount) {
		int rowsAffected = 0;
		try {
			conn = DatabaseUtil.getConnection();

			if (conn != null) {
				String sql = "update Bank_Account set Balance=((select Balance from Bank_Account where AccountId="+accountId+")+"+amount+") where AccountId="
						+ accountId;
				ps = conn.prepareStatement(sql);
				rowsAffected = ps.executeUpdate(sql);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DatabaseUtil.closeConnection(conn);
		}
		return rowsAffected;
	}
	
	
	
	public int withdraw(String accountId, double amount) {
		int rowsAffected = 0;
		String sql = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();

			if (conn != null) {
				sql = "select Balance from Bank_Account where AccountId=" + accountId;
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					double amountCurrentlyInAccount = rs.getDouble(1);
					if (amountCurrentlyInAccount != 0 && amountCurrentlyInAccount >= amount) {
						sql = "update Bank_Account set Balance=((select Balance from Bank_Account where AccountId="+accountId+")-"+amount+") where AccountId="
								+ accountId;
						ps = conn.prepareStatement(sql);
						rowsAffected = ps.executeUpdate(sql);
					} else {
						// if amount withdrawn is greater than the current balance.
						return -1;
					}
				}
			}	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DatabaseUtil.closeConnection(conn);
		}
		return rowsAffected;
	}
	
	
	
	public int transfer(String sourceAccountId, String destinationAccountId, double amount) {
		
		int withdrawRes = withdraw(sourceAccountId, amount);
		if (withdrawRes == -1) {
			return -1;
		}
		
		int depositRes = deposit(destinationAccountId, amount);
		if (depositRes == 1) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	
	
	

}
