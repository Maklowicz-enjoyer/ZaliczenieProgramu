package org.example;

import java.util.List;

public interface ResultFileWriterInterface {
    void exportResults(List<Participant> participants, String filename);
}
