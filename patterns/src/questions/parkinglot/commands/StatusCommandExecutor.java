package questions.parkinglot.commands;

import questions.parkinglot.OutputPrinter;
import questions.parkinglot.models.Command;
import questions.parkinglot.models.Slot;
import questions.parkinglot.models.Vehicle;
import questions.parkinglot.service.ParkingLotService;

import java.util.List;

public class StatusCommandExecutor extends CommandExecutor{

    public static String COMMAND_NAME = "status";

    public StatusCommandExecutor(ParkingLotService parkingLotService, OutputPrinter printer) {
        super(parkingLotService, printer);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {
        final List<Slot> occupiedSlots = parkingLotService.getOccupiedSlots();

        if (occupiedSlots.isEmpty()) {
            outputPrinter.printWithNewLine("Empty Parking Lot");
            return;
        }
        for (Slot slot : occupiedSlots) {
            final Vehicle parkedCar = slot.getVehicle();
            final String slotNumber = slot.getSlotNumber().toString();

            outputPrinter.printWithNewLine(padString(slotNumber, 12)
                    + padString(parkedCar.getRegistrationNo(), 19) + parkedCar.getColor());
        }
    }
    private static String padString(final String word, final int length) {
        String newWord = word;
        for(int count = word.length(); count < length; count++) {
            newWord = newWord + " ";
        }
        return newWord;
    }
}
