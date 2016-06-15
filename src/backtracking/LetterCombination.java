package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajat on 6/15/16.
 */
public class LetterCombination {

    public static final String[] MAPPING = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] partial = new char[digits.length()];
        if (digits == null || digits.length() == 0) return result;
        letterCombinationUtil(digits, partial, 0, result);
        return result;
    }

    public void letterCombinationUtil(String digits, char[] partial, int i, List<String> result) {
        if (i == digits.length()) {
            result.add(String.valueOf(partial));
        } else {
            int x = Character.getNumericValue(digits.charAt(i));
            String lookup = MAPPING[x];
            for (int j = 0; j < lookup.length(); j++) {
                partial[i] = lookup.charAt(j);
                letterCombinationUtil(digits, partial, i + 1, result);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombination l = new LetterCombination();
        System.out.println(l.letterCombinations("23"));
    }
}
