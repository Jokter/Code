package Code.背包问题;

public class 子集背包问题 {

    public static void main(String[] args) {
        int[] ans = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(ans));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int veg = sum / 2;
        return knapsack(nums.length, veg, nums);
    }

    public static boolean knapsack(int count, int capacity, int[] nums) {
        //建立dp数组
        boolean[][] dp = new boolean[count + 1][capacity + 1];
        //设置base
        for (int i = 0; i <= count; i++) {
            dp[i][0] = true;
        }
        //遍历
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[count][capacity];
    }

}
