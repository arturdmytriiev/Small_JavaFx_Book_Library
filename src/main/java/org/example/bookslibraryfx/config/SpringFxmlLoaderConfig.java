package org.example.bookslibraryfx.config;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class SpringFxmlLoaderConfig {
    private final ApplicationContext context;

    public SpringFxmlLoaderConfig(ApplicationContext context) {
        this.context = context;
    }

    public FXMLLoader load(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(context::getBean);
        InputStream fxmlStream = getClass().getResourceAsStream(fxmlPath);
        if (fxmlStream != null) {
            loader.setLocation(getClass().getResource(fxmlPath));
        } else {
            throw new RuntimeException("FXML file not found: " + fxmlPath);
        }
        return loader;
    }
}
