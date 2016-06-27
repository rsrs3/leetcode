package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by rajat on 6/19/16.
 */
public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        permuteUtil(nums, new HashSet<>(), new int[nums.length], 0, result);
        return result;
    }

    private void permuteUtil(int[] nums, Set<Integer> used, int[] partial,
                             int pos, List<List<Integer>> result) {
        if (pos == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : partial) list.add(num);
            result.add(list);
        }

        for (int num : nums) {
            if (!used.contains(num)) {
                partial[pos] = num;
                used.add(num);
                permuteUtil(nums, used, partial, pos + 1, result);
                used.remove(num);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        System.out.println(new Permutation().permute(input));
    }
}
