package com.example.demo.io.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String complexName;
    @OneToMany
    private List<Silo> siloList;

    public Store() {
    }

    public Store(String complexName, List<Silo> siloList) {
        this.complexName = complexName;
        this.siloList = siloList;
    }

    public Store(Long id, String complexName, List<Silo> siloList) {
        this.id = id;
        this.complexName = complexName;
        this.siloList = siloList;
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

    public List<Silo> getSiloList() {
        return siloList;
    }

    public void setSiloList(List<Silo> siloList) {
        this.siloList = siloList;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", complexName='" + complexName + '\'' +
                ", siloList=" + siloList +
                '}';
    }
}
