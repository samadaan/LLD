package questions.parkinglot.commands;

import questions.parkinglot.OutputPrinter;
import questions.parkinglot.models.Command;
import questions.parkinglot.models.Slot;
import questions.parkinglot.service.ParkingLotService;

import java.util.List;
import java.util.stream.Collectors;

public class ColorToRegNumberCommandExecutor extends CommandExecutor{

    public static String COMMAND_NAME="registration_numbers_for_cars_with_colour";
    public ColorToRegNumberCommandExecutor(ParkingLotService parkingLotService, OutputPrinter printer) {
        super(parkingLotService, printer);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size()==1;
    }

    @Override
    public void execute(Command command) {
        List<Slot> allSlots=parkingLotService.getSlotsForColor(command.getParams().get(0));
        if(allSlots.isEmpty()){
            outputPrinter.notFound();
        }else{
            String result=allSlots.stream().map(slot -> slot.getVehicle().getColor()).collect(Collectors.joining(", "));
            outputPrinter.printWithNewLine(result);
        }

    }
}
