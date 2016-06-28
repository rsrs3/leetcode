package string;

/**
 * Created by rajat on 6/27/16.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        int first = 0, last = s.length() - 1;

        while (first < last) {
            char f = s.charAt(first);
            char l = s.charAt(last);
            if (Character.isLetterOrDigit(f) && Character.isLetterOrDigit(l)) {
                if (Character.toLowerCase(f) != Character.toLowerCase(l)) return false;
                first++;
                last--;
            } else if (Character.isLetterOrDigit(f)) {
                last--;
            } else if (Character.isLetterOrDigit(l)) {
                first++;
            } else {
                first++;
                last--;
            }
        }
        return true;
    }
}
