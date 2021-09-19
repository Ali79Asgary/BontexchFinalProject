package com.example.demo.io.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Silo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int maxCapacity;
    private int cerealsAmount;

    public Silo() {
    }

    public Silo(String name, int maxCapacity, int cerealsAmount) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.cerealsAmount = cerealsAmount;
    }

    public Silo(Long id, String name, int maxCapacity, int cerealsAmount) {
        this.id = id;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.cerealsAmount = cerealsAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCerealsAmount() {
        return cerealsAmount;
    }

    public void setCerealsAmount(int cerealsAmount) {
        this.cerealsAmount = cerealsAmount;
    }

    @Override
    public String toString() {
        return "Silo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", cerealsAmount=" + cerealsAmount +
                '}';
    }
}
