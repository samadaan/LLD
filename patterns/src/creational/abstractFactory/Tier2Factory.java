package creational.abstractFactory;

public class Tier2Factory extends UniversityFactory{

    @Override
    public AdmitCard getAdmitCard(String course) {
        switch (course){
            case "CSE":
                return new VITAdmitCard();
            case "IT":
                return new ManipalAdmitCard();
        }
        return null;
    }
}
