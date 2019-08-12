package com.toyota.usedcardocker.controllers;

import com.toyota.usedcardocker.entities.Vehicle;
import com.toyota.usedcardocker.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    private static final String TEST_VIN = "Lol";
    private VehicleRepository vehicleRepository;

    @Autowired
    public DummyController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public String getGreeting(){
        return "Hello there, general Kenobi.";
    }

    @GetMapping("/Vehicle")
    public Vehicle getVehicle(){
        return vehicleRepository.findAllByVin(TEST_VIN);
    }

    @GetMapping("/AddVehicle")
    public void addVehicle(){
        Vehicle entity = new Vehicle();
        entity.setVin(TEST_VIN);
        vehicleRepository.save(entity);
    }

}
