public class PrototypeModel {

    //原型模式
    //用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
    // 适用性
    //    1.当一个系统应该独立于它的产品创建、构成和表示时。
    //    2.当要实例化的类是在运行时刻指定时，例如，通过动态装载。
    //    3.为了避免创建一个与产品类层次平行的工厂的层次时。
    //    4.当一个类的实例只能有几个不同状态组合中的一种时。
    //    建立相应数目的原型并克隆它们可能比每次用合适的状态手工实例化该类更方便一些。

    public static void main(String[] args){
        //Client写到主函数里
        Prototype pro1 = new ConcretePrototype("张三");
        Prototype pro2 = (Prototype)pro1.clone();
        System.out.println(pro1.getName());
        System.out.println(pro2.getName());
        System.out.println("pro1 == pro2 ?" + (pro1==pro2));  //false
        System.out.println("pro1.getClass() == pro2.getClass()?" + (pro1.getClass()==pro2.getClass()));  //true
    }
}

//声明一个克隆自身的类
class Prototype implements Cloneable{
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public java.lang.Object clone(){
        Prototype prototype = null;
        try {
            prototype = (Prototype)super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }

        return  prototype;
    }
}

//实现克隆自身的操作
class ConcretePrototype extends Prototype{
    public ConcretePrototype(String name){
        setName(name);
    }
}

//让一个原型克隆自身从而创建一个新对象
class Client{

}
