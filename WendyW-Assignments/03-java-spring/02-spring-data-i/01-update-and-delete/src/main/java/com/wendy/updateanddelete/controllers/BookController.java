package com.wendy.updateanddelete.controllers;

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

import com.wendy.updateanddelete.models.Book;
import com.wendy.updateanddelete.services.BookService;

@Controller
public class BookController {
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
		return "showBook.jsp";
	}
	
	@RequestMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book book = bookService.findBookByIndex(id);
        if (book != null){
            model.addAttribute("books", book);
            return "editBook.jsp";
        }else{
            return "redirect:/books";
        }
    }
	@PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "showBook.jsp";
        }else{
            this.bookService.updateBook(book);
            return "redirect:/books/{id}";
        }
    }
	
	@GetMapping(value="/books/delete/{id}")
    public String destroyBook(@PathVariable("id") Long id) {
        this.bookService.destroyBook(id);
        return "redirect:/books";
    }

}