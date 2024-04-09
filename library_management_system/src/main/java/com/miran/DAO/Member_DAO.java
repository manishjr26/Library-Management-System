package com.miran.DAO;

import java.util.InputMismatchException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.miran.CONTROLLER.Member_Controller;
import com.miran.DTO.Admin;
import com.miran.DTO.Library;
import com.miran.DTO.Member;

public class Member_DAO 
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Your");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	java.util.Scanner mr=new java.util.Scanner(System.in);
	public void addMember()
	{
		try
		{
		System.out.println("\n Enter Library Id : ");
		int libraryId=mr.nextInt();
		mr.nextLine();
		et.begin();
		Library li=em.find(Library.class, libraryId);
		if(li!=null) // checking if user entered Library Id is present in Member Table.
		{
			System.out.println("\n Enter Admin Id : ");
			int adminId=mr.nextInt(); mr.nextLine();
			Admin a=em.find(Admin.class, adminId);
			if(a!=null) // checking if user entered Admin Id is present in Member Table.
			{
				System.out.println("\n Enter Member Name");
				String name=mr.nextLine();
				System.out.println("\n Enter Member Address : ");
				String address=mr.nextLine();
				System.out.println("\n Enter Member Contact :");
				long number=mr.nextLong();				
				Member m=new Member();
				m.setName(name);
				m.setContact(number);
				m.setAddress(address);
				m.setL(li);
				m.setA(a);
				em.persist(m);
				et.commit();
				System.out.println("\n\t\t =================== \n "+name+" added successfully to "+li.getName()+" library .\n\t\t\t ====================== ");
				Member_Controller.main(null);
			}else
				System.err.println("\n\t\t\t\t\t\t\t ------------- Invalid Admin Id . ---------------");
				System.exit(0);
			
		}else
			System.err.println("\n\t\t\t\t\t\t\t ------------- Invalid Library Id . ---------------");
			System.exit(0);
		}catch(InputMismatchException e)
		{
			System.err.println("\n\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}
	}
	
	public void updateMemberName_Number_Address()
	{
		System.out.println("\n Enter Library Id : ");
		int libraryId=mr.nextInt(); mr.nextLine();
		et.begin();
		Library li=em.find(Library.class, libraryId);
		if(li!=null) // checking if user entered Library Id is present in Member Table.
		{
			System.out.println("\n Enter Admin Id : ");
			int adminId=mr.nextInt(); mr.nextLine();
			Admin a=em.find(Admin.class, adminId);
			if(a!=null) // checking if user entered Admin Id is present in Member Table.
			{
				System.out.println("\n Enter Member Name");
				String name=mr.nextLine();
				System.out.println("\n Enter Member Address : ");
				String address=mr.nextLine();
				System.out.println("\n Enter Member Contact :");
				long number=mr.nextLong();				
				Member m=new Member();
				m.setName(name);
				m.setContact(number);
				m.setAddress(address);
				em.merge(m);
				et.commit();
				System.out.println("\n\t\t\t\t\t\t\t =================== \n "+name+" updated successfully in "+li.getName()+" library .\n\t\t\t ====================== ");
				Member_Controller.main(null);
			}else
				System.err.println("\n\t\t\t\t\t\t\t\t ------------- Invalid Admin Id . ---------------");
				System.exit(0);
			
		}else
			System.err.println("\n\t\t\t\t\t\t\t ------------- Invalid Library Id . ---------------");
			System.exit(0);	
	}
	
	public void removeMemberBasedOnName()
	{
		System.out.println("\n Enter Library Id : ");
		int libraryId=mr.nextInt(); mr.nextLine();
		et.begin();
		Library li=em.find(Library.class, libraryId);
		if(li!=null) // checking if user entered Library Id is present in Member Table.
		{
			System.out.println("\n Enter Admin Id : ");
			int adminId=mr.nextInt(); mr.nextLine();
			Admin a=em.find(Admin.class, adminId);
			if(a!=null) // checking if user entered Admin Id is present in Member Table.
			{
				System.out.println("\n Enter Member Name");
				String name=mr.nextLine();
				String lower =name.trim().toLowerCase();
				Query q=em.createQuery("select m from Member m where lower(m.name)=:name");
				q.setParameter("name", lower);
				List<Member> me=q.getResultList();
				if(!me.isEmpty()) // checking if user entered name member exists in Member Table .
				{
					for(Member mem:me)
					{
						em.remove(mem);
					}
					et.commit();
					System.out.println("\n\t\t\t\t\t\t\t =================== \n "+name+" removed successfully from "+li.getName()+" library .\n\t\t\t ====================== ");
					Member_Controller.main(null);
				}else
					System.err.println("\n\t\t\t\t\t\t ---------------- \'"+name+"\' ------------------");								
			}else
				System.err.println("\n\t\t\t\t\t\t ------------- Invalid Admin Id . ---------------");
				System.exit(0);
			
		}else
			System.err.println("\n\t\t\t\t\t\t\t ------------- Invalid Library Id . ---------------");
			System.exit(0);	
	}
	
	public void displayDetailsAboutMemberBasedOnName()
	{
		System.out.println("\n Enter Library Id : ");
		int libraryId=mr.nextInt(); mr.nextLine();
		et.begin();
		Library li=em.find(Library.class, libraryId);
		if(li!=null) // checking if user entered Library Id is present in Member Table.
		{
			System.out.println("\n Enter Admin Id : ");
			int adminId=mr.nextInt(); mr.nextLine();
			Admin a=em.find(Admin.class, adminId);
			if(a!=null) // checking if user entered Admin Id is present in Member Table.
			{
				System.out.println("\n Enter Member Name");
				String name=mr.nextLine();
				String lower =name.trim().toLowerCase();
				Query q=em.createQuery("select m from Member m where lower(m.name)=:name");
				q.setParameter("name", lower);
				List<Member> m=q.getResultList();
				if(!m.isEmpty()) // checking if user entered name member exists in Member Table .
				{
										
					for(Member me:m)
					{
						System.out.println("\n Details About : \'" +me.getName()+"\'");
						System.out.println("\n Member Id \t Member Name \t Member Address \t Member Contact");
						System.out.println("\t"+me.getMemberId()+" \t"+me.getName()+" \t"+me.getAddress()+"\t"+me.getContact());
					} Member_Controller.main(null);
				}else
					System.err.println("\n\t\t\t\t ------------------  Invalid \'"+name+ " \' ----------------------- ");
			}else
				System.err.println("\n\t\t\t\t\t\t ------------- Invalid Admin Id . ---------------");
				System.exit(0);
			
		}else
			System.err.println("\n\t\t\t\t\t\t\t ------------- Invalid Library Id . ---------------");
			System.exit(0);	
	}
	public void close()
	{
		emf.close();
		mr.close();
		em.close();
	}
}
