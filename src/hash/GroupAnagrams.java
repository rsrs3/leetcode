package hash;

import java.util.*;

/**
 * Created by rajat on 6/23/16.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        Arrays.stream(strs).forEach(str -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> list;
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(key, list);
        });

        List<List<String>> result = new ArrayList<>();
        map.values().forEach(list -> result.add(list));
        return result;
    }
}
