package org.example;

import java.util.List;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultFileWriter implements ResultFileWriterInterface {
    @Override
    public void exportResults(List<Participant> participants, String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            for (Participant p : participants) {
                fw.write(p.getInfo() + "\n");
            }
            System.out.println("Wyniki zapisano do pliku: " + filename);
        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku: " + e.getMessage());
        }
    }
}