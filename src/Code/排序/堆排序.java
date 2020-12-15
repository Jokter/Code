package Code.排序;

import java.util.PriorityQueue;

public class 堆排序 {
    public static void main(String[] args) {
        int[] nums = {2,1,4,3};
        int[] bigNums = 小根堆(nums);
        for(int num : bigNums){
            System.out.println(num);
        }
    }

    private static int[] 小根堆(int[] nums){
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1,n2) -> n2 - n1);
        for(int num : nums){
            queue.add(num);
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = queue.poll();
        }
        return nums;
    }

    private static int[] 大根堆(int[] nums){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.add(num);
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = queue.poll();
        }
        return nums;
    }
}
