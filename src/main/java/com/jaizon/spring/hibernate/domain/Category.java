package com.jaizon.spring.hibernate.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "category")
public class Category implements Serializable {

	private int id;
	private String name;
	private Set<Book> books = new HashSet<Book>();	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "category", cascade=CascadeType.ALL, orphanRemoval=true)	
	public Set<Book> getBooks() {
		return this.books;
	}
			 
	public void setBooks(Set<Book> books) {
		this.books = books;
	}				

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name +"]";
	}

	// Constructors 	
	public Category() {
		super();
	}
	
	public Category(int id) {
		this.id = id;	
	}

	private static final long serialVersionUID = 1L;
}
