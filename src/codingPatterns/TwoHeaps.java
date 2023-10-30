package codingPatterns;

import java.util.PriorityQueue;

public class TwoHeaps {
    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public TwoHeaps() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max Heap for smaller half
        minHeap = new PriorityQueue<>(); // Min Heap for larger half
    }

    public void addNumber(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        TwoHeaps twoHeaps = new TwoHeaps();
        twoHeaps.addNumber(1);
        twoHeaps.addNumber(3);
        twoHeaps.addNumber(2);
        twoHeaps.addNumber(4);
        twoHeaps.addNumber(5);

        System.out.println("Median: " + twoHeaps.findMedian()); // Output: 3.0
    }
}
