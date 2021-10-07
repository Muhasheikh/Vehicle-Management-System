/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PurchaseService;

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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kokila
 */

@CrossOrigin
@RestController
public class PurchaseController {
        @Autowired
    private PurchaseRepository purchaseRepository;


      @GetMapping("/purchases")
  List<Purchase> all() {
    return purchaseRepository.findAll();
  }
  
  @PostMapping(path = "/Purchases")
    public Purchase createPurchase(@RequestBody Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @PutMapping(path = "/Purchases")
    public Purchase updatePurchase(@RequestBody Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
    
    
     @DeleteMapping(path = "/Purchases/{id}")
  public HashMap<String, String> deletePurchase(@PathVariable Integer id) {
      
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
           purchaseRepository.deleteById(id);
              HashMap<String, String> map;
            map = new HashMap<>();
        
        map.put("message", "Delete Successful");
        map.put("status", "true");
        map.put("error", "no");
        
        return map;
          
          }
      }  
}
