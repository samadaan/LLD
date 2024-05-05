package creational.factory;

public class Truck extends Vehicle{
    @Override
    public void createVehicle() {
        tyresList.add(new ApolloTyre());
    }
    @Override
    public String display(){
        return "Truck "+tyresList.toString();
    }
}
