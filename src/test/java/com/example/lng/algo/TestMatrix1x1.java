package com.example.lng.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMatrix1x1 {
    DisjointSetBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new DisjointSetBuilder();
    }

    @Test
    void build_ok_1() {
        List<String> lines = List.of("1");
        assertEquals(1, builder.buildGroups(lines).size());
    }
}
