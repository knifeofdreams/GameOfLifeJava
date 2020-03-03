package io.github.knifeofdreams.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistogramTest {
    @Test
    public void test1() {
        final List<Integer> heights = List.of(2, 1, 5, 6, 2, 3);

        Histogram kata = new Histogram();
        assertEquals(10, kata.largestRectangle(heights));
    }

    @Test
    public void test2() {
        final List<Integer> heights = List.of(1, 0, 2, 1, 2);

        Histogram kata = new Histogram();
        assertEquals(3, kata.largestRectangle(heights));
    }

    @Test
    public void test3() {
        final List<Integer> heights = List.of(1, 3, 2, 1, 2);

        Histogram kata = new Histogram();
        assertEquals(5, kata.largestRectangle(heights));
    }

}
