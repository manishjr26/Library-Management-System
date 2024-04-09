package com.miran.CONTROLLER;

import java.util.InputMismatchException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main_Controller 
{
	public static void main(String[] args) 
	{
		java.util.Scanner mr=new java.util.Scanner(System.in);
		System.out.println("\n\t\t\t\t\t\t\t\t ===================== Welcome to Library Management System ====================== \t\n\t\t Choose your choice: \n\n\t\t\t\t\t\t\t\t 1 - Go to Member Controller \t "
				+ "2 - Go to Library Controller \t 3 - Go to Book Controller \n\n\t\t\t\t\t\t\t\t 4 - Go to Admin Controller "
				+ "\t 5 - Go to Loan Controller \t 6 - Exit");
		try
		{
			int userChoice=mr.nextInt();
			switch (userChoice) 
			{
			case 1: Member_Controller.main(null);				
				break;
			case 2: Library_Controller.main(null);				
				break;
			case 3: 	Book_Controller.main(null);
				break;
			case 4: 	Admin_Controller.main(null);
				break;
			case 5: 	Loan_Controller.main(null);
				break;
			case 6: 	
				System.out.println("\n\t\t\t ------------------------- \n\t\t\t ++++++++++++++++++++ Thank You For Visiting \"Library Management System \"  . +++++++++++++++++++ \n \t\t\t\t\t\t\t\t\t -------------------------------------- ");
				System.exit(0);
				break;
			default: System.err.println("\n\t\t\t\t\t\t\t\t\t ---- Invalid Input . ---- \t\t\t\t");
				break;
			}
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t\t\t\t------------------- Input Mis Match --------------- \t\t\t\t\t");
		}
		
		finally
		{
			mr.close();
		}
	}
}
