package Code.字符串;

import java.util.Scanner;

public class 最长公共子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = "";
        String str2 = "";
        while(sc.hasNext()){
            str1 = sc.next();
            str2 = sc.next();
            System.out.println(getCommonStrLength(str1, str2));
        }
    }

    public static int getCommonStrLength(String str1, String str2){

        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);    //区别在这儿
                }
            }
        }
        return dp[len1][len2];
    }
}
