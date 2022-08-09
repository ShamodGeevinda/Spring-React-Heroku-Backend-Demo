package com.example.demo1.controller;

import com.example.demo1.dto.UserDTO;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUser(){

        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public UserDTO getUserByID(@PathVariable String id){

        return userService.getUserbyID(id);
    }

    @GetMapping("/getUserByIDAndName/{id}/{name}")
    public UserDTO getUserByIDAndName(@PathVariable String id,@PathVariable String name){

        return userService.getUserbyIDAndName(id, name);
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);

    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){

        return userService.deleteUser(userDTO);
    }
}
