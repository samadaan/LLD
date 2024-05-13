package structural.decorator;

public class Demo {
    public static void main(String[] args) {
        Pizza paradise=new Paradise();
        Pizza extraCheeseParadise=new ExtraCheeseDecorater(paradise);
        Pizza extraOlivesExtraCheeseParaidise=new ExtraOlivesDecorater(extraCheeseParadise);
        System.out.println(extraOlivesExtraCheeseParaidise.cost());
    }
}
