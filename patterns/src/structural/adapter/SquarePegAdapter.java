package structural.adapter;

public class SquarePegAdapter implements RoundPeg {

    private SquarePeg squarePeg;
    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg=squarePeg;
    }

    @Override
    public int getRadius() {
        int ans= (int)(squarePeg.getWidth()*Math.sqrt(2.0)/2.0);
        System.out.println(ans);
        return ans;
    }
}
