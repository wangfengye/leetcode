/**
 * 面试题63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 10^5
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int maxId = 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (maxId <= i && i + 1 < prices.length) {
                maxId = i + 1;
                for (int j = i + 2; j < prices.length; j++) {
                    if (prices[j] > prices[maxId]) maxId = j;
                }
            }
            if (maxId > i) {
                max = Math.max(max, prices[maxId] - prices[i]);
            }
        }
        return max;
    }
    public static int maxProfitFun1(int[] prices) {
        if(prices.length==0)return 0;
        int minPrice=prices[0];
        int max=0;
        for (int i = 1; i < prices.length; i++) {
            if(minPrice>prices[i]){
                minPrice=prices[i];
            }else {
                max=Math.max(max,prices[i]-minPrice);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitFun1(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitFun1(new int[]{7, 6, 4, 3, 1}));
    }
}
