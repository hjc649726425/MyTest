import java.util.ArrayList;
import java.util.List;

public class ObserverModel {

    //观察者模式
    //定义对象间的一种一对多的依赖关系,当一个对象的状态发生改变时,所有依赖于它的对象都得到通知并被自动更新。

    //    1.当一个抽象模型有两个方面,其中一个方面依赖于另一方面。
    //      将这二者封装的独立的对象中以使它们可以各自独立地改变和复用。
    //    2.当对一个对象的改变需要同时改变其它对象,而不知道具体有多少对象有待改变。
    //    3.当一个对象必须通知其它对象，而它又不能假定其它对象是谁。

    public static void main(String[] args){
        Policemen thPol = new TianHePolicemen();
        Policemen hpPol = new HuangPuPolicemen();

        Citizen hpC = new HuangPuCitizen(hpPol);
        hpC.sendMessage("unnormal");
        hpC.sendMessage("normal");

        Citizen thC = new HuangPuCitizen(thPol);
        thC.sendMessage("unnormal");
        thC.sendMessage("normal");
    }
}

abstract class Citizen{
    List pols;
    private String help = "normal";

    public void setHelp(String help){
        this.help = help;
    }

    public String getHelp(){
        return help;
    }

    abstract void sendMessage(String help);

    public void setPolicemen(){
        this.pols = new ArrayList();
    }

    public void register(Policemen pol){
        this.pols.add(pol);
    }

    public void unregister(Policemen pol){
        pols.remove(pol);
    }
}

interface Policemen{
    void action(Citizen citizen);
}

class HuangPuCitizen extends Citizen{

    public HuangPuCitizen(Policemen pol){
        setPolicemen();
        register(pol);
    }

    @Override
    void sendMessage(String help) {
        setHelp(help);
        for(int i = 0 ;i<pols.size();i++){
            Policemen pol = (Policemen) pols.get(i);
            pol.action(this);
        }
    }
}

class TianHeCitizen extends Citizen{

    public TianHeCitizen(Policemen pol){
        setPolicemen();
        register(pol);
    }

    @Override
    void sendMessage(String help) {
        setHelp(help);
        for(int i = 0 ;i<pols.size();i++){
            Policemen pol = (Policemen) pols.get(i);
            pol.action(this);
        }
    }
}

class HuangPuPolicemen implements Policemen{

    @Override
    public void action(Citizen citizen) {
        String help = citizen.getHelp();
        if(help.equals("normal")){
            System.out.println("一切正常，不用出动");
        }

        if(help.equals("unnormal")){
            System.out.println("有犯罪行为，黄埔警察出动");
        }
    }
}

class TianHePolicemen implements Policemen{

    @Override
    public void action(Citizen citizen) {
        String help = citizen.getHelp();
        if(help.equals("normal")){
            System.out.println("一切正常，不用出动");
        }

        if(help.equals("unnormal")){
            System.out.println("有犯罪行为，天河警察出动");
        }
    }
}



