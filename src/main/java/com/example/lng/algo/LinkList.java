package com.example.lng.algo;

import java.util.*;

public class LinkList {
    public List<long[]> list = new ArrayList<>();
    public long[][] matrix;

    public void add(String[] values) {
        long[] arr = new long[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i].isEmpty())
                arr[i] = Long.MIN_VALUE;
            else arr[i] = Long.parseLong(values[i]);
        }
        list.add(arr);
    }

    public void createMatrix(int n) {
        matrix = new long[list.size()][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                matrix[i][j] = list.get(i)[j];
            }
        }
    }

    public static int build(long[][] matrix) {
        Integer[] index = new Integer[matrix.length];
        for (int i = 0; i < index.length; i++)
            index[i] = i;
        for (int j = 0; j < matrix[0].length; j++) {
            Map<Long, Integer> set = new HashMap<>();
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == Long.MIN_VALUE) {
                    continue;
                }
                if (!set.containsKey(matrix[i][j])) {
                    set.put(matrix[i][j], index[i]);
                } else {
                    index[i] = set.get(matrix[i][j]);
                }
            }
            System.out.println(getSet(index).size());
        }
        return getSet(index).size();
    }

    public static Set<Integer> getSet(Integer[] arr) {
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, arr);
        set.remove(Long.MIN_VALUE);
        return set;
    }

}
