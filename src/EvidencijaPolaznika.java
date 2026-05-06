import java.util.ArrayList;
import java.util.Scanner;

public class EvidencijaPolaznika {
    private static ArrayList<Polaznik> polaznici = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Dobrodošli u Evidenciju Polaznika Tečaja!");

        boolean run = true;
        while (run) {
            System.out.println("1. Unos novog polaznika");
            System.out.println("2. Ispis svih polaznika");
            System.out.println("3. Pretraživanje polaznika po e-mail adresi");
            System.out.println("4. Izlaz\n");

            System.out.print("Odaberi opciju (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consuming newline character

            switch (choice) {
                case 1:
                    unosNovogPolaznika();
                    break;
                case 2:
                    ispisiSvePolaznike();
                    break;
                case 3:
                    pretraziPolaznikaPoEmailu();
                    break;
                case 4:
                    run = false;
                    System.out.println("Hvala što ste koristili program. Doviđenja!");
                    break;
                default:
                    System.out.println("Nepostojeća opcija. Molimo odaberite ponovno.");
            }
        }
    }

    private static void unosNovogPolaznika() {
        System.out.print("Unesite ime polaznika: ");
        String ime = scanner.nextLine();

        System.out.print("Unesite prezime polaznika: ");
        String prezime = scanner.nextLine();

        System.out.print("Unesite e-mail adresu polaznika: ");
        String email = scanner.nextLine();

        Polaznik noviPolaznik = new Polaznik(ime, prezime, email);
        polaznici.add(noviPolaznik);

        System.out.println("Polaznik " + ime + " " + prezime + " uspješno dodan!\n");
    }

    private static void ispisiSvePolaznike() {
        System.out.println("Popis polaznika:");
        for (int i = 0; i < polaznici.size(); i++) {
            System.out.println((i + 1) + ". " + polaznici.get(i));
        }
        System.out.println();
    }

    private static void pretraziPolaznikaPoEmailu() {
        System.out.print("Unesite e-mail adresu polaznika za pretraživanje: ");
        String email = scanner.nextLine();

        for (Polaznik polaznik : polaznici) {
            if (polaznik.getEmail().equals(email)) {
                System.out.println("Polaznik s e-mail adresom " + email + " pronađen:");
                System.out.println(polaznik + "\n");
                return;
            }
        }
        System.out.println("Nema polaznika s e-mail adresom " + email + ".\n");
    }
}