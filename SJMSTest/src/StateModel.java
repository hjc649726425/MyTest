public class StateModel {

    //状态模式
    // 定义对象间的一种一对多的依赖关系,当一个对象的状态发生改变时,所有依赖于它的对象都得到通知并被自动更新。

    //    1.一个对象的行为取决于它的状态,并且它必须在运行时刻根据状态改变它的行为。
    //    2.一个操作中含有庞大的多分支的条件语句，且这些分支依赖于该对象的状态。

    public static void main(String[] args){
        ContextTest con = new ContextTest();
        con.setWeather(new SunShine());
        System.out.println(con.getWeatherMsg());

        ContextTest con2 = new ContextTest();
        con2.setWeather(new Rain());
        System.out.println(con2.getWeatherMsg());
    }
}

class ContextTest{
    private Weather weather;
    public void setWeather(Weather weather){
        this.weather = weather;
    }

    public Weather getWeather(){
        return this.weather;
    }

    public String getWeatherMsg(){
        return this.weather.getWeather();
    }
}

interface Weather{
    String getWeather();
}

class Rain implements Weather{

    @Override
    public String getWeather() {
        return "下雨";
    }
}

class SunShine implements Weather{

    @Override
    public String getWeather() {
        return "阳光";
    }
}