package Code.枚举;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author demonwangyu_i
 * @creator 2021/1/26 下午5:14
 */
public class demo {
    public static void main(String[] args) {
        //枚举类型的属性、方法和构造函数测试
        System.out.println("————————枚举类型的属性、方法和构造函数测试————————");
        Pizza testPz = new Pizza();
        testPz.setStatus(Pizza.PizzaStatus.READY);
        System.out.println(testPz.isDeliverable());

        //EnumSet测试
        System.out.println("————————EnumSet测试————————");
        List<Pizza> pzList = new ArrayList<>();
        Pizza pz1 = new Pizza();
        pz1.setStatus(Pizza.PizzaStatus.DELIVERED);

        Pizza pz2 = new Pizza();
        pz2.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz3 = new Pizza();
        pz3.setStatus(Pizza.PizzaStatus.ORDERED);

        Pizza pz4 = new Pizza();
        pz4.setStatus(Pizza.PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        List<Pizza> undeliveredPzs = Pizza.getAllUndeliveredPizzas(pzList);
        System.out.println(undeliveredPzs.size());

        //EnumMap测试
        System.out.println("————————EnumMap测试————————");
//        EnumMap<Pizza.PizzaStatus,List<Pizza>> map = Pizza.groupPizzaByStatus(pzList);
//        System.out.println(map.get(Pizza.PizzaStatus.DELIVERED).size() == 1);
//        System.out.println(map.get(Pizza.PizzaStatus.ORDERED).size() == 2);
//        System.out.println(map.get(Pizza.PizzaStatus.READY).size() == 1);
    }
}
