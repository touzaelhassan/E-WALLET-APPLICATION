package com.application.services.implementations;

import com.application.entities.User;
import com.application.repositories.UserRepository;
import com.application.services.specifications.UserServiceSpecification;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("userServiceBean")
public class UserServiceImplementation implements UserServiceSpecification {

    private final UserRepository userRepositoryBean;

    @Autowired
    public UserServiceImplementation(UserRepository userRepositoryBean) { this.userRepositoryBean = userRepositoryBean; }

    @Override
    public User addUser(User user) {
        User DBUser =  this.getUserByEmail(user.getEmail());
        if  (DBUser != null){ throw new IllegalStateException("Email already exists !!."); }
        return userRepositoryBean.save(user);
    }
    @Transactional
    @Override
    public void updateUser(Integer id, String name, String email) {
        User userById = userRepositoryBean.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exists"));
        if(name != null && name.length() > 0 && !Objects.equals(userById.getName(), name)){userById.setName(name);}
        if(email != null && email.length() > 0 && !Objects.equals(userById.getEmail(), email)){
            User userByEmail = userRepositoryBean.findUserByEmail(email);
            if(userByEmail != null){ throw new IllegalStateException("Email is already exists !!."); }
            userById.setEmail(email);
        }
    }
    @Override
    public User getUserByEmail(String email) { return userRepositoryBean.findUserByEmail(email); }
    @Override
    public User getUserById(Integer id) { return userRepositoryBean.findById(id).orElse(null); }
    @Override
    public List<User> getUsers() { return userRepositoryBean.findAll(); }
    @Override
    public void deleteUser(Integer id) {
        boolean isUserExists = userRepositoryBean.existsById(id);
        if(!isUserExists){ throw new IllegalStateException("User with Id " + id + " does not exist !!."); }
        userRepositoryBean.deleteById(id);
    }
}
