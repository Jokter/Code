package Code;


import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author demonwangyu_i
 * @creator 2021/1/11 下午10:06
 */
public class demo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        int[] arr = {5, 1, 3, 9, 7, 2, 6, 8, 4};
//        insert(arr);
//        for (int number:arr) {
//            System.out.print(number+" ");
//        }
//        System.out.println();
//        print(5);


        cat cat = new cat();
        Field name = cat.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(cat, "hello-kit");
        System.out.println(cat.getName()); //hello-kit

        HashMap<Object, Object> hashMap = new HashMap<>(7);
        hashMap.put(1,2);
        System.out.println(hashMap.size());

    }

    //冒泡
    public static void maopo(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
        }
    }

    //快排
    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = sort(nums, low, high);
            quickSort(nums, low, mid - 1);
            quickSort(nums, mid +1, high);
        }
    }

    public static int sort(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while(low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];
            while(low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }

    //直接插入
    public static void insert(int[] nums) {
        int i, j;
        for (i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] > x) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j+1] = x;
        }
    }

    static volatile int flag = 0;
    static volatile int result = 0;
    //多线程交替打印1-100
    public static void print(int nThreads) {
        final Object LOCK = new Object();
        for (int i = 0; i < nThreads; i++) {
            final int index= i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(result <= 100) {
                            synchronized(LOCK) {
                                if (flag == index) {
                                    System.out.println(index + "  " + result++);
                                    flag = index == nThreads - 1 ? 0 : index + 1;
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

}