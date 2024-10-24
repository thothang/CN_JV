package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppInfo {
    @Value("${app.name}")
    private String name;

    @Value("${app.version}")
    private String version;

    @Value("${app.description}")
    private String description;

    public void printInfo() {
        System.out.println("Application Name: " + name);
        System.out.println("Version: " + version);
        System.out.println("Description: " + description);
    }
}

