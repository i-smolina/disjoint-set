package com.example.lng.algo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String REGEX_LONG = "\\d+";
    private static final String REGEX_INCORRECT = "\\d+\"\\d+";

    public static boolean isIncorrect(String line) {
        Pattern pattern = Pattern.compile(REGEX_INCORRECT);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    public static long[] parse(String s) {
        Pattern pattern = Pattern.compile(REGEX_LONG);
        String[] values = s.split(";");
        long[] res = new long[values.length];
        for (int i = 0; i < values.length; i++) {
            if (isIncorrect(values[i])) {
                System.out.println("incorrect line: " + values[i]);
                continue;
            }
            Matcher matcher = pattern.matcher(values[i]);
            if (matcher.find()) {
                res[i] = Long.parseLong(values[i].substring(matcher.start(), matcher.end()));
            } else res[i] = Long.MIN_VALUE;
        }
        return res;
    }
}
