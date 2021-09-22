package com.example.demo.io.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ChangeStoredAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String detectTime;
    private int changeAmount;
    @ManyToOne
    private Silo silo;

    public ChangeStoredAmount() {
    }

    public ChangeStoredAmount(String detectTime, int changeAmount, Silo silo) {
        this.detectTime = detectTime;
        this.changeAmount = changeAmount;
        this.silo = silo;
    }

    public ChangeStoredAmount(Long id, String detectTime, int changeAmount, Silo silo) {
        this.id = id;
        this.detectTime = detectTime;
        this.changeAmount = changeAmount;
        this.silo = silo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetectTime() {
        return detectTime;
    }

    public void setDetectTime(String detectTime) {
        this.detectTime = detectTime;
    }

    public int getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(int changeAmount) {
        this.changeAmount = changeAmount;
    }

    public Silo getSilo() {
        return silo;
    }

    public void setSilo(Silo silo) {
        this.silo = silo;
    }

    @Override
    public String toString() {
        return "ChangeStoredAmount{" +
                "id=" + id +
                ", detectTime=" + detectTime +
                ", changeAmount=" + changeAmount +
                ", silo=" + silo +
                '}';
    }
}
