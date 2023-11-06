package com.example.lng.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMatrix3x3 {
    DisjointSetBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new DisjointSetBuilder();
    }

    @Test
    void build_ok_1() {
        List<String> lines = List.of("1; 2; 3", "1; 2; 3", "1; 2; 3");
        assertEquals(1, builder.buildGroups(lines).size());
    }

    @Test
    void build_ok_2() {
        List<String> lines = List.of("1; 3; 1", "2; 3; 2", "3; 1; 3");
        assertEquals(2, builder.buildGroups(lines).size());
    }

    @Test
    void build_ok_3() {
        List<String> lines = List.of("1; 3; 1", "3; 1; 3", "2; 3; 2");
        assertEquals(2, builder.buildGroups(lines).size());
    }

    @Test
    void build_ok_4() {
        List<String> lines = List.of("1; 1; 1", "2; 2; 2", "3; 3; 3");
        assertEquals(3, builder.buildGroups(lines).size());
    }

}
