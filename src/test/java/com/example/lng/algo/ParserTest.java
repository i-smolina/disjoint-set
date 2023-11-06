package com.example.lng.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void isIncorrect() {
        assertTrue(Parser.isIncorrect("\"8383\"200000741652251\""));
    }

    @Test
    void isIncorrect2() {
        assertTrue(Parser.isIncorrect("\"79855053897\"83100000580443402\";\"200000133000191\""));
    }

    @Test
    void isIncorrect3() {
        assertFalse(Parser.isIncorrect("\"79483313540\";\"79876715080\";\"\";\"79046210236\""));
    }
}