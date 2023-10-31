package codingPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KWayMerge {
    public static List<Integer> kWayMerge(List<List<Integer>> lists) {
        List<Integer> merged = new ArrayList<>();
        if (lists == null || lists.isEmpty()) {
            return merged;
        }

        // Create a min-heap to store the smallest elements.
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        // Initialize the min-heap with the first element from each list.
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            if (!list.isEmpty()) {
                minHeap.offer(new Element(i, 0, list.get(0)));
            }
        }

        // Merge elements.
        while (!minHeap.isEmpty()) {
            Element element = minHeap.poll();
            merged.add(element.value);

            // If there are more elements in the same list, add the next element.
            if (element.index + 1 < lists.get(element.listIndex).size()) {
                int nextIndex = element.index + 1;
                int nextValue = lists.get(element.listIndex).get(nextIndex);
                minHeap.offer(new Element(element.listIndex, nextIndex, nextValue));
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        List<List<Integer>> sortedLists = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(4);
        nums.add(6);
        nums.add(8);

        List<Integer> nums2 = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(7);

        List<Integer> nums3 = new ArrayList<>();
        nums.add(0);
        nums.add(9);
        nums.add(10);
        nums.add(11);

        sortedLists.add(nums);
        sortedLists.add(nums2);
        sortedLists.add(nums3);

        List<Integer> merged = kWayMerge(sortedLists);

        System.out.println("Merged List: " + merged);
    }
}

class Element {
    int listIndex;
    int index;
    int value;

    public Element(int listIndex, int index, int value) {
        this.listIndex = listIndex;
        this.index = index;
        this.value = value;
    }
}
