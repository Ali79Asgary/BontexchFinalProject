package com.example.demo.io.dao;

import com.example.demo.io.entity.Silo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiloRepository extends JpaRepository<Silo, Long> {
}
