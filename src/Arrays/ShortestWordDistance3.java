package Arrays;

/**
 * Created by rajat on 6/27/16.
 */
public class ShortestWordDistance3 {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int i = -1, j = -1, min = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);
        for (int l = 0; l < words.length; ++l) {
            if (words[l].equals(word1)) {
                if (same) {
                    i = j;
                    j = l;
                } else {
                    i = l;
                }
            } else if (words[l].equals(word2)) {
                j = l;
            }
            if (i != -1 && j != -1) min = Math.min(min, Math.abs(i - j));
        }
        return min;
    }
}
