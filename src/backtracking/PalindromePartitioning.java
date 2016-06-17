package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajat on 6/17/16.
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) return result;
        if (s.length() == 1) {
            List<String> list = new ArrayList<>();
            list.add(s);
            result.add(list);
            return result;
        }
        for (int i = 0; i < s.length(); ++i) {
            String before = s.substring(0, i + 1);
            if (isPalindrome(before)) {
                if (i == s.length() - 1) {
                    List<String> list = new ArrayList<>();
                    list.add(before);
                    result.add(list);
                } else {
                    List<List<String>> bList = partition(s.substring(i + 1));
                    for (List<String> l : bList) {
                        l.add(0, before);
                        result.add(l);
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
