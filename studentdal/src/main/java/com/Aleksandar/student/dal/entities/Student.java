package com.Aleksandar.student.dal.entities;

import javax.persistence.*;

@Entity
@Table(name = "studenttab")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sname")
    private String name;
    @Column(name = "scourse")
    private String course;
    @Column(name = "sfee")
    private Double fee;

    public Long getId() {
        return id;
    }

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getCourse() {
        return course;
    }

    public Student setCourse(String course) {
        this.course = course;
        return this;
    }

    public Double getFee() {
        return fee;
    }

    public Student setFee(Double fee) {
        this.fee = fee;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", fee=" + fee +
                '}';
    }
}
