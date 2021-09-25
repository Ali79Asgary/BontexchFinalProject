package com.example.demo.config;

import com.example.demo.io.dao.*;
import com.example.demo.io.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AllConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            SensorRepository sensorRepository,
            SiloRepository siloRepository,
            StoreRepository storeRepository,
            ChangeStoredAmountRepository changeStoredAmountRepository,
            ScheduledSenseDataRepository scheduledSenseDataRepository,
            ScheduledSenseDataTimeRepository scheduledSenseDataTimeRepository) {
        return args -> {
            Store firstStore = new Store();
            Store secondStore = new Store();
            storeRepository.saveAll(
                    List.of(firstStore, secondStore)
            );

            Silo firstSilo = new Silo();
            Silo secondSilo = new Silo();
            siloRepository.saveAll(
                    List.of(firstSilo, secondSilo)
            );

            Sensor firstSensor = new Sensor();
            Sensor secondSensor = new Sensor();
            sensorRepository.saveAll(
                    List.of(firstSensor, secondSensor)
            );

            ChangeStoredAmount firstChangeStoredAmount = new ChangeStoredAmount();
            ChangeStoredAmount secondChangeStoredAmount = new ChangeStoredAmount();
            changeStoredAmountRepository.saveAll(
                    List.of(firstChangeStoredAmount, secondChangeStoredAmount)
            );

            ScheduledSenseData firstScheduledSenseData = new ScheduledSenseData();
            ScheduledSenseData secondScheduledSenseData = new ScheduledSenseData();
            scheduledSenseDataRepository.saveAll(
                    List.of(firstScheduledSenseData, secondScheduledSenseData)
            );

            ScheduledSenseDataTime firstScheduledSenseDataTime = new ScheduledSenseDataTime();
            ScheduledSenseDataTime secondScheduledSenseDataTime = new ScheduledSenseDataTime();
            scheduledSenseDataTimeRepository.saveAll(
                    List.of(firstScheduledSenseDataTime, secondScheduledSenseDataTime)
            );
        };
    }
}
