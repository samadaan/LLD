package creational.abstractFactory;

public abstract class UniversityFactory {

    public static int cutoff=10;

    public static UniversityFactory getUniversityFactory(int score){
        if(score>cutoff){
            return new Tier1Factory();
        }
        return new Tier2Factory();
    }
    public abstract AdmitCard getAdmitCard(String course);

}
