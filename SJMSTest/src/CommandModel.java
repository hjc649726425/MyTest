public class CommandModel {

    //命令模式  123
    //  将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤消的操作。

    //    1.抽象出待执行的动作以参数化某对象。
    //    2.在不同的时刻指定、排列和执行请求。
    //    3.支持取消操作。
    //    4.支持修改日志，这样当系统崩溃时，这*修改可以被重做一遍。
    //    5.用构建在原语操作上的高层操作构造一个系统。

    public static void main(String[] args){
        Receiver receiver = new Receiver(); //命令请求者
        Invoke invoke = new Invoke();       //命令实际执行者
        Command command = new CommandImpl(receiver);  //命令

        invoke.setCommand(command);
        invoke.execute();
    }
}

class Receiver{
    public void request(){
        System.out.println("这是Receiver类");
    }
}

abstract class Command{
    protected Receiver receiver;

    public Command(Receiver receiver){
        this.receiver = receiver;
    }

    public abstract void  execute();
}

class CommandImpl extends Command{

    public CommandImpl(Receiver receiver){
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.request();
    }
}

class Invoke{
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void execute(){
        command.execute();
    }
}
