package com.miran.CONTROLLER;

import java.util.InputMismatchException;

import com.miran.DAO.Loan_DAO;

public class Loan_Controller 
{
	public static void main(String[] args) 
	{
		Loan_DAO  ld=new Loan_DAO();
		java.util.Scanner mr=new java.util.Scanner(System.in);
		System.out.println("\n\t\t\t\t\t\t\t\t ===================== Welcome to Loan_Controller ====================== \t\n\t\t Choose your choice: \n\n\t\t\t\t\t\t\t\t\t 1 - Issue Book \t 2 - Return Book \t 3 - Renew Load \n\n\t\t\t\t\t\t\t\t\t 4 - Loan History of Member \t 5 - Loan History of Book \n\n\t\t\t\t\t\t\t 6 - Display  All Current Loans  \t\t\t 7 - Go to Main Menu \t ");
		try
		{
			int userChoice=mr.nextInt();
			switch (userChoice) 
			{
			case 1: 	
				System.out.println("Enter Member Id : ");
				int memberId=mr.nextInt();
				System.out.println("Enter Book Id : ");
				int bookId=mr.nextInt();
				ld.issueBook(memberId, bookId);			
				break;
			case 2: 	
				System.out.println("Enter Load Id : ");
				int loanId=mr.nextInt();
				ld.returnBook(loanId);
				break;
			case 3: 
				System.out.println("Enter Load Id : ");
				int loanId1=mr.nextInt();
				ld.renewLoan(loanId1);
				break;
			case 4: 
				System.out.println("Enter Member Id : ");
				int memberId1=mr.nextInt();
				ld.getLoanHistoryForMember(memberId1);
				break;
			case 5:
				System.out.println("Enter Book Id : ");
				int bookId1=mr.nextInt();
				ld.getLoanHistoryForBook(bookId1);
				break;
			case 6: ld.getAllCurrentLoans();
				break;
			case 7: Main_Controller.main(null);
				break;
			default: System.err.println("\n\t\t\t\t ---- Invalid Details . ---- \t\t\t\t");
				break;
			}
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t------------------- Input Mis Match --------------- ");
		}
		
		finally
		{
			mr.close();
		}
	}

}
