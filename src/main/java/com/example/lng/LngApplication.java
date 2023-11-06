package com.example.lng;

import com.example.lng.algo.DisjointSetBuilder;
import com.example.lng.algo.Parser;
import com.example.lng.file.FileReader;
import com.example.lng.file.FileWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@SpringBootApplication
public class LngApplication {

    public static void main(String[] args) {

        SpringApplication.run(LngApplication.class, args);

        Instant start = Instant.now();

        if (args.length < 1) {
            System.out.println("Please enter filename:");
            return;
        }
        String filename = args[0];

        FileReader reader = new FileReader();
        List<String> lines = reader.readFile(filename);

        DisjointSetBuilder builder = new DisjointSetBuilder();
        List<String> result = builder.build(lines);

        FileWriter writer = new FileWriter();
        writer.writeFile(Path.of(filename).getParent() + "/output.txt", result, builder.getGroupsCount());

        Instant end = Instant.now();
        System.out.println("Duration:" + Duration.between(start, end).getSeconds() + " seconds");
    }
}
