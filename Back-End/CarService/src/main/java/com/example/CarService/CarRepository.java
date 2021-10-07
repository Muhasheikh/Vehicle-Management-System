/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.CarService;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lahiru Yapa
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
    
    @Query("select c from Car c where c.userReferenceId = ?1")
    List<Car> findByUserReferenceId(String userReferenceId);
    
//    @Query("select c from Car c where c.model = ?1")
//    List<Car> findByModel(String model);
    
//    @Query("select c from Car c where c.dailyRental = ?1")
//    List<Car> findByRental(String dailyRental);
    
//    @Query("select c from Car c where c.model = ?1 and c.dailyRental = ?2")
//    List<Car> findByModelAndRental(String model, String dailyRental);
    
}
