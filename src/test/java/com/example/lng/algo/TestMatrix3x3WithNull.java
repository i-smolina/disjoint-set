package com.example.lng.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMatrix3x3WithNull {

    @Test
    void build_with_null_1() {
        long[][] matrix = {
                {Long.MIN_VALUE, 1, 1},
                {2, 2, 2},
                {3, 3, 3}};
        assertEquals(3, LinkList.build(matrix));
    }

    @Test
    void build_with_null_2() {
        long[][] matrix = {
                {Long.MIN_VALUE, 1, 1},
                {Long.MIN_VALUE, 2, 2},
                {3, 3, 3}};
        assertEquals(3, LinkList.build(matrix));
    }

    @Test
    void build_with_null_3() {
        long[][] matrix = {
                {1, Long.MIN_VALUE, 1},
                {2, Long.MIN_VALUE, 2},
                {3, 3, 3}};
        assertEquals(3, LinkList.build(matrix));
    }

    @Test
    void build_with_null_4() {
        long[][] matrix = {
                {1, Long.MIN_VALUE, 1},
                {1, Long.MIN_VALUE, 2},
                {3, 3, 3}};
        assertEquals(2, LinkList.build(matrix));
    }

    @Test
    void build_with_null_5() {
        long[][] matrix = {
                {1, Long.MIN_VALUE, 1},
                {Long.MIN_VALUE, 1, 2},
                {3, 3, 3}};
        assertEquals(3, LinkList.build(matrix));
    }

    @Test
    void build_with_null_6() {
        long[][] matrix = {
                {1, Long.MIN_VALUE, 1},
                {Long.MIN_VALUE, 1, 2},
                {3, 3, 3}};
        assertEquals(3, LinkList.build(matrix));
    }

    @Test
    void build_with_null_7() {
        long[][] matrix = {
                {1, Long.MIN_VALUE, 1},
                {Long.MIN_VALUE, 1, 2},
                {3, 3, Long.MIN_VALUE}};
        assertEquals(3, LinkList.build(matrix));
    }

    @Test
    void build_with_null_8() {
        long[][] matrix = {
                {1, Long.MIN_VALUE, 1},
                {1, Long.MIN_VALUE, 1},
                {3, Long.MIN_VALUE, 1}};
        assertEquals(1, LinkList.build(matrix));
    }
}
