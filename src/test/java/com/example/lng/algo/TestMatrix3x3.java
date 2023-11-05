package com.example.lng.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMatrix3x3 {
    @Test
    void build_ok_1() {
        long[][] matrix = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        assertEquals(1, LinkList.build(matrix));
    }

    @Test
    void build_ok_2() {
        long[][] matrix = {{1, 3, 1}, {2, 3, 2}, {3, 1, 3}};
        assertEquals(2, LinkList.build(matrix));
    }

    @Test
    void build_ok_3() {
        long[][] matrix = {{1, 3, 1}, {3, 1, 3}, {2, 3, 2}};
        assertEquals(2, LinkList.build(matrix));
    }

    @Test
    void build_ok_4() {
        long[][] matrix = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        assertEquals(3, LinkList.build(matrix));
    }

}
