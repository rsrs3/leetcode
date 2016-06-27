package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rajat on 6/19/16.
 */
public class GreyCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        if (n == 0) {
            result.add(0);
            return result;
        }

        int inc = 1 << (n - 1);
        List<Integer> prev = grayCode(n - 1);
        for (int num : prev) {
            result.add(result.size() / 2, num);
            result.add(1 + result.size() / 2, num + inc);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GreyCode().grayCode(2));
    }
}
