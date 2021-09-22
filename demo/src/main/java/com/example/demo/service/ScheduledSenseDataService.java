package com.example.demo.service;

import com.example.demo.io.dao.ScheduledSenseDataRepository;
import com.example.demo.io.entity.ScheduledSenseData;
import com.example.demo.io.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ScheduledSenseDataService {

    private final ScheduledSenseDataRepository scheduledSenseDataRepository;

    @Autowired
    public ScheduledSenseDataService(ScheduledSenseDataRepository scheduledSenseDataRepository) {
        this.scheduledSenseDataRepository = scheduledSenseDataRepository;
    }

    public List<ScheduledSenseData> getScheduledSenseData() {
        return scheduledSenseDataRepository.findAll();
    }

    public ScheduledSenseData getScheduledSenseDataById(@PathVariable Long id) {
        return scheduledSenseDataRepository.getById(id);
    }

    public ScheduledSenseData insertScheduledSenseData(@RequestBody ScheduledSenseData scheduledSenseData) {
        return scheduledSenseDataRepository.save(scheduledSenseData);
    }

    public void deleteScheduledSenseDataById(@PathVariable Long id) {
        scheduledSenseDataRepository.deleteById(id);
    }

    public ScheduledSenseData updateScheduledSenseData(@RequestBody ScheduledSenseData newScheduledSenseData, @PathVariable Long id) {
        return scheduledSenseDataRepository.findById(id).map(scheduledSenseData -> {
            scheduledSenseData.setDuration(newScheduledSenseData.getDuration());
            scheduledSenseData.setSensor(newScheduledSenseData.getSensor());
            scheduledSenseData.setScheduledSenseDataTimeList(newScheduledSenseData.getScheduledSenseDataTimeList());
            return scheduledSenseDataRepository.save(scheduledSenseData);
        }).orElseGet(() -> {
            return scheduledSenseDataRepository.save(newScheduledSenseData);
        });
    }
}
