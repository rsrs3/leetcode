package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajat on 6/27/16.
 */
public class FlipGame {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
                char[] temp = s.toCharArray();
                temp[i - 1] = '-';
                temp[i] = '-';
                result.add(String.valueOf(temp));
            }
        }
        return result;
    }
}
