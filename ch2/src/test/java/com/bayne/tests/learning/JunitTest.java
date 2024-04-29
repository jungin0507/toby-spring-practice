package com.bayne.tests.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JunitTest {

    int foo = 0;

    @Test
    void test1() {
        ++foo;
        assertEquals(1, foo);
    }

    @Test
    void test2() {
        ++foo;
        assertEquals(1, foo);
    }

    @Test
    void test3() {
        ++foo;
        assertEquals(1, foo);
    }
}
