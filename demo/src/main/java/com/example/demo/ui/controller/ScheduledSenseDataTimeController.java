package com.example.demo.ui.controller;

import com.example.demo.io.entity.ScheduledSenseDataTime;
import com.example.demo.service.ScheduledSenseDataService;
import com.example.demo.service.ScheduledSenseDataTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/scheduled-sense-data-time")
public class ScheduledSenseDataTimeController {

    private final ScheduledSenseDataTimeService scheduledSenseDataTimeService;

    @Autowired
    public ScheduledSenseDataTimeController(ScheduledSenseDataTimeService scheduledSenseDataTimeService) {
        this.scheduledSenseDataTimeService = scheduledSenseDataTimeService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ScheduledSenseDataTime> getScheduledSenseDataTimes() {
        return scheduledSenseDataTimeService.getScheduledSenseDataTimes();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ScheduledSenseDataTime getScheduledSenseDataTimeById(@PathVariable Long id) {
        return scheduledSenseDataTimeService.getScheduledSenseDataTimeById(id);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ScheduledSenseDataTime insertScheduledSenseDataTime(@RequestBody ScheduledSenseDataTime scheduledSenseDataTime) {
        return scheduledSenseDataTimeService.insertScheduledSenseDataTime(scheduledSenseDataTime);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteScheduledSenseDataTimeById(@PathVariable Long id) {
        scheduledSenseDataTimeService.deleteScheduledSenseDataTimeById(id);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ScheduledSenseDataTime updateScheduledSenseDataTime(
            @RequestBody ScheduledSenseDataTime newScheduledSenseDataTime,
            @PathVariable Long id) {
        return scheduledSenseDataTimeService.updateScheduledSenseDataTime(newScheduledSenseDataTime, id);
    }
}
