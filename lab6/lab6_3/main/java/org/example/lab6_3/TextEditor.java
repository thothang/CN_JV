package org.example.lab6_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {

    private TextWriter textWriter;
    private String inputText;

    @Autowired
    public TextEditor(@Qualifier("pdfTextWriter") TextWriter textWriter) {
        this.textWriter = textWriter;
    }

    public void input(String text) {
        this.inputText = text;
        System.out.println("Text received: " + text);
    }

    public void save(String fileName) {
        textWriter.write(fileName, inputText);
    }
}

