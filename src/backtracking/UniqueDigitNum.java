package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajat on 6/17/16.
 */
public class UniqueDigitNum {

    public int countNumbersWithUniqueDigits(int n) {
        int result = 0;
        if (n > 10) return result;
        if (n == 0) return 1;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(9 * 9);
        list.add(9 * 9 * 8);
        list.add(9 * 9 * 8 * 7);
        list.add(9 * 9 * 8 * 7 * 6);
        list.add(9 * 9 * 8 * 7 * 6 * 5);
        list.add(9 * 9 * 8 * 7 * 6 * 5 * 4);
        list.add(9 * 9 * 8 * 7 * 6 * 5 * 4 * 3);
        list.add(9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2);
        list.add(9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1);
        for (int i = 1; i <= n; i++) {
            result += list.get(i);
        }
        return result;
    }
}
