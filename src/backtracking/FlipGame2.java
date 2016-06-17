package backtracking;

/**
 * Created by rajat on 6/17/16.
 */
public class FlipGame2 {

    public boolean canWin(String s) {
        char[] input = s.toCharArray();
        return helper(input);
    }

    private boolean helper(char[] input) {
        for (int i = 0; i < input.length - 1; ++i) {
            if (input[i] == '-' || input[i + 1] == '-') continue;
            input[i] = '-';
            input[i + 1] = '-';
            boolean otherWin = helper(input);
            input[i] = '+';
            input[i + 1] = '+';
            if (!otherWin) return true;
        }
        return false;
    }
}
