package com.wendy.updateanddelete.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wendy.updateanddelete.models.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	// this method retrieves all the books from the database
    List<Book> findAll();
}

