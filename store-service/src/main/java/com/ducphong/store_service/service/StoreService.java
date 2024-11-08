package com.ducphong.store_service.service;

import com.ducphong.store_service.model.Store;
import com.ducphong.store_service.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public ResponseEntity<?> createStore(Store store){
        try{
            return new ResponseEntity<Store>(storeRepository.save(store), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchStoreById(String id){
        Optional<Store> store = storeRepository.findById(id);
        if(store.isPresent()){
            return new ResponseEntity<>(store, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Store Found!!!",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchStores(){
        List<Store> stores = storeRepository.findAll();
        if(!stores.isEmpty()){
            return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Stores",HttpStatus.NOT_FOUND);
        }
    }
}
