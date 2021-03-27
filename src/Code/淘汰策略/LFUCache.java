package Code.淘汰策略;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    HashMap<Integer, Integer> keyToVal = new HashMap<>();
    HashMap<Integer, Integer> keyToFre = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> freToKey = new HashMap<>();
    int cap;
    int minFre;

    public LFUCache(int capacity) {
        this.cap = capacity;
        minFre = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        //更新fre
        increaseFre(key);

        return keyToVal.get(key);
    }

    private void increaseFre(int key) {
        int oldFre = keyToFre.get(key);
        keyToFre.put(key, oldFre + 1);
        freToKey.get(oldFre).remove(key);
        freToKey.putIfAbsent(oldFre + 1, new LinkedHashSet<Integer>());
        freToKey.get(oldFre + 1).add(key);

        if (freToKey.get(oldFre).isEmpty()) {
            freToKey.remove(oldFre);
            if (oldFre == this.minFre) {
                minFre++;
            }
        }
    }

    public void put(int key, int value) {
        if (this.cap <= 0) return;
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFre(key);
            return;
        }
        if (keyToVal.size() >= this.cap) {
            //去掉minFre中的头
            removeMinFre();
        }

        keyToVal.put(key, value);
        keyToFre.put(key, 1);
        freToKey.putIfAbsent(1, new LinkedHashSet<Integer>());
        freToKey.get(1).add(key);
        minFre = 1;

    }

    public void removeMinFre() {
        LinkedHashSet<Integer> set = freToKey.get(minFre);
        int delete = set.iterator().next();
        set.remove(delete);
        if (set.isEmpty()) {
            freToKey.remove(this.minFre);
        }
        keyToFre.remove(delete);
        keyToVal.remove(delete);
    }
}
