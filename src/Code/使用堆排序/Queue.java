package Code.使用堆排序;

import java.util.PriorityQueue;

public class Queue {
    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] minQueue=minSlidingWindow(nums);
        System.out.println("小顶堆");
        for(int i=0;i<minQueue.length;i++){
            System.out.print(minQueue[i]+"  ");
        }
    }

    public static int[] minSlidingWindow(int[] nums) {
        if(nums == null || nums.length==0)

        if (nums == null || nums.length == 0){
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            res[i]= queue.poll();
        }
        return res;
    }
}
