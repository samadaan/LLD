package behavioral.chainOfResponsibilty;

public class UserExistsMiddleware extends Middleware{
    private Server server;
    public UserExistsMiddleware(Server server){
        this.server=server;
    }

    @Override
    public boolean check(String name, String password){
        if(!server.hasEmail(name)){
            System.out.println("email not registered");
            return false;
        }
        if(!server.isValidPassword(name, password)){
            System.out.println("passeword not correct");
            return false;
        }
        return checkNext(name, password);
    }
}
