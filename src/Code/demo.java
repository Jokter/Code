package Code;
import java.util.Arrays;

/**
 * @author demonwangyu_i
 * @creator 2021/1/11 下午10:06
 */
public class demo {
    public static void main(String[] args) {
        int[] ans = new int[]{5, 1, 3, 9, 7, 2, 6, 8, 4};
        System.out.println(Arrays.toString(sortArray(ans)));
    }

    public static int[] sortArray(int[] ans) {
        //创建+1数组
        int len = ans.length;
        int[] res = new int[len + 1];

        for (int i = 0; i < len; i++) {
            res[i + 1] = ans[i];
        }

        //构建堆
        for (int i = len/2; i >= 1; i--) {
            sink(res, i, len);
        }

        //排序
        int k = len;
        while (k > 1) {
            swap(res, 1, k--);
            sink(res, 1, k);
        }

        //返回
        for (int i = 0; i < len; i++) {
            ans[i] = res[i + 1];
        }
        return ans;
    }

    private static void sink(int[] ans, int k, int end) {
        while (2 * k <= end) {
            int j = 2 * k;
            if (j + 1 <= end && ans[j] < ans[j+1]) {
                j++;
            }
            if (ans[k] < ans[j]) {
                swap(ans, k, j);
            } else {
                break;
            }
            k = j;
        }
    }

    private static void swap(int[] ans, int i, int j) {
        int temp = ans[i];
        ans[i] = ans[j];
        ans[j] = temp;
    }



}