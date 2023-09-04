package com.example.librarymanagementsystem.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "USERS_TBL")
@Access(AccessType.FIELD)
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    @NotNull
    @NotEmpty(message = "*Please provide a user name")
    @Column(unique = true,name="user_name")
    private String username;

    @NotNull
    @NotEmpty(message = "*Please provide a password")
    @Column(name="pass")
    private String password;
    @ManyToMany(fetch=FetchType.LAZY)
    //cascade =CascadeType.ALL
    @JoinTable(name = "USER_ROLE_TBL",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}