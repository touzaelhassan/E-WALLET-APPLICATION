package com.application.controllers;

import com.application.entities.User;
import com.application.services.specifications.UserServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserServiceSpecification userServiceBean;

    @Autowired
    public UserController(UserServiceSpecification userServiceBean) {
        this.userServiceBean = userServiceBean;
    }

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user){ return userServiceBean.addUser(user); }

    @PutMapping("/user/update/{id}")
    public void updateUser(@PathVariable("id") Integer id, @RequestParam(required = false) String name, @RequestParam(required = false) String email){ userServiceBean.updateUser(id, name, email); }

    @GetMapping("/user/{id}")
    public User updateUser(@PathVariable("id") Integer id){
       return userServiceBean.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getUsers(){ return userServiceBean.getUsers(); }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userServiceBean.deleteUser(id);
    }

}
