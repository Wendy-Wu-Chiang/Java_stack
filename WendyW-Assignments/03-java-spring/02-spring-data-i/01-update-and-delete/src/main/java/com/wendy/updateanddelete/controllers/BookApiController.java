package com.wendy.updateanddelete.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wendy.updateanddelete.models.Book;
import com.wendy.updateanddelete.services.BookService;

@RestController
public class BookApiController {
	private BookService bookService;
	
    public BookApiController(BookService service){
        this.bookService = service;
    }
    @RequestMapping("/api/books")
    public List<Book> index() {
        return this.bookService.getAllBooks();
    }
  //Get One Book (Read)
  	@RequestMapping("/{id}")  //Get Request
  	public Book getBook(@PathVariable("id") Long id) {
  		return this.bookService.getSingleBook(id);
  	}
  	
  	//Create A Book
  	@RequestMapping(value="/", method=RequestMethod.POST) //Post Request
  	public Book create(Book book) {
  		return this.bookService.createBook(book);
  	}
  	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
  	public void destroyBook(@PathVariable("id")Long id) {
  			this.bookService.destroyBook(id);
        }
  	
  	@PutMapping(value="/update/{id}")
  	public Book update(@PathVariable("id") Long id, Book updatedBook) {
  		return this.bookService.updateBook(updatedBook);
  	}
  	
}
