import Plantilla.*;

import javax.sound.midi.SysexMessage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Format;
import java.util.ArrayList;
import java.util.Scanner;

public class MainPlantilla {

    public static void main(String[] args) {
        // Ruta al archivo CSV
        String filePath = "jazz_classics.csv";
        System.out.println("Reading from: " + filePath);

        // Inicializar BufferedReader
        StringBuilder csvContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                csvContent.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File not found: " + filePath);
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("IO error");
            System.exit(1);
        }
        // Convertir StringBuilder a String
        String csvContentString = csvContent.toString();
        String[] lines = csvContentString.split("\n");

        // Ahora lo tenemos en CSVFile Parseado
        CSVParser csvParser = new CSVParser(lines);
        csvParser.parse();
        CSVFile csvFile = csvParser.getCSVFile();
        csvFile.printTitles();

        // Llamo a factory de formateo
        int out = 1;
        while(out != 0) {
            System.out.print("Con que tipo de formateo deseas ver la informacion?: ");
            System.out.println();
            System.out.println("1. short");
            System.out.println("2. long");
            Scanner sc = new Scanner(System.in);
            String option = String.valueOf(sc.nextLine());
            switch(option) {
                case "1":
                    FormattedInfo f1 = new ShortFormat();
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
            System.out.println("Deseas salir? (1 para seguir, 0 para salir)");
            out = Integer.parseInt(sc.nextLine());
        }



    }
}
