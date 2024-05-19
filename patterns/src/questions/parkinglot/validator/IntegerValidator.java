package questions.parkinglot.validator;

public class IntegerValidator {

    public static boolean isInteger(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(NumberFormatException numberFormatException){
            return false;
        }
    }
}
