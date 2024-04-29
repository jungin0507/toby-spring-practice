package com.bayne.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    Calculator calculator;

    String filePath;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        filePath = getClass().getResource("/numbers.txt")
                .getPath();
    }

    @Test
    void sum_of_numbers() throws IOException {
        assertEquals(10, calculator.sum(filePath));
    }

    @Test
    void multiply_of_numbers() throws IOException {
        assertEquals(24, calculator.multiply(filePath));
    }

    @Test
    void concatenate_of_numbers() throws IOException {
        assertEquals("1234", calculator.concatenate(filePath));
    }
}
