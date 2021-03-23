package Code.笔试题;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            int s = help(num);
            nums[i] = s;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int rs = 0;
        for (int i = 0; i < n / 2; i++) {
            rs = nums[i] + rs;
        }
        System.out.println(rs);
    }
    //返回最小奖券数
    private static int help(int x) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= Math.sqrt(x) + 1; i++) {
            int abs = Math.abs(x - i * i);
            min = Math.min(min, abs);
        }
        return min;
    }
}
