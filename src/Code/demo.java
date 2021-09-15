package Code;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author demonwangyu_i
 * @creator 2021/1/11 下午10:06
 */
public class demo {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] ans = new int[]{1, 2, 2};
        subsetsWithDup(ans);
        System.out.println(res);

    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        track(list, nums, 0);
        return res;
    }
    private static void track(List<Integer> list , int[] nums, int index) {
        if(index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        track(list, nums, index + 1);
        list.remove(list.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        track(list, nums, index + 1);
    }
}