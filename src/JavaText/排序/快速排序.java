package JavaText.排序;

public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 9, 7, 2, 6, 8, 4};
        quickSort(arr,0,arr.length-1);
        for (int i:arr) {
            System.out.print(i+" ");
        }
    }
    public static void quickSort(int[] arr,int low,int high){
        if (low < high) {
            int mid = sort(arr, low, high);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }
    }
    public static int sort(int[] arr,int low,int high){
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}


//查找数组中第几大的数
class Solution {
    int p;
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length-1;
        while(true){
            int pivotpos = sort(nums,low,high);
            if(pivotpos>nums.length-k){
                high = pivotpos - 1;
            }else if(pivotpos<nums.length-k){
                low = pivotpos + 1;
            }else{
                return nums[pivotpos];
            }
        }
    }
    private int sort(int[] nums,int low,int high){
        int temp = nums[low];
        while(low<high){
            while(low<high&&nums[high]>=temp){
                high--;
            }
            nums[low] = nums[high];
            while(low<high&&nums[low]<=temp){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }
}
