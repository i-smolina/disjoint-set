package com.example.lng.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<String> readFile(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            String str;
            while ((str = reader.readLine()) != null) {
                lines.add(str);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return lines;
    }
}
