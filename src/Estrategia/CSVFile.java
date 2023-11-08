package Estrategia;

import java.util.ArrayList;

public class CSVFile {
    private final ArrayList<String> headers;
    private final ArrayList<ArrayList<String>> records;

    public CSVFile(ArrayList<String> headers, ArrayList<ArrayList<String>> records) {
        this.headers = headers;
        this.records = records;
    }

    public ArrayList<String> getHeaders() {
        return headers;
    }
    public ArrayList<String> getTitles() {
        ArrayList<String> titles = new ArrayList<>();
        for (ArrayList<String> record : getRecords()) {
            titles.add(record.get(0));
        }
        return titles;
    }

    public String getValue(int i, int j) {
        return records.get(i).get(j);
    }

    public int getSize() {
        int lines = 0;
        for (ArrayList<String> row : this.records)
            lines++;
        return lines;
    }

    public ArrayList<ArrayList<String>> getRecords() {
        return records;
    }

    public void printTitles() {
        int i = 0;
        for (ArrayList<String> record : getRecords()) {
            System.out.println(i + ". " + record.get(0));
            i++;
        }
        System.out.println();
    }

    public String getArtistForTitle(String selectedTitle) {
        for (ArrayList<String> record : getRecords()) {
            String title = record.get(0);
            if (title.equals(selectedTitle)) {
                return record.get(1); // Suponiendo que el artista está en la segunda columna
            }
        }
        return "Artista no encontrado";
    }

    public void printAllInfo(String selectedTitle) {
        for(ArrayList<String> record : getRecords()) {
            String title = record.get(0);
            if (title.equals(selectedTitle)) {
                for (String value : record) {
                    System.out.print(getHeaders().get(record.indexOf(value)) + ": ");
                    System.out.println(value);
                }
            }
        }
    }

}
