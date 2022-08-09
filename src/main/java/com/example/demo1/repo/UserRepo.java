package com.example.demo1.repo;

import com.example.demo1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository <User, Integer>{

    @Query(value = "SELECT * FROM user WHERE id = ?1", nativeQuery = true)
    User getUserByID (String id);

    @Query(value = "SELECT * FROM user WHERE id = ?1 AND name = ?2", nativeQuery = true)
    User getUserByIDAndName (String id, String name);

    // Update query

//    @Modifying
//    @Query(value = "SELECT * FROM user WHERE id = ?1 AND name = ?2", nativeQuery = true)
//    User getUserByIDAndName (String id, String name);





}
