package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rajat on 6/23/16.
 */
public class LongestSubstringWithoutRepetition {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c) && map.get(c) >= start) {
                if (max < end - start) max = end - start;
                start = map.get(c) + 1;
            }
            map.put(c, end);
            end++;
        }

        if (max < end - start) max = end - start;
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepetition l = new LongestSubstringWithoutRepetition();
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }
}
