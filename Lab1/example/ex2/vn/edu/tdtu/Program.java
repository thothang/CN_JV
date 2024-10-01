package org.example.ex2.vn.edu.tdtu;

import vn.edu.tdtu.ArrayHandler;
import vn.edu.tdtu.ArrayOutput;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        int[] a = {5, 1, 9, 4};
        int[] b = {3, 7, 2, 8};

        System.out.println("Array a:");
        ArrayOutput.print(a);
        System.out.println("Array b:");
        ArrayOutput.print(b);

        int[] c = ArrayHandler.merge(a, b);
        System.out.println("Array c (after merging):");
        ArrayOutput.print(c);

        ArrayHandler.sort(c);
        System.out.println("Array c (after sorting):");
        ArrayOutput.print(c);

        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int num : c) {
                writer.write(num + " ");
            }
            System.out.println("Array c has been written to output.txt.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}

