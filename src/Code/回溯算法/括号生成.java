package Code.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        char[] chs = new char[2 * n];
        track(chs, 0);
        return res;
    }

    public static void track(char[] chs, int index) {
        if (chs.length == index) {
            if (isValid(chs)) {
                res.add(new String(chs));
            }
            return;
        }
        chs[index] = '(';
        track(chs, index+1);
        chs[index] = ')';
        track(chs, index+1);
    }

    public static boolean isValid(char[] chs) {
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                index++;
            } else {
                if (index == 0) {
                    return false;
                }
                index--;
            }
        }
        return index == 0;
    }
}
