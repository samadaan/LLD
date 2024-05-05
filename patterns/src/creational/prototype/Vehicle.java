package creational.prototype;

import java.util.List;

public class Vehicle<T extends Vehicle<T>> implements VehiclePrototype<T>{

    private String rc;
    private int tyres;
    private String company;

    protected Vehicle(Vehicle other){
        this.rc=other.rc;
        this.tyres=other.tyres;
        this.company=other.company;
    }

    protected Vehicle(VehicleBuilder other){
        this.rc=other.rc;
        this.tyres=other.tyres;
        this.company=other.company;

    }

    static class VehicleBuilder<T extends VehicleBuilder>{
        private String rc;
        private int tyres;
        private String company;

        T self() {
            return (T) this;
        }

        public T setRc(String rc){
            this.rc=rc;
            return self();
        }
        public T setTyres(int tyres){
            this.tyres=tyres;
            return self();
        }
        public T setCompany(String company){
            this.company=company;
            return self();
        }
        public Vehicle build(){
            return new Vehicle(this);
        }
    }

    @Override
    public T clone() {
        return (T) new Vehicle(this);
    }
}
