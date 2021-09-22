package com.example.demo.io.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class ScheduledSenseDataTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Time time;
    private int sensedValue;
    @ManyToOne
    private ScheduledSenseData scheduledSenseData;

    public ScheduledSenseDataTime() {
    }

    public ScheduledSenseDataTime(Time time, int sensedValue, ScheduledSenseData scheduledSenseData) {
        this.time = time;
        this.sensedValue = sensedValue;
        this.scheduledSenseData = scheduledSenseData;
    }

    public ScheduledSenseDataTime(Long id, Time time, int sensedValue, ScheduledSenseData scheduledSenseData) {
        this.id = id;
        this.time = time;
        this.sensedValue = sensedValue;
        this.scheduledSenseData = scheduledSenseData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getSensedValue() {
        return sensedValue;
    }

    public void setSensedValue(int sensedValue) {
        this.sensedValue = sensedValue;
    }

    public ScheduledSenseData getScheduledSenseData() {
        return scheduledSenseData;
    }

    public void setScheduledSenseData(ScheduledSenseData scheduledSenseData) {
        this.scheduledSenseData = scheduledSenseData;
    }

    @Override
    public String toString() {
        return "ScheduledSenseDataTime{" +
                "id=" + id +
                ", time=" + time +
                ", sensedValue=" + sensedValue +
                ", scheduledSenseData=" + scheduledSenseData +
                '}';
    }
}
