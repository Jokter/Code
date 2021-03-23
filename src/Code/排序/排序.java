package Code.排序;

public class 排序 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 9, 7, 2, 6, 8, 4};
        helper(arr);
        for (int i:arr) {
            System.out.print(i+" ");
        }
    }

    public static void helper(int[] arr) {
        int len = arr.length;
        int i, j;
        for (i = 0; i < len; i++) {
            int x = arr[i];
            for (j = i-1; j >= 0; j--) {
                if (x < arr[j]) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = x;
        }
    }

    public static void help(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = len - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

}
