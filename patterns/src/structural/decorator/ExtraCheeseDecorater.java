package structural.decorator;

public class ExtraCheeseDecorater extends BaseDecorater{

    public ExtraCheeseDecorater(Pizza wrappee) {
        super(wrappee);
    }
    @Override
    public int cost() {
        return wrappee.cost() + 30;
    }
}
