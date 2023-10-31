package codingPatterns;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        generateSubsetsRecursive(nums, 0, currentSubset, subsets);
        return subsets;
    }

    private void generateSubsetsRecursive(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> subsets) {
        // Base case: Add the current subset to the result
        subsets.add(new ArrayList<>(currentSubset));

        // Explore possibilities for the remaining elements
        for (int i = index; i < nums.length; i++) {
            // Include the current element in the current subset
            currentSubset.add(nums[i]);

            // Recurse to explore subsets with the current element
            generateSubsetsRecursive(nums, i + 1, currentSubset, subsets);

            // Exclude the current element from the current subset
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsetsGenerator = new Subsets();
        int[] nums = {1, 2, 3};

        List<List<Integer>> allSubsets = subsetsGenerator.generateSubsets(nums);

        System.out.println("All Subsets:");
        for (List<Integer> subset : allSubsets) {
            System.out.println(subset);
        }
    }
}
