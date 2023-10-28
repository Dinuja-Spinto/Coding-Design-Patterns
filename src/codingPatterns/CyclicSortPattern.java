package codingPatterns;

public class CyclicSortPattern {
    public void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                // Swap the element to its correct position
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        CyclicSortPattern cyclicSortPattern = new CyclicSortPattern();
        int[] nums = {3, 1, 5, 2, 4};

        cyclicSortPattern.cyclicSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
