package com.example.demo.io.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String complexName;

    public Store() {
    }

    public Store(String complexName) {
        this.complexName = complexName;
    }

    public Store(Long id, String complexName) {
        this.id = id;
        this.complexName = complexName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", complexName='" + complexName + '\'' +
                '}';
    }
}
