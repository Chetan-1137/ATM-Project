package com.java;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.java.*;

public class SqlCommands {
	public static int id=0;
	static long balance=0;
	public static String name=null;
	public static int pass=0;
	public static String acc_no=null;
	public static String mob_no=null;
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		Methods ac=new Methods();
		Methods M=new Methods();
		//PIN GENERATOR
		Random r1=new Random();
		Random r2=new Random();
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection cm=DriverManager.getConnection("jdbc:mysql://localhost:3306/Account","root","root");
		java.sql.Statement st=cm.createStatement();
		java.sql.PreparedStatement p=null;
		System.out.println("\n**********************************************************\n");
		System.out.println("\n                   <<*** WELCOME ***>>\n\nHope  you doing greate\n\n"
				+ "  \t\tMake your choice >>\n\n1] Account Validfication \n2] Bank transation ");
		int x12=0;
		try {
			x12=sc.nextInt();
			if(x12>5) {
				System.out.println("Invalid option !");
			}
		}catch(Exception e) {
			System.out.println("Invalid option");
		}
		switch (x12){
		case 1:
			for(int i=0;i<2;i++) {
				System.out.println("\n**********************************************************\n");
				System.out.println("  Choose your option  >>\n"
						+ "1] Bank Account Opening form\n2] Passbook \n3] Delete Current bank account\n"
						+ "4] Exit");
				int choose=0;
				try {
					choose=sc.nextInt();
					if(choose>6) {
						System.out.println("invalid Option\nChoose again");
						choose=sc.nextInt();
						if(choose>6) {
							System.out.println("Again invalid Option \nTry after a second");
							System.exit(choose);
						}
					}
				}
				catch(Exception e) {
					System.out.println("Invalid option");
				}
				switch(choose){
				case 1:
					int a=r1.nextInt(500);
					int b=r1.nextInt(500);
					int c=r1.nextInt(500);
					int d=r1.nextInt(500);
					int e=r1.nextInt(500);
					int number=a+b+c+d+e;
					int number2=0;
					int x=r2.nextInt(550);
					int y=r2.nextInt(550);
					int z=r2.nextInt(550);
					int l=r2.nextInt(550);
					int m=r2.nextInt(550);
					number2=x+y+z+l+m;
					if(number>1000) {
						pass=number;
					}if(number2>1000) {
						pass=number2;
					}
					//ACCOUNT NUMBER GENERATOR
					int a1=r1.nextInt(50000000);
					int b1=r1.nextInt(50000000);
					int c1=r1.nextInt(50000000);
					int d1=r1.nextInt(50000000);
					int e1=r1.nextInt(50000000);

					int x1=r2.nextInt(55000000);
					int y1=r2.nextInt(55000000);
					int z1=r2.nextInt(55000000);
					int l1=r2.nextInt(55000000);
					int m1=r2.nextInt(55000000);
					long a11=a1+c1+b1+d1+e1;
					long a12=x1+y1+z1+l1+m1;
					long j1=a11+a12;
					String acc1=Long.toString(j1);
					int lg=acc1.length();
					acc_no=acc1;
					int a2=r1.nextInt(1);
					int a3=r1.nextInt(2);
					int a4=r1.nextInt(3);
					int t1=r2.nextInt(2);
					int t2=r2.nextInt(3);
					int t3=r2.nextInt(4);
					int a5 =r1.nextInt(5);
					int a6=r2.nextInt(6);
					int a7=r2.nextInt(7);
					int t4=t1+t2+t3+a6+a7;
					int t5=a2+a3+a6+a4+a5;
					id=t5+t4;
					M.addingData();
					String query="insert into bank(id,name,acc_no,mob_no,balance,pass)values(?, ? ,?, ?, ? ,?)";
					java.sql.PreparedStatement pr=cm.prepareStatement(query);
					pr.setInt(1,id);
					pr.setString(2, name);
					pr.setString(3, acc_no);
					pr.setString(4, mob_no);
					pr.setLong(5, balance);
					pr.setInt(6, pass);
				int k=	pr.executeUpdate();
					System.out.println(k+" - Your bank accouunt created ");
					System.out.println("Your Account number and Pin is generated \n"
							+ "PIN >> "+pass+"\nAccount Number >> "+acc_no+id);
					System.out.println("\n**********************************************************\n");
					break;
				case 2:
					System.out.println("Enter PIN >>");
					int pin=sc.nextInt();
					String sql = "select * from bank where pass ="+pin;
					p = cm.prepareStatement(sql);
					java.sql.ResultSet rs = p.executeQuery();
					// Condition check
					while (rs.next()) {
						String name = rs.getString("name");
						long mob=rs.getLong("mob_no");
						long acc=rs.getLong("acc_no");
						int balance=rs.getInt("balance");
						System.out.println("\n**********************************************************\n");
						System.out.println("\t\t***** WELCOME ******\n\nCustomer name >> "+name+"\n"
								+ "Account Number >> "+acc+"\n"
								+"Mobile Number >> "+mob+"\nCurrent Balance >> "+balance);
						System.out.println("Thanks For Visisting Mr "+name);
					}
					System.out.println("\t");
					break;
				case 3:
					System.out.println("Enter your account number >>");
					acc_no=sc.next();
					int k1=st.executeUpdate("delete from bank where acc_no="+acc_no);
					System.out.println(k1+" Account Deleted !");
					break;
				case 4:
					System.out.println("Exiting");
					System.out.println("****** All Process done *****");
					break;
				case 5:
					try {
						String sql1 = "select * from bank ";
						p = cm.prepareStatement(sql1);
						java.sql.ResultSet rs1 = p.executeQuery();
						System.out.println("PIN\t\tName\t\t\tMobile\t\t\tAccount No\t\t\tBalance");
						while (rs1.next()) {
							int password = rs1.getInt("pass");
							String name = rs1.getString("name");
							long mob=rs1.getLong("mob_no");
							long acc=rs1.getLong("acc_no");
							int balance=rs1.getInt("balance");
							System.out.println(password + "\t\t" + name
									+ "\t\t" + mob+"\t\t"+acc+"\t\t\t"+balance);
						}
					}
					catch(SQLException h) {
						System.out.println(h);
					}
					System.out.println("\n\n ^^ Data");
					break;
				}
			}
		case 2:
			System.out.println("\n\n************  ATM Machine  ************* \n");
			System.out.println("If their is no Correct PIN message comes then PIN is Wrong !");
			System.out.println("Enter PIN >>");
			int pin=sc.nextInt();
			String sql = "select * from bank where pass="+pin;
			p = cm.prepareStatement(sql);
			java.sql.ResultSet rs = p.executeQuery();

			String sql1 = "select *from bank where pass="+pin;
			p = cm.prepareStatement(sql1);
			java.sql.ResultSet rs1 = p.executeQuery();
			while (rs1.next()) {
				int password = rs1.getInt("pass");
				String name = rs1.getString("name");
				long mob=rs1.getLong("mob_no");
				long acc=rs1.getLong("acc_no");
				int balance=rs1.getInt("balance");
				System.out.println(password);
				if(pin!=password) {
					System.out.println("Incorrect");
				}else if(pin==password){
					System.out.println("Correct PIN Good to gooo >>");
					break;
				}
			}
			System.out.println("\nEnter the option >>\n");
			System.out.println("1 - Deposite               2 - Withdraw");
			System.out.println("3 -Mini Statement         4 - Show Balance");
			int option=0;
			try {
				option=sc.nextInt();}
			catch(IllegalArgumentException e) {
				System.out.println("Invalid Option");
			}
			for(int i=0;i<2;i++) {
				switch(option) {
				case 1:
					while (rs.next()) {
						String name = rs.getString("name");
						long mob=rs.getLong("mob_no");
						long acc=rs.getLong("acc_no");
						balance=rs.getInt("balance");
						System.out.println("balance > "+balance);
						System.out.println("Enter the amount for Deposite >> ");
						int add=sc.nextInt();
						if(add<1) {
							System.out.println("Invalid Amount !\nTry again");
						}
						else if(add>1000000) {
							System.out.println("You can't deposite that much money !");
						}
						else {
							balance+=add;
							System.out.println();
						}
						sql=" update bank set balance="+balance+" where pass="+pin;
						int k=st.executeUpdate(sql);
						System.out.println("Current balance >> "+balance);
					}	
					break;
				case 2:
					while (rs.next()) {
						String name = rs.getString("name");
						long mob=rs.getLong("mob_no");
						long acc=rs.getLong("acc_no");
						balance=rs.getInt("balance");
						System.out.println("balance > "+balance);
						System.out.println("Enter the amount for Withdraw >> ");
						int minus=sc.nextInt();
						int tot=0;
						if(balance<minus) {
							System.out.println("Bank balance is low can't withdraw");
						}
						else if(minus==balance) {
							System.out.println("You can't withdraw all amount from bank !");
						}
						else if(minus>1000000) {
							System.out.println("You can't Withdraw that much money !");
						}
						else if(minus<1){
							System.out.println("Low Number ! \n Try again ");
						}else {
							balance-=minus;
						}
						System.out.println("Current balance >> "+balance);
					}
					sql=" update bank set balance="+balance+" where pass="+pin;
					int k=st.executeUpdate(sql);
					break;
				case 3:
					try {
						while (rs.next()) {
							String name = rs.getString("name");
							long mob=rs.getLong("mob_no");
							long acc=rs.getLong("acc_no");
							balance=rs.getInt("balance");
							System.out.println("\n**********************************************************\n");
							System.out.println("MINI Statatement ");
							System.out.println("Name >> "+name+"\nMob No >> "+mob+"\nBalance >> "+balance);
						}
					}catch(SQLException f) {
						System.out.println(f);
					}
					break;
				case 4:
					while (rs.next()) {
						String name = rs.getString("name");
						long mob=rs.getLong("mob_no");
						long acc=rs.getLong("acc_no");
						balance=rs.getInt("balance");
						System.out.println("Current balance >> "+balance);
					}
					break;
				}
			}
			System.out.println("\n**********************************************************\n");
			System.out.println("\n"
					+ "Thank you for visiting us "                  );
		}
	}
}