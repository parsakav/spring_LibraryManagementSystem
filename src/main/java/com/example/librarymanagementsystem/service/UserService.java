package com.example.librarymanagementsystem.service;


import com.example.librarymanagementsystem.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface UserService {

     User findUserByUsername(String userName);

     User saveUser(User user);
     Page<User> getAllUser(Pageable pageable);
     void delUserById(long id);
}
