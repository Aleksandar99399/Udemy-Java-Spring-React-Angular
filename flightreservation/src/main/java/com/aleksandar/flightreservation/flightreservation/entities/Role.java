package com.aleksandar.flightreservation.flightreservation.entities;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
public class Role extends AbstractEntity implements GrantedAuthority {

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User>users;

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }


    public Set<User> getUsers() {
        return users;
    }

    public Role setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
