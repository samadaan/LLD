package creational.singleton;

public class Demo {

    public static void main(String[] args) {
        Cache cache=Cache.getInstance();
        System.out.println(cache.dummy());

    }
}
