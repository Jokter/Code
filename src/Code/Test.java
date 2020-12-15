package Code;

import java.util.*;

/**
 * dasfadadsfgadgasdgadg
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        List<int[]> list = helper(nums, 7);
        for(int[] temp : list){
            for(int i=0;i<temp.length;i++){
                System.out.print(temp[i]+ " ");
            }
            System.out.println();
        }
    }
    public static List<int[]> helper(int[] nums,int target) {
        List<int[]> list = new ArrayList<>();
        int cur = 0;
        for(int left = 1,right=1;right<target;right++){
            cur = cur+right;
            while(cur>target){
                cur = cur - left;
                left++;
            }
            if(cur==target){
                int[] temp = new int[right-left+1];
                for(int i = left;i<=right;i++){
                    temp[i-left] = i;
                }
                list.add(temp);
            }
        }
        return list;

    }
}

