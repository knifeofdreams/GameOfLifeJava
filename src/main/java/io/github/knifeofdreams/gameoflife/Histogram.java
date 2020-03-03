package io.github.knifeofdreams.gameoflife;

import java.util.List;
import java.util.Stack;

import static java.lang.Math.max;

public class Histogram {

    public int largestRectangle(List<Integer> histogram) {
        Stack<Integer> positions = new Stack();
        Stack<Integer> heights = new Stack();
        int maxSize = 0;

        for (int i = 0; i < histogram.size(); i++) {
            if (heights.empty() || histogram.get(i) > heights.peek()) {
                positions.push(i);
                heights.push(histogram.get(i));
            } else {
                maxSize = max(heights.pop() * (i - positions.peek()), maxSize);

                if (!heights.empty() && histogram.get(i) <= heights.peek()) {
                    positions.pop();
                } else {
                    heights.push(histogram.get(i));
                }
            }
            System.out.println("lofasz");
        }

        while (!heights.empty()) {
            maxSize = max(heights.pop() * (histogram.size() - positions.pop()), maxSize);
        }

        return maxSize;
    }
}
