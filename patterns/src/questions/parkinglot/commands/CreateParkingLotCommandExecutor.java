package questions.parkinglot.commands;

import questions.parkinglot.OutputPrinter;
import questions.parkinglot.models.Command;
import questions.parkinglot.models.ParkingLot;
import questions.parkinglot.models.parking.strategy.NaturalOrderingParkingStrategy;
import questions.parkinglot.service.ParkingLotService;
import questions.parkinglot.validator.IntegerValidator;

import java.util.List;

public class CreateParkingLotCommandExecutor extends CommandExecutor{
    public static final String COMMAND_NAME="create_parking_lot";

    public CreateParkingLotCommandExecutor(ParkingLotService parkingLotService, OutputPrinter printer) {
        super(parkingLotService, printer);
    }

    @Override
    public boolean validate(Command command) {
        List<String> params=command.getParams();
        if(params.size()!=1)return false;
        return IntegerValidator.isInteger(params.get(0));
    }

    @Override
    public void execute(Command command) {
        int parkingLotCapacity=Integer.parseInt(command.getParams().get(0));
        ParkingLot parkingLot=new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot, new NaturalOrderingParkingStrategy());
        outputPrinter.printWithNewLine("Crated a parking lot");
    }
}
