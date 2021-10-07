/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EmployeeService;

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
 * @author Kokila
 */

@CrossOrigin
@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;

//  @GetMapping(path = "/employees")
//    public List<Employee> getemployees(@RequestParam String name) {
//        if (name == null || name.isEmpty()) {
//            return null;
//        }
//        return employeeRepository.findByName(name);
//    }
    
   
      @GetMapping("/employees")
  List<Employee> all() {
    return employeeRepository.findAll();
  }
    
    

      @PostMapping(path = "/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    
     @PutMapping(path = "/employees")
    public HashMap<String, String> updateEmployee(@RequestBody Employee employee) {
       Employee updatedEmp;
       updatedEmp =  employeeRepository.save(employee); 
       
       if(updatedEmp != null){
           
           HashMap<String, String> map;
             map = new HashMap<>();
        
        map.put("message", "Update Successfully ");
        map.put("status", "true");
        map.put("error", "no");
       return map;
       }
       else{ HashMap<String, String> map;
             map = new HashMap<>();
        
        map.put("message", "Update Failed ");
        map.put("status", "false");
        map.put("error", "yes");
       return map;}
        
    }
    
    
    @GetMapping(path = "/employees/{id}")
    public List<Employee> getEmployee(@PathVariable Integer id) {
        return employeeRepository.findByEmployeeId(id);
    }
    
    String Email;
    String status;
    Employee emp;
    
    String feedBack [];
    
    
    @PostMapping(path = "/login")
    public HashMap<String, String> loginEmployee(@RequestParam("email") String email,@RequestParam("password") String password){
    
         System.out.println(email);
         System.out.println(password);
        
        emp = employeeRepository.loginEmployee(email, password);
        
        System.out.println(emp.getAddress());
        
    if(  emp.getEmail() == null ? email == null : emp.getEmail().equals(email)){
        
        status =  "success";
        
        HashMap<String, String> map;
             map = new HashMap<>();
        
        map.put("message", "successfully ");
        map.put("status", "true");
        map.put("error", "no");
        map.put("id",String.valueOf(emp.getId()));
        map.put("email", emp.getEmail());
        map.put("age", emp.getAge());
        map.put("skills", emp.getSkills());
        map.put("phone", emp.getPhone());
        map.put("profession", emp.getProfession());
        map.put("qualifications", emp.getQualifications());        
        map.put("address", emp.getAddress());
        map.put("name", emp.getName());
        map.put("password", emp.getPassword());
        
        
        System.out.println(map);
        
    return map;
    }
    
    else{
       
            HashMap<String, String> map;
            map = new HashMap<>();
        
        map.put("message", "login Fail.");
        map.put("status", "false");
        map.put("error", "no");
        
       status = "login fail";
     return map;
    }
   }
 }
    
    
   
     
     
  
    
//     @DeleteMapping("/employees/{id}")
//  void deleteEmployee(@PathVariable Long id) {
//    employeeRepository.deleteById(id);
//  }
    
  
  

