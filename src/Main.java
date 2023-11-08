import Estrategia.CSVFile;
import Estrategia.CSVParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
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

    }
}
