package creational.abstractFactory;

public class Tier1Factory extends UniversityFactory {

    @Override
    public AdmitCard getAdmitCard(String course) {
        switch (course){
            case "CSE":
                return new IITAdmitCard();
            case "IT":
                return new NITAdmitCard();
        }
        return null;
    }
}
