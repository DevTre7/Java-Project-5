import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class missingNumber {
    public static int missingNumber(int[] nums, int maxNum) {

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= maxNum; i += 1) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    public static int missingNumberSort(int[] nums, int maxNum) {
        Arrays.sort(nums);

        for (int i = 1; i < maxNum; i += 1) {
            if (i != nums[i - 1]) {
                return i;
            }
        }

        // If none is missing
        if (nums.length == maxNum && nums[maxNum - 1] == maxNum) {
            return 0;
        }

        return maxNum;
    }

    public static int missingNumberSum(int[] nums, int maxNum) {
        // Alternate solution: int sum = (nums.length + 1)*(nums.length) / 2
        int expectedSum = 0;
        for (int i = 1; i <= maxNum; i += 1) {
            expectedSum += i;
        }

        int actualSum = Arrays.stream(nums).sum();

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] missingNone = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] missingSeven = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };

        System.out.println("Missing Max:" + missingNumber(missingMax, 10));
        System.out.println("Missing None:" + missingNumber(missingNone, 10));
        System.out.println("Missing Seven:" + missingNumber(missingSeven, 10));
        System.out.println("Missing Max:" + missingNumberSort(missingMax, 10));
        System.out.println("Missing None:" + missingNumberSort(missingNone, 10));
        System.out.println("Missing Seven:" + missingNumberSort(missingSeven, 10));
        System.out.println("Missing Max:" + missingNumberSum(missingMax, 10));
        System.out.println("Missing None:" + missingNumberSum(missingNone, 10));
        System.out.println("Missing Seven:" + missingNumberSum(missingSeven, 10));

    }
}
