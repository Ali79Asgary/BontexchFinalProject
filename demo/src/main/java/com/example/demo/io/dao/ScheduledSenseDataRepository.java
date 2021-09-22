package com.example.demo.io.dao;

import com.example.demo.io.entity.ScheduledSenseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledSenseDataRepository extends JpaRepository<ScheduledSenseData, Long> {
}
