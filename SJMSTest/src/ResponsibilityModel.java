public class ResponsibilityModel {

    //责任链模式
    //使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，
    //并沿着这条链传递该请求，直到有一个对象处理它为止。
    //这一模式的想法是，给多个对象处理一个请求的机会，从而解耦发送者和接受者.
    //    1.有多个的对象可以处理一个请求，哪个对象处理该请求运行时刻自动确定。
    //    2.在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。
    //    3.可处理一个请求的对象集合应被动态指定。

    public static void main(String[] args){
        RequestHandle hr = new HRRequestHandle();
        RequestHandle pm = new PMRequestHandle(hr);
        RequestHandle tl = new TLRequestHandle(pm);

        //离职请求
        Request r1 = new DimissionRequest();
        tl.handleRequest(r1);

        //加薪请求
        Request r2 = new AddMoneyRequest();
        tl.handleRequest(r2);

        //请假请求
        Request r3 = new LeaveRequest();
        tl.handleRequest(r3);
    }
}

class Request{

}

class DimissionRequest extends Request{

}

class AddMoneyRequest extends Request{

}

class LeaveRequest extends Request{

}

interface RequestHandle{
    void handleRequest(Request request);
}

class HRRequestHandle implements RequestHandle{

    @Override
    public void handleRequest(Request request) {
        if(request instanceof DimissionRequest){
            System.out.println("离职，人事审批");
        }

        System.out.println("请求完毕");
    }
}

class PMRequestHandle implements RequestHandle{

    RequestHandle rh;

    public PMRequestHandle(RequestHandle rh){
        this.rh = rh;
    }

    @Override
    public void handleRequest(Request request) {
        if(request instanceof AddMoneyRequest){
            System.out.println("加薪，项目经理审批");
        }else {
            rh.handleRequest(request);
        }
    }
}

class TLRequestHandle implements RequestHandle{

    RequestHandle rh;

    public TLRequestHandle(RequestHandle rh){
        this.rh = rh;
    }

    @Override
    public void handleRequest(Request request) {
        if(request instanceof LeaveRequest){
            System.out.println("请假，项目组长审批");
        }else {
            rh.handleRequest(request);
        }
    }
}