import java.util.HashMap;
import java.util.Map;

public class FlyweightModel {

    //享元模式
    //运用共享技术有效地支持大量细粒度的对象。

    //    当都具备下列情况时，使用Flyweight模式：
    //    1.一个应用程序使用了大量的对象。
    //    2.完全由于使用大量的对象，造成很大的存储开销。
    //    3.对象大多数状态都可变为外部状态。
    //    4.如果删除对象的外部状态，那么可以相对较少的共享对象取代很多组对象。
    //    5.应用程序不依赖于对象标识。由于Flyweight对象可以被共享，对于概念上明显有别的对象，标识测试将返回真值。

    public static void main(String[] args){
        Flyweight fly1 = FlyweightFactory.getFlyweight("a");
        fly1.action(1);

        Flyweight fly2 = FlyweightFactory.getFlyweight("a");
        System.out.println(fly1 == fly2);

        Flyweight fly3 = FlyweightFactory.getFlyweight("b");
        fly3.action(2);

        Flyweight fly4 = FlyweightFactory.getFlyweight("c");
        fly3.action(3);

        Flyweight fly5 = FlyweightFactory.getFlyweight("d");
        fly3.action(4);

        System.out.println(FlyweightFactory.getSize());
    }
}

interface Flyweight{
    void action(int arg);
}

class FlyweightImpl implements Flyweight{

    @Override
    public void action(int arg) {
        System.out.println("参数值：" + arg);
    }
}

class FlyweightFactory{
    private static Map flyweights = new HashMap();
    /*public FlyweightFactory(String arg){
        flyweights.put(arg,new FlyweightImpl());
    }*/

    public static Flyweight getFlyweight(String key){
        if(flyweights.get(key) == null){
            flyweights.put(key,new FlyweightImpl());
        }

        return (Flyweight)flyweights.get(key);
    }

    public static int getSize(){
        return flyweights.size();
    }

}
