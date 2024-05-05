package creational.prototype;




import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Truck.TruckBuilder truckBuilder = new Truck.TruckBuilder();
        Truck truck = truckBuilder.setIsFragile(false)
                .setEligiblePackages(Arrays.asList("A", "B"))
                .setTypeOfTruck("MID").setCompany("Mahindra").setTyres(8)
                .setRc("RC").build();

        Truck otherObj=truck.clone();
        System.out.println(truck);
        System.out.println(otherObj);
        System.out.println(otherObj.typeOfTruck);


    }
}
