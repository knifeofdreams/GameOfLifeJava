package io.github.knifeofdreams.gameoflife;

import java.util.List;
import java.util.Stack;

import static java.lang.Math.max;

public class Histogram {

    private Stack<Integer> positions = new Stack();
    private Stack<Integer> heights = new Stack();
    private List<Integer> histogram;
    private int maxSize = 0;

    public Histogram(List<Integer> histogram) {
        this.histogram = histogram;
    }

    public int sizeOfLargestRectangle() {
        for (int i = 0; i < histogram.size(); i++) {
            if (isHigherThanPeek(i)) {
                pushToStack(histogram.get(i), i);
            } else {
                calculateSizesSinceLastShorterBar(i);
            }
        }
        checkForLargerSizeInStack();

        return maxSize;
    }

    private void calculateSizesSinceLastShorterBar(int i) {
        int lastPosition = i;
        while (isLowerOrEqualToPeek(i)) {
            lastPosition = positions.pop();
            maxSize = calculateMaxSize(i, lastPosition);
        }
        pushToStack(histogram.get(i), lastPosition);
    }

    private void checkForLargerSizeInStack() {
        while (!heights.empty()) {
            maxSize = calculateMaxSize(histogram.size(), positions.pop());
        }
    }

    private int calculateMaxSize(int i, int lastPosition) {
        return max(heights.pop() * (i - lastPosition), maxSize);
    }

    private boolean isLowerOrEqualToPeek(int i) {
        return !heights.empty() && histogram.get(i) <= heights.peek();
    }

    private void pushToStack(Integer height, int position) {
        heights.push(height);
        positions.push(position);
    }

    private boolean isHigherThanPeek(int i) {
        return heights.empty() || histogram.get(i) > heights.peek();
    }
}
