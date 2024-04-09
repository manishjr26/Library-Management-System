package com.miran.CONTROLLER;

import java.util.InputMismatchException;

import com.miran.DAO.Book_DAO;

public class Book_Controller 
{
	public static void main(String[] args) 
	{
		Book_DAO bd=new Book_DAO();
		java.util.Scanner mr=new java.util.Scanner(System.in);
		System.out.println("\n\t\t\t\t\t\t\t\t ===================== Welcome to Book_Controller ====================== \t\n\t\t Choose your choice: \n\n\t\t\t\t\t\t\t\t\t 1 - Add a Book \t 2 - Update Book \t 3 - Remove Book \n\n\t\t\t\t\t\t\t\t\t\t 4 - Display Book Details \t 5 - Go to Main Menu \t ");
		try
		{
			int userChoice=mr.nextInt();
			switch (userChoice) 
			{
			case 1: 	bd.addBook();		
				break;
			case 2: 		bd.updateBookTitleAuthorGenreIsbn();		
				break;
			case 3: 	bd.removeBook();
				break;
			case 4: 	bd.displayBookDetails();
				break;
			case 5: 	Main_Controller.main(null);
				break;
			default: System.err.println("\n\t\t\t\t\t\t\t\t\t ---- Invalid Details . ---- \t\t\t\t");
				break;
			}
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t\t ------------------- Input Mis Match --------------- ");
		}
		
		finally
		{
			mr.close();
		}
	}

}
