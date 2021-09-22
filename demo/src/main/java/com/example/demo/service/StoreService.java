package com.example.demo.service;

import com.example.demo.io.dao.StoreRepository;
import com.example.demo.io.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(@PathVariable Long id) {
        return storeRepository.getById(id);
    }

    public int getStoreCerealsAmount(@PathVariable Long id) {
        int result = 0;
        for (int i = 0; i < storeRepository.getById(id).getSiloList().size(); i++) {
            result += storeRepository.getById(id).getSiloList().get(i).getCerealsAmount();
        }
        return result;
    }

    public Store insertStore(@RequestBody Store store) {
        return storeRepository.save(store);
    }

    public void deleteStoreById(@PathVariable Long id) {
        storeRepository.deleteById(id);
    }

    public Store updateStore(@RequestBody Store newStore, @PathVariable Long id) {
        return storeRepository.findById(id).map(store -> {
            store.setComplexName(newStore.getComplexName());
            store.setSiloList(newStore.getSiloList());
            return storeRepository.save(store);
        }).orElseGet(() -> {
            return storeRepository.save(newStore);
        });
    }
}
