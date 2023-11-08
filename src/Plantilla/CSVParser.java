package Plantilla;

import java.util.ArrayList;
import java.util.Arrays;


public class CSVParser{
    public static final String SEPARATOR = ",";
    protected String[] data;
    private CSVFile csvFile;


    public CSVParser(String[] data) {
        this.data = data;
    }

    public void parse() {
        ArrayList<String> headers = new ArrayList<>(Arrays.asList(data[0].split(SEPARATOR)));
        ArrayList<ArrayList<String>> records =  new ArrayList<>();
        csvFile = new CSVFile(headers, records);
        for (int i = 1; i < data.length; i++) {
            ArrayList<String> content = new ArrayList<>(Arrays.asList(data[i].split(SEPARATOR)));
            csvFile.getRecords().add(content);
        }
    }

    public CSVFile getCSVFile() {
        return csvFile;
    }
}
