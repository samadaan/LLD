package creational.builder;

public class Demo {
    public static void main(String[] args) {

        House house=new House.HouseBuilder().setAddress("Okayayy").setDoors(4).setFurnished(true).build();
        System.out.println(house);
    }
}
