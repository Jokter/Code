package Code.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集 {
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 1, 2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        if(nums.length<1){
            return res;
        }
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(),nums,0);
        return res;
    }

    private static void helper(List<Integer> cur,int[] nums,int index){
        if(nums.length==index){
            res.add(new ArrayList(cur));
            return;
        }
        cur.add(nums[index]);
        helper(cur, nums, index+1);
        cur.remove(cur.size() - 1);
        while(index + 1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }
        helper(cur, nums, index+1);
    }
}
