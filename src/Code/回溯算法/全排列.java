package Code.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列 {
    static List<List<Integer>> res;

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        ArrayList<Integer> cur = new ArrayList<>();
        boolean[] booleans = new boolean[nums.length];
        track(cur, nums, booleans);
        return res;
    }

    public static void track(ArrayList<Integer> cur, int[] nums, boolean[] booleans) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (booleans[i]) {
                continue;
            }
            if (i > 0 && !booleans[i-1] && nums[i] == nums[i-1]) {
                continue;
            }
            cur.add(nums[i]);
            booleans[i] = true;
            track(cur, nums, booleans);
            booleans[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
