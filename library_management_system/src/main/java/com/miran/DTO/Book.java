package com.miran.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Book 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String title;
	private String author;
	private String ISBN;
	private String genre;
	
	@ManyToOne
    @JoinColumn(name = "memberId")
    Member m;
    
    @OneToMany(mappedBy = "b")
    List<Loan> lo = new ArrayList<Loan>();
	
	
	@ManyToOne
    @JoinColumn(name = "libraryId")
    Library l;

    @ManyToOne
    @JoinColumn(name = "adminId")
    Admin a;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Member getM() {
		return m;
	}

	public void setM(Member m) {
		this.m = m;
	}

	public List<Loan> getLo() {
		return lo;
	}

	public void setLo(List<Loan> lo) {
		this.lo = lo;
	}

	public Library getL() {
		return l;
	}

	public void setL(Library l) {
		this.l = l;
	}

	public Admin getA() {
		return a;
	}

	public void setA(Admin a) {
		this.a = a;
	}
	
    

}
