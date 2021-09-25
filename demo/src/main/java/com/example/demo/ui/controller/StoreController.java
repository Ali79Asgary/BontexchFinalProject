package com.example.demo.ui.controller;

import com.example.demo.io.entity.Store;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/store")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Store> getStores() {
        return storeService.getStores();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Store getStoreById(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @GetMapping(path = "/{id}/cereals-amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getStoreCerealsAmount(@PathVariable Long id) {
        return storeService.getStoreCerealsAmount(id);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Store insertStore(@RequestBody Store store) {
        return storeService.insertStore(store);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStoreById(@PathVariable Long id) {
        storeService.deleteStoreById(id);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Store updateStore(@RequestBody Store newStore, @PathVariable Long id) {
        return storeService.updateStore(newStore, id);
    }
}
