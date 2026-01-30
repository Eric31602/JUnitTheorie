package be.vdab;

public class StandaardAfwijking {

    void main() {

        var keuze = Integer.parseInt(IO.readln(
                "1=personen.csv, 2=personen.xml:"));
        while (keuze != 1 && keuze != 2) {
            IO.print("Verkeerd keuze, probeer opnieuw:");
            keuze = Integer.parseInt(IO.readln());
        }
        PersoonRepository repository = keuze == 1 ?
                new CsvPersoonRepository() :
                new XmlPersoonRepository();
        var service = new PersoonService(repository);
        try {
            IO.println(service.standaardAfwijkingWeddes());
        } catch (RepositoryException ex) {
            IO.println("Kan personen niet lezen.");
            ex.printStackTrace(System.err);
        }
    }
}

