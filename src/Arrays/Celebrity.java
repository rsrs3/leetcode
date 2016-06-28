package Arrays;

/**
 * Created by rajat on 6/27/16.
 */
public class Celebrity {

    public int findCelebrity(int n) {
        int left = 0, right = n - 1;
        while (left < right) {
            if (knows(left, right)) left++;
            else right--;
        }

        int candidate = right;
        for (int i = 0; i < n; ++i) {
            if (candidate != i && (!knows(i, candidate) || knows(candidate, i))) {
                candidate = -1;
                break;
            }
        }
        return candidate;
    }

    public boolean knows(int x, int y) {
        return x < y;
    }
}
