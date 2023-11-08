package Estrategia;

import java.util.Scanner;
public class LargeFormat implements FormattedInfo {

    @Override
    public void display(CSVFile record) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el índice del título que deseas seleccionar:");
        int selectedIndex = Integer.parseInt(sc.nextLine());

        if (selectedIndex >= 0 && selectedIndex < record.getTitles().size()) {
            String selectedTitle = record.getTitles().get(selectedIndex);
            String selectedArtist = record.getArtistForTitle(selectedTitle);
            record.printAllInfo(selectedTitle);
        } else {
            System.out.println("Índice no válido.");
        }

    }
}
