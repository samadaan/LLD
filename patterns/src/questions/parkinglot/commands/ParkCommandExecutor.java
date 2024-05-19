package questions.parkinglot.commands;

import questions.parkinglot.OutputPrinter;
import questions.parkinglot.exception.NoFreeSlotAvailableException;
import questions.parkinglot.models.Command;
import questions.parkinglot.models.Vehicle;
import questions.parkinglot.service.ParkingLotService;

public class ParkCommandExecutor extends CommandExecutor{

    public static String COMMAND_NAME = "park";
    public ParkCommandExecutor(ParkingLotService parkingLotService, OutputPrinter printer) {
        super(parkingLotService, printer);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    public void execute(Command command) {

        Vehicle vehicle=new Vehicle(command.getParams().get(0), command.getParams().get(1));
        try{
            int slot = parkingLotService.park(vehicle);
            outputPrinter.printWithNewLine("Allocated Slot" + slot);
        }catch(NoFreeSlotAvailableException exception){
            outputPrinter.printWithNewLine("Parking Lot full");
        }

    }
}
