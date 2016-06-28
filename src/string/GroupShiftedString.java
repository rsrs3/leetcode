package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rajat on 6/27/16.
 */
public class GroupShiftedString {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        if (strings == null || strings.length == 0) return result;
        Map<String, List<String>> map = new HashMap<>();
        for (String value : strings) {
            String key = hash(value);
            List<String> list;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(value);
            map.put(key, list);
        }

        for (List<String> list : map.values()) {
            result.add(list);
        }

        return result;
    }

    private String hash(String value) {
        StringBuilder sb = new StringBuilder();
        char first = value.charAt(0);
        for (int i = 0; i < value.length(); ++i) {
            int diff = value.charAt(i) - first;
            if (diff < 0) diff += 26;
            sb.append(diff).append(",");
        }
        return sb.toString();
    }
}
