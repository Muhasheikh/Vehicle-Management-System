/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FeedbackService;

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
public class FeedbackController {
         @Autowired
    private FeedbackRepository feedbackRepository;


     @GetMapping("/feedbacks")
    public List<Feedback> GetPatients() {
        return feedbackRepository.findAll();
    }
    
        @GetMapping("/feedbacks/{id}")
    public Feedback GetPatient(@PathVariable Integer id) {
        return feedbackRepository.findById(id).orElse(null);
    }
    
        @PostMapping(path = "/feedbacks")
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @PutMapping(path = "/feedbacks")
    public Feedback updateFeedback(@RequestBody Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
    
      @DeleteMapping(path = "/feedbacks/{id}")
  public HashMap<String, String> deleteFeddback(@PathVariable Integer id) {
      
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
           feedbackRepository.deleteById(id);
              HashMap<String, String> map;
            map = new HashMap<>();
        
        map.put("message", "Delete Successful");
        map.put("status", "true");
        map.put("error", "no");
        
        return map;
          
          }
      }  
    
}
