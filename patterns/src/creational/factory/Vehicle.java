package creational.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    List<Tyre> tyresList;

    public Vehicle(){
        tyresList=new ArrayList<>();
        this.createVehicle();
    }
    public abstract void createVehicle();
    public abstract String display();
}
