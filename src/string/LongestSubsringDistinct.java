package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rajat on 6/27/16.
 */
public class LongestSubsringDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> hash = new HashMap<>();
        int left = 0, max = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            hash.put(c, hash.getOrDefault(c, 0) + 1);
            while (hash.size() > k) {
                char l = s.charAt(left);
                int n = hash.get(l);
                if (n == 1) hash.remove(l);
                else hash.put(l, n - 1);
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
