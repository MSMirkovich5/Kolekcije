import java.util.*;

public class EvidencijaPolaznika {
    private static HashMap<String, Polaznik> polaznici = new HashMap();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Dobrodošli u evidenciju polaznika!");

        boolean run = true;
        while (run) {
            System.out.println("1. Unos novog polaznika");
            System.out.println("2. Ispis svih polaznika");
            System.out.println("3. Izlaz \n");

            System.out.print("Izaberite opciju (1-3): ");
            int opcija = scanner.nextInt();
            scanner.nextLine(); // čišćenje Entera

            switch (opcija) {
                case 1:
                    unosNovogPolaznika();
                    break;
                case 2:
                    ispisSvihPolaznika();
                    break;
                case 3:
                    run = false;
                    System.out.println("Hvala što ste koristili program. Doviđenja!");
                    break;
                default:
                    System.out.println("Nepostojeća opcija! \n");
            }
        }
    }

    private static void unosNovogPolaznika() {
        System.out.print("Upišite ime polaznika: ");
        String ime = scanner.nextLine();
        System.out.print("Upišite prezime polaznika: ");
        String prezime = scanner.nextLine();
        System.out.print("Upišite email polaznika: ");
        String email = scanner.nextLine();

        if (polaznici.containsKey(email)) {
            System.out.println("Polaznik s tim emailom već postoji!\n");
            return;
        }
        Polaznik noviPolaznik = new Polaznik(ime, prezime, email);
        polaznici.put(email, noviPolaznik);
        System.out.println("Uspiješno dodan: " + ime + " " + prezime + "\n");
    }

    private static void ispisSvihPolaznika() {
        System.out.println("Ispis svih polaznika: ");
        int i = 1;
        for (Polaznik p : polaznici.values()) {
            System.out.println(i + ". " + p.toString());
            i++;
        }
        System.out.println();
    }
}