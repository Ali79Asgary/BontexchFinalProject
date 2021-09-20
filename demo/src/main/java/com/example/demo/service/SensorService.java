package com.example.demo.service;

import com.example.demo.io.dao.SensorRepository;
import com.example.demo.io.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> getSensors() {
        return sensorRepository.findAll();
    }

    public Sensor getSensorById(@PathVariable  Long id) {
        return sensorRepository.getById(id);
    }

    public Sensor insertSensor(@RequestBody Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public void deleteSensorById(@PathVariable Long id) {
        sensorRepository.deleteById(id);
    }
}
