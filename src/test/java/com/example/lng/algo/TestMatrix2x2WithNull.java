package com.example.lng.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMatrix2x2WithNull {
    @Test
    void build_null_no_matches() {
        long[][] matrix = {{Long.MIN_VALUE, 2}, {2, 1}};
        assertEquals(2, LinkList.build(matrix));
    }

    @Test
    void build_null_ok() {
        long[][] matrix = {{Long.MIN_VALUE, 2}, {2, 2}};
        assertEquals(1, LinkList.build(matrix));
    }

    @Test
    void build_null_x2_ok() {
        long[][] matrix = {{Long.MIN_VALUE, 2}, {Long.MIN_VALUE, 2}};
        assertEquals(1, LinkList.build(matrix));
    }

    @Test
    void build_null_x2_no_matches() {
        long[][] matrix = {{Long.MIN_VALUE, 1}, {Long.MIN_VALUE, 2}};
        assertEquals(2, LinkList.build(matrix));
    }
}
