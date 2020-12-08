package JavaText.排序;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 9, 7, 2, 6, 8, 4};
//        从小到大(arr);
        从大到小(arr);
        for (int number:arr) {
            System.out.print(number+" ");
        }
    }

    private static void 从大到小(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            boolean flag = true;
            for(int j = arr.length-1;j>i;j--){
                if(arr[j]>arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    private static void 从小到大(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            boolean flag = true;
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
