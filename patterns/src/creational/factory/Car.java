package creational.factory;

public class Car extends Vehicle{
    @Override
    public void createVehicle() {
        tyresList.add(new MrfTyre());
    }
    @Override
    public String display(){
        return "Car "+tyresList.toString();
    }

}
