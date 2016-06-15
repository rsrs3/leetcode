package DynamicProgramming;

/**
 * Created by rajat on 5/16/16.
 */
public class Stocks {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0, minPrice = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > minPrice) {
                int val = prices[i] - minPrice;
                if (val > profit) profit = val;
            } else {
                minPrice = prices[i];
            }
        }
        return profit;
    }
}
