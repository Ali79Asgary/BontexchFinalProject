package com.example.demo.ui.controller;

import com.example.demo.io.entity.ChangeStoredAmount;
import com.example.demo.service.ChangeStoredAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/change-stored-amount")
public class ChangeStoredAmountController {

    private final ChangeStoredAmountService changeStoredAmountService;

    @Autowired
    public ChangeStoredAmountController(ChangeStoredAmountService changeStoredAmountService) {
        this.changeStoredAmountService = changeStoredAmountService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ChangeStoredAmount> getChangeStoredAmounts() {
        return changeStoredAmountService.getChangeStoredAmounts();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ChangeStoredAmount getChangeStoredAmountById(@PathVariable Long id) {
        return changeStoredAmountService.getChangeStoredAmountById(id);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChangeStoredAmount insertChangeStoredAmount(@RequestBody ChangeStoredAmount changeStoredAmount) {
        return changeStoredAmountService.insertChangeStoredAmount(changeStoredAmount);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteChangeStoredAmountById(@PathVariable Long id) {
        changeStoredAmountService.deleteChangeStoredAmountById(id);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChangeStoredAmount updateChangeStoredAmount(
            @RequestBody ChangeStoredAmount newChangeStoredAmount,
            @PathVariable Long id) {
        return changeStoredAmountService.updateChangeStoredAmount(newChangeStoredAmount, id);
    }
}
