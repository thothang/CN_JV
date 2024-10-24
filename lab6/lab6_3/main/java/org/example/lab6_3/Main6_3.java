package org.example.lab6_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main6_3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TextEditor textEditor = context.getBean(TextEditor.class);

        textEditor.input("This is some sample text.");
        textEditor.save("outputFile");

    }
}

