package com.jaizon.spring.hibernate.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import com.jaizon.spring.hibernate.app.SpringHibernateApp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book")
@NamedQueries({
	
	//Based on assignment the result is always ordered by bookId (b.id)
	@NamedQuery(name="Book.findAllWithDetail",
				query="select distinct b from Book b left join fetch b.category c left join fetch b.authors a order by b.id"),
	
	@NamedQuery(name="Book.findById",
	query="select distinct b from Book b left join fetch b.category c left join fetch b.authors a where b.id = :bookId order by b.id"),

	
	@NamedQuery(name="Book.findByAuthorId",
	query="select distinct b from Book b left join fetch b.category c left join fetch b.authors a where a.id = :authorId order by b.id")

})
public class Book implements Serializable {	
	
	private	int id;
	private Category category;
	private String isbn;
	private String title;
	private float price;		
	private Set<Author> authors = new HashSet<Author>();
	
		
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}	
	
	@Column(name = "ISBN")
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "PRICE_DECIMAL")
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID")	
	public Category getCategory() {
		return this.category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@ManyToMany
	@JoinTable(name = "author_book", 
	joinColumns = @JoinColumn(name = "AUTHOR_ID"),	
	inverseJoinColumns = @JoinColumn(name = "BOOK_ID")) 	
	public Set<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", categoryId=" + category.getId() + ", isbn=" + isbn + ", title=" + title + ", price=" + price + "]";
	}

	
	private static final long serialVersionUID = 1L;
	
}
