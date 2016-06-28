package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rajat on 6/27/16.
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        char[] value = s.toCharArray();
        Set<Character> vowelSet = getVowelSet();

        int first = 0, last = value.length - 1;
        while (first < last) {
            if (vowelSet.contains(value[first]) && vowelSet.contains(value[last])) {
                char temp = value[first];
                value[first] = value[last];
                value[last] = temp;
                first++;
                last--;
            } else if (vowelSet.contains(value[first])) {
                last--;
            } else if (vowelSet.contains(value[last])) {
                first++;
            } else {
                first++;
                last--;
            }

        }
        return String.valueOf(value);
    }

    private Set<Character> getVowelSet() {
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');
        return vowelSet;
    }
}
