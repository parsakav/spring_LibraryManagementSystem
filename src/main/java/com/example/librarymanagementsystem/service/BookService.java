package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dto.request.BookRequest;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.User;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class BookService implements InitializingBean {

    @Value("${upload.bookpic.folder}")
  private  String uploadpath;
    static List<Book> listOfBooks= new ArrayList<>();
    @Getter
    static int id = 5;
    static
    {
        listOfBooks.add(new Book(1,"Head First Java","Kathy Sierra, Bert Bates","O'Reilly",new Date(2003,11,2),new Date(2021,2,1),null));
        listOfBooks.add(new Book(2,"Clean Code","Robert C. Martin","Pearson Education",new Date(2008,3,7),new Date(2021,9,5),null));
        listOfBooks.add(new Book(3,"The Go Programming Language","Alan A. A. Donovan","Pearson Education",new Date(2015,5,8),new Date(2021,10,6),null));
        listOfBooks.add(new Book(4,"Python Crash Course","Eric Matthes","No Starch Press",new Date(2019,4,8),new Date(2021,4,7),null));
    }
    @Autowired
    private BookRepository bookRepository;

    public Page<Book> showAllBooks(Pageable pageable) {
        int start = (int)pageable.getOffset();
//        System.out.println(start);
        int end = Math.min((start + pageable.getPageSize()), listOfBooks.size());
//        System.out.println(end);
        Page<Book> page = new PageImpl<>(listOfBooks.subList(start, end), pageable, listOfBooks.size());
        return page;
    }

    public List<Book> addBook(String name, String authors, String publisher, Date published, MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();

            Path path = Paths.get(uploadpath + file.getOriginalFilename());
            Path p = Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        listOfBooks.add(new Book(id++, name, authors, publisher, published, new Date(), file.getOriginalFilename()));
        return listOfBooks;
    }

    public void removeBook(int id) {
        Iterator it= listOfBooks.iterator();

        while (it.hasNext()) {
            Book bid=(Book) it.next();
            if(bid.getISSN() == id) {
                it.remove();
            }
        }
    }

    public void editBook(int id, String bookname) {
        Iterator it= listOfBooks.iterator();

        while (it.hasNext()) {
            Book bid=(Book) it.next();
            if(bid.getISSN() == id) {
                bid.setName(bookname);
            }
        }
    }

    public Book getDetails(String book_name) {
        Iterator it= listOfBooks.iterator();

        while (it.hasNext()) {
            Book mybook=(Book) it.next();
            if((mybook.getName()).equalsIgnoreCase(book_name)) {
                return mybook;
            }
        }
        return null;
    }

    public Book findBookByName(String Name) {
        return bookRepository.findBookByName(Name);
    }

    public List<Book> showAllBooksData() {
        return listOfBooks;
    }

    public Book getBookDetails(String book_name) {
        Iterator it= listOfBooks.iterator();

        while (it.hasNext()) {
            Book mybook=(Book) it.next();
            if((mybook.getName()).equalsIgnoreCase(book_name))
                return mybook;
        }
        return null;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        File f = new File(uploadpath);
        f.mkdir();
    }
}
