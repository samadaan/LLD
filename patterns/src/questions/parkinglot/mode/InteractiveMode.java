package questions.parkinglot.mode;

import questions.parkinglot.OutputPrinter;
import questions.parkinglot.commands.CommandExecutorFactory;
import questions.parkinglot.commands.ExitCommandExecutor;
import questions.parkinglot.models.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode{
    public InteractiveMode(CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter) {
        super(commandExecutorFactory, outputPrinter);
    }

    @Override
    public void process() throws IOException {
        outputPrinter.printWithNewLine("Welcome");
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String string= reader.readLine();
            Command command=new Command(string);
            processCommand(command);
            if(command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)){
                break;
            }
        }

    }
}
