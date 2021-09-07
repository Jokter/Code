package Code.多线程;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ExecutorServiceDemo {

    public static void main(String[] args) {
        ExecutorServiceDemo.task();
    }

    private final static int NUMBER = 3;

    public static void task() {

        // 创建线程池。
        ExecutorService pool = Executors.newFixedThreadPool(NUMBER);

        ArrayList<Future<String>> futures = new ArrayList<Future<String>>();

        for (int i = 0; i < 10; i++) {
            int f = i;
            // 创建调度任务
            FutureTask<String> futureTask = new FutureTask<>(() -> {
                Thread.sleep(new Random().nextInt(10));
                return "" + f;
            });
            // 执行任务
            pool.execute(futureTask);
            futures.add(futureTask);
        }

         System.out.println("遍历获取结果中...");
        ArrayList<String> res = new ArrayList<>();
        while(futures.size() > 0) {
            Iterator<Future<String>> iterator = futures.iterator();
            while (iterator.hasNext()) {
                Future<String> future = iterator.next();
                try {
                    // 判断是否返回结果，防止直接回去结果阻塞
                    if (future.isDone()) {
                        System.out.println(future.get());
                        res.add(future.get());
                        iterator.remove();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                // 释放CPU，降低服务器压力
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("完成遍历结果.");

        // 关闭线程池。
        pool.shutdown();
    }
}