package com.example.demo.ui.controller;

import com.example.demo.io.entity.ChangeStoredAmount;
import com.example.demo.io.entity.Silo;
import com.example.demo.service.SiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/silo")
public class SiloController {

    private final SiloService siloService;

    @Autowired
    public SiloController(SiloService siloService) {
        this.siloService = siloService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Silo> getSilos() {
        return siloService.getSilos();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Silo getSiloById(@PathVariable Long id) {
        return siloService.getSiloById(id);
    }

    @GetMapping(path = "/{id}/cereals-amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getSiloCerealsAmount(@PathVariable Long id) {
        return siloService.getSiloCerealsAmount(id);
    }

    @PostMapping(path = "/{id}/add-cereals", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addCerealsAmount(int addedCerealsAmount, @PathVariable Long id) {
        siloService.addCerealsAmount(addedCerealsAmount, id);
    }

    @PostMapping(path = "/{id}/reduce-cereals", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void reduceCerealsAmount(int reducedCerealsAmount, @PathVariable Long id) {
        siloService.reduceCerealsAmount(reducedCerealsAmount, id);
    }

    @GetMapping(path = "/{id}/changes-count", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ChangeStoredAmount> getChangesByCount(int count, @PathVariable Long id) {
        return siloService.getChangesByCount(count, id);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Silo insertSilo(@RequestBody Silo silo) {
        return siloService.insertSilo(silo);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSiloById(@PathVariable Long id) {
        siloService.deleteSiloById(id);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Silo updateSilo(@RequestBody Silo newSilo, @PathVariable Long id) {
        return siloService.updateSilo(newSilo, id);
    }
}
