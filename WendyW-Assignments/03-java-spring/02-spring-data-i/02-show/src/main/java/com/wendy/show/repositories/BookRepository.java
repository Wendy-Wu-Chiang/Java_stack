package com.wendy.show.repositories;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wendy.show.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	// this method retrieves all the books from the database
    List<Book> findAll();
    // this method find a book by their description
    List<Book> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
	Book save(java.awt.print.@Valid Book book);
}

//This will create a repository for us that will expose the Spring Data JPA. This will expose a variety of methods, 
//as well as allow us to extend it. Without any further code, this will automatically allow us to create, read, update, 
//and destroy our books - after all, it is a CRUD repository we are extending.
//
//The Spring Data JPA Query creation can seem magical at first,
//and it takes some experience writing in it to get a good feel for the queries,
//but it will automatically build queries from method names in your interface. 