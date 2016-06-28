package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rajat on 6/27/16.
 */
public class WordDistance {

    private Map<String, List<Integer>> indexMap;

    public WordDistance(String[] words) {
        indexMap = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            List<Integer> list;
            if (indexMap.containsKey(word)) {
                list = indexMap.get(word);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            indexMap.put(word, list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = indexMap.get(word1);
        List<Integer> list2 = indexMap.get(word2);
        int i = 0, j = 0, min = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            min = Math.min(min, Math.abs(index1 - index2));
            if (index1 < index2) i++;
            else j++;
        }
        return min;
    }
}
