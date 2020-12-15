package Code.排序;

public class 二分查找 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7,9,13};
        int target = 9;
        int index = getIndex(arr, target);
        System.out.println(index);
    }

    private static int getIndex(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int index = -1;
        while(low<high){
            int mid = (low+high)>>1;
            if(arr[mid]>target){
                high = mid - 1;
            }else if(arr[mid]<target){
                low = mid + 1;
            }else {
                index = mid;
                break;
            }
        }
        return index;
    }
}
