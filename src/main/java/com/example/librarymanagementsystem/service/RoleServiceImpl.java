package com.example.librarymanagementsystem.service;


import com.example.librarymanagementsystem.controller.SignupController;
import com.example.librarymanagementsystem.model.Role;
import com.example.librarymanagementsystem.repository.RoleRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.librarymanagementsystem.controller.SignupController.Roles.*;

import javax.annotation.PostConstruct;

@Service
public class RoleServiceImpl implements RoleService, InitializingBean {
private final RoleRepository roleRepository;

@Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role saveRole(Role role) {


        return roleRepository.save(role);


    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Role role = new Role();
        role.setId(ROLE_USER);
        role.setName(ROLE_1);
        this.saveRole(role);
        role.setId(ROLE_ADMIN);
        role.setName(ROLE_2);
        this.saveRole(role);
        role.setId(ROLE_PUBLISHER);
        role.setName(ROLE_3);
        this.saveRole(role);

    }
}
