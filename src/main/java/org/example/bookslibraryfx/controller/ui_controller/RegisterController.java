package org.example.bookslibraryfx.controller.ui_controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.bookslibraryfx.config.SecurityConfig;
import org.example.bookslibraryfx.config.SpringFxmlLoaderConfig;
import org.example.bookslibraryfx.model.Role;
import org.example.bookslibraryfx.model.User;
import org.example.bookslibraryfx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Component
public class RegisterController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label errorLabel;

    @Autowired
    private UserService userService;

    @Autowired
    private SpringFxmlLoaderConfig springFXMLLoader;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @FXML
    private void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            errorLabel.setText("All fields are required.");
            errorLabel.setVisible(true);
        } else if (!password.equals(confirmPassword)) {
            errorLabel.setText("Passwords do not match.");
            errorLabel.setVisible(true);
        }
        User user = userService.getUserByUsername(username);
        if(user != null) {
          errorLabel.setText("Username is already taken.");
          errorLabel.setVisible(true);
        } else {
            errorLabel.setVisible(false);
            System.out.println("Registration successful for user: " + username);
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(passwordEncoder.encode(password));
            newUser.setRole(new Role(2, "USER"));
            userService.saveUser(newUser);
            handleBackToLogin();
        }
    }

    @FXML
    private void handleBackToLogin() {
        try {
            FXMLLoader loader = springFXMLLoader.load("/ui_templates/Main.fxml");
            Parent root = loader.load();
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load login screen.");
        }
    }
}
