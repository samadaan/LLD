package questions.parkinglot.models;

public class Vehicle {
    private String registrationNo;
    private String color;

    public Vehicle(String registrationNo, String color){
        this.registrationNo=registrationNo;
        this.color=color;
    }
    public String getRegistrationNo(){
        return this.registrationNo;
    }
    public String getColor(){
        return this.color;
    }
}
