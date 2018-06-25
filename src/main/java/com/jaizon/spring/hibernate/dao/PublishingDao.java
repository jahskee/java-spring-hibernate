package com.jaizon.spring.hibernate.dao;

import java.util.List;

import  com.jaizon.spring.hibernate.domain.Book;

public interface PublishingDao {
	public List<Book> findAllBooks();
    public List<Book> findAllBooksWithDetail();
    public Book findBookById(int bookId);
    public Book save(Book book);
    public void delete(Book book);
    public List<Book> findBooksByAuthorId(int authorId);
}
