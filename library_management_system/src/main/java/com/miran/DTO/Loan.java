package com.miran.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Loan 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanId ;
	private String borrowDate;
	private String returnDate;
	
	@ManyToOne
    @JoinColumn(name = "memberId")
    Member m;

    @ManyToOne
    @JoinColumn(name = "adminId")
    Admin a;

    @ManyToOne
    @JoinColumn(name = "libraryId")
    Library l;

    @ManyToOne
    @JoinColumn(name = "bookId")
    Book b;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Member getM() {
		return m;
	}

	public void setM(Member memberId) {
		this.m = memberId;
	}

	public Admin getA() {
		return a;
	}

	public void setA(Admin a) {
		this.a = a;
	}

	public Library getL() {
		return l;
	}

	public void setL(Library l) {
		this.l = l;
	}

	public Book getB() {
		return b;
	}

	public void setB(Book b) {
		this.b = b;
	}
	
    
}
