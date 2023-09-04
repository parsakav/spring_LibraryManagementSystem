package com.example.librarymanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK_TBL")

public class Book {
    @Id
    @GeneratedValue
    private int ISSN;
    private String name;
    private String authors;
    private String publisher;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date published;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date added;
    private String picture;
}
