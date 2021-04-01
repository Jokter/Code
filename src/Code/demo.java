package Code;


import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author demonwangyu_i
 * @creator 2021/1/11 下午10:06
 */
public class demo {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String str = s.trim();
        String[] strArr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (!strArr[i].equals("")) {
                sb.append(strArr[i].trim() + " ");
            }
        }
        return sb.toString().trim();
    }

}