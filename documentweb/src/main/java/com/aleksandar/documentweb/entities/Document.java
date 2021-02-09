package com.aleksandar.documentweb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Document {

    @Id
    private long id;
    private String name;
    @Lob
    private byte[] data;

    public long getId() {
        return id;
    }

    public Document setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Document setName(String name) {
        this.name = name;
        return this;
    }

    public byte[] getData() {
        return data;
    }

    public Document setData(byte[] data) {
        this.data = data;
        return this;
    }
}
