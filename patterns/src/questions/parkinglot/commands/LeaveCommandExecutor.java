package questions.parkinglot.commands;

import questions.parkinglot.OutputPrinter;
import questions.parkinglot.models.Command;
import questions.parkinglot.service.ParkingLotService;
import questions.parkinglot.validator.IntegerValidator;

import java.util.List;

public class LeaveCommandExecutor extends CommandExecutor{

    public static String COMMAND_NAME = "leave";
    public LeaveCommandExecutor(ParkingLotService parkingLotService, OutputPrinter printer) {
        super(parkingLotService, printer);
    }

    @Override
    public boolean validate(Command command) {
        final List<String> params = command.getParams();
        if (params.size() != 1) {
            return false;
        }
        return IntegerValidator.isInteger(params.get(0));
    }

    @Override
    public void execute(Command command) {
        final int slotNum = Integer.parseInt(command.getParams().get(0));
        parkingLotService.makeSlotFree(slotNum);
        outputPrinter.printWithNewLine("Slot number " + slotNum + " is free");
    }
}
