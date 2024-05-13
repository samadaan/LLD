package structural.decorator;

public class ExtraOlivesDecorater extends BaseDecorater{

    public ExtraOlivesDecorater(Pizza wrappee) {
        super(wrappee);
    }

    @Override
    public int cost() {
        return wrappee.cost() + 20;
    }
}
