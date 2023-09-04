package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
Role findById(long id);
    
}