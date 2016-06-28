package string;

import java.util.Stack;

/**
 * Created by rajat on 6/27/16.
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') stack.push(c);

            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char f = stack.pop();
                if (c == ')' && f != '(') return false;
                else if (c == '}' && f != '{') return false;
                else if (c == ']' && f != '[') return false;
            }
        }
        if (!stack.empty()) return false;
        return true;
    }
}
