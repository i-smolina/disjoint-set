package com.example.lng.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMatrix2x2WithNull {
    DisjointSetBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new DisjointSetBuilder();
    }

    @Test
    void build_null_no_matches() {
        List<String> lines = List.of("\"\"; 2", "2; 1");
        assertEquals(2, builder.buildGroups(lines).size());
    }

    @Test
    void build_null_ok() {
        List<String> lines = List.of("\"\"; 2", "2; 2");
        assertEquals(1, builder.buildGroups(lines).size());
    }

    @Test
    void build_null_x2_ok() {
        List<String> lines = List.of("\"\"; 2", "\"\"; 2");
        assertEquals(1, builder.buildGroups(lines).size());
    }

    @Test
    void build_null_x2_no_matches() {
        List<String> lines = List.of("\"\"; 1", "\"\"; 2");
        assertEquals(2, builder.buildGroups(lines).size());
    }
}
