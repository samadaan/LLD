package questions.parkinglot;

import questions.parkinglot.commands.CommandExecutorFactory;
import questions.parkinglot.mode.FileMode;
import questions.parkinglot.mode.InteractiveMode;
import questions.parkinglot.service.ParkingLotService;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {

        OutputPrinter outputPrinter=new OutputPrinter();
        ParkingLotService parkingLotService=new ParkingLotService();
        CommandExecutorFactory executorFactory=new CommandExecutorFactory(parkingLotService);


        if (isInteractiveMode(args)) {
            new InteractiveMode(executorFactory, outputPrinter).process();
        } else if (isFileInputMode(args)) {
            new FileMode(executorFactory, outputPrinter, args[0]).process();
        } else {
            throw new RuntimeException("Exception in Mode Selection");
        }
    }

    private static boolean isFileInputMode(final String[] args) {
        return args.length == 1;
    }

    private static boolean isInteractiveMode(final String[] args) {
        return args.length == 0;
    }


}
