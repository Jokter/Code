package Code.并查集;

import java.util.HashMap;

public class UnionFind {

    HashMap<Integer, Integer> map;
    int count;

    public UnionFind() {
        map = new HashMap<>();
        count = 0;
    }

    public void add(int x) {
        if (!map.containsKey(x)) {
            map.put(x, null);
            count++;
        }
    }

    public void merge(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx == rooty) {
            map.put(rootx, rooty);
            count--;
        }
    }

    public int find(int x) {
        int root = x;
        while (map.get(root) != null) {
            root = map.get(root);
        }
        while (x != root) {
            int old = map.get(x);
            map.put(x, root);
            x = old;
        }

        return root;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int getCount() {
        return count;
    }

}
