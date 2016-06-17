package dfs;

import java.util.List;

/**
 * Created by rajat on 6/16/16.
 */
public class NestedListSum {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSumUtil(nestedList, 1);
    }

    private int depthSumUtil(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) sum += n.getInteger() * depth;
            else sum += depthSumUtil(n.getList(), depth + 1);
        }
        return sum;
    }
}
