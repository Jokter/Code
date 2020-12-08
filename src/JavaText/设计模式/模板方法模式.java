package JavaText.设计模式;
/**
 * 定义了一个抽象类，在抽象类中可以定义模板方法进行对抽象方法的调度，形成一个框架
 */
public class 模板方法模式 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.start();
        Cat cat = new Cat();
        cat.start();
    }
}

//抽象父类
abstract class Animal{
    //定义抽象方法
    abstract void eat();
    abstract void run();
    //定义模板方法
    public void start(){
        //定义一个框架，确定方法的执行步骤
        eat();
        run();
    }
}

class Dog extends Animal{

    @Override
    void eat() {
        System.out.println("我是小狗，我在吃东西");
    }

    @Override
    void run() {
        System.out.println("我是小狗，我在跑");
    }
}

class Cat extends Animal{

    @Override
    void eat() {
        System.out.println("我是小猫，我在吃东西");
    }

    @Override
    void run() {
        System.out.println("我是小猫，我在跑");
    }

    private void wash(){
        System.out.println("我是小猫，我在洗手");
    }
}
