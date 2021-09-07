package Code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author demonwangyu_i
 * @creator 2021/1/11 下午10:06
 */
public class demo {

    public static void main(String[] args) {
        int[] ans = new int[]{5, 1, 3, 9, 7, 2, 6, 8, 4};
//        System.out.println(Arrays.toString(sortArray(ans)));
        Random random = new Random();
        System.out.println(random.nextInt(10));
    }

    private static int[] sortArray(int[] ans) {
        //新建替换数组
        int len = ans.length;
        int[] res = new int[len + 1];
        for (int i = 0; i < len; i++) {
            res[i + 1] = ans[i];
        }

        //建堆
        for (int i = len/2; i >= 1; i--) {
            sink(res, i, len);
        }

        //排序
        int k = len;
        while (k > 1) {
            swap(res, 1, k);
            k--;
            sink(res, 1, k);
        }

        //换为原数组
        for (int i = 0; i < len; i++) {
            ans[i] = res[i + 1];
        }
        return ans;
    }

    private static void sink (int[] ans, int k, int end) {
        while (2 * k <= end) {
            //左子节点
            int j = 2 * k;
            //左右节点找大的
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

    private static void swap(int[] ans, int i, int j) {
        int temp = ans[i];
        ans[i] = ans[j];
        ans[j] = temp;
    }
}