package questions.parkinglot.mode;

import questions.parkinglot.OutputPrinter;
import questions.parkinglot.commands.CommandExecutor;
import questions.parkinglot.commands.CommandExecutorFactory;
import questions.parkinglot.exception.InvalidCommandException;
import questions.parkinglot.models.Command;

import java.io.IOException;

public abstract class Mode {
    protected CommandExecutorFactory commandExecutorFactory;
    protected OutputPrinter outputPrinter;

    public Mode(
            final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter) {
        this.commandExecutorFactory = commandExecutorFactory;
        this.outputPrinter = outputPrinter;
    }

    protected void processCommand(Command command){
        CommandExecutor commandExecutor= commandExecutorFactory.getCommandExecutor(command);
        if(commandExecutor.validate(command)){
            commandExecutor.execute(command);
        }else{
            throw new InvalidCommandException();
        }
    }

    public abstract void process() throws IOException;


}
