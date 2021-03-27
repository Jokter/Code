package Code.DFS;

import Code.数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 树DFS {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> cur = new ArrayList<>();
        track(cur, root, sum);
        return res;
    }

    public void track(ArrayList<Integer> cur, TreeNode root, int sum) {
        if (root != null) {
            cur.add(root.val);
            sum = sum - root.val;
            if (sum == 0 && root.right == null && root.left == null) {
                res.add(new ArrayList(cur));
            }
            track(cur, root.left, sum);
            track(cur, root.right, sum);
            cur.remove(cur.size() - 1);
        }
    }
}
