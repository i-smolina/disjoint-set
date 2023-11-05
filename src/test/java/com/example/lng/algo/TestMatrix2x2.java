package com.example.lng.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TestMatrix2x2 {
    @Test
    void build_ok_1() {
        long[][] matrix = {{1, 2}, {1, 2}};
        assertEquals(1, LinkList.build(matrix));
    }

    @Test
    void build_ok_2() {
        long[][] matrix = {{1, 2}, {2, 2}};
        assertEquals(1, LinkList.build(matrix));
    }

    @Test
    void build_identical() {
        long[][] matrix = {{1, 1}, {1, 1}};
        assertEquals(1, LinkList.build(matrix));
    }

    @Test
    void build_no_matches() {
        long[][] matrix = {{1, 2}, {2, 1}};
        assertEquals(2, LinkList.build(matrix));
    }
}