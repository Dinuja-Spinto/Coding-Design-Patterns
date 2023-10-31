package codingPatterns;

import java.util.PriorityQueue;

public class TopKElements {
    public static int[] findTopKLargest(int[] nums, int k) {
        // Create a min-heap with a capacity of K.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Initialize the heap with the first K elements.
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        // Continue processing the remaining elements.
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                // If the current element is larger than the smallest element in the heap,
                // remove the smallest element and add the current element.
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        // Convert the min-heap to an array of top K largest elements.
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 12, 2, 11};
        int k = 3;

        int[] topK = findTopKLargest(nums, k);

        System.out.print("Top " + k + " largest elements: ");
        for (int num : topK) {
            System.out.print(num + " ");
        }
    }
}
