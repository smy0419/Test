package newcoder;

public class 买卖股票最佳时机 {
    public static void main(String[] args) {
        int[] prices = {8, 9, 2, 5, 4, 7, 1};
//        int[] prices = {3, 2, 1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minValue = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minValue = Math.min(minValue, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
        }
        return maxProfit;
    }
}
