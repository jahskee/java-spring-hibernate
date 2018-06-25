package com.jaizon.spring.hibernate.app;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jaizon.spring.hibernate.dao.PublishingDao;
import com.jaizon.spring.hibernate.domain.Book;
import com.jaizon.spring.hibernate.domain.Category;
import com.jaizon.spring.hibernate.domain.Author;


public class SpringHibernateApp 
{
	static Logger log = Logger.getLogger(SpringHibernateApp.class);
    public static void main( String[] args )
    {
    	
    	/*BasicConfigurator.configure();*/
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");	
		ctx.refresh();
		
		PublishingDao publishingDao = ctx.getBean("publishingDao", PublishingDao.class);
		
		log.info("\n\n=================== 1. findAllBooks(): without Authors and Categories ======================\n");
		List<Book> allBooks = publishingDao.findAllBooks();
		for(Book book: allBooks){
			/*log.info(book);*/
			log.info(book);
		}
		log.info("=========================================\n");

		log.info("\n\n=================== 2. findAllBooksWithDetail(): with Authors and Categories ======================\n");
		List<Book> allBooksWithDetail = publishingDao.findAllBooksWithDetail();
		displayBooks(allBooksWithDetail);
		log.info("=========================================\n");
		
		
		log.info("\n\n=================== 3. findBookById(String bookId): with Authors and Categories ======================\n");
		int searchBookId = 2;
		Book book = publishingDao.findBookById(searchBookId);
		log.info(book);
		log.info("\t"+book.getCategory());
		for(Author author: book.getAuthors()){
			log.info("\t"+author);
		}
		log.info("=========================================\n");
		
		log.info("\n\n=================== 4. Insert new Book ======================\n");
		Book newBook = new Book();		
		
		// create book category
		newBook.setCategory(new Category(1));
		newBook.setTitle("Spring in Action");	
		
		// create list of Authors
		Set<Author> authors = new HashSet<Author>();
		authors.add(new Author(7)); //authorId = 7		
		newBook.setAuthors(authors);
		
		newBook.setIsbn("161729120X");
		newBook.setPrice(39.99f);
		
		publishingDao.save(newBook);		
		// display all books with new book inserted
		allBooksWithDetail = publishingDao.findAllBooksWithDetail();
		displayBooks(allBooksWithDetail);
		log.info("=========================================\n");

		
		log.info("\n\n=================== 5. Delete Book ======================\n");
		
		// Delete the last Inserted book
		publishingDao.delete(newBook);
		// display all books with new book inserted
		allBooksWithDetail = publishingDao.findAllBooksWithDetail();
		displayBooks(allBooksWithDetail);
		log.info("=========================================\n");
		
		
		log.info("\n\n=================== 6. findBooksByAuthorId(String authorId) ======================\n");		
		
		// Based on assignment documentation, I see a book with id = 6 was added with title "UML Distilled" by Martin Fowler
		newBook = new Book();
		// create book category
		newBook.setCategory(new Category(3));
		newBook.setTitle("UML Distilled");	
		
		// create list of Authors
		authors = new HashSet<Author>();
		authors.add(new Author(3)); //authorId = 3		
		newBook.setAuthors(authors);
		
		newBook.setIsbn("0321193687");
		newBook.setPrice(20.75f);
		
		publishingDao.save(newBook);		
		
		// Find 2 of Martin Fowler's book;
		List<Book> booksByAuthor = publishingDao.findBooksByAuthorId(3); 
		displayBooks(booksByAuthor);
		log.info("=========================================\n");
		ctx.close();
    }
    
    private static void displayBooks(List<Book> books) {
    	log.info("Display all Books:\n");
    	for(Book book: books){
			/*log.info(book);*/
			log.info(book);			
			log.info("\t"+book.getCategory());
			for(Author author: book.getAuthors()){
				log.info("\t"+author);
			}			
			log.info("\n");
		}
    }
}
