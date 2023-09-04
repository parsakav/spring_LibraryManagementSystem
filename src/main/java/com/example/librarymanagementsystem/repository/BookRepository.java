package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
    Book findBookByName(String name);
}
