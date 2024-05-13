package structural.adapter;

public class RoundHole {
    private int radius;


    public RoundHole(int radius){
        this.radius=radius;
    }
    public int getRadius(){
        return this.radius;

    }
    public boolean fits(RoundPeg roundPeg){
        return this.radius >= roundPeg.getRadius();
    }
}
