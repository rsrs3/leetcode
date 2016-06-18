package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajat on 6/18/16.
 */
public class FactorCombination {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 3) return result;
        factorsUtil(n, 2, result, new ArrayList<>());
        return result;
    }

    private void factorsUtil(int n, int start, List<List<Integer>> result, List<Integer> curr) {
        if (n == 1 && curr.size() > 1) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                curr.add(i);
                factorsUtil(n / i, i, result, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }


}
