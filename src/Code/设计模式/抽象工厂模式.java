package Code.设计模式;

public class 抽象工厂模式 {
    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //获取circle形状
        Shape circle = shapeFactory.getShape("CIRCLE");
        //画一个圆形
        circle.draw();
        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        //获取red颜色
        Color red = colorFactory.getColor("RED");
        //填色
        red.fill();
    }
}

//工厂创造器
class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}

//形状和颜色的抽象工厂
abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}

class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}

class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("WHITE")){
            return new White();
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeType){
        return null;
    }
}

//颜色
interface Color {
    void fill();
}

class Red implements Color {
    @Override
    public void fill() {
        System.out.println("红色填充");
    }
}

class White implements Color {
    @Override
    public void fill() {
        System.out.println("白色填充");
    }
}

//形状
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("画个三角形");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("画个圆形");
    }
}