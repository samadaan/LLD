package creational.prototype;

import creational.singleton.Cache;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.ArrayList;
import java.util.List;


public class Truck extends Vehicle<Truck>{

    public String typeOfTruck;
    public List<String> eligiblePackages;
    public Boolean isFragile;


    private Truck(Truck other){
        super(other);
        this.typeOfTruck=other.typeOfTruck;
        this.eligiblePackages=new ArrayList<>(other.eligiblePackages);
        this.isFragile= other.isFragile;;
    }
    private Truck(TruckBuilder other){
        super(other);
        this.typeOfTruck=other.typeOfTruck;
        this.eligiblePackages=new ArrayList<>(other.eligiblePackages);
        this.isFragile= other.isFragile;;
    }

    public static class TruckBuilder extends Vehicle.VehicleBuilder<TruckBuilder>{
        private String typeOfTruck;
        private List<String> eligiblePackages;
        protected Boolean isFragile;

        public TruckBuilder setTypeOfTruck(String typeOfTruck){
            this.typeOfTruck=typeOfTruck;
            return  this;
        }
        public TruckBuilder setEligiblePackages(List<String> eligiblePackages){
            this.eligiblePackages = new ArrayList<>(eligiblePackages);
            return  this;
        }
        public TruckBuilder setIsFragile(Boolean isFragile){
            this.isFragile=isFragile;
            return  this;
        }
        public Truck build(){
            return new Truck(this);
        }
    }

    @Override
    public Truck clone() {
        return new Truck(this);
    }
}
