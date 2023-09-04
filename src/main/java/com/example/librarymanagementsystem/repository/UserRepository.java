package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
    User findById(long id);


    /* @Modifying
    @Query("update User u set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
    void updateUserById(String firstname, String lastname, Integer userId); */
}