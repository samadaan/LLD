package questions.parkinglot.commands;

import questions.parkinglot.OutputPrinter;
import questions.parkinglot.models.Command;
import questions.parkinglot.service.ParkingLotService;

public class ExitCommandExecutor extends CommandExecutor{

    public static String COMMAND_NAME = "exit";
    public ExitCommandExecutor(ParkingLotService parkingLotService, OutputPrinter printer) {
        super(parkingLotService, printer);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {
        outputPrinter.end();
    }
}
