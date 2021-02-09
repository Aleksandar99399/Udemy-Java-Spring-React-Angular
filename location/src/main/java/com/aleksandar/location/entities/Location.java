package com.aleksandar.location.entities;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    private int id;
    private String code;
    private String name;
    private String type;

    public int getId() {
        return id;
    }

    public Location setId(int id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Location setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Location setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Location setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
