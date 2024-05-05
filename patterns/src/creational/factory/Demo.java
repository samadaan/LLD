package creational.factory;

public class Demo {
    public static void main(String[] args) {
        Vehicle vehicle=VehicleFactory.getInstance(4);
        System.out.println(vehicle.display());

        Vehicle vehicle1=VehicleFactory.getInstance(8);
        System.out.println(vehicle1.display());

    }
}
