package Arrays;

/**
 * Created by rajat on 6/27/16.
 */
public class ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        int first = -words.length, second = words.length;
        int min = words.length;
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) first = i;
            if (words[i].equals(word2)) second = i;
            min = Math.min(min, Math.abs(first - second));
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = {"b", "c", "a", "a", "b"};
        ShortestWordDistance wd = new ShortestWordDistance();
        System.out.println(wd.shortestDistance(words, "a", "b"));
    }
}
