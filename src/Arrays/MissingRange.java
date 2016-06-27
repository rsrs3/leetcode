package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajat on 6/26/16.
 */
public class MissingRange {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            list.add(rangeString(lower, upper));
            return list;
        }
        if (lower < nums[0]) list.add(rangeString(lower, nums[0] - 1));
        for (int i = 0; i < nums.length; ++i) {
            int j = i + 1;
            while (j < nums.length && (nums[j] == nums[j - 1] || nums[j] == nums[j - 1] + 1)) j++;
            if (j < nums.length) list.add(rangeString(nums[j - 1] + 1, nums[j] - 1));
            i = j - 1;
        }

        if (upper > nums[nums.length - 1]) list.add(rangeString(nums[nums.length - 1] + 1,
                upper));
        return list;
    }

    private String rangeString(int lower, int upper) {
        StringBuilder sb = new StringBuilder();
        sb.append(lower);
        if (lower != upper) sb.append("->").append(upper);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] result = {0, 1, 3, 50, 75};
        MissingRange ms = new MissingRange();
        System.out.println(ms.findMissingRanges(result, 0, 99));
    }


}
