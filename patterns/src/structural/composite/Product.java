package structural.composite;

public class Product implements Package{
    private int price;
    public Product(int price){
        this.price=price;
    }

    @Override
    public int cost() {
        return price;
    }
}
