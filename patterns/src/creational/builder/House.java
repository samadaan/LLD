package creational.builder;

public class House {
    private int doors;
    private String address;
    private boolean furnished;

    private House(){

    }

    private House(HouseBuilder houseBuilder){
        this.doors=houseBuilder.doors;
        this.furnished=houseBuilder.furnished;
        this.address=houseBuilder.address;
    }

    static class HouseBuilder{

        private int doors;
        private String address;
        private boolean furnished;

        public HouseBuilder setDoors(int doors){
            this.doors=doors;
            return this;
        }
        public HouseBuilder setAddress(String address){
            this.address=address;
            return this;
        }
        public HouseBuilder setFurnished(boolean furnished){
            this.furnished=furnished;
            return this;
        }
        public House build(){
            return new House(this);
        }
    }

    public String toString(){
        return " "+this.address+" "+this.furnished+" "+this.doors;
    }

}
