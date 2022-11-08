package com.prog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BankEmployee {
	
	private static Connection conn;
	private static ResultSet rs;
	private static PreparedStatement pst;
	
	
	public static void addAccountNumber() throws SQLException {
		
		conn=BankConnection.getConnection();
		
		Scanner sc = new Scanner(System.in);
		String acc = null;
		String cname,mname,lname,hno,village,pin,pno;
		float inamt;
		System.out.println("Enter customer name");
		cname=sc.next();
		System.out.println("Enter customer house number");
		hno=sc.next();
		System.out.println("Enter customer city name");
		village=sc.next();
		System.out.println("Enter pin code");
		pin=sc.next();
		System.out.println("Enter the phone number");
		pno=sc.next();
		System.out.println("Enter the initial amount you want to deposit");
		inamt=sc.nextFloat();
		System.out.println("Assign a new account number for the user.");
		acc=sc.next();
		
		String s="insert into account values(?,?,?,?,?,?,?)";
		
		pst=conn.prepareStatement(s);
		
		
		pst.setString(1, acc);
		pst.setString(2, cname);
		pst.setString(3, pno);
		pst.setString(4, hno);
		pst.setString(5, village);
		pst.setString(6, pin);
		pst.setFloat(7, inamt);
		
		int rv=pst.executeUpdate();
		if(rv>0) {
			System.out.println("Record inserted Successfully.");
		
		}
		else {
			System.out.println("Unable to insert record");
		}
		
		
	}
	public static void deleteRecord() throws SQLException {
		conn=BankConnection.getConnection();
		
		String acc;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number to delete record");
		acc=sc.next();
		
		String sel="Select * from account where acc_no=?";
		pst=conn.prepareStatement(sel);
		pst.setString(1, acc);
		rs=pst.executeQuery();
		if(rs.next()) {
			String del="delete from account where acc_no=?";
			pst=conn.prepareStatement(del);
			pst.setString(1, acc);
			int rv=pst.executeUpdate();
			if(rv>0) {
				System.out.println("Record is deleted");
			}else {
				System.out.println("ERROR!!!!!");
			}
			}else {
				System.out.println("Student id "+acc+" not exists");
			}
		
	}
	
	public static void updateRrecord() throws SQLException {
		
		conn=BankConnection.getConnection();
		
		String cname,acc,phone;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter customer account number to update record");
		acc=sc.next();
		String s ="select * from account where acc_no=?";
		pst=conn.prepareStatement(s);
		pst.setString(1,acc);
		rs=pst.executeQuery();
		
		if(rs.next()) {
			
			System.out.println("Enter the operation you want to perform");
			System.out.println("1. To update name of the customer");
			System.out.println("2. to update Phone number");
			
			int input;
			input = sc.nextInt();
			
			switch(input) {
			
			case 1:
				System.out.println("Enter the name to change");
				 cname=sc.next();
				 
				String upd="update account set cname=? where acc_no=?";
				pst=conn.prepareStatement(upd);
				pst.setString(1,cname);
				pst.setString(2, acc);
				
				int rv=pst.executeUpdate();
				if(rv>0) {
					System.out.println("Name is changed succesfully");
				}else {
					System.out.println("Error!!");
				}
				break;
				
			case 2:
				
				System.out.println("Enter the phone number you want to update");
				phone=sc.next();
				
				String upd1="update account set phone=? where acc_no=?";
				pst=conn.prepareStatement(upd1);
				pst.setString(1, phone);
				pst.setString(2, acc);
				
				int rv1=pst.executeUpdate();
				if(rv1>0) {
					System.out.println("Phone number is changed succesfully");
				}else {
					System.out.println("Error!!");
				}
				
				break;
				
				
			}
			
		}
		
		
	}
	
	public static void retriveRecords() throws SQLException {
         
		conn = BankConnection.getConnection();
		
		
		String s="select * from account";
		pst=conn.prepareStatement(s);
		rs=pst.executeQuery();
		System.out.println("acc_no\t\tcustomer_name\tphone_no\thouse_no\tcity\t\tpincode\t\tamount");
		while(rs.next()) {
			
		    
			String ac=rs.getString("acc_no");
		     String cname=rs.getString("cname");
		     String phone=rs.getString("phone");
		     String hno=rs.getString("house_no");
		     String dist = rs.getString("city");
		     String pin=rs.getString("pincode");
		     int amt=rs.getInt("amount");
		     
		     System.out.println(ac+"\t\t"+cname+"\t\t"+phone+"\t"+hno+"\t\t"+dist+"\t\t"+pin+"\t\t"+amt);
		
		}
		System.out.println("Error!!!");
		
	}
	

}
