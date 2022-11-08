package com.prog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer {
	
	public static Connection conn;
	public static ResultSet rs;
	public static PreparedStatement pst;
	
	
	
	public static void showDetails() throws SQLException {
		
		conn = BankConnection.getConnection();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your account number to view your account details ");
		String acc=sc.next();
		String s="select * from account where acc_no=?";
		
		pst=conn.prepareStatement(s);
		pst.setString(1, acc);
		rs=pst.executeQuery();
		if(rs.next()) {
			System.out.println("acc_no\t\tcustomer_name\tphone_no\thouse_no\tcity_or_village\tpincode\tamount");
		     String ac=rs.getString("acc_no");
		     String cname=rs.getString("cname");
		     String phone=rs.getString("phone");
		     String hno=rs.getString("house_no");
		     String dist = rs.getString("city");
		     String pin=rs.getString("pincode");
		     float amt=rs.getFloat("amount");
		     
		     System.out.println(ac+"\t\t"+cname+"\t"+phone+"\t"+hno+"\t"+dist+"\t"+pin+"\t"+amt);
		
		}
		System.out.println("Account not found");
		
	}
	public static void withdrawAmount() throws SQLException {
		
		conn = BankConnection.getConnection();
		float wamount;
		float a=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number");
		String acc=sc.next();
		System.out.println("Enter the amount you want to withdraw");
		wamount=sc.nextFloat();
		String s = "select * from account where acc_no=?";
		pst=conn.prepareStatement(s);
		pst.setString(1,acc);
		rs=pst.executeQuery();
		if(rs.next()) {
		 a=rs.getInt("amount");
		
		a=a-wamount;
		
		String upd="update account set amount=? where acc_no=?";
		pst=conn.prepareStatement(upd);
		pst.setFloat(1, a);
		pst.setString(2, acc);
		int rv=pst.executeUpdate();
		if(rv>0) {
			System.out.println("Transaction successful");
			System.out.println("Remaining account balance is :"+a);
		}else {
			System.out.println("Insufficient Balance");
		}
		}else {
			System.out.println("Account number not found!!");

		}
		
	}
	
	
	public static void depositAmount() throws SQLException {
		
		conn = BankConnection.getConnection();
		float damount,a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number");
		String acc=sc.next();
		System.out.println("Enter the amount you want to Deposit");
		damount=sc.nextFloat();
		String s = "select * from account where acc_no=?";
		pst=conn.prepareStatement(s);
		pst.setString(1, acc);
		rs=pst.executeQuery();
		if(rs.next()) {
		 a=rs.getFloat("amount");
		
		a=a+damount;
		damount=a;
		String upd="update account set amount=? where acc_no=?";
		pst=conn.prepareStatement(upd);
		pst.setFloat(1, a);
		pst.setString(2, acc);
		int rv=pst.executeUpdate();
		if(rv>0) {
			System.out.println("Transaction successful");
			System.out.println("Remaining account balance is :"+a);
		}
		}else {
			System.out.println("Account holder not found!!");
		}
		
	
		
	}
	

}
