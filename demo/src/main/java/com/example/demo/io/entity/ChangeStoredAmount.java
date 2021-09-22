package com.example.demo.io.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class ChangeStoredAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Time detectTime;
    private int changeAmount;
    @OneToOne
    private Silo silo;

    public ChangeStoredAmount() {
    }

    public ChangeStoredAmount(Time detectTime, int changeAmount, Silo silo) {
        this.detectTime = detectTime;
        this.changeAmount = changeAmount;
        this.silo = silo;
    }

    public ChangeStoredAmount(Long id, Time detectTime, int changeAmount, Silo silo) {
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

    public Time getDetectTime() {
        return detectTime;
    }

    public void setDetectTime(Time detectTime) {
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
