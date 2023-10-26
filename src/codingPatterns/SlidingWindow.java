package codingPatterns;

public class SlidingWindow {

    public static void main(String[] args){
        int[] numbers = { 2,4,7,5,6,76,9,6,5,22 };
        System.out.println(maxSubarraySum(numbers, 4));
    }

    //Use sliding window coding pattern to find max subArray sum
    public static int maxSubarraySum(int[] nums, int k) {
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        maxSum = currentSum;

        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

}
