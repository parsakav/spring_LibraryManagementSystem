package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.dto.request.BookRequest;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/book")
public class BookRestController {

    private final BookService services;

    @Autowired
    public BookRestController(BookService services) {
        this.services = services;
    }

    @GetMapping("/list")
    public ModelAndView listOfBooks(Pageable pageable, Model model) {
        model.addAttribute("books", services.showAllBooks(pageable).getContent());
        ModelAndView modelAndView = new ModelAndView("showallbooks");
        return modelAndView;
    }

    @PreAuthorize("hasRole('PUBLISHER')")
    @GetMapping("/add")
    public ModelAndView addBooksShowPage(Model model) {
        model.addAttribute("book", new BookRequest(null,"BookName", "Author Names", "Publisher", new Date(), null));
        ModelAndView modelAndView = new ModelAndView("addbook");
        return modelAndView;
    }
    @PreAuthorize("hasRole('PUBLISHER')")
    @PostMapping("/add")
    public void addBooks(ModelMap model, BookRequest bookRequest, HttpServletResponse response, @RequestParam("file") MultipartFile file) throws IOException {
        bookRequest.setPicture(file);
        services.addBook(bookRequest.getName(),
                bookRequest.getAuthors(),
                bookRequest.getPublisher(),
                bookRequest.getPublished(),
                bookRequest.getPicture());
        response.sendRedirect("/book/list");
    }

    @PreAuthorize("hasRole('PUBLISHER')")
    @GetMapping("/delete")
    public void deleteBook(int id, HttpServletResponse response) throws IOException {
        services.removeBook(id);
        response.sendRedirect("/book/list");
    }

    @PreAuthorize("hasRole('PUBLISHER')")
    @PostMapping("/edit")
    public void editBook(int id, @RequestParam String bookname, HttpServletResponse response) throws IOException {
        services.editBook(id, bookname);
        response.sendRedirect("/book/list");
    }
    @PreAuthorize("hasRole('PUBLISHER')")
    @GetMapping("/edit")
    public ModelAndView editBookDetailsShowPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("edit");
        return modelAndView;
    }

    @GetMapping("/get-details")
    public ModelAndView getBookDetails(Model model) {
        model.addAttribute("searchbook", services.showAllBooksData());
        ModelAndView modelAndView = new ModelAndView("bookdetails");
        return modelAndView;
    }

    @RequestMapping("/get-book-details-one")
    public ModelAndView getBookDetails(ModelMap model, @RequestParam String book_name) {
        model.put("clickbook",services.getBookDetails(book_name));
        //model.put("clickbook",bookRepository.findByBook_name(book_name));
        {

            model.put("error","No Subjects are available");
        }
        ModelAndView modelAndView = new ModelAndView("getbookdetails");
        return modelAndView;
    }
}
