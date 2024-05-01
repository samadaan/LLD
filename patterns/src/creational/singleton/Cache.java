package creational.singleton;

public class Cache {

    private static volatile Cache instance;

    private Cache(){};

    public static Cache getInstance(){
        if(instance==null){
            synchronized (Cache.class){
                if(instance==null){
                    instance = new Cache();
                }
            }
        }
        return instance;
    }

    public String dummy(){
        return "DUMMY";
    }
}
