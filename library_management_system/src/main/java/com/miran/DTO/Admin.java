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
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String username;
	private String password;
	
	@ManyToOne
    @JoinColumn(name = "libraryId")
    Library l;

    @OneToMany(mappedBy = "a")
    List<Member> m = new ArrayList<Member>();

    @OneToMany(mappedBy = "a")
    List<Loan> lo = new ArrayList<Loan>();

    @OneToMany(mappedBy = "a")
    List<Book> b = new ArrayList<Book>();

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Library getL() {
		return l;
	}

	public void setL(Library l) {
		this.l = l;
	}

	public List<Member> getM() {
		return m;
	}

	public void setM(List<Member> m) {
		this.m = m;
	}

	public List<Loan> getLo() {
		return lo;
	}

	public void setLo(List<Loan> lo) {
		this.lo = lo;
	}

	public List<Book> getB() {
		return b;
	}

	public void setB(List<Book> b) {
		this.b = b;
	}
    
    
}
