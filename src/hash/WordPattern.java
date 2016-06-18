package hash;

import java.util.HashMap;

/**
 * Created by rajat on 6/18/16.
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0)
            return false;
        HashMap<Character, String> patternHash = new HashMap<>();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); ++i) {
            char c = pattern.charAt(i);
            if (patternHash.containsKey(c) && !patternHash.get(c).equals(words[i]))
                return false;
            else if (!patternHash.containsKey(c) && patternHash.values().contains(words[i])) return false;
            else patternHash.put(c, words[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog dog dog dog"));
    }
}
