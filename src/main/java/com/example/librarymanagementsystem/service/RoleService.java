package com.example.librarymanagementsystem.service;


import com.example.librarymanagementsystem.model.Role;

public interface RoleService {
     Role saveRole(Role role);
     Role findById(long id);

}
