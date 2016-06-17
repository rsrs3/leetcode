package DynamicProgramming;

/**
 * Created by rajat on 6/17/16.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxEndingHere = 0, maxEndingSoFar = Integer.MIN_VALUE;
        for (int num : nums) {
            if (maxEndingHere > 0) {
                maxEndingHere += num;
            } else {
                maxEndingHere = num;
            }
            if (maxEndingSoFar < maxEndingHere) maxEndingSoFar = maxEndingHere;
        }
        return maxEndingSoFar;
    }
}
