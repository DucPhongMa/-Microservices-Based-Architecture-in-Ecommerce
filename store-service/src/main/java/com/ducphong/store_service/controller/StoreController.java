package com.ducphong.store_service.controller;

import com.ducphong.store_service.kafka.StoreKafkaProducer;
import com.ducphong.store_service.model.Store;
import com.ducphong.store_service.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {
    @Autowired
    private StoreService storeService;

    @Autowired
    private StoreKafkaProducer storeKafkaProducer;

    @PostMapping("/api/store/request")
    public ResponseEntity<String> requestStoreInfo(@RequestBody Store store){
        storeKafkaProducer.sendMessage(store);
        return ResponseEntity.ok("Json message sent to the kafka topic");
    }

    @GetMapping("/api/store/{id}")
    public ResponseEntity<?> fetchStudents(@PathVariable String id) {
        return storeService.fetchStoreById(id);
    }


    @GetMapping("/api/stores")
    public ResponseEntity<?> fetchStudents() {
        return storeService.fetchStores();
    }
}
