package structural.composite;

public class Demo {

    public static void main(String[] args) {
        Product product=new Product(10);
        SpecialProduct specialProduct=new SpecialProduct(200);
        Box insideBox=new Box();
        insideBox.addPackage(product);
        insideBox.addPackage(specialProduct);
        Box outsideBox=new Box();
        outsideBox.addPackage(new Product(20));
        outsideBox.addPackage(new SpecialProduct(400));
        outsideBox.addPackage(insideBox);
        System.out.println(outsideBox.cost());
        System.out.println(insideBox.cost());
    }
}
