package questions.parkinglot.models;

import questions.parkinglot.exception.InvalidSlotException;
import questions.parkinglot.exception.ParkingLotException;
import questions.parkinglot.exception.SlotAlreadyOccupiedException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static int MAX_CAPACITY = 100000;
    private int capacity;
    private Map<Integer, Slot> slots;

    public ParkingLot(int capacity) {
        if (capacity > MAX_CAPACITY || capacity <= 0) {
            throw new ParkingLotException("Invalid Capacity given for parking lot");
        }
        this.capacity = capacity;
        this.slots = new HashMap<>();
    }

    public Map<Integer, Slot> getSlots() {
        return this.slots;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private Slot getSlot(int slotNumber) {
        if(slotNumber>getCapacity() || slotNumber<=0){
            throw new InvalidSlotException();
        }
        Map<Integer, Slot> allSlots=getSlots();
        if(!allSlots.containsKey(slotNumber)){
            allSlots.put(slotNumber, new Slot(slotNumber));
        }
        return allSlots.get(slotNumber);
    }

    public Slot park(Vehicle vehicle, int slotNumber){
        Slot slot=getSlot(slotNumber);
        if(!slot.isSlotFree()){
            throw new SlotAlreadyOccupiedException();
        }
        slot.assignVehicle(vehicle);
        return slot;
    }

    public Slot makeFree(int slotNumber){
        Slot slot=getSlot(slotNumber);
        slot.unAssignVehicle();
        return slot;
    }


}