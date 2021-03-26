package Code.背包问题;
//给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。
//其中第i个物品的重量为wt[i]，价值为val[i]，
//现在让你用这个背包装物品，最多能装的价值是多少？
public class 背包问题 {
    public static void main(String[] args) {
        int knapsack = knapsack(4, 3, new int[]{2, 1, 3}, new int[]{4, 2, 3});
        System.out.println(knapsack);
    }

    //0-1背包问题
    public static int knapsack(int w, int n, int[] wt, int[] val) {
        //建立dp二维数组
        int[][] dp = new int[n + 1][w + 1];
        //确认base，由于任一为0，价值均为0，所以不用专门设置base
        //遍历
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < wt[i - 1]) {
                    //装不下
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //装得下,装入或不装入择优
                    int x = dp[i-1][j]; //不装入物品的最大价值
                    int y = dp[i-1][j-wt[i-1]] + val[i-1];  //减去当前重量装入的最大价值 + 当前物品的最大价值
                    dp[i][j] = Math.max(x, y);
                }
            }
        }
        return dp[n][w];
    }



}
