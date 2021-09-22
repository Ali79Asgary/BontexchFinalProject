package com.example.demo.io.entity;

import javax.persistence.*;

@Entity
public class Silo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int maxCapacity;
    private int cerealsAmount;
    @ManyToOne
    private Store store;
    @OneToOne
    private Sensor sensor;
    @OneToOne
    private ChangeStoredAmount changeStoredAmount;

    public Silo() {
    }

    public Silo(
            String name,
            int maxCapacity,
            int cerealsAmount,
            Store store,
            Sensor sensor,
            ChangeStoredAmount changeStoredAmount
    ) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.cerealsAmount = cerealsAmount;
        this.store = store;
        this.sensor = sensor;
        this.changeStoredAmount = changeStoredAmount;
    }

    public Silo(Long id,
                String name,
                int maxCapacity,
                int cerealsAmount,
                Store store,
                Sensor sensor,
                ChangeStoredAmount changeStoredAmount
    ) {
        this.id = id;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.cerealsAmount = cerealsAmount;
        this.store = store;
        this.sensor = sensor;
        this.changeStoredAmount = changeStoredAmount;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public ChangeStoredAmount getChangeStoredAmount() {
        return changeStoredAmount;
    }

    public void setChangeStoredAmount(ChangeStoredAmount changeStoredAmount) {
        this.changeStoredAmount = changeStoredAmount;
    }

    @Override
    public String toString() {
        return "Silo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", cerealsAmount=" + cerealsAmount +
                ", store=" + store +
                ", sensor=" + sensor +
                ", changeStoredAmount=" + changeStoredAmount +
                '}';
    }
}
