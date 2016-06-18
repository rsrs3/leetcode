package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajat on 6/18/16.
 */
public class GenaralizedAbbreviation {

    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        for (int i=0;i<=word.length();++i){
            abbreviationsUtil(word, i, 0, result);
        }
        return result;
    }

    private void abbreviationsUtil(String word, int val, int start, List<String> res){
        if(val==0) {
            res.add(word);
            return;
        }
        for(int i=1;i<=val;++i) {
            if (start + i < word.length()) {
                String abr = word.substring(start) + i +word.substring(start + i, word.length());
                abbreviationsUtil(abr, val-i, start+i, res);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenaralizedAbbreviation().generateAbbreviations("word"));
    }
}
