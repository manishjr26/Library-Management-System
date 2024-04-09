package com.miran.DAO;

import java.util.InputMismatchException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.miran.CONTROLLER.Admin_Controller;
import com.miran.DTO.Admin;

public class Admin_DAO 
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Your");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	java.util.Scanner mr=new java.util.Scanner(System.in);
	
	public void addAdmin()
	{
		try
		{
			System.out.println("Enter Admin Name : ");
			String name=mr.nextLine();
			String lower =name.trim().toLowerCase();
			et.begin();
			Query q=em.createQuery("select a from Admin a where lower(a.username)=:name ");
			q.setParameter("name", lower);
			List<Admin> a=q.getResultList();
			if(a.isEmpty()) // checking if entered Admin is not present in DB
			{
				Admin ad=new Admin();
				ad.setUsername(lower);
				System.out.println("Enter Password : ");
				String password=mr.nextLine();
				ad.setPassword(password);
				em.persist(ad);
				et.commit();
				System.out.println("\n\t\t\t\t\t\t\t ============ Admin  : \" "+lower +" \" added successfully . \t ===========");
				Admin_Controller.main(null);
			}else
			{
				System.err.println("\n\t\t\t\t\t\t\t -----------------------  Admin Already  Exits . ----------------------- ");
			}
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}
	}
	
	public void updateAdminNamePassword()
	{
		try
		{
			System.out.println("Enter Admin Name : ");
			String name=mr.nextLine();
			String lower =name.trim().toLowerCase();
			et.begin();
			Query q=em.createQuery("select a from  Admin a where lower(a.username)=:name ");
			q.setParameter("name", lower);
			List<Admin> a=q.getResultList();
			if(!a.isEmpty())  // checking if entered Admin is present in DB
			{
				Admin ad=new Admin();
				System.out.println("Enter New User Name : ");
				String newName=mr.nextLine().trim().toLowerCase();
				ad.setUsername(newName);
				System.out.println("Enter new  Password : ");
				String password=mr.nextLine();
				ad.setPassword(password);
				em.merge(ad);
				et.commit();
				System.out.println("\n\t\t\t\t\t\t\t\t ============ Admin  : \""+lower + "\" updated successfully . \t ============== ");
				Admin_Controller.main(null);
			}else
			{
				System.err.println("\n\t\t\t\t\t\t\t -----------------------  Admin Does'nt  Exits . ----------------------- ");
				System.exit(0);
			}
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}
	}
	
	public void removeAdmin()
	{
		try
		{
			System.out.println("Enter Admin Name : ");
			String name=mr.nextLine();
			String lower =name.trim().toLowerCase();
			et.begin();
			Query q=em.createQuery("select a from Admin a where lower(a.username)=:name ");
			q.setParameter("name", lower);
			List<Admin> a=q.getResultList();
			if(!a.isEmpty())  // checking if entered Admin is present in DB
			{
				for(Admin an:a)
				{
					em.remove(an);
				}
				et.commit();
				System.out.println("\n\t\t\t\t\t\t\t ============ Admin  : \""+lower +" \" removed successfully .\t ============  ");
				Admin_Controller.main(null);
			}else
			{
				System.err.println("\n\t\t\t\t\t\t\t -----------------------  Admin Does'nt  Exits . ----------------------- ");
				System.exit(0);
			}
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}
	}
	
	public void displayDetailsAboutAdmin()
	{
		try
		{
			System.out.println("Enter Admin Name : ");
			String name=mr.nextLine();
			String lower =name.trim().toLowerCase();
			Query q=em.createQuery("select a from Admin a where lower(a.username)=:name ");
			q.setParameter("name", lower);
			List<Admin> a=q.getResultList();
			if(!a.isEmpty())  // checking if entered Admin is present in DB
			{
				System.out.println("\t\t\t\t\t\t\t\t ========================================================= \n \t\t\t\t\t\t\t\t\t\t\t Admin Id \t Admin UserName \t");
				for(Admin an:a)
				{
					System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t "+an.getAdminId()+"\t "+an.getUsername()+"\t\n \t\t\t\t\t\t\t\t ========================================================= \n");
				}
				Admin_Controller.main(null);
			}else
			{
				System.err.println("\n\t\t\t\t\t\t\t\t -----------------------  Admin Does'nt  Exits . ----------------------- ");
				System.exit(0);
			}
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}
	}
	
	
	
	public void close()
	{
		emf.close();
		mr.close();
		em.close();
	}

}
