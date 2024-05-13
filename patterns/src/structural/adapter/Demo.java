package structural.adapter;

public class Demo {

    public static void main(String[] args) {
        SquarePeg smallSquarePeg=new SquarePeg(5);
        SquarePeg largeSquarePeg=new SquarePeg(10);

        RoundHole roundHole=new RoundHole(5);
        System.out.println(roundHole.fits(new SquarePegAdapter(smallSquarePeg)));
        System.out.println(roundHole.fits(new SquarePegAdapter(largeSquarePeg)));
    }



}
