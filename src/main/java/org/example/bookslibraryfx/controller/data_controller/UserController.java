package org.example.bookslibraryfx.controller.data_controller;


import org.example.bookslibraryfx.model.User;
import org.example.bookslibraryfx.repository.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User updatedUser = new User();
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(user.getPassword());
        return userRepository.save(updatedUser);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }



}
