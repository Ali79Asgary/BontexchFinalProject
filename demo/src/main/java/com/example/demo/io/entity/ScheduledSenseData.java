package com.example.demo.io.entity;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@Entity
public class ScheduledSenseData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Duration duration;
    @OneToOne
    private Sensor sensor;
    @OneToMany
    private List<ScheduledSenseDataTime> scheduledSenseDataTimeList;

    public ScheduledSenseData() {
    }

    public ScheduledSenseData(Duration duration, Sensor sensor, List<ScheduledSenseDataTime> scheduledSenseDataTimeList) {
        this.duration = duration;
        this.sensor = sensor;
        this.scheduledSenseDataTimeList = scheduledSenseDataTimeList;
    }

    public ScheduledSenseData(Long id, Duration duration, Sensor sensor, List<ScheduledSenseDataTime> scheduledSenseDataTimeList) {
        this.id = id;
        this.duration = duration;
        this.sensor = sensor;
        this.scheduledSenseDataTimeList = scheduledSenseDataTimeList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public List<ScheduledSenseDataTime> getScheduledSenseDataTimeList() {
        return scheduledSenseDataTimeList;
    }

    public void setScheduledSenseDataTimeList(List<ScheduledSenseDataTime> scheduledSenseDataTimeList) {
        this.scheduledSenseDataTimeList = scheduledSenseDataTimeList;
    }

    @Override
    public String toString() {
        return "ScheduledSenseData{" +
                "id=" + id +
                ", duration=" + duration +
                ", sensor=" + sensor +
                ", scheduledSenseDataTimeList=" + scheduledSenseDataTimeList +
                '}';
    }
}
