package Estrategia;

import java.util.Scanner;

public class ShortFormat implements FormattedInfo {
    @Override
    public void display(CSVFile record) {
        // Ahora preguntar que titulos queremos analizar
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el índice del título que deseas seleccionar:");
        int selectedIndex = Integer.parseInt(sc.nextLine());

        if (selectedIndex >= 0 && selectedIndex < record.getTitles().size()) {
            String selectedTitle = record.getTitles().get(selectedIndex);
            String selectedArtist = record.getArtistForTitle(selectedTitle);
            System.out.println("Título seleccionado: " + selectedTitle);
            System.out.println("Artista: " + selectedArtist);
        } else {
            System.out.println("Índice no válido.");
        }
    }
}
