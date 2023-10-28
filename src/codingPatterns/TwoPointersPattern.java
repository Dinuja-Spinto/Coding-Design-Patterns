package codingPatterns;

public class TwoPointersPattern {
    public int[] findPairWithSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++; // Move the left pointer to the right
            } else {
                right--; // Move the right pointer to the left
            }
        }

        return null; // No pair found
    }

    public static void main(String[] args) {
        TwoPointersPattern twoPointers = new TwoPointersPattern();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] pair = twoPointers.findPairWithSum(nums, target);
        if (pair != null) {
            System.out.println("Pair with sum " + target + ": " + pair[0] + ", " + pair[1]);
        } else {
            System.out.println("No pair found.");
        }
    }
}
