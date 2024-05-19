package questions.parkinglot.mode;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import questions.parkinglot.OutputPrinter;
import questions.parkinglot.commands.CommandExecutorFactory;
import questions.parkinglot.models.Command;

import java.io.*;

public class FileMode extends Mode{
    private String fileName;
    public FileMode(CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter, String fileName) {
        super(commandExecutorFactory, outputPrinter);
        this.fileName=fileName;
    }

    @Override
    public void process() throws IOException {
        File file=new File(fileName);
        BufferedReader bufferedReader;
        try{
            bufferedReader=new BufferedReader(new FileReader(file));
        }catch (FileNotFoundException e){
            outputPrinter.printWithNewLine("File not present");
            return;
        }
        String string= bufferedReader.readLine();
        while (string!=null){
            Command command=new Command(string);
            processCommand(command);
            string=bufferedReader.readLine();
        }
    }
}
