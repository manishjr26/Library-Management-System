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
public class Library
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int libraryId;
	private String name;
	
	@OneToMany(mappedBy = "l")
    List<Book> b = new ArrayList<Book>();

    @OneToMany(mappedBy = "l")
    List<Member> m = new ArrayList<Member>();

    @ManyToOne
    @JoinColumn(name = "adminId")
    Admin a;

    @OneToMany(mappedBy = "l")
    List<Loan> lo = new ArrayList<Loan>();

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getB() {
		return b;
	}

	public void setB(List<Book> b) {
		this.b = b;
	}

	public List<Member> getM() {
		return m;
	}

	public void setM(List<Member> m) {
		this.m = m;
	}

	public Admin getA() {
		return a;
	}

	public void setA(Admin a) {
		this.a = a;
	}

	public List<Loan> getLo() {
		return lo;
	}

	public void setLo(List<Loan> lo) {
		this.lo = lo;
	}
	
    

}
