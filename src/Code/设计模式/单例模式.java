package Code.设计模式;
/**
 * 单例模式：在一个系统中，一个类只存在一个对象
 */
/**
 * 多线程情况下的懒汉式：多线程可以通过加入synchronized内部锁来解决安全问题，并且通过volatile关键字禁止指令重排序
 */
public class 单例模式 {
    private static volatile 单例模式 s = null;
    private 单例模式(){};
    public static 单例模式 getInstance(){
        if(s==null){
            synchronized (单例模式.class){
                if(s==null){
                    s = new 单例模式();
                }
            }
        }
        return s;
    }
}

/**
 * 饿汉式：在程序初始化的时候就创建了对象，需要使用时直接获取
 */
class 饿汉式{
    private static final 饿汉式 s = new 饿汉式();
    private 饿汉式(){};
    public static 饿汉式 getInstance(){
        return s;
    }
}

/**
 * 懒汉式：初始化时将对象置为null，在真正使用到的时候，才创建对象
 */
class 懒汉式 {
    private static 懒汉式 s = null;
    private 懒汉式(){};
    public static 懒汉式 getInstance(){
        if(s==null){
            s = new 懒汉式();
        }
        return s;
    }
}

class Single {

}
