package Code.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class 区间调度 {

    public static void main(String[] args) {

    }

    public static int intervalSchedule(int[][] intvs) {
        if (intvs.length < 1) {
            return 0;
        }
        Arrays.sort(intvs, (p1, p2) -> p1[1] > p2[1] ? 1 : -1);

        //至少应该有一个区间不相交
        int count = 1;
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            if (interval[0] >= x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }

}
