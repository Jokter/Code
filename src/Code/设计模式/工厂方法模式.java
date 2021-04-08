package Code.设计模式;

public class 工厂方法模式 {
    public static void main(String[] args) {
        Create create = new Creator();
        Product pen = create.createProduct(Pen.class);
        Product pencil = create.createProduct(Pencil.class);
        pen.exclude();
        pencil.exclude();
    }
}

//产品
abstract class Product {
    public void currency() {
        System.out.println("我是通用方法");
    }
    public abstract void exclude();
}

class Pen extends Product {
    @Override
    public void exclude() {
        System.out.println("我是钢笔");
    }
}

class Pencil extends Product {
    @Override
    public void exclude() {
        System.out.println("我是铅笔");
    }
}

//创建者
abstract class Create {
    public abstract <T extends Product> T createProduct(Class<T> c);
}

class Creator extends Create {

    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = (Product) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}