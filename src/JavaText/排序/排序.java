package JavaText.排序;

public class 排序 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 9, 7, 2, 6, 8, 4};
        helper(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    private static void helper(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            boolean flag = true;
            for(int j = arr.length-1;j>i;j--){
                if(arr[j]>arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

}
