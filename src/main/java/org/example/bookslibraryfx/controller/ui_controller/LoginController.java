package org.example.bookslibraryfx.controller.ui_controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.bookslibraryfx.config.SpringFxmlLoaderConfig;
import org.example.bookslibraryfx.model.User;
import org.example.bookslibraryfx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    SpringFxmlLoaderConfig springFXMLLoader;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please fill in all fields");
            errorLabel.setVisible(true);
            return;
        }

        User user = userService.getUserByUsername(username);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            errorLabel.setText("Invalid username or password");
            errorLabel.setVisible(true);
        } else {
            errorLabel.setVisible(false);
            System.out.println("Login successful");
            // TODO: Redirect to the home page or dashboard
        }
    }

    @FXML
    private void handleRegister() {
        try {
            FXMLLoader fxmlLoader = springFXMLLoader.load("/ui_templates/Register.fxml");
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
