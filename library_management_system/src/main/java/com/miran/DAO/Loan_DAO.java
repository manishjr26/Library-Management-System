package com.miran.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.miran.CONTROLLER.Loan_Controller;
import com.miran.DTO.Book;
import com.miran.DTO.Loan;
import com.miran.DTO.Member;



public class Loan_DAO 
{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Your");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    public void issueBook(int memberId, int bookId)
    {
        tx.begin();
        Loan loan = new Loan();
        Member member = em.find(Member.class, memberId);
        Book book = em.find(Book.class, bookId);
        loan.setM(member);
        loan.setB(book);
        em.persist(loan);
        tx.commit();
        Loan_Controller.main(null);
    }


    public void returnBook(int loanId) 
    {
        tx.begin();
        Loan loan = em.find(Loan.class, loanId);
        if (loan != null)
        {
            em.remove(loan);
        }
        tx.commit();Loan_Controller.main(null);
    }

    public void renewLoan(int loanId)
    {
        tx.begin();
        Loan loan = em.find(Loan.class, loanId);
        if (loan != null) 
        {
        	loan.setReturnDate("03/40/2002");
            em.merge(loan);
        }
        tx.commit(); Loan_Controller.main(null);
    }

    public List<Loan> getLoanHistoryForMember(int memberId) 
    {
        Query query = em.createQuery("SELECT l FROM Loan l WHERE l.memberId = :memberId");
        query.setParameter("memberId", memberId);
        return query.getResultList(); 
    }

    public List<Loan> getLoanHistoryForBook(int bookId) 
    {
        Query query = em.createQuery("SELECT l FROM Loan l WHERE l.bookId = :bookId");
        query.setParameter("bookId", bookId);
        return query.getResultList(); 
    }

    public List<Loan> getAllCurrentLoans() 
    {
        Query query = em.createQuery("SELECT l FROM Loan l");
        return query.getResultList(); 
    }

    public void close() {
        em.close();
        emf.close();
    }
}
