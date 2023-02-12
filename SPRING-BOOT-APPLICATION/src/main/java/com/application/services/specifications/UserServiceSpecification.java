package com.application.services.specifications;

import com.application.entities.User;
import java.util.List;

public interface UserServiceSpecification {
    User addUser(User user);
    void updateUser(Integer id, String name, String email);
    User getUserByEmail(String email);
    User getUserById(Integer id);
    List<User> getUsers();
    void deleteUser(Integer id);
}
