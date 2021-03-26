package Code.背包问题;
//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。
//假设每一种面额的硬币有无限个
public class 完全背包问题 {

    public static void main(String[] args) {
        int[] ans = new int[]{1, 2, 5};
        System.out.println(change(5, ans));
    }

    public static int change(int amount, int[] coins) {
        int count  = coins.length;
        return knapsack(count, amount, coins);
    }

    public static int knapsack(int count, int capacity, int[] coins) {
        //定义dp
        int[][] dp = new int[count + 1][capacity + 1];
        //设置base
        for (int i = 0; i <= count; i++) {
            dp[i][0] = 1;
        }
        //遍历
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[count][capacity];
    }


}