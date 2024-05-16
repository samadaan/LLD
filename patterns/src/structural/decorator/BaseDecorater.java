package structural.decorator;

public class BaseDecorater implements Pizza{

    Pizza wrappee;
    public BaseDecorater(Pizza wrappee){
        this.wrappee=wrappee;
    }
    @Override
    public int cost() {
        return wrappee.cost();
    }
}
