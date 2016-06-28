package string;

import java.util.Arrays;

/**
 * Created by rajat on 6/27/16.
 */
public class ReverseString2 {

    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;
        reverseHelper(s, 0, s.length - 1);
        int start = 0, end = 0;
        while (true) {
            if (end >= s.length) break;
            while (end < s.length && s[end] != ' ') end++;
            reverseHelper(s, start, end - 1);
            start = end = end + 1;
        }
    }

    private void reverseHelper(char[] input, int first, int last) {
        int start = first, end = last;
        while (start < end) {
            char t = input[start];
            input[start] = input[end];
            input[end] = t;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] input = "the sky is blue".toCharArray();
        new ReverseString2().reverseWords(input);
        System.out.println(Arrays.toString(input));
    }
}
