package com.example.lng.algo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String REGEX_DOUBLE = "\\d+\\.*\\d*";
    private static final String REGEX_INCORRECT = "\\d+\"\\d+";

    public static boolean isIncorrect(String line) {
        Pattern pattern = Pattern.compile(REGEX_INCORRECT);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    public static double[] parse(String s) {
        Pattern pattern = Pattern.compile(REGEX_DOUBLE);
        String[] values = s.split(";");
        double[] res = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            if (isIncorrect(values[i])) {
                System.out.println("incorrect line: " + values[i]);
                continue;
            }
            Matcher matcher = pattern.matcher(values[i]);
            if (matcher.find()) {
                res[i] = Double.parseDouble(values[i].substring(matcher.start(), matcher.end()));
            } else res[i] = Double.MIN_VALUE;
        }
        return res;
    }
}
