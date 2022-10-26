package com.seyitahmetinci.springsecurity.entitites;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "roles")
@Getter
@Setter
public class Roles {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role_name")
    private String name;


    public Roles() {
    }

    public Roles(String name) {
        this.name = name;
    }

    public Roles(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Roles(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return id == roles.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
