package questions.parkinglot.service;

import questions.parkinglot.exception.ParkingLotException;
import questions.parkinglot.models.ParkingLot;
import questions.parkinglot.models.Slot;
import questions.parkinglot.models.Vehicle;
import questions.parkinglot.models.parking.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public void createParkingLot(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        if (this.parkingLot != null) {
            throw new ParkingLotException("Parking lot already exists");
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            parkingStrategy.addSlot(i);
        }
    }

    public Integer park(Vehicle vehicle) {
        validateParkingLotExists();
        int freeSlot = parkingStrategy.getNextSlot();
        parkingLot.park(vehicle, freeSlot);
        parkingStrategy.removeSlot(freeSlot);
        return freeSlot;
    }

    public void makeSlotFree(int slotNumber) {
        validateParkingLotExists();
        parkingLot.makeFree(slotNumber);
        parkingStrategy.addSlot(slotNumber);
    }

    public List<Slot> getOccupiedSlots() {
        validateParkingLotExists();
        List<Slot> occupiedSlotList = new ArrayList<>();
        Map<Integer, Slot> allSlots = parkingLot.getSlots();

        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            if (allSlots.containsKey(i)) {
                Slot slot = allSlots.get(i);
                if (!slot.isSlotFree()) {
                    occupiedSlotList.add(slot);
                }
            }
        }
        return occupiedSlotList;
    }

    public List<Slot> getSlotsForColor(String color) {
        List<Slot> slotList = getOccupiedSlots();
        return slotList.stream()
                .filter(slot -> slot.getVehicle().getColor().equals(color)).collect(Collectors.toList());
    }

    private void validateParkingLotExists() {
        if (parkingLot == null) {
            throw new ParkingLotException("Parking lot does not exists to park");
        }
    }
}
