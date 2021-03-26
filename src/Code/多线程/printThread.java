package Code.多线程;
public class printThread {
    static volatile int result = 0;
    static volatile int flag = 0;
    public static void print(int n) {
        final Object LOCK = new Object();
        for (int i = 0;i < n; i++){
            final int index = i;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        while (result <= 10) {
                            synchronized (LOCK){
                                if(flag == index) {
                                    System.out.println("thread" + index + ": " + result++);
                                    flag = index == n - 1 ? 0 : index + 1;
                                    // 唤醒其他wait线程
                                    LOCK.notifyAll();
                                } else {
                                    LOCK.wait();
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        print(4);
    }

}