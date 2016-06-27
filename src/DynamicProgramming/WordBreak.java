package DynamicProgramming;

import java.util.Set;

/**
 * Created by rajat on 6/22/16.
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {

        boolean[][] wordDP = new boolean[s.length()][s.length()];

        for (int l = 1; l <= s.length(); ++l) {
            for (int i = 0; i < s.length() - l + 1; ++i) {
                int j = i + l - 1;
                String word = s.substring(i, j + 1);
                if (wordDict.contains(word)) {
                    wordDP[i][j] = true;
                } else {
                    for (int k = i + 1; k <= j; ++k) {
                        if (wordDP[i][k - 1] && wordDP[k][j]) {
                            wordDP[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return wordDP[0][s.length() - 1];
    }
}
