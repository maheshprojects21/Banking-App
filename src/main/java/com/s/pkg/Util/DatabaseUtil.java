package com.s.pkg.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtil {
		
		
		private static final String DRIVERNAME="oracle.jdbc.driver.OracleDriver";
		private static final String URL="jdbc:oracle:thin:@//localhost:32769/ORCLCDB.localdomain";
		private static final String USERNAME="system";
		private static final String PASSWORD="Oradoc_db1";
		
		
		
		public static Connection getConnection(){
			
			Connection con=null;
			try {
				Class.forName(DRIVERNAME);
				System.out.println("Driver loaded!");
				con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("connection made!");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			return con;
			
			
		
		}
		

		
		public static void closeStatement(PreparedStatement ps){
			
			if(ps!=null){
				
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
			
			
		}
		
		
		
		public static void closeConnection(Connection  con){
			
			if(con!=null){
				
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
			
			
		}
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			getConnection();

		}

}
