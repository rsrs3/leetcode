package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rajat on 6/27/16.
 */
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String word : strs) {
            sb.append(word.length()).append(":").append(word);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            int pos = s.indexOf(":", index);
            int len = Integer.parseInt(s.substring(index, pos));
            result.add(s.substring(pos + 1, pos + 1 + len));
            index = pos + len + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"63/Rc", "h", "BmI3FS~J9#vmk", "7uBZ?7*/", "24h+X", "O "};
        List<String> words = Arrays.asList(strs);
        Codec cd = new Codec();
        String encdoed = cd.encode(words);
        System.out.println(encdoed);
        System.out.println(cd.decode(encdoed));
    }
}
