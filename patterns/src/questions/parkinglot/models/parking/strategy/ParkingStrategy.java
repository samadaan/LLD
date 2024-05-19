package questions.parkinglot.models.parking.strategy;

public interface ParkingStrategy {
    void addSlot(int slot);
    void removeSlot(int slot);
    int getNextSlot();
}
