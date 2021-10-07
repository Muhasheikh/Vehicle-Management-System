/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EmployeeService;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kokila
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
     
    @Query("select e from Employee e where e.id = ?1")
    List<Employee> findByEmployeeId(Integer id);
    
     @Query("select e from Employee e where e.name=  ?1")
    List<Employee> findByName(String name);
    
    
    @Query("delete from Employee e where e.id = ?1")
    void deleteUsersByFirstName(String email, String pass);
   
   
   @Query("SELECT e FROM Employee e WHERE e.email = ?1 AND e.password = ?2")
    Employee loginEmployee(String email, String password);
    
    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    char getUser(String param);
}
