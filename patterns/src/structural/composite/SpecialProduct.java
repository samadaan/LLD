package structural.composite;

public class SpecialProduct extends Product{
    public SpecialProduct(int price) {
        super(price);
    }
    @Override
    public int cost() {
        return super.cost() * 2;
    }
}
