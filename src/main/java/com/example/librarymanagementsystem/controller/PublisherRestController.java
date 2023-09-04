package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.dto.request.BookRequest;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/publisher")
@PreAuthorize("hasRole('PUBLISHER')")
public class PublisherRestController {
    private final BookService services;

    @Autowired
    public PublisherRestController(BookService services) {
        this.services = services;
    }


    @GetMapping("/add")
    public ModelAndView addBooksShowPage(Model model) {
        model.addAttribute("book", new BookRequest(null,"BookName", "Author Names", "Publisher", new Date(), null));
        ModelAndView modelAndView = new ModelAndView("addbook");
        return modelAndView;
    }

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

    @GetMapping("/delete")
    public ModelAndView deleteBook(Model model) {
        model.addAttribute("book", new BookRequest("id",null,null,null, null, null));
        ModelAndView modelAndView = new ModelAndView("deletebook");
        return modelAndView;
    }

    @PostMapping("/delete")
    public void deleteBook(HttpServletResponse response, BookRequest bookRequest) throws IOException {
        services.removeBook(Integer.valueOf(bookRequest.getId()));
        response.sendRedirect("/book/list");
    }

    @GetMapping("/edit")
    public ModelAndView editBook(Model model) {
        model.addAttribute("book", new BookRequest("id","BookName", null, null, null, null));
        ModelAndView modelAndView = new ModelAndView("editbook");
        return modelAndView;
    }

    @PostMapping("/edit")
    public void editBook(HttpServletResponse response,  BookRequest bookRequest) throws IOException {
        services.editBook(Integer.valueOf(bookRequest.getId()), bookRequest.getName());
        response.sendRedirect("/book/list");
    }


}
