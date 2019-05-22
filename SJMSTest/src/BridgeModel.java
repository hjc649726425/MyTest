public class BridgeModel {
    //桥接模式111
    //将抽象部分与它的实现部分分离，使它们都可以独立地变化。
    //    1.你不希望在抽象和它的实现部分之间有一个固定的绑定关系。
    //      例如这种情况可能是因为，在程序运行时刻实现部分应可以选择或者切换。
    //    2.类的抽象以及它的实现都应该可以通过生成子类的方法加以扩充。
    //      这时Bridge模式使你可以对不同的抽象接口和实现部分进行组合，并分别对它们进行扩充。
    //    3.对一个抽象的实现部分的修改应对客户不产生影响，即客户的代码不必重新编译。
    //    4.有许多类要生成。这一种类层次结构说明你必须将一个对象分解成两个部分。
    //    5.想在多个对象间共享实现（可能使用引用计数），但同时要求客户并不知道这一点。

    public static void main(String[] args){
        People man = new Man();
        People woman = new Woman();
        Clothing jacket = new Jacket();
        Clothing trouser = new Trouser();

        jacket.dress(man);
        trouser.dress(man);
        jacket.dress(woman);
        trouser.dress(woman);

        man.setClothing(jacket);
        man.dress();
        woman.setClothing(jacket);
        woman.dress();
        man.setClothing(trouser);
        man.dress();
        woman.setClothing(trouser);
        woman.dress();
    }
}

abstract class People{
    private Clothing clothing;
    private String type;
    public Clothing getClothing(){
        return clothing;
    }

    public void setClothing(Clothing clothing){
        this.clothing = clothing;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public abstract void dress();

}

class Man extends People{

    public Man(){
        setType("男人");
    }

    @Override
    public void dress() {
        getClothing().dress(this);
        //System.out.println(this.getType() + "穿" + clothing.getName());
    }
}

class Woman extends People{

    public Woman(){
        setType("女人");
    }

    @Override
    public void dress() {
        getClothing().dress(this);
        //System.out.println(this.getType() + "穿" + clothing.getName());
    }
}

abstract class Clothing{
    private String name;

    public String getName(){
        return  this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void dress(People people);
}

class Jacket extends Clothing{

    public Jacket(){
        setName("夹克");
    }

    @Override
    public void dress(People people) {
        System.out.println(people.getType() + "穿马甲");
    }
}

class Trouser extends Clothing{

    public Trouser(){
        setName("裤子");
    }

    @Override
    public void dress(People people) {
        System.out.println(people.getType() + "穿裤子");
    }
}


