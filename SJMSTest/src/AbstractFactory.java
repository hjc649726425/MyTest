public class AbstractFactory { //用来创建不同类的产品
    //抽象工厂111222333
    //提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
   // 1.一个系统要独立于它的*品的创建、组合和表示时。
   // 2.一个系统要由多个产品系列中的一个来配置时。
   // 3.当你要强调一系列相关的产品对象的设计以便进行联合使用时*
   // 4.当你提供一个产品类库，而只想显示它们的接口而不是实现时。

    public static void main(String[] args){
        IAnimalFactory black = new BlackAnimalFactory();
        ICat bcat = black.CreateCat();
        IDog bdog = black.CreateDog();
        bcat.eat();
        bdog.eat();

        IAnimalFactory white = new WhiteAnimalFactory();
        ICat wcat = white.CreateCat();
        IDog wdog = white.CreateDog();
        wcat.eat();
        wdog.eat();

    }
}

interface IAnimalFactory{
    ICat CreateCat();
    IDog CreateDog();
}

class BlackAnimalFactory implements IAnimalFactory{

    @Override
    public ICat CreateCat() {
        return new BlackCat();
    }

    @Override
    public IDog CreateDog() {
        return new BlackDog();
    }
}

class WhiteAnimalFactory implements IAnimalFactory{

    @Override
    public ICat CreateCat() {
        return new WhiteCat();
    }

    @Override
    public IDog CreateDog() {
        return new WhiteDog();
    }
}

interface  ICat{
    void eat();
}

class BlackCat implements ICat{
    @Override
    public void eat(){
        System.out.println("黑猫在吃");
    }
}

class WhiteCat implements ICat{
    @Override
    public void eat(){
        System.out.println("白猫在吃");
    }
}

interface IDog{
    void eat();
}

class BlackDog implements IDog{
    @Override
    public void eat(){
        System.out.println("黑狗在吃");
    }
}

class WhiteDog implements IDog{
    @Override
    public void eat(){
        System.out.println("白狗在吃");
    }
}