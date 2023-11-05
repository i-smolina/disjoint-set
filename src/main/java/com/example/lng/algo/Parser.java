package com.example.lng.algo;

import org.springframework.util.NumberUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public List<String[]> list = new ArrayList<>();
    public List<HashMap<String, String>> map = new LinkedList<>();

    public static boolean isFalse(String line) {
        String wrong = "\\d+\"\\d+";
        Pattern pattern = Pattern.compile(wrong);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    public static String[] parse(String s) {

        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        String[] values = s.split(";");
        for (int i = 0; i < values.length; i++) {
            Matcher matcher = pattern.matcher(values[i]);
            if (matcher.find()) {
                values[i] = values[i].substring(matcher.start(), matcher.end());
            } else values[i] = "";

        }
        return values;
    }
}
