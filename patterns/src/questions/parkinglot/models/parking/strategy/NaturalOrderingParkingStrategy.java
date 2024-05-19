package questions.parkinglot.models.parking.strategy;

import questions.parkinglot.exception.NoFreeSlotAvailableException;

import java.util.TreeSet;

public class NaturalOrderingParkingStrategy implements ParkingStrategy{

    TreeSet<Integer> slotTreeSet;

    public NaturalOrderingParkingStrategy(){
        slotTreeSet=new TreeSet<>();
    }
    @Override
    public void addSlot(int slot) {
        this.slotTreeSet.add(slot);
    }

    @Override
    public void removeSlot(int slot) {
        this.slotTreeSet.remove(slot);
    }

    @Override
    public int getNextSlot() {
        if(this.slotTreeSet.isEmpty()){
            throw new NoFreeSlotAvailableException();
        }
        return this.slotTreeSet.first();
    }
}
