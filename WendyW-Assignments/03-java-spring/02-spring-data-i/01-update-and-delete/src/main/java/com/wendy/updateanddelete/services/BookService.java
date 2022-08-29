package com.wendy.updateanddelete.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendy.updateanddelete.models.Book;
import com.wendy.updateanddelete.repositories.BookRepository;

@Service
public class BookService {
	
    private List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("Diamond Sutra", "Let it go, let it be! Stay still.", "English", 77),
            new Book("Buddha Speaks Infinite Life Sutra", "how to get into infinity life space", "Chinese", 777)
            ));
    
    public List<Book> allBooks() {
        return books;
    }
    
    public Book findBookByIndex(int index) {
        if (index < books.size()){
            return books.get(index);
        }else{
            return null;
        }
    }
	@Autowired
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
   

	public Book getSingleBook(Long id) {
		return this.bookRepository.findById(id).orElse(null);
	}
    
	public Book updateBook(Book updatedBook) {
        return this.bookRepository.save(updatedBook);
    }
	
	public String destroyBook(Long id) {
        this.bookRepository.deleteById(id);
        return "Book" + id + " has been deleted";
        
    }
}
// retrieves a book same as getSingleBook method
//public Book findBook(Long id) {
//    Optional<Book> optionalBook = bookRepository.findById(id);
//    if(optionalBook.isPresent()) {
//        return optionalBook.get();
//    } else {
//        return null;
//    }
//}
