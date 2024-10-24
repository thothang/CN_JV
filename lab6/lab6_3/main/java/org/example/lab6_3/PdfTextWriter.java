package org.example.lab6_3;

import org.springframework.stereotype.Component;

@Component
public class PdfTextWriter implements TextWriter {
    @Override
    public void write(String fileName, String text) {
        System.out.println("PDF text would be written to " + fileName + ".pdf (simulated)");
    }
}
