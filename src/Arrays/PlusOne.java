package Arrays;

import java.util.Arrays;

/**
 * Created by rajat on 6/26/16.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;

        int[] result = new int[digits.length];
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; --i) {
            int val, sum;
            if (i == digits.length - 1) {
                sum = 1 + digits[i];
            } else {
                sum = carry + digits[i];
            }
            val = sum % 10;
            carry = sum / 10;
            result[i] = val;
        }

        if (carry != 0) {
            int[] fArray = new int[digits.length + 1];
            fArray[0] = carry;
            for (int i = 0; i < result.length; ++i)
                fArray[i + 1] = result[i];
            result = fArray;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {9, 9};
        System.out.println(Arrays.toString(new PlusOne().plusOne(num)));
    }


}
