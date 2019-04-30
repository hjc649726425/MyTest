public class DecoratorModel {

    //装饰模式
    // 动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator模式相比生成子类更为灵活。
    //    1.在不影响其他*象的情况下，以动态、透明的方式给单个对象添加职责。
    //    2.处理那些可以撤消的职责。
    //    3.当不能采用生成子类的方法进行扩充时。

    public static void main(String[] args){
        IPeople mp = new ManPeople();
        IPeople mda = new ManDecoratorA(mp);
        IPeople mdb = new ManDecoratorB(mp);

        mp.eat();
       // mda.setPerson(mp);
        mda.eat();
       // mdb.setPerson(mp);
        mdb.eat();
    }
}

interface IPeople{
    void eat();
}

class ManPeople implements IPeople{

    @Override
    public void eat(){
        System.out.println("男人在吃");
    }
}

abstract class Decorator implements IPeople{
    public IPeople person;

    public Decorator(IPeople person){
        this.person = person;
    }

    public void setPerson(IPeople person){
        this.person = person;
    }

    public void eat(){
        person.eat();
    }
}

class ManDecoratorA extends Decorator{

    public ManDecoratorA(IPeople people){
        super(people);
    }

    public void eat(){
        super.eat();
        reEat();
        System.out.println("ManDecoratorA类");
    }

    public void reEat(){
        System.out.println("再吃一顿饭");
    }
}

class ManDecoratorB extends Decorator{

    public ManDecoratorB(IPeople people){
        super(people);
    }

    public void eat(){
        System.out.println("ManDecoratorB类");
    }
}