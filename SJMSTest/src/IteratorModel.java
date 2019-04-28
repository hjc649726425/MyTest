import java.lang.Object;
public class IteratorModel {

    //迭代器模式
    // 给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。

    //    1.访问一个聚合对象的内容而无需暴露它的内部表示。
    //    2.支持对聚合对象的多种遍历。
    //    3.为遍历不同的聚合结构提供一个统一的接口(即,支持多态迭代)。

    public static void main(String[] args){
        MyList myList = new MyListImpl();
        myList.add(1);
        myList.add(2);
        myList.add("a");
        myList.add("b");

        Iteator iteator = myList.iteator();
        while (iteator.hasNext()){
            System.out.println(iteator.next());
        }
    }
}

interface Iteator{
    Object next();
    void first();
    void last();
    boolean hasNext();
}

class IteatorImpl implements Iteator{

    private MyList list;
    private int index;

    public IteatorImpl(MyList list){
        this.list = list;
        index = 0;
    }

    @Override
    public Object next() {
        Object obj = (Object) list.get(index);
        index ++;
        return obj;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void last() {
        index = list.getSize();
    }

    @Override
    public boolean hasNext() {
        return index < list.getSize();
    }
}

interface MyList{
    Object get(int index);
    int getSize();
    void add(Object obj);
    Iteator iteator();
}

class MyListImpl implements MyList{

    private Object[] list;
    private int index;
    private int size;

    public MyListImpl(){
        list = new Object[100];
        index = 0;
        size = 0;
    }

    @Override
    public Iteator iteator(){
        return  new IteatorImpl(this);
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void add(Object obj) {
        list[index++] = obj;
        size ++;
    }
}




