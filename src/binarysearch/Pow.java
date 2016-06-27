package binarysearch;

/**
 * Created by rajat on 6/23/16.
 */
public class Pow {

    public double myPow(double x, int n) {
        boolean neg = n < 0 ? true : false;
        if (neg) {
            n = -n;
        }
        double result = powHelper(x, n);
        if (neg) result = 1 / result;
        return result;
    }

    private double powHelper(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        double ans = powHelper(x, n / 2);
        if (n % 2 == 0) {
            ans *= ans;
        } else {
            ans *= (ans * x);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2, -2147483648));
    }
}
