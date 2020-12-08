package JavaText.双向队列;

import java.util.LinkedList;

public class Queue {
    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] minQueue=maxSlidingWindow(nums,3);
        for(int i=0;i<minQueue.length;i++){
            System.out.print(minQueue[i]+"  ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //0、判断异常条件
        if(nums.length == 0 || k <1 || nums.length < k){
            return new int[0];
        }
        //1、创建linklist，为了可以获取首尾元素，内部存放的是元素的索引
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        //2、创建res，用来返回res结果
        int[] res = new int[nums.length-k+1];
        int index = 0;//标志着res对应位置的索引
        for(int i = 0; i < nums.length; i++){
            //3、判断LinkList是否为空，并且将要入元素是否大于末尾元素，确保首位元素最大
            while(!qmax.isEmpty() && nums[i] >= nums[qmax.peekLast()]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            //4、判断首位元素是否从窗口划出
            if(qmax.peekFirst() == (i-k)){
                qmax.pollFirst();
            }
            //5、判断窗口是否成立，若成立则将首位索引对应的元素入res
            if(i >= (k-1)){
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        //6、返回res
        return res;
    }
}
