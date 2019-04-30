import org.omg.CORBA.PUBLIC_MEMBER;

public class Singleton {
    //单态模式（单例模式）
    //保证一个类仅有一个实例，只提供一个访问它的全局访问点。
    //1.当类只能有一个实例而且客户可以从一个众所周知的访问点访问它时。
    //2.当这个唯一实例应该是通过子类化可扩展的，并且客户应该无需更改代码就能使用一个扩展的实例时。

    public static void main(String[] args){

    }
}

class EH{ //饿汉式 静态常量 或 静态代码块  避免同步的问题，但是没有实现懒加载，造成内存浪费
    private final static EH eh = new EH();

    private EH(){}

    /*static {
        eh = new EH();
    }*/

    public static EH getInstance(){
        return eh;
    }
}

class LH{  //懒汉 双重检测
    private static volatile LH lh;
    private LH(){}

    public static LH getInstance(){
        if(lh == null){
            synchronized (LH.class){
                if(lh == null){
                    lh = new LH();
                }
            }
        }

        return lh;
    }
}
