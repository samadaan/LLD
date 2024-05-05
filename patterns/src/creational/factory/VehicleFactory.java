package creational.factory;

public class VehicleFactory {
    public static Vehicle getInstance(int tyres){
        switch(tyres){
            case 4:
                return new Car();
            default:
                return new Truck();
        }
    }
}
