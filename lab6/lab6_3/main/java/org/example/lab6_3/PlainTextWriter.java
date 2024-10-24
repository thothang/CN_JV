package org.example.lab6_3;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class PlainTextWriter implements TextWriter {
    @Override
    public void write(String fileName, String text) {
        try (FileWriter writer = new FileWriter(fileName + ".txt")) {
            writer.write(text);
            System.out.println("Văn bản đã được ghi vào " + fileName + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


