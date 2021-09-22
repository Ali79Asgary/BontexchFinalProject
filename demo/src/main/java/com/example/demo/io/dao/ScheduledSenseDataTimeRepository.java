package com.example.demo.io.dao;

import com.example.demo.io.entity.ScheduledSenseDataTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledSenseDataTimeRepository extends JpaRepository<ScheduledSenseDataTime, Long> {
}
