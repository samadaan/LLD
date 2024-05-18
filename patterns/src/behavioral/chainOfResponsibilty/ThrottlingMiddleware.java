package behavioral.chainOfResponsibilty;

public class ThrottlingMiddleware extends Middleware{

    private int requestsPerMinute;
    private long currentTime;
    private int request;

    public ThrottlingMiddleware(int requestsPerMinute){
        this.requestsPerMinute=requestsPerMinute;
        this.currentTime=System.currentTimeMillis();
    }
    @Override
    public boolean check(String email, String password) {
        if(System.currentTimeMillis()>currentTime+60000){
            request=0;
            currentTime=System.currentTimeMillis();
        }
        request++;
        if(request>requestsPerMinute){
            System.out.println("Request Limit Exceeded");
            return false;
        }
        return checkNext(email, password);
    }
}
