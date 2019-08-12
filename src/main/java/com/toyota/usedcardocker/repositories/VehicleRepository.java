package com.toyota.usedcardocker.repositories;

import com.toyota.usedcardocker.entities.Vehicle;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface VehicleRepository extends CrudRepository<Vehicle,String> {
    Vehicle findAllByVin(String vin);
}
