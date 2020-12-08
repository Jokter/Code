package JavaText.多线程;

import java.util.*;
public class ABCD{
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Object d = new Object();
        int count = Integer.parseInt(sc.nextLine());
        Help pa = new Help("A", d, a, count);
        Help pb = new Help("B", a, b, count);
        Help pc = new Help("C", b, c, count);
        Help pd = new Help("D", c, d, count);

        new Thread(pa).start();
        Thread.sleep(100); // 确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
        new Thread(pd).start();
    }
}

class Help implements Runnable{
    private String name;
    private Object prev;
    private Object self;
    private int count;
    public Help(String name, Object prev, Object self, int count) {
        this.name = name;
        this.prev = prev;
        this.self = self;
        this.count = count;
    }
    @Override
    public void run() {
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                if(count==0){
                    break;
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}