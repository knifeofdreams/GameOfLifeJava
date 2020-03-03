package io.github.knifeofdreams.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistogramTest {
    @Test
    public void test1() {
        Histogram kata = new Histogram(List.of(2, 1, 5, 6, 2, 3));
        assertEquals(10, kata.sizeOfLargestRectangle());
    }

    @Test
    public void test2() {
        Histogram kata = new Histogram(List.of(1, 0, 2, 1, 2));
        assertEquals(3, kata.sizeOfLargestRectangle());
    }

    @Test
    public void test3() {
        Histogram kata = new Histogram(List.of(1, 3, 2, 1, 2));
        assertEquals(5, kata.sizeOfLargestRectangle());
    }

}
