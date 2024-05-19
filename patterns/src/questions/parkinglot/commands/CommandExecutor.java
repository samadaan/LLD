package questions.parkinglot.commands;

import questions.parkinglot.OutputPrinter;
import questions.parkinglot.models.Command;
import questions.parkinglot.models.ParkingLot;
import questions.parkinglot.service.ParkingLotService;

public abstract class CommandExecutor {

    protected ParkingLotService parkingLotService;
    protected OutputPrinter outputPrinter;

    public CommandExecutor(ParkingLotService parkingLotService, OutputPrinter printer){
        this.parkingLotService=parkingLotService;
        this.outputPrinter=printer;
    }

    public abstract boolean validate(Command command);

    public abstract void execute(Command command);

}
