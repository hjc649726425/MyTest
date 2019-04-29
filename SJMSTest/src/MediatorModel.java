public class MediatorModel {

    //中介者模式 Test
    //  用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。

    //    1.一组对象以定义良好但是复杂的方式进行通信。产生的相互依赖关系结构混乱且难以理解。
    //    2.一个对象引用其他很多对象并且直接与这些对象通信,导致难以复核该对象。
    //    3.想定制一个分布在多个类中的行为，且又不想生成太多的子类。

    public static void main(String[] args){
        Mediator mediator = new ConcreteMediator();
        mediator.notice("boss");
        mediator.notice("client");
    }
}

abstract class Mediator{
    public abstract void notice(String content);
}

class ConcreteMediator extends Mediator{

    private ColleagueA colleagueA;
    private ColleagueB colleagueB;

    ConcreteMediator(){
        colleagueA = new ColleagueA();
        colleagueB = new ColleagueB();
    }

    @Override
    public void notice(String content) {
        if(content.equals("boss")){
            colleagueA.action();
        }

        if(content.equals("client")){
            colleagueB.action();
        }
    }
}

abstract class Colleague{
    public abstract void action();
}

class ColleagueA extends Colleague{

    @Override
    public void action() {
        System.out.println("普通员工努力工作");
    }
}
class ColleagueB extends Colleague{

    @Override
    public void action() {
        System.out.println("前台注意了");
    }
}

