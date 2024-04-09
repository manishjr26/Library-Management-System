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

@Entity
public class Member
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberId;
	private String name;
	private long contact;
	private String address;
	
	@ManyToOne
    @JoinColumn(name = "libraryId")
    Library l;

	@OneToMany(mappedBy = "m")
    List<Book> b = new ArrayList<Book>();
    
    @OneToMany(mappedBy = "m")
    List<Loan> lo = new ArrayList<Loan>();

    @ManyToOne
    @JoinColumn(name = "adminId")
    Admin a;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Library getL() {
		return l;
	}

	public void setL(Library l) {
		this.l = l;
	}

	public List<Book> getB() {
		return b;
	}

	public void setB(List<Book> b) {
		this.b = b;
	}

	public List<Loan> getLo() {
		return lo;
	}

	public void setLo(List<Loan> lo) {
		this.lo = lo;
	}

	public Admin getA() {
		return a;
	}

	public void setA(Admin a) {
		this.a = a;
	}
    
    
}
