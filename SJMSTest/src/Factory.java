
//工厂模式是用来创建同一个产品的不同类型的,产品类单一
//抽象工厂模式用来创建不同类的产品
public class Factory {
    //工厂模式
    //定义一个用于创建对象的接口，让子类决定实例化哪一个类。FactoryMethod使一个类的实例化延迟到其子类。

    //适用:
    //1.当一个类不知道它所必须创建的对象的类的时候。
    //2.当一个类希望由它的子类来指定它所创建的对象的时候。
    //3.将创建对象的职责委托给多个帮助类中的某一个，并且希望将哪一个帮助子类是代理者这一信息局部化的时候。
    public static void main(String[] args){
        IWorkFactory student = new StudentWorkFactory();
        student.getWork().doWork();

        IWorkFactory teacher = new TeacherWorkFactory();
        teacher.getWork().doWork();
    }
}

//创建对象的接口 Product
interface IWork{
    void doWork();
}

class StudentWork implements IWork{

    @Override
    public void doWork(){
        System.out.println("学生做作业");
    }
}

class TeacherWork implements IWork{

    @Override
    public void doWork(){
        System.out.println("老师批作业");
    }
}

//声明工厂的方法
interface IWorkFactory {
    IWork getWork();
}

class StudentWorkFactory implements IWorkFactory{

    @Override
    public IWork getWork() {
        return new StudentWork();
    }
}

class TeacherWorkFactory implements IWorkFactory{

    @Override
    public IWork getWork() {
        return new TeacherWork();
    }
}
