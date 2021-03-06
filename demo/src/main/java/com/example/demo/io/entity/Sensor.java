package com.example.demo.io.entity;

import javax.persistence.*;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Silo silo;
    @OneToOne
    private ScheduledSenseData scheduledSenseData;

    public Sensor() {
    }

    public Sensor(String name, Silo silo, ScheduledSenseData scheduledSenseData) {
        this.name = name;
        this.silo = silo;
        this.scheduledSenseData = scheduledSenseData;
    }

    public Sensor(Long id, String name, Silo silo, ScheduledSenseData scheduledSenseData) {
        this.id = id;
        this.name = name;
        this.silo = silo;
        this.scheduledSenseData = scheduledSenseData;
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

    public Silo getSilo() {
        return silo;
    }

    public void setSilo(Silo silo) {
        this.silo = silo;
    }

    public ScheduledSenseData getScheduledSenseData() {
        return scheduledSenseData;
    }

    public void setScheduledSenseData(ScheduledSenseData scheduledSenseData) {
        this.scheduledSenseData = scheduledSenseData;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", silo=" + silo +
                ", scheduledSenseData=" + scheduledSenseData +
                '}';
    }
}
