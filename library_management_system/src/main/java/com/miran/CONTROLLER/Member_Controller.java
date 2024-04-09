package com.miran.CONTROLLER;

import java.util.InputMismatchException;

import com.miran.DAO.Member_DAO;



public class Member_Controller 
{
	public static void main(String[] args) 
	{ 
		Member_DAO md=new Member_DAO();
		java.util.Scanner mr=new java.util.Scanner(System.in);
		System.out.println("\n\t\t\t\t\t\t\t\t ===================== Welcome to Member_Controller ====================== \t\n\t\t Choose your choice: \n\n\t\t\t\t\t\t\t\t\t 1 - Add a Member \t 2 - Update Member \t 3 - Remove Member \n\n\t\t\t\t\t\t\t\t\t\t 4 - Display Members \t 5 - Go to Main Menu \t");
		try
		{
			int userChoice=mr.nextInt();
			
			switch (userChoice) 
			{
			case 1: 	md.addMember();			
				break;
			case 2: 	md.updateMemberName_Number_Address();			
				break;
			case 3: 	md.removeMemberBasedOnName();
				break;
			case 4: 	md.displayDetailsAboutMemberBasedOnName();
				break;
			case 5: Main_Controller.main(null);
				break;
			default: System.err.println("\n\t\t\t\t ---- Invalid Choice . ---- \t\t\t\t");
				break;
			}
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t------------------- Input Mis Match --------------- ");
		}
		finally
		{
			mr.close();
		}
	}

}
