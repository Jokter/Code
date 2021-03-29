package Code.多线程;

public class DeadLock {

    final static Object LOCK1 = new Object();
    final static Object LOCK2 = new Object();

    public static void main (String[] args) {
        Thread thread1 = new Thread(new lock1());
        Thread thread2 = new Thread(new lock2());
        thread1.start();
        thread2.start();
    }

    static class lock1 implements Runnable{
        public void run(){
            synchronized(LOCK1){
                System.out.println("1：我获得了第一个锁");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(LOCK2){
                    System.out.println("1：我获得了第二个锁");
                }
            }
        }
    }

    static class lock2 implements Runnable{
        public void run(){
            synchronized(LOCK2){
                System.out.println("2：我获得了第二个锁");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(LOCK1){
                    System.out.println("2：我获得了第一个锁");
                }
            }
        }
    }
}
