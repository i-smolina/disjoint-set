package com.example.lng.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMatrix1x1 {
    @Test
    void build_ok_1() {
        long[][] matrix = {{1}};
        assertEquals(1, LinkList.build(matrix));
    }
}
