package com.example.lng.algo;

import java.util.*;
import java.util.stream.Collectors;

public class DisjointSetBuilder {
    List<String> lines;
    long[][] matrix;
    int[] index;
    Map<Integer, List<Integer>> groups;
    int countGroupsMore1Element;

    public List<String> build(List<String> lines) {
        buildGroups(lines);
        return getLinesForPrint();
    }

    public Map<Integer, List<Integer>> buildGroups(List<String> lines) {
        this.lines = lines;
        convertLinesToMatrix();
        buildIndex();
        convertIndexToGroups(index);
        return groups;
    }

    private List<String> getLinesForPrint() {
        return convertGroupsToLines(getGroupsSizeMoreOne());
    }

    private void convertLinesToMatrix() {
        List<long[]> longList = new ArrayList<>();
        int dimY = 0;
        for (String line : lines) {
            long[] bufArray = Parser.parse(line);
            if (bufArray.length > dimY)
                dimY = bufArray.length;
            longList.add(bufArray);
        }
        matrix = new long[longList.size()][dimY];
        initMatrix(matrix, dimY);

        for (int i = 0; i < longList.size(); i++) {
            System.arraycopy(longList.get(i), 0, matrix[i], 0, longList.get(i).length);
        }
    }

    private void initMatrix(long[][] matrix, int dimY) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < dimY; j++)
                matrix[i][j] = Long.MIN_VALUE;
    }

    private void buildIndex() {
        index = new int[matrix.length];
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
        }
    }

    private List<List<Integer>> getGroupsSizeMoreOne() {
        return groups.values().stream().filter(e -> e.size() > 1).sorted(Comparator.comparing(List::size)).collect(Collectors.toList());
    }

    private List<String> convertGroupsToLines(List<List<Integer>> groups) {
        countGroupsMore1Element = groups.size();
        List<String> list = new ArrayList<>();
        for (int i = groups.size() - 1; i >= 0; i--) {
            list.add("Группа " + (groups.size() - i));
            groups.get(i).forEach(elem -> list.add(lines.get(elem)));
        }
        return list;
    }

    private void convertIndexToGroups(int[] index) {
        groups = new HashMap<>();
        for (int i = 0; i < index.length; i++) {
            if (!groups.containsKey(index[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                groups.put(index[i], list);
            } else {
                groups.get(index[i]).add(i);
            }
        }
    }

    public int getGroupsCount() {
        return countGroupsMore1Element;
    }
}
