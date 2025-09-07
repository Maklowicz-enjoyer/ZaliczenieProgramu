package org.example;




import java.util.*;

public class ParticipantService {
    private List<Participant> participants = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void registerParticipant() {
        System.out.print("Imię: ");
        String firstName = sc.nextLine();
        System.out.print("Nazwisko: ");
        String lastName = sc.nextLine();
        System.out.print("Numer licencji: ");
        String license = sc.nextLine();
        System.out.print("Numer patentu: ");
        String patent = sc.nextLine();

        Participant p = new Participant(firstName, lastName, license, patent);

        System.out.println("Wybierz dyscypliny (PISTOL, RIFLE, SHOTGUN) oddzielone przecinkiem:");
        String[] choices = sc.nextLine().toUpperCase().split(",");

        for (String c : choices) {
            DisciplineType type = DisciplineType.valueOf(c.trim());
            switch (type) {
                case PISTOL -> {
                    List<Integer> shots = new ArrayList<>();
                    for (int i = 1; i <= 10; i++) {
                        System.out.print("Pistolet - strzał " + i + " (0-10): ");
                        shots.add(sc.nextInt());
                    }
                    sc.nextLine();
                    p.addResult(new Pistol(shots));
                }
                case RIFLE -> {
                    List<Integer> shots = new ArrayList<>();
                    for (int i = 1; i <= 10; i++) {
                        System.out.print("Karabin - strzał " + i + " (0-10): ");
                        shots.add(sc.nextInt());
                    }
                    sc.nextLine();
                    p.addResult(new Rifle(shots));
                }
                case SHOTGUN -> {
                    List<Boolean> shots = new ArrayList<>();
                    for (int i = 1; i <= 5; i++) {
                        System.out.print("Strzelba - strzał " + i + " (1=trafiony,0=chybiony): ");
                        shots.add(sc.nextInt() == 1);
                    }
                    sc.nextLine();
                    p.addResult(new Shotgun(shots));
                }
            }
        }

        participants.add(p);
        System.out.println("Dodano uczestnika!");
    }

    public void listParticipants() {
        int i = 1;
        for (Participant p : participants) {
            System.out.println(i++ + ". " + p.getInfo());
        }
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}