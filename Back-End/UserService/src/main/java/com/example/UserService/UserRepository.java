/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.UserService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lahiru Yapa
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    
    @Query("select u from User u where u.userReferenceId = ?1")
    User findByUserReferenceId(String userReferenceId);
    
}
