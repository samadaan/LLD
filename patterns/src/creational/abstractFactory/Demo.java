package creational.abstractFactory;

public class Demo {
    public static void main(String[] args) {

        UniversityFactory factory=UniversityFactory.getUniversityFactory(101);

        AdmitCard admitCard1= factory.getAdmitCard("CSE");

        System.out.println(admitCard1.getCollegeName());





    }
}
