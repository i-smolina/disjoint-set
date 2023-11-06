package com.example.lng.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMatrix3x3WithNull {
    DisjointSetBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new DisjointSetBuilder();
    }


    @Test
    void build_with_null_1() {
        List<String> lines = List.of(
                "\"\"; 1; 1",
                "2; 2; 2",
                "3; 3; 3");
        assertEquals(3, builder.buildGroups(lines).size());
    }

    @Test
    void build_with_null_2() {
        List<String> lines = List.of(
                "\"\"; 1; 1",
                "\"\"; 2; 2",
                "3; 3; 3");
        assertEquals(3, builder.buildGroups(lines).size());
    }

    @Test
    void build_with_null_3() {
        List<String> lines = List.of(
                "1; \"\"; 1",
                "2; \"\"; 2",
                "3; 3; 3");
        assertEquals(3, builder.buildGroups(lines).size());
    }

    @Test
    void build_with_null_4() {
        List<String> lines = List.of(
                "1; \"\"; 1",
                "1; \"\"; 2",
                "3; 3; 3");
        assertEquals(2, builder.buildGroups(lines).size());
    }

    @Test
    void build_with_null_5() {
        List<String> lines = List.of(
                "1; \"\"; 1",
                "\"\"; 1; 2",
                "3; 3; 3");
        assertEquals(3, builder.buildGroups(lines).size());
    }


    @Test
    void build_with_null_7() {
        List<String> lines = List.of(
                "1; \"\"; 1",
                "\"\"; 1; 2",
                "3; 3; \"\"");
        assertEquals(3, builder.buildGroups(lines).size());
    }

    @Test
    void build_with_null_8() {
        List<String> lines = List.of(
                "1; \"\"; 1",
                "1; \"\"; 1",
                "3; \"\"; 1");
        assertEquals(1, builder.buildGroups(lines).size());
    }
}
