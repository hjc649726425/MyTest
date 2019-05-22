public class Builder {
    //建造者模式1111111
    //将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示。
    //    1.当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时。
    //    2.当构造过程必须允许被构造的对象有不同类表示时。

    //每一个具体建造者都相对独立，而与其他的具体建造者无关，因此可以很方便地替换具体建造者或增加新的具体建造者， 用户使用不同的具体建造者即可得到不同的产品对象 。
    //更加清晰地控制产品的创建

    public static void main(String[] args){
        Director director = new Director();
        Person person = director.constructPerson(new ManBuilder());
        System.out.println(person.getBody());
        System.out.println(person.getFoot());
        System.out.println(person.getHead());
    }
}

//抽象建造者
//为创建一个Product对象的各个部件指定抽象接口
interface PersonBuilder{
    void BuildHead();
    void BuildBody();
    void BuildFoot();
    Person BuildPerson();
}

//具体建造者
//实现Builer的接口以构造和装配该产品的各个部件。
//定义并明确它所创建的表示类
//提供一个检索产品的接口。
class ManBuilder implements PersonBuilder{

    private Person person;

    public ManBuilder(){
        person = new Person();
    }

    @Override
    public void BuildHead() {
        person.setBody("身体");
    }

    @Override
    public void BuildBody() {
        person.setHead("头");
    }

    @Override
    public void BuildFoot() {
        person.setFoot("脚");
    }

    @Override
    public Person BuildPerson() {
        return person;
    }
}

//指挥者
//构造一个使用Builder接口的对象
class Director{
    public Person constructPerson(PersonBuilder pb){
        pb.BuildBody();
        pb.BuildFoot();
        pb.BuildHead();
        return pb.BuildPerson();
    }
}

//产品角色
//表示被构造的复杂对象。ConcreteBuilder创建该产品的内部表示并定义它的装配过程。
//包含定义组成部件的类，包括将这些部件装配成最终产品的接口
class Person{
    private String head;
    private String body;
    private String foot;

    public String getHead(){
        return this.head;
    }

    public void setHead(String head){
        this.head = head;
    }
    public String getBody(){
        return this.body;
    }

    public void setBody(String body){
        this.body = body;
    }
    public String getFoot(){
        return this.foot;
    }

    public void setFoot(String foot){
        this.foot = foot;
    }

}
