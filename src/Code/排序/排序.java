package Code.排序;

public class 排序 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 9, 7, 2, 6, 8, 4};
        quickSort(arr,0,arr.length-1);
        for (int i:arr) {
            System.out.print(i+" ");
        }
    }

    public static void quickSort(int[] arr,int low,int high){
        if (low <high) {
            int mid = sort(arr, low, high);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }
    }

    public static int sort(int[] arr,int low,int high){
        int temp = arr[low];
        while (low < high) {
            while(low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while(low<high&& arr[low]<=temp) {
                low ++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}
