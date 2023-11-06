package com.example.lng.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class TestMatrix2x2 {
    DisjointSetBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new DisjointSetBuilder();
    }

    @Test
    void build_ok_1() {
        List<String> lines = List.of("1; 2", "1; 2");
        assertEquals(1, builder.buildGroups(lines).size());
    }

    @Test
    void build_ok_2() {
        List<String> lines = List.of("1; 2", "2; 2");
        assertEquals(1, builder.buildGroups(lines).size());
    }

    @Test
    void build_identical() {
        List<String> lines = List.of("1; 1", "1; 1");
        assertEquals(1, builder.buildGroups(lines).size());
    }

    @Test
    void build_no_matches() {
        List<String> lines = List.of("1; 2", "2; 1");
        assertEquals(2, builder.buildGroups(lines).size());
    }
}