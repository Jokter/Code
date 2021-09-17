package Code.贪心算法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi]
    1、请你判断一个人是否能够参加这里面的全部会议canAttendMeetings
    2、请你判断最少需要几个会议室minMeetingRooms
 */
public class 会议室 {
    public static void main(String[] args) {
        int[][] ans = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        // 判断一个人是否能够参加这里面的全部会议
        System.out.println(canAttendMeetings(ans));
        // 1、判断最少需要几个会议室
        System.out.println(minMeetingRooms1(ans));
        // 2、判断最少需要几个会议室
        System.out.println(minMeetingRooms2(ans));
    }

    /**
     * 判断一个人是否能够参加这里面的全部会议
     * @param ans 会议数组
     */
    private static boolean canAttendMeetings(int[][] ans) {
        Arrays.sort(ans, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < ans.length - 1; i++) {
            if (ans[i][1] > ans[i + 1][0])
                return false;
        }
        return true;
    }

    /**
     * 方法一
     * 判断最少需要几个会议室
     * @param ans 会议数组
     * @return
     */
    private static int minMeetingRooms1(int[][] ans) {
        if(ans.length<1)return 0;
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        Arrays.sort(ans, (o1, o2)->(o1[0] - o2[0]));
        int res=0;
        for(int[] time : ans){
            while(!queue.isEmpty()&&time[0]>=queue.peek()){
                queue.poll();
            }
            queue.add(time[1]);
            res=Math.max(res, queue.size());
        }
        return res;
    }

    /**
     * 方法二
     * 判断最少需要几个会议室
     * @param ans 会议数组
     * @return
     */
    private static int minMeetingRooms2(int[][] ans) {
        if (ans.length == 0) {
            return 0;
        }
        // 分开排序
        Integer[] start = new Integer[ans.length];
        Integer[] end = new Integer[ans.length];
        for (int i = 0; i < ans.length; i++) {
            start[i] = ans[i][0];
            end[i] = ans[i][1];
        }
        Arrays.sort(start, (o1, o2) -> o1 - o2);
        Arrays.sort(end, (o1, o2) -> o1 - o2);

        int startPointer = 0, endPointer = 0;
        int res = 0;

        while (startPointer < ans.length) {
            if (start[startPointer] < end[endPointer]) {
                res++;
            } else {
                endPointer++;
            }
            startPointer++;
        }
        return res;
    }

}
