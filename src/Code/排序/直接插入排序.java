package Code.排序;

public class 直接插入排序 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 9, 7, 2, 6, 8, 4};
//        从小到大(arr);
        从大到小(arr);
        for (int number:arr) {
            System.out.print(number+" ");
        }
    }

    private static void 从大到小(int[] arr){
        int i,j;
        for(i=0;i<arr.length;i++){
            int x = arr[i];
            for(j=i-1;j>=0;j--){
                if(x>arr[j]){
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = x;
        }
    }

    private static void 从小到大(int[] arr) {
        int i,j;
        for(i=0;i<arr.length;i++){
            int x = arr[i];
            for(j=i-1;j>=0;j--){
                if(x<arr[j]){
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = x;
        }
    }
}
