package Code.排序;

import java.util.PriorityQueue;

public class 无序数组的中位数 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 7, 2, 6, 8, 4};
//        PriorityQueue<Integer> queue = new PriorityQueue<>((n1,n2)->n2-n1);
//        queue.add(2);
//        queue.add(1);
//        queue.add(3);
//        queue.poll();
//        queue.poll();
        System.out.println(median(arr));
    }
    private static double median(int[] array){
        int heapSize = array.length/2+1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<heapSize;i++){
            queue.offer(array[i]);
        }
        for(int i = heapSize;i<array.length;i++){
            queue.offer(array[i]);
            queue.poll();
        }
        if(array.length%2==0){
            return (double)(queue.poll()+queue.poll())/2.0;
        }else{
            return (double)queue.poll();
        }
    }
}