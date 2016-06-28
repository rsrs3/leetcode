package string;

/**
 * Created by rajat on 6/27/16.
 */
public class Atoi {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        int sign = 1, sum = 0, i = 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            if (str.charAt(i) == '-') sign = -1;
            i++;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (sum > Integer.MAX_VALUE / 10 || sum == Integer.MAX_VALUE / 10 && str.charAt(i) > '7') {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }

            sum = (sum * 10) + str.charAt(i++) - '0';
        }

        return sum * sign;
    }
}
