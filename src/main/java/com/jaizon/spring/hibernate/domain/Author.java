package com.jaizon.spring.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "author")
@NamedQueries({
	@NamedQuery(name="Author.findAllWithDetail",
				query="select distinct a from Author a")
})
public class Author implements Serializable {
	
	private int id;
	private String firstName;
	private String lastName;
	private String description;	
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
	
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany
	@JoinTable(name = "author_book", 
	joinColumns = @JoinColumn(name = "BOOK_ID"), 
	inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID")) 	
	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}	
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", description="
				+ description + "]";
	}

	// Constructors
	public Author() {
		super();
	}
	
	public Author(int id) {
		this.id = id;
	}

	private static final long serialVersionUID = 1L;
}
