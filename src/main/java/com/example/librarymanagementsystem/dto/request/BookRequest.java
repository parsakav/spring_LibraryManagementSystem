package com.example.librarymanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String id;
    private String name;
    private String authors;
    private String publisher;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date published;
    private MultipartFile picture;

}
