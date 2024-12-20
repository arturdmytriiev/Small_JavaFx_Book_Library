package org.example.bookslibraryfx.service;

import lombok.Data;
import org.example.bookslibraryfx.controller.data_controller.UserController;
import org.example.bookslibraryfx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {
    @Autowired
    private UserController userController;

    public User saveUser(User user) {
        return userController.addUser(user);
    }

    public User getUserByUsername(String username) {
        return userController.getUserByUsername(username);
    }
}
