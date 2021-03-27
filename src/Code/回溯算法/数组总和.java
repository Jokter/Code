package Code.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 数组总和 {
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{2, 5, 2 , 1, 2}, 5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> cur = new ArrayList<>();
        track(cur, candidates, target, new boolean[candidates.length], 0);
        return res;
    }

    public static void track(ArrayList<Integer> cur, int[] cadidates, int target, boolean[] booleans, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < cadidates.length; i++) {
            if (booleans[i]) {
                continue;
            }
            if (i > 0 && !booleans[i-1] && cadidates[i-1] == cadidates[i]) {
                continue;
            }
            cur.add(cadidates[i]);
            booleans[i] = true;
            track(cur, cadidates, target - cadidates[i], booleans, i + 1);
            cur.remove(cur.size() - 1);
            booleans[i] = false;
        }
    }
}
