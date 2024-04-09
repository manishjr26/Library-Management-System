package com.miran.DAO;

import java.util.InputMismatchException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.miran.CONTROLLER.Library_Controller;
import com.miran.DTO.Admin;
import com.miran.DTO.Book;
import com.miran.DTO.Library;
import com.miran.DTO.Member;

public class Library_DAO 
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Your");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	java.util.Scanner mr=new java.util.Scanner(System.in);
	public void createLibrary()
	{
		try
		{
			System.out.println("Enter Admin Id : ");
			int adminId=mr.nextInt();
			mr.nextLine(); et.begin();
			Admin a=em.find(Admin.class, adminId);
			if(a!=null)  // checking if Admin Exits
			{
				System.out.println("Enter Library Name : ");
				String name=mr.nextLine();
				String lower =name.trim().toLowerCase();
				
				Query q=em.createQuery("select l from Library l where lower(l.name)=:name");
				q.setParameter("name", lower);
				List<Library> l=q.getResultList();
				if(l.isEmpty()) // checking if entered name is not present already 
				{
					Library lo=new Library();
					lo.setName(lower);
					lo.setA(a);
					em.persist(lo);
					et.commit();
					System.out.println("\n\t\t\t\t\t\t\t\t ============ Library  : \" "+lower +" \" added successfully and its Admin is : \" " +a.getUsername()+"\" ==============");
					Library_Controller.main(null);
				}else
					System.err.println("\n\t\t\t\t\t\t\t\t -----------------------  Library Already  Exits . ----------------------- ");
			}else
				System.err.println("\n\t\t\t\t\t\t\t\t ----------------------- Invalid Admin Id  . ----------------------- ");
				System.exit(0);
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}
		
	}
	
	public void updateLibraryName()
	{
		try
		{
			System.out.println("Enter Admin Id : ");
			int adminId=mr.nextInt();
			mr.nextLine();  et.begin();
			Admin a=em.find(Admin.class, adminId);
			if(a!=null)  // checking if Admin Exits
			{
				System.out.println("Enter Library Name : ");
				String name=mr.nextLine();
				String lower =name.trim().toLowerCase();
				
				Query q=em.createQuery("select l from Library l where lower(l.name)=:name");
				q.setParameter("name", lower);
				List<Library> l=q.getResultList();
				if(!l.isEmpty()) // checking if entered name is  present in Library 
				{
					Library lo=new Library();
					lo.setName(lower);
					em.merge(lo);
					et.commit();
					System.out.println("\n\t\t\t\t\t\t ============ Library with : \" "+lower +" \" updated successfully its Admin is : \" " +a.getUsername()+" \" ==============");
					Library_Controller.main(null);
				}else
					System.err.println("\n\t\t\t\t\t\t\t -----------------------  Library Does'nt Exits . ----------------------- ");
			}else
				System.err.println("\n\t\t\t\t\t\t\t ----------------------- Invalid Admin Id  . ----------------------- ");
				System.exit(0);
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}
	}
	
	public void removeLibraryName()
	{
		try
		{
			System.out.println("Enter Admin Id : ");  
			int adminId=mr.nextInt();
			mr.nextLine(); et.begin();
			Admin a=em.find(Admin.class, adminId);
			if(a!=null)  // checking if Admin Exits
			{
				System.out.println("Enter Library Name : ");
				String name=mr.nextLine();
				String lower =name.trim().toLowerCase();
				
				Query q=em.createQuery("select l from Library l where lower(l.name)=:name");
				q.setParameter("name", lower);
				List<Library> l=q.getResultList();
				if(!l.isEmpty()) // checking if entered name is  present in Library
				{
					for(Library li:l)
					{
						em.remove(li);
					}
					et.commit();
					System.out.println("\n\t\t\t\t\t\t Library \" "+lower +" \" removed successfully its Admin was : \" " +a.getUsername()+" \" ==============");
					Library_Controller.main(null);
				}else
					System.err.println("\n\t\t\t\t\t\t\t -----------------------  Library Does'nt Exits . ----------------------- ");
			}else
				System.err.println("\n\t\t\t\t\t\t\t ----------------------- Invalid Admin Id  . ----------------------- ");
				System.exit(0);
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}
	}
	
	public void displayLibraryDetalisBasedOnName()
	{
		try
		{
			System.out.println("Enter Admin Id : ");  
			int adminId=mr.nextInt();
			mr.nextLine(); et.begin();
			Admin a=em.find(Admin.class, adminId);
			if(a!=null)  // checking if Admin Exits
			{
				System.out.println("Enter Library Name : ");
				String name=mr.nextLine();
				String lower =name.trim().toLowerCase();
				
				Query q=em.createQuery("select l from Library l where lower(l.name)=:name");
				q.setParameter("name", lower);
				List<Library> l=q.getResultList();
				if(!l.isEmpty()) // checking if entered name is  present in Library
				{
					System.out.println("\n Library Id \t  Library Name");
					for(Library li:l)
					{
						System.out.println("\t"+li.getLibraryId()+" \t"+li.getName());
					}
					
					Library_Controller.main(null);
				}else
					System.err.println("\n\t\t\t\t\t\t\t -----------------------  Library Does'nt Exits . ----------------------- ");
			}else
				System.err.println("\n\t\t\t\t\t\t\t ----------------------- Invalid Admin Id  . ----------------------- ");
				System.exit(0);
			
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}
	}
	
	public void listMembersAndBooksAssociatedWithLibrary()
	{
		try
		{
			System.out.println("Enter Admin Id : ");  
			int adminId=mr.nextInt();
			mr.nextLine(); et.begin();
			Admin a=em.find(Admin.class, adminId);
			if(a!=null)  // checking if Admin Exits
			{
				System.out.println("Enter Library Name : ");
				String name=mr.nextLine();
				String lower =name.trim().toLowerCase();
				
				Query q=em.createQuery("select l from Library l where lower(l.name)=:name");
				q.setParameter("name", lower);
				List<Library> l=q.getResultList();
				if(!l.isEmpty()) // checking if entered name is  present in Library
				{
					
					for(Library li:l)
					{
						System.out.println();
						List<Book> b=li.getB();
						if(!b.isEmpty()) // checking if Book is assigned to Library so far 
						{ 
							List<Member> me=li.getM();
							if(!me.isEmpty())
							{
								for(Book bo:b)
								{  
									System.out.println("\n Library Id \t  Library Name \t Admin Id \t Book Title \t Book Author \t Book Genre \t");
									for(Member mer:me)
									{
										System.out.println("\t "+li.getLibraryId()+" \t"+li.getName()+"\t "+li.getA().getAdminId()+"\t"+bo.getTitle()+" \t"+bo.getAuthor()+" \t"+bo.getGenre());
									}									
								} Library_Controller.main(null);
							}else
								System.err.println("\n\t\t\t\t\t ----------------- Member Not Assigned Still . ---------------");
						}else
						{
							System.err.println("\n\t\t\t\t ----------------------- Book & Member Not Assigned to Library Still . ----------------------- ");						
						}
					}	
				}else 
				{
					System.err.println("\n\t\t\t\t\t\t\t -----------------------  Library Does'nt Exits . ----------------------- ");
				}
			}else
			{
				System.err.println("\n\t\t\t\t\t\t\t ----------------------- Invalid Admin Id  . ----------------------- ");
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
		em.close();
		mr.close();
	}

}
