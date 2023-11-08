package Estrategia;

public class ContextFormato {

    public ContextFormato(String option,CSVFile csvFile) {
        switch(option) {
            case "1":
                Estrategia.FormattedInfo f1 = new ShortFormat();
                f1.display(csvFile);
                break;
            case "2":
                FormattedInfo f2 = new LargeFormat();
                f2.display(csvFile);
                break;
            default:
                System.out.println("Opcion no valida");
                System.exit(1);
        }

    }

}
