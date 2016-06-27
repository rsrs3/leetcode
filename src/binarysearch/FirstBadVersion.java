package binarysearch;

/**
 * Created by rajat on 6/23/16.
 */
public abstract class FirstBadVersion {

    public abstract boolean isBadVersion(int i);

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

}
