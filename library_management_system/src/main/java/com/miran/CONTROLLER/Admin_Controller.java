package com.miran.CONTROLLER;

import java.util.InputMismatchException;

import com.miran.DAO.Admin_DAO;

public class Admin_Controller 
{
	public static void main(String[] args) 
	{
		Admin_DAO ad=new Admin_DAO();
		java.util.Scanner mr=new java.util.Scanner(System.in);
		System.out.println("\n\t\t\t\t\t\t\t\t ===================== Welcome to Admin_Controller ====================== \t\n\t\t Choose your choice: \n\n\t\t\t\t\t\t\t\t 1 - Add a Admin \t 2 - Update Admin \t 3 - Remove Admin \n\n\t\t\t\t\t\t\t\t\t 4 - Display Admin Details \t 5 - Go to Main Menu \t ");
		try
		{
			int userChoice=mr.nextInt();
			switch (userChoice) 
			{
			case 1: ad.addAdmin();				
				break;
			case 2: 	ad.updateAdminNamePassword();			
				break;
			case 3: 	ad.removeAdmin();
				break;
			case 4: 	ad.displayDetailsAboutAdmin();
				break;
			case 5: 	 Main_Controller.main(null);
				break;
			default: System.err.println("\n\t\t\t\t ---- Invalid Choice . ---- \t\t\t\t");
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
