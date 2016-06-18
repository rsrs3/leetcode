package DynamicProgramming;

/**
 * Created by rajat on 6/17/16.
 */
public class LIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = dp[0];
        for (int i = 1; i < dp.length; ++i) {
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(new LIS().lengthOfLIS(input));
    }
}
