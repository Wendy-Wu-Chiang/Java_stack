package com.wendy.show.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wendy.show.models.Book;
import com.wendy.show.services.BookService;


@RestController
public class ApiController {
	private BookService bookService;
	
    public ApiController(BookService service){
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
}
