package com.miran.DAO;

import java.util.InputMismatchException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.miran.CONTROLLER.Book_Controller;
import com.miran.DTO.Admin;
import com.miran.DTO.Book;
import com.miran.DTO.Library;
import com.miran.DTO.Member;

public class Book_DAO 
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Your");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	java.util.Scanner mr=new java.util.Scanner(System.in);
	
	
	public void addBook()
	{
		try
		{
			System.out.println("Enter Library Id : ");
			int libraryId=getValidInput();
			mr.nextLine();
			et.begin();
			Library li=em.find(Library.class, libraryId);
			if(li!=null) // to check if Library exists 
			{	
				System.out.println("Enter Admin Id : ");
				int adminId=getValidInput();
				mr.nextLine();  
				Admin a=em.find(Admin.class, adminId);
				if(a!=null) // to check if Admin exists
				{
					System.out.println("Enter Member Id: ");
					int memberId=getValidInput(); mr.nextLine();
					Member m=em.find(Member.class, memberId);
					if(m!=null) // to check if Member exists
					{
						System.out.println("Enter Book Title : ");
						String bookTitle=mr.nextLine().trim().toLowerCase();
						Query q=em.createQuery("select b from Book b where lower(b.title)=:name");
						q.setParameter("name", bookTitle);
						List<Book> b=q.getResultList();
						if(b.isEmpty())  // to check if Book Does'nt exist already
						{
							Book bo=new Book();
							System.out.println("Enter Book Author : ");
							String bookAuthor=mr.nextLine();
							System.out.println("Enter Book ISBN : ");
							String bookISBN=mr.nextLine();
							System.out.println("Enter Book Genre : ");
							String bookGenre=mr.nextLine();
							bo.setTitle(bookTitle);
							bo.setAuthor(bookAuthor);
							bo.setISBN(bookISBN);
							bo.setGenre(bookGenre);
							bo.setL(li); // setting book to Library 
							bo.setM(m); // setting book to Member
							bo.setA(a); // // setting book to Admin
							em.persist(bo);
							et.commit();
							System.out.println("\n\t\t\t\t ========================  Book with name : \" "+bookTitle+" \"  added successfully to Library : \" "+li.getName()+" \" ===================.");
							Book_Controller.main(null);
						}else
						{
							System.out.println("\n\t\t\t\t\t\t\t -----------------------  Book  Exits Already . ----------------------- ");
						}
					}else
					{
						System.err.println("\n\t\t\t\t\t\t\t -----------------------  Invalid Member Id . ----------------------- ");
					}
				}else
				{
					System.err.println("\n\t\t\t\t\t\t\t\t -----------------------  Invalid Admin Id . ----------------------- ");
				}					
			}else
			{
				System.err.println("\n\t\t\t\t\t\t\t\t\t\t -----------------------  Invalid Library Id . ----------------------- ");
			}
		}catch(InputMismatchException e)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			System.err.println("\n\t\t\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}catch(Exception e)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			e.printStackTrace();
			System.err.println("\n\t\t\t\t\t\t\t\t --------------------- Error Adding Book . ------------------- ");
		}
	}
	
	public void updateBookTitleAuthorGenreIsbn()
	{
		try
		{
			System.out.println("Enter Library Id : ");
			int libraryId=getValidInput();
			mr.nextLine();
			et.begin();
			Library li=em.find(Library.class, libraryId);
			if(li!=null) // to check if Library exists 
			{	
				System.out.println("Enter Admin Id : ");
				int adminId=getValidInput();
				mr.nextLine();  
				Admin a=em.find(Admin.class, adminId);
				if(a!=null) // to check if Admin exists
				{
					System.out.println("Enter Member Id: ");
					int memberId=getValidInput(); mr.nextLine();
					Member m=em.find(Member.class, memberId);
					if(m!=null) // to check if Member exists
					{
						System.out.println("Enter Book Title : ");
						String bookTitle=mr.nextLine().trim().toLowerCase();
						Query q=em.createQuery("select b from Book b where lower(b.title)=:name");
						q.setParameter("name", bookTitle);
						List<Book> b=q.getResultList();
						if(!b.isEmpty())  // to check if Book  exist 
						{
							Book bo=new Book();
							System.out.println("Enter Book New  Author : ");
							String bookAuthor=mr.nextLine();
							System.out.println("Enter Book New ISBN : ");
							String bookISBN=mr.nextLine();
							System.out.println("Enter Book New  Genre : ");
							String bookGenre=mr.nextLine();
							System.out.println("Enter Book New Title : ");
							String newTitle=mr.nextLine().trim().toLowerCase();
							bo.setTitle(newTitle);
							bo.setAuthor(bookAuthor);
							bo.setISBN(bookISBN);
							bo.setGenre(bookGenre);
							em.merge(bo);
							et.commit();
							System.out.println(" ====================== Book \'"+bookTitle+"\' update to new title as \'"+newTitle+"\' ========================== .");
							Book_Controller.main(null);
						}else
						{
							System.err.println("\n\t -----------------------  Book with name  \'"+bookTitle+ "\' Does'nt  Exits . ----------------------- ");
						}
					}else
					{
						System.err.println("\n\t\t\t\t\t\t\t -----------------------  Invalid Member Id . ----------------------- ");
					}
				}else
				{
					System.err.println("\n\t\t\t\t\t\t\t\t -----------------------  Invalid Admin Id . ----------------------- ");
				}					
			}else
			{
				System.err.println("\n\t\t\t\t\t\t\t\t\t\t -----------------------  Invalid Library Id . ----------------------- ");
			}
		}catch(InputMismatchException e)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			System.err.println("\n\t\t\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}catch(Exception e)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			e.printStackTrace();
			System.err.println("\n\t\t\t\t\t\t\t\t --------------------- Error Updating Book . ------------------- ");
		}
	}
	
	public void removeBook()
	{
		try
		{
			System.out.println("Enter Library Id : ");
			int libraryId=getValidInput();
			mr.nextLine();
			et.begin();
			Library li=em.find(Library.class, libraryId);
			if(li!=null) // to check if Library exists 
			{	
				System.out.println("Enter Admin Id : ");
				int adminId=getValidInput();
				mr.nextLine();  
				Admin a=em.find(Admin.class, adminId);
				if(a!=null) // to check if Admin exists
				{
					System.out.println("Enter Member Id: ");
					int memberId=getValidInput(); mr.nextLine();
					Member m=em.find(Member.class, memberId);
					if(m!=null) // to check if Member exists
					{
						System.out.println("Enter Book Title : ");
						String bookTitle=mr.nextLine().trim().toLowerCase();
						Query q=em.createQuery("select b from Book b where lower(b.title)=:name");
						q.setParameter("name", bookTitle);
						List<Book> b=q.getResultList();
						if(!b.isEmpty())  // to check if Book  exist 
						{
							for(Book bo:b)
							{
								em.remove(bo);
							}
							et.commit();
							System.out.println("\n\t========================  Book with name : \'"+bookTitle+"\' removed successfully from Library : \'"+li.getName()+"\' ===================.");
							Book_Controller.main(null);
						}else
						{
							System.err.println("\n\t -----------------------  Book with name  \'"+bookTitle+ "\' Does'nt  Exits . ----------------------- ");
						}
					}else
					{
						System.err.println("\n\t\t\t\t\t\t\t -----------------------  Invalid Member Id . ----------------------- ");
					}
				}else
				{
					System.err.println("\n\t\t\t\t\t\t\t\t -----------------------  Invalid Admin Id . ----------------------- ");
				}					
			}else
			{
				System.err.println("\n\t\t\t\t\t\t\t\t\t\t -----------------------  Invalid Library Id . ----------------------- ");
			}
		}catch(InputMismatchException e)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			System.err.println("\n\t\t\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}catch(Exception e)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			e.printStackTrace();
			System.err.println("\n\t\t\t\t\t\t\t --------------------- Error Removing Book . ------------------- ");
		}
	}
	
	public void displayBookDetails()
	{
		try
		{
			System.out.println("Enter Library Id : ");
			int libraryId=getValidInput();
			mr.nextLine();
			et.begin();
			Library li=em.find(Library.class, libraryId);
			if(li!=null) // to check if Library exists 
			{	
				System.out.println("Enter Admin Id : ");
				int adminId=getValidInput();
				mr.nextLine();  
				Admin a=em.find(Admin.class, adminId);
				if(a!=null) // to check if Admin exists
				{
					System.out.println("Enter Member Id: ");
					int memberId=getValidInput(); mr.nextLine();
					Member m=em.find(Member.class, memberId);
					if(m!=null) // to check if Member exists
					{
						System.out.println("Enter Book Title : ");
						String bookTitle=mr.nextLine().trim().toLowerCase();
						Query q=em.createQuery("select b from Book b where lower(b.title)=:name");
						q.setParameter("name", bookTitle);
						List<Book> b=q.getResultList();
						if(!b.isEmpty())  // to check if Book  exist 
						{
							System.out.println(" Book Id \t Book Title \t  Book Author \t\t Book ISBN \t Book Genre   \t Library Name  \t Admin Username");
							for (Book book : b) 
							{
	                            System.out.printf("\n %d\t\t %s\t\t %s\t\t %s\t\t %s\t\t %s\t\t %s\n",
	                                    book.getBookId(), book.getTitle(), book.getAuthor(),
	                                    book.getISBN(), book.getGenre(), li.getName(), a.getUsername());
	                        } Book_Controller.main(null);
						}else
						{
							System.err.println("\n\t -----------------------  Book with name  \'"+bookTitle+ "\' Does'nt  Exits . ----------------------- ");
						}
					}else
					{
						System.err.println("\n\t\t\t\t\t\t\t -----------------------  Invalid Member Id . ----------------------- ");
					}
				}else
				{
					System.err.println("\n\t\t\t\t\t\t\t\t -----------------------  Invalid Admin Id . ----------------------- ");
				}					
			}else
			{
				System.err.println("\n\t\t\t\t\t\t\t\t\t\t -----------------------  Invalid Library Id . ----------------------- ");
			}
		}catch(InputMismatchException e)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			System.err.println("\n\t\t\t\t\t\t\t\t\t ----------------------- Input MisMatch . ----------------------- ");
		}catch(Exception e)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			e.printStackTrace();
			System.err.println("\n\t\t\t\t\t\t\t --------------------- Error Retriving Book . ------------------- ");
		}
	}
	
	
	private int getValidInput()
	{
		while(true)
		{
			try
			{
				return mr.nextInt();
			}catch(InputMismatchException e)
			{
				System.err.println("\n\t\t\t\t\t\t\t\t\t ------------------------- Invalid Input. Please enter valid Input . ----------------");
				mr.next();
			}
		}
	}
	public void close()
	{
		emf.close();
		mr.close();
		em.close();
	}

}
