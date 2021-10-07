/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.CarService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lahiru Yapa
 */

@CrossOrigin
@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    
//    @GetMapping(path = "/cars")
//    public List<Car> getCars(@RequestParam String dailyRental) {
////        if (dailyRental == null || dailyRental.isEmpty()) {
////            return null;
////        }
//        return carRepository.findByRental(dailyRental);
//    }

      @GetMapping("/cars")
  List<Car> all() {
    return carRepository.findAll();
  }
    
      
    @GetMapping(path = "/cars/{userReferenceId}")
    public List<Car> getCar(@PathVariable String userReferenceId) {
        return carRepository.findByUserReferenceId(userReferenceId);
    }

    @PostMapping(path = "/cars")
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @PutMapping(path = "/cars")
    public Car updateCar(@RequestBody Car car) {
        return carRepository.save(car);
    }
    
    @DeleteMapping(path = "/cars/{id}")
  public HashMap<String, String> deleteTutorial(@PathVariable Integer id) {
      
      if(id == null){
          
         System.out.println("Error");
            HashMap<String, String> map2;
            map2 = new HashMap<>();
        
        map2.put("message", "Delete Fail");
        map2.put("status", "false");
        map2.put("error", "yes");
        
        return map2;
          
      }
      else{
           carRepository.deleteById(id);
              HashMap<String, String> map;
            map = new HashMap<>();
        
        map.put("message", "Delete Successful");
        map.put("status", "true");
        map.put("error", "no");
        
        return map;
          
          }
      }  

}
