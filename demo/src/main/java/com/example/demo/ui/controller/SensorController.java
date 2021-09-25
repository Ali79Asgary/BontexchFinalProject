package com.example.demo.ui.controller;

import com.example.demo.io.entity.Sensor;
import com.example.demo.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sensor")
public class SensorController {

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sensor> getSensors() {
        return sensorService.getSensors();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Sensor getSensorById(@PathVariable Long id) {
        return sensorService.getSensorById(id);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Sensor insertSensor(@RequestBody Sensor sensor) {
        return sensorService.insertSensor(sensor);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSensorById(@PathVariable Long id) {
        sensorService.deleteSensorById(id);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Sensor updateSensor(@RequestBody Sensor newSensor, @PathVariable Long id) {
        return sensorService.updateSensor(newSensor, id);
    }
}
