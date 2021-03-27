package Code.回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 分割回文串 {
    static List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        if(s.length() == 0){
            return res;
        }
        LinkedList<String> cur = new LinkedList<>();
        helper(cur, s, 0);
        return res;
    }

    private static void helper(LinkedList<String> cur, String s, int start){
        if(s.length() == start){
            res.add(new ArrayList(cur));
            return;
        }
        for(int i = start; i < s.length(); i++){
            if(help(s, start, i)){
                cur.addLast(s.substring(start, i + 1));
                helper(cur, s, i + 1);
                cur.removeLast();
            }
        }
    }

    private static boolean help(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
