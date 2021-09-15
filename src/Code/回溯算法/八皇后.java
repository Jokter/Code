package Code.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 八皇后 {
    static List<List<String>> res;

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] arr = new char[n][n];
        //填充棋盘，每个格子默认是“。”表示没有放置皇后
        for(int i=0;i<n;++i) {
            Arrays.fill(arr[i],'.');
        }
        track(arr, 0);
        return res;
    }

    public static void track(char[][] arr, int row) {
        if (arr.length == row) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(new String(arr[i]));
            }
            res.add(list);
            return;
        }
        for (int col = 0; col < arr[row].length; col++) {
            if (!isValid(arr, row, col)) {
                continue;
            }
            arr[row][col] = 'Q';
            track(arr, row + 1);
            arr[row][col] = '.';
        }
    }
    public static boolean isValid(char[][] arr, int row, int col) {
        int n = arr.length;
        //列冲突
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }
        //左上冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        //右上冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (arr[i][j] == 'Q')
                return false;
        }
        return true;
    }
}
