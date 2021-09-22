package com.example.demo.service;

import com.example.demo.io.dao.ScheduledSenseDataTimeRepository;
import com.example.demo.io.entity.ScheduledSenseData;
import com.example.demo.io.entity.ScheduledSenseDataTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ScheduledSenseDataTimeService {

    private final ScheduledSenseDataTimeRepository scheduledSenseDataTimeRepository;

    @Autowired
    public ScheduledSenseDataTimeService(ScheduledSenseDataTimeRepository scheduledSenseDataTimeRepository) {
        this.scheduledSenseDataTimeRepository = scheduledSenseDataTimeRepository;
    }

    public List<ScheduledSenseDataTime> getScheduledSenseDataTimes() {
        return scheduledSenseDataTimeRepository.findAll();
    }

    public ScheduledSenseDataTime getScheduledSenseDataTimeById(@PathVariable Long id) {
        return scheduledSenseDataTimeRepository.getById(id);
    }

    public ScheduledSenseDataTime insertScheduledSenseDataTime(@RequestBody ScheduledSenseDataTime scheduledSenseDataTime) {
        return scheduledSenseDataTimeRepository.save(scheduledSenseDataTime);
    }

    public void deleteScheduledSenseDataTimeById(@PathVariable Long id) {
        scheduledSenseDataTimeRepository.deleteById(id);
    }

    public ScheduledSenseDataTime updateScheduledSenseDataTime(
            @RequestBody ScheduledSenseDataTime newScheduledSenseDataTime,
            @PathVariable Long id) {
        return scheduledSenseDataTimeRepository.findById(id).map(scheduledSenseDataTime -> {
            scheduledSenseDataTime.setTime(newScheduledSenseDataTime.getTime());
            scheduledSenseDataTime.setSensedValue(newScheduledSenseDataTime.getSensedValue());
            scheduledSenseDataTime.setScheduledSenseData(newScheduledSenseDataTime.getScheduledSenseData());
            return scheduledSenseDataTimeRepository.save(scheduledSenseDataTime);
        }).orElseGet(() -> {
            return scheduledSenseDataTimeRepository.save(newScheduledSenseDataTime);
        });
    }
}
