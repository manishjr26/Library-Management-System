package com.miran.CONTROLLER;

import java.util.InputMismatchException;

import com.miran.DAO.Library_DAO;

public class Library_Controller 
{
	public static void main(String[] args) 
	{
		Library_DAO ld=new Library_DAO();
		java.util.Scanner mr=new java.util.Scanner(System.in);
		System.out.println("\n\t\t\t\t\t\t\t\t ===================== Welcome to Library_Controller ====================== \t\n\t\t Choose your choice: \n\n\t\t\t\t\t\t\t\t 1 - Create Library  \t 2 - Update Library \t 3 - Remove Library \n\n\t\t\t\t\t\t 4 - Display Library Details \t 5 - Display Members & Books Associated With Library \t 6- Go to Main Menu \t ");
		try
		{
			int userChoice=mr.nextInt();			
			switch (userChoice) 
			{
			case 1: ld.createLibrary();				
				break;
			case 2: ld.updateLibraryName();				
				break;
			case 3: ld.removeLibraryName();	
				break;
			case 4: 	ld.displayLibraryDetalisBasedOnName();
				break;
			case 5: 	ld.listMembersAndBooksAssociatedWithLibrary();
				break;
			case 6: Main_Controller.main(null);	
				break;
			default: System.err.println("\n\t\t\t\t\t\t\t ---- Invalid Details . ---- \t\t\t\t");
				break;
			}
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t\t------------------- Input Mis Match --------------- ");
		}
		finally
		{
			mr.close();
		}
	}

}
