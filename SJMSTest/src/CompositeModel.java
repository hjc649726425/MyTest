import java.util.ArrayList;
import java.util.List;

public class CompositeModel {

    //组合模式
    //将对象组合成树形结构以表示"部分-整体"的层次结构。"Composite使得用户对单个对象和组合对象的使用具有一致性。"
    //    1.你想表示对象的部分-整体层次结构。
    //    2.你希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。

    public static void main(String[] args){
        Employer pm =  new ProjectManager("项目经理");
        Employer pa = new ProjectAssistant("项目助理");
        Employer pro1 = new Programmer("程序员1");
        Employer pro2 = new Programmer("程序员2");

        pm.add(pa);
        pm.add(pro1);
        pm.add(pro2);

        List<Employer> list = pm.getEmploys();
        for (Employer emp:list) {
            System.out.println(emp.getName());
        }
    }
}

abstract class Employer {
    private String name;
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void add(Employer employer);
    public abstract void delete(Employer employer);

    protected List employs;

    public void printInfo(){
        System.out.println(name);
    }

    public List getEmploys(){
        return employs;
    }
}

class Programmer extends Employer{

    public Programmer(String name){
        this.setName(name);
        employs = null;  //程序员，没有下属
    }

    @Override
    public void add(Employer employer) {

    }

    @Override
    public void delete(Employer employer) {

    }
}

class ProjectAssistant extends Employer{
    public ProjectAssistant(String name){
        this.setName(name);
        employs = null;  //项目助理，没有下属
    }

    @Override
    public void add(Employer employer) {

    }

    @Override
    public void delete(Employer employer) {

    }
}

class ProjectManager extends Employer{
    public ProjectManager(String name){
        this.setName(name);
        employs = new ArrayList();
    }

    @Override
    public void add(Employer employer) {
        employs.add(employer);
    }

    @Override
    public void delete(Employer employer) {
        employs.remove(employer);
    }
}
