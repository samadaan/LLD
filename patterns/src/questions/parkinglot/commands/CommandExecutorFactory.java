package questions.parkinglot.commands;

import questions.parkinglot.OutputPrinter;
import questions.parkinglot.exception.InvalidCommandException;
import questions.parkinglot.models.Command;
import questions.parkinglot.service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    private Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(ParkingLotService parkingLotService) {
        OutputPrinter outputPrinter = new OutputPrinter();
        commands.put(CreateParkingLotCommandExecutor.COMMAND_NAME, new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter));
        commands.put(ColorToRegNumberCommandExecutor.COMMAND_NAME, new ColorToRegNumberCommandExecutor(parkingLotService, outputPrinter));
        commands.put(ColorToSlotNumberCommandExecutor.COMMAND_NAME, new ColorToSlotNumberCommandExecutor(parkingLotService, outputPrinter));
        commands.put(ExitCommandExecutor.COMMAND_NAME, new ExitCommandExecutor(parkingLotService, outputPrinter));
        commands.put(LeaveCommandExecutor.COMMAND_NAME, new LeaveCommandExecutor(parkingLotService, outputPrinter));
        commands.put(ParkCommandExecutor.COMMAND_NAME, new ParkCommandExecutor(parkingLotService, outputPrinter));
        commands.put(SlotForRegNumberCommandExecutor.COMMAND_NAME, new SlotForRegNumberCommandExecutor(parkingLotService, outputPrinter));
        commands.put(StatusCommandExecutor.COMMAND_NAME, new StatusCommandExecutor(parkingLotService, outputPrinter));
    }

    public CommandExecutor getCommandExecutor(Command command) {
        CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new InvalidCommandException();
        }
        return commandExecutor;
    }

}
