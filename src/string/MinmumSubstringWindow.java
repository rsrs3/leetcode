package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rajat on 6/27/16.
 */
public class MinmumSubstringWindow {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || s.length() < t.length()) return "";

        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, found = 0, min = Integer.MAX_VALUE;
        String minWindow = "";

        Map<Character, Integer> visited = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (hash.containsKey(c)) {
                if (visited.containsKey(c)) {
                    if (hash.get(c) > visited.get(c)) found++;
                    visited.put(c, visited.get(c) + 1);
                } else {
                    visited.put(c, 1);
                    found++;
                }
            }

            if (found == t.length()) {
                char sc = s.charAt(left);
                while (!visited.containsKey(sc) || visited.get(sc) > hash.get(sc)) {
                    if (visited.containsKey(sc) && visited.get(sc) > hash.get(sc)) {
                        visited.put(sc, visited.get(sc) - 1);
                    }
                    left++;
                    sc = s.charAt(left);
                }

                if (right - left + 1 < min) {
                    min = right - left + 1;
                    minWindow = s.substring(left, right + 1);
                }
            }
            right++;
        }

        return minWindow;
    }
}
