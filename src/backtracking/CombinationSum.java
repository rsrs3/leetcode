package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajat on 6/18/16.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        combinationUtil(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void combinationUtil(int[] candidate, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0 && current.size() > 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidate.length; ++i) {
            current.add(candidate[i]);
            combinationUtil(candidate, target - candidate[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidate = {2, 3, 6, 7};
        System.out.println(new CombinationSum().combinationSum(candidate, 7));
    }
}
