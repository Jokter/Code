package Code.排序;

import java.util.PriorityQueue;

/**
 * @author wangyu
 * @created 2020/12/15 11:34 上午
 */
public class 查找数组中第几大的数 {

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 9, 7, 2, 6, 8, 4};
        System.out.println(findKthLargest(arr, 4));
    }

    public static int findKthLargest(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;
        while(true){
            int mid = sort(arr,low,high);
            if(mid>arr.length-k){
                high = mid - 1;
            }else if(mid<arr.length-k){
                low = mid + 1;
            }else{
                return arr[mid];
            }
        }
    }

    private static int sort(int[] arr,int low,int high){
        int temp = arr[low];
        while(low<high){
            while(low<high&&arr[high]>=temp){
                high--;
            }
            arr[low] = arr[high];
            while(low<high&&arr[low]<=temp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}
