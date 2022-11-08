package com.prog;

import java.sql.SQLException;
import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) throws SQLException {
		
Scanner sc = new Scanner(System.in);
		
		int choice,c2,c3;
		char ch;
		String upass,uname;
		
		while(true) {
			
			System.out.println("________WELCOME_______");
			System.out.println("Enter your choice from below");
			System.out.println("1.For Customer");
			System.out.println("2.For Bank Staff");
			
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				while(true) {
				System.out.println("**********__WELCOME__*********");
				System.out.println("1. Display the account details");
				System.out.println("2. Witihdraw Amount");
			    System.out.println("3. Deposit Amount");
			    
			    c2=sc.nextInt();
			    switch(c2) {
			    case 1:
			    	System.out.println("Enter your account number to view account details:");
			    	Customer.showDetails();
			    	break;
	case 2:
			    	System.out.println("Withdrawl Section");
			    	Customer.withdrawAmount();
			    	break;
			    case 3:
			    	System.out.println("Deposit Section");
			    	Customer.depositAmount();
			    	
			    	default:System.out.println("Invalid input");
			    		break;
			    }
			    System.out.println("Do you want to continue? Y/N");
			    char ch1=sc.next().charAt(0);
			    if(ch1=='n'||ch1=='N') {
			    	break;
			    }
			    
				}
				break;
			case 2:
				
				System.out.println("Welcome to the login window");
				System.out.println("Enter username:");
				uname=sc.next();
				System.out.println("Enter your password:");
				upass=sc.next();
				if(uname.equalsIgnoreCase("Varsha123")&&upass.equals("varsha@100")) {
					while(true) {
					System.out.println("_***WELCOME***_");
					System.out.println("Choose the options you waant to perform:");
					System.out.println("1. Open new account.");
					System.out.println("2. Delete existing details.");
					System.out.println("3. Update the Record as per requeust.");
					System.out.println("4. Retrive all records.");
					c3=sc.nextInt();
					
					switch(c3) {
					case 1:
						System.out.println("Fill the following details correctly to open an account.");
						BankEmployee.addAccountNumber();
						break;
						
					case 2:
						System.out.println("Enter account number to delete record.");
						BankEmployee.deleteRecord();
						break;
					case 3:
						System.out.println("Update existing records.");
						BankEmployee.updateRrecord();
						break;
					case 4:
						System.out.println("To view all records.");
						BankEmployee.retriveRecords();
						break;
						default:
							System.out.println("Invalid Input");
					      break;
					      
					}
				
					System.out.println("Do you want to continue?");
					char inp=sc.next().charAt(0);
					if(inp=='n'||inp=='N') {
						break;
					}
					System.out.println("You have been logged out.");
					
					}
				}else {
					System.out.println("Incorrect username or password! ");
					
				
				}
				
				
				
				break;
				
				default:
					System.out.println("Invalid Input");
					break;
			}
			System.out.println("Do you want to continue y/n?");
			char ch2 = sc.next().charAt(0);
			if(ch2=='n'||ch2=='N') {
				break;
			}
		}
		

	}

}
