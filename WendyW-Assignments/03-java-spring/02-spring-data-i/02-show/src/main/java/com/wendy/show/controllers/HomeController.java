package com.wendy.show.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wendy.show.models.Book;
import com.wendy.show.services.BookService;

@Controller
public class HomeController {
	@Autowired
	private BookService bookService;
	
	//Get All Books

	@GetMapping("/books")
	public String index(Model model) {
		List<Book> allBooks= this.bookService.getAllBooks();
		model.addAttribute("allBooks", allBooks);
		return "index.jsp";	
	}

	//Create A Book
	@GetMapping("/books/add")
	public String addBook(@ModelAttribute("Book") Book book) {
		return "add.jsp";
	}
	
	@PostMapping("/books/add")
	//@Valid annotation checks to see if the submitted object passes validation
	public String addB(@Valid @ModelAttribute("Book") Book book, BindingResult result) {

		if(result.hasErrors()) {
			return "add.jsp";  //going to WEB-INF file
		}
		this.bookService.createBook(book);
		return "redirect:/books";
	}
	@PostMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    @PostMapping(value="/books")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        
    	if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            this.bookService.createBook(book);
            return "redirect:/books";
        }
    }

	//Get One Book (Read)
	@GetMapping("/books/{id}")
	public String findById(@ModelAttribute("book") Book book, Model model, @PathVariable("id") Long id) {
		Book singleBook = this.bookService.getSingleBook(id);
		model.addAttribute("book", singleBook);
		return "/books/new.jsp";
	}

}