package com.jaizon.spring.hibernate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jaizon.spring.hibernate.app.SpringHibernateApp;
import com.jaizon.spring.hibernate.domain.Book;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import javax.annotation.Resource;

@Transactional
@Repository("publishingDao")
public class PublishingDaoImpl implements PublishingDao {
	static Logger log = Logger.getLogger(PublishingDaoImpl.class);

	private SessionFactory sessionFactory;
	
    @SuppressWarnings("unchecked")
    @Override
	@Transactional(readOnly=true)
	public List<Book> findAllBooks() {
		return sessionFactory.getCurrentSession().createQuery("from Book b").list();
	}	

    @SuppressWarnings("unchecked")
    @Override
	@Transactional(readOnly=true)
    public List<Book> findAllBooksWithDetail() {
    	return sessionFactory.getCurrentSession().getNamedQuery("Book.findAllWithDetail").list();
    }

	@Override
	@Transactional(readOnly=true)
	public Book findBookById(int bookId) {
		return (Book) sessionFactory.getCurrentSession().
			   getNamedQuery("Book.findById").
			   setParameter("bookId", bookId).uniqueResult();
	}
    
	@Override
	public List<Book> findBooksByAuthorId(int authorId) {
		return sessionFactory.getCurrentSession().
				   getNamedQuery("Book.findByAuthorId").
				   setParameter("authorId", authorId).list();

	}

	@Override
	public Book save(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
		log.info("Book saved with id: " + book.getId());
		return book;
	}

	@Override
	public void delete(Book book) {
		sessionFactory.getCurrentSession().delete(book);
		log.info("Book deleted with id: " + book.getId());
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
   
}
