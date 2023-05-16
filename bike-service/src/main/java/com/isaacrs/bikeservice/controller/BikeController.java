package com.isaacrs.bikeservice.controller;

import com.isaacrs.bikeservice.entity.Bike;
import com.isaacrs.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAll(){
        List<Bike> bikes = bikeService.getAll();
        if(bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getById(@PathVariable("id") int id){
        Bike bike = bikeService.getUserById(id);
        if(bike== null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bike);
    }

    @PostMapping
    public ResponseEntity<Bike> save(@RequestBody Bike bike){
        Bike bikeNew = bikeService.save(bike);
        return ResponseEntity.ok(bikeNew);
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<Bike>> getByUserId(@PathVariable("userId") int userId){
        List<Bike> bikes = bikeService.byUserId(userId);
        return ResponseEntity.ok(bikes);
    }
}
