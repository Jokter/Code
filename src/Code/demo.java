package Code;

import Code.domain.ListNode;

import java.util.*;

/**
 * @author demonwangyu_i
 * @creator 2021/1/11 下午10:06
 */
public class demo {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindow(nums, 3));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - 2];
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            while (!list.isEmpty() && temp >= nums[list.peekLast()]) {
                list.removeLast();
            }
            list.addLast(i);
            if (i - k >= list.peekFirst()) {
                list.removeFirst();
            }
            if (i - k + 1 >= 0) {
                ans[index++] = nums[list.peekFirst()];
            }
        }
        return ans;
    }
}