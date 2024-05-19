package questions.parkinglot.commands;

import questions.parkinglot.OutputPrinter;
import questions.parkinglot.models.Command;
import questions.parkinglot.models.Slot;
import questions.parkinglot.service.ParkingLotService;

import java.util.List;
import java.util.stream.Collectors;

public class ColorToSlotNumberCommandExecutor extends CommandExecutor{

    public static String COMMAND_NAME="slot_numbers_for_cars_with_colour";
    public ColorToSlotNumberCommandExecutor(ParkingLotService parkingLotService, OutputPrinter printer) {
        super(parkingLotService, printer);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size()==1;
    }

    @Override
    public void execute(Command command) {
        List<Slot> slotsForColor=parkingLotService.getSlotsForColor(command.getParams().get(0));
        if(slotsForColor.isEmpty()){
            outputPrinter.notFound();
        }else{
            String result=slotsForColor.stream()
                    .map(slot -> slot.getSlotNumber().toString()).collect(Collectors.joining(", "));
            outputPrinter.printWithNewLine(result);
        }

    }
}
