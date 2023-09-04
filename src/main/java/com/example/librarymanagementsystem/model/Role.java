package com.example.librarymanagementsystem.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROLE_TBL")
@Access(AccessType.FIELD)

public class Role {

    @Id
    @GeneratedValue()
    @Column(name = "")
    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles")


    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}