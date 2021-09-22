package com.example.demo.io.dao;

import com.example.demo.io.entity.ChangeStoredAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeStoredAmountRepository extends JpaRepository<ChangeStoredAmount, Long> {
}
