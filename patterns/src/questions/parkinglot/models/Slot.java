package questions.parkinglot.models;

public class Slot {
    private Vehicle vehicle;
    private Integer slotNumber;

    public Slot(int slotNumber){
        this.slotNumber=slotNumber;
    }

    public Integer getSlotNumber(){
        return this.slotNumber;
    }
    public void assignVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
    }
    public void unAssignVehicle(){
        this.vehicle=null;
    }
    public boolean isSlotFree(){
        return vehicle==null?true:false;
    }
    public Vehicle getVehicle(){
        return this.vehicle;
    }
}
