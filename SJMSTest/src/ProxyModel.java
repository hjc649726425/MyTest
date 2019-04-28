import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.*;
import java.lang.reflect.Proxy;

public class ProxyModel {

    //代理模式
    //为其他对象提供一种代理以控制对这个对象的访问

    //    1.远程代理（RemoteProxy）为一个对象在不同的地址空间提供局部代表。
    //    2.虚代理（VirtualProxy）根据需要创建开销很大的对象。
    //    3.保护代理（ProtectionProxy）控制对原始对象的访问。
    //    4.智能指引（SmartReference）取代了简单的指针，它在访问对象时执行一些附加操作。

    public static void main(String[] args){
        ObjectImpl objimpl = new ObjectImpl();
        //Object obj = new ProxyObject(objimpl);
        //obj.action();

        Object dynamicobj = (Object)Proxy.newProxyInstance(Object.class.getClassLoader(),new Class[]{Object.class},new DynamicProxyHandler(objimpl));
        dynamicobj.action();

        //IMyC c = new MyC();
        //c.Func2();
    }

}

interface Object{
    void action();
}

class ProxyObject implements Object {

    Object obj;

    public ProxyObject(ObjectImpl objimpl){
        System.out.println("这是静态代理类");
        obj = objimpl;
    }

    @Override
    public void action() {
        System.out.println("代理开始");
        obj.action();
        System.out.println("代理结束");
    }
}

class ObjectImpl implements Object{

    @Override
    public void action() {
        System.out.println("============");
        System.out.println("这是被代理类");
        System.out.println("============");
    }
}

//动态代理
//在动态代理中我们不再需要再手动的创建代理类，我们只需要编写一个动态处理器就可以了。真正的代理对象由JDK再运行时为我们动态的来创建。

class DynamicProxyHandler implements InvocationHandler{   //JVM生成的代理类继承Proxy类，由于java的继承机制，所以动态代理只能对接口进行代理

    private java.lang.Object obj;   //代理类并不是真正实现服务，而是通过调用委托类（被代理的类）的对象的方法来实现服务。invoke方法不能获取到被代理对象,所以要传一个具体代理对象
     public DynamicProxyHandler(java.lang.Object obj){
         this.obj = obj;
     }

    @Override
    public java.lang.Object invoke(java.lang.Object proxy, Method method, java.lang.Object[] args) throws Throwable {
        System.out.println("动态代理前");
        //System.out.println(proxy.getClass().getName());   //proxy是代理类的一个实例
        //System.out.println(method.getName());
        //System.out.println(this.getClass().getName());
        java.lang.Object result = method.invoke(obj, args);
        //System.out.println(result);
        System.out.println("动态代理后");
        return result;
    }
}

interface IMyC{
    void Func1();
    void Func2();
}

class MyC implements IMyC{

    public void Func1(){
        System.out.println("Func1");
    }

    public void Func2(){
        DynamicProxyHandler handler = new DynamicProxyHandler(this);
        IMyC c = (IMyC)Proxy.newProxyInstance(IMyC.class.getClassLoader(),new Class[]{IMyC.class},handler);
        c.Func1();
    }
}



