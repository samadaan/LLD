package questions.parkinglot;

import questions.parkinglot.models.ParkingLot;

public class OutputPrinter {
    public void welcome(){
        printWithNewLine("Welcome");
    }
    public void end(){
        printWithNewLine("End");
    }
    public void notFound(){
        printWithNewLine("Not found");
    }
    public void printWithNewLine(String msg){
        System.out.println(msg);
    }
}
