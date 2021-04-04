package Code.排序;

import java.util.Arrays;
import java.util.PriorityQueue;
//两个重要步骤：建堆（上浮/下沉）+排序
public class 堆排序 {
    public static void main(String[] args) {
        int[] ans = new int[]{5, 1, 3, 9, 7, 2, 6, 8, 4};
        System.out.println(Arrays.toString(sortArray(ans)));
    }

    //大根堆
    public static int[] sortArray(int[] ans) {
        int len = ans.length;
        //二倍交换，所以索引+1
        int[] res = new int[len + 1];

        for (int i = 0; i < ans.length; i++) {
            res[i+1] = ans[i];
        }
        //下沉建堆
        for (int i = len/2; i >= 1; i--) {
            sink(res, i, len);
        }

        int k = len;
        //排序
        while (k > 1) {
            swap(res, 1, k--);
            sink(res, 1, k);
        }
        for (int i = 1; i < len + 1; i++) {
            ans[i-1] = res[i];
        }
        return ans;
    }

    public static void sink (int[] ans, int k, int end) {
        //下沉
        while (2 * k <= end) {
            int j = 2 * k;
            //找出子节点中最大或最小的那个
            if (j + 1 <= end && ans[j + 1] > ans[j]) {
                j++;
            }
            //交换操作，父节点下沉，与最大的孩子节点交换
            if (ans[j] > ans[k]) {
                swap(ans, j, k);
            } else {
                break;
            }
            //继续下沉
            k = j;
        }
    }

    public static void swap (int[] ans, int i, int j) {
        int temp = ans[i];
        ans[i] = ans[j];
        ans[j] = temp;
    }

}
