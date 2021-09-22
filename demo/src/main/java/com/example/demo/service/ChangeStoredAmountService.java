package com.example.demo.service;

import com.example.demo.io.dao.ChangeStoredAmountRepository;
import com.example.demo.io.entity.ChangeStoredAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ChangeStoredAmountService {

    private final ChangeStoredAmountRepository changeStoredAmountRepository;

    @Autowired
    public ChangeStoredAmountService(ChangeStoredAmountRepository changeStoredAmountRepository) {
        this.changeStoredAmountRepository = changeStoredAmountRepository;
    }

    public List<ChangeStoredAmount> getChangeStoredAmounts() {
        return changeStoredAmountRepository.findAll();
    }

    public ChangeStoredAmount getChangeStoredAmountById(@PathVariable Long id) {
        return changeStoredAmountRepository.getById(id);
    }

    public ChangeStoredAmount insertChangeStoredAmount(@RequestBody ChangeStoredAmount changeStoredAmount) {
        return changeStoredAmountRepository.save(changeStoredAmount);
    }

    public void deleteChangeStoredAmountById(@PathVariable Long id) {
        changeStoredAmountRepository.deleteById(id);
    }

    public ChangeStoredAmount updateChangeStoredAmount(
            @RequestBody ChangeStoredAmount newChangeStoredAmount,
            @PathVariable Long id) {
        return changeStoredAmountRepository.findById(id).map(changeStoredAmount -> {
            changeStoredAmount.setChangeAmount(newChangeStoredAmount.getChangeAmount());
            changeStoredAmount.setDetectTime(newChangeStoredAmount.getDetectTime());
            changeStoredAmount.setSilo(newChangeStoredAmount.getSilo());
            return changeStoredAmountRepository.save(changeStoredAmount);
        }).orElseGet(() -> {
            return changeStoredAmountRepository.save(newChangeStoredAmount);
        });
    }
}
