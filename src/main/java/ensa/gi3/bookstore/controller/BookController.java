package ensa.gi3.bookstore.controller;

import ensa.gi3.bookstore.model.Book;
import ensa.gi3.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String index(Book book, BindingResult result, Model model) {
        Iterable<Book> books = bookRepository.findAll();

        if (books instanceof Collection && ((Collection<?>) books).size() > 0) {
            model.addAttribute("books", bookRepository.findAll());
        }
        return "index";
    }

    @GetMapping("/new")
    public String create(Book book, BindingResult result, Model model) {
        return "new";
    }


    @PostMapping("/")
    public String store(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new";
        }

        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    // additional CRUD methods
}