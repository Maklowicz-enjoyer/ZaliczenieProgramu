package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParticipantService service = new ParticipantService();
        ResultFileWriterInterface exporter = new ResultFileWriter();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Rejestracja uczestnika");
            System.out.println("2. Lista uczestników");
            System.out.println("3. Zapis do pliku");
            System.out.println("4. Wyjście");
            System.out.print("Wybór: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> service.registerParticipant();
                case 2 -> service.listParticipants();
                case 3 -> {
                    System.out.print("Podaj nazwę pliku: ");
                    String filename = sc.nextLine();
                    exporter.exportResults(service.getParticipants(), filename);
                }
                case 4 -> {
                    System.out.println("Koniec programu.");
                    return;
                }
                default -> System.out.println("Nieprawidłowy wybór!");
            }
        }
    }
}