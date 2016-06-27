package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajat on 6/26/16.
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        if (nums.length == 1) list.add(String.valueOf(nums[0]));
        else {
            int start = nums[0], last = nums[0];
            for (int i = 1; i <= nums.length; ++i) {
                if (i < nums.length && (nums[i] == last || nums[i] == last + 1)) {
                    last = nums[i];
                } else {
                    StringBuilder result = new StringBuilder();
                    if (start == last) result.append(start);
                    else result.append(start).append("->").append(last);
                    if (i < nums.length) start = last = nums[i];
                    list.add(result.toString());
                }
            }
        }
        return list;
    }
}
