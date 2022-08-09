package com.example.demo1.service;

import com.example.demo1.dto.UserDTO;
import com.example.demo1.entity.User;
import com.example.demo1.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser (UserDTO userDTO){
    userRepo.save(modelMapper.map(userDTO, User.class));
    return userDTO;
    }

    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return  true;
    }

    public UserDTO getUserbyID (String id){
        User user = userRepo.getUserByID(id);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO getUserbyIDAndName (String id, String name){
        User user = userRepo.getUserByIDAndName(id, name);
        return modelMapper.map(user, UserDTO.class);
    }


}
