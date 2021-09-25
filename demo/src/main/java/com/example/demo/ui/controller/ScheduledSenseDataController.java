package com.example.demo.ui.controller;

import com.example.demo.io.entity.ScheduledSenseData;
import com.example.demo.service.ScheduledSenseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/scheduled-sense-data")
public class ScheduledSenseDataController {

    private final ScheduledSenseDataService scheduledSenseDataService;

    @Autowired
    public ScheduledSenseDataController(ScheduledSenseDataService scheduledSenseDataService) {
        this.scheduledSenseDataService = scheduledSenseDataService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ScheduledSenseData> getScheduledSenseData() {
        return scheduledSenseDataService.getScheduledSenseData();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ScheduledSenseData getScheduledSenseDataById(@PathVariable Long id) {
        return scheduledSenseDataService.getScheduledSenseDataById(id);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ScheduledSenseData insertScheduledSenseData(@RequestBody ScheduledSenseData scheduledSenseData) {
        return scheduledSenseDataService.insertScheduledSenseData(scheduledSenseData);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteScheduledSenseDataById(@PathVariable Long id) {
        scheduledSenseDataService.deleteScheduledSenseDataById(id);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ScheduledSenseData updateScheduledSenseData(
            @RequestBody ScheduledSenseData newScheduledSenseData,
            @PathVariable Long id) {
        return scheduledSenseDataService.updateScheduledSenseData(newScheduledSenseData, id);
    }
}
