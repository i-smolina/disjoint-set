package com.example.lng.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private List<String> list = new ArrayList<>();
    public int maxSize;

    public List<String> readFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        String str;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((str=reader.readLine())!=null) {
                list.add(str);
            }
        }
        catch(IOException e) {

        }
       return list;
    }
}
