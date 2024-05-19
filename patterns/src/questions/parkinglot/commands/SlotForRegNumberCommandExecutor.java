package questions.parkinglot.commands;

import questions.parkinglot.OutputPrinter;
import questions.parkinglot.models.Command;
import questions.parkinglot.models.Slot;
import questions.parkinglot.service.ParkingLotService;

import java.util.List;
import java.util.Optional;

public class SlotForRegNumberCommandExecutor extends CommandExecutor{

    public static String COMMAND_NAME="slot_number_for_registration_number";
    public SlotForRegNumberCommandExecutor(ParkingLotService parkingLotService, OutputPrinter printer) {
        super(parkingLotService, printer);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
       List<Slot> occupiedSlots= parkingLotService.getOccupiedSlots();
       String regNumberToFind=command.getParams().get(0);
       Optional<Slot> foundSlot=occupiedSlots.stream().filter(slot -> slot.getVehicle().getRegistrationNo().equals(regNumberToFind)).findFirst();
       if(foundSlot.isPresent()){
           outputPrinter.printWithNewLine(foundSlot.get().getSlotNumber().toString());
       }else{
           outputPrinter.notFound();
       }

    }
}
