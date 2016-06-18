package DynamicProgramming;

/**
 * Created by rajat on 6/17/16.
 */
public class HouseRobber2 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[1];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robUtil(nums, 0, nums.length - 2), robUtil(nums, 1, nums.length - 1));
    }

    public int robUtil(int[] nums, int low, int high) {
        int pre = 0, curr = 0;
        for (int i = low; i <= high; i++) {
            int next = Math.max(pre + nums[i], curr);
            pre = curr;
            curr = next;
        }
        return curr;
    }
}
