package com.example.demo.service;

import com.example.demo.io.dao.SiloRepository;
import com.example.demo.io.entity.ChangeStoredAmount;
import com.example.demo.io.entity.Silo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class SiloService {

    private final SiloRepository siloRepository;

    @Autowired
    public SiloService(SiloRepository siloRepository) {
        this.siloRepository = siloRepository;
    }

    public List<Silo> getSilos() {
        return siloRepository.findAll();
    }

    public Silo getSiloById(@PathVariable Long id) {
        return siloRepository.getById(id);
    }

    public int getSiloCerealsAmount(@PathVariable Long id) {
        return siloRepository.getById(id).getCerealsAmount();
    }

    public void addCerealsAmount(int addedCerealsAmount, @PathVariable Long id) {
        Date date = new Date();
        int initialAmount = siloRepository.getById(id).getCerealsAmount();
        siloRepository.getById(id).setCerealsAmount(initialAmount+addedCerealsAmount);
        List<ChangeStoredAmount> changeStoredAmountList = siloRepository.getById(id).getChangeStoredAmount();
        changeStoredAmountList.add(new ChangeStoredAmount(date.toString(), addedCerealsAmount, siloRepository.getById(id)));
        siloRepository.getById(id).setChangeStoredAmount(changeStoredAmountList);
    }

    public void reduceCerealsAmount(int reducedCerealsAmount, @PathVariable Long id) {
        Date date = new Date();
        int initialAmount = siloRepository.getById(id).getCerealsAmount();
        siloRepository.getById(id).setCerealsAmount(initialAmount-reducedCerealsAmount);
        List<ChangeStoredAmount> changeStoredAmountList = siloRepository.getById(id).getChangeStoredAmount();
        changeStoredAmountList.add(new ChangeStoredAmount(date.toString(), reducedCerealsAmount, siloRepository.getById(id)));
        siloRepository.getById(id).setChangeStoredAmount(changeStoredAmountList);
    }

    public List<ChangeStoredAmount> getChangesByCount(int count, @PathVariable Long id) {
        List<ChangeStoredAmount> changeStoredAmountList = siloRepository.getById(id).getChangeStoredAmount();
        List<ChangeStoredAmount> resultList = null;
        for (int i = changeStoredAmountList.size()-count; i < changeStoredAmountList.size(); i++) {
            resultList.add(changeStoredAmountList.get(i));
        }
        return resultList;
    }

    public Silo insertSilo(@RequestBody Silo silo) {
        return siloRepository.save(silo);
    }

    public void deleteSiloById(@PathVariable Long id) {
        siloRepository.deleteById(id);
    }

    public Silo updateSilo(@RequestBody Silo newSilo, @PathVariable Long id) {
        return siloRepository.findById(id).map(silo -> {
            silo.setName(newSilo.getName());
            silo.setMaxCapacity(newSilo.getMaxCapacity());
            silo.setCerealsAmount(newSilo.getCerealsAmount());
            silo.setChangeStoredAmount(newSilo.getChangeStoredAmount());
            silo.setSensor(newSilo.getSensor());
            silo.setStore(newSilo.getStore());
            return siloRepository.save(silo);
        }).orElseGet(() -> {
            return siloRepository.save(newSilo);
        });
    }
}
