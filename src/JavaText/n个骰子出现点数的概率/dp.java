package JavaText.n个骰子出现点数的概率;

public class dp {
    public static void main(String[] args) {
        double[] result = twoSum(2);
        double[] result1 = twoSum1(2);
        for (Double d:result) {
            System.out.print(d+"  ");
        }
        System.out.println();
        for (Double d:result1) {
            System.out.print(d+"  ");
        }
    }

    public static double[] twoSum(int n) {
        final int face = 6;
        final int pointNum = face * n;
        final double totalNum = Math.pow(6, n);
        int[][] dp = new int[n + 1][pointNum + 1];

        for (int i = 1; i <= face; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = i; j <= pointNum; j++)     /* 使用 i 个骰子最小点数为 i */
                for (int k = 1; k <= face && k <= j; k++)
                    dp[i][j] += dp[i - 1][j - k];

        double[] res = new double[n * 5 + 1];
        int index = 0;
        for (int i = n; i <= pointNum; i++) {
            res[index++] = dp[n][i] / totalNum;
        }
        return res;
    }


    public static double[] twoSum1(int n) {
        int [][]dp = new int[n+1][6*n+1];
        //边界条件
        for(int s = 1; s <= 6; s++) dp[1][s]=1;
        for(int i=2;i<=n;i++){
            for(int s=i;s<=6*i;s++){
                //求dp[i][s]
                for(int d=1;d<=6;d++){
                    if(s-d<i-1)break;//为0了
                    dp[i][s]+=dp[i-1][s-d];
                }
            }
        }
        double total = Math.pow((double)6,(double)n);
        double[] ans = new double[5*n+1];
        for(int i=n;i<=6*n;i++){
            ans[i-n]=((double)dp[n][i])/total;
        }
        return ans;
    }
}
