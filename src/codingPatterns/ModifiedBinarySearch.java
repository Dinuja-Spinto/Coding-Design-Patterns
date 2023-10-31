package codingPatterns;

public class ModifiedBinarySearch {
    public static int findFirstOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                // Found a candidate, but we continue searching to the left.
                result = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 2, 3, 3, 3, 4, 4, 5};
        int target = 4;

        int firstOccurrence = findFirstOccurrence(sortedArray, target);

        if (firstOccurrence != -1) {
            System.out.println("First occurrence of " + target + " is at index " + firstOccurrence);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }
}
