import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class EvidencijaPolaznika {
    private static HashSet<Polaznik> polaznici = new HashSet<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Dobrodošli u evidenciju polaznika!");

        boolean run = true;
        while (run) {
            System.out.println("1. Unos novog polaznika");
            System.out.println("2. Ispis svih polaznika");
            System.out.println("3. Pretraživanje polaznika po email adresi");
            System.out.println("4. Izlaz \n");

            System.out.print("Izaberite opciju (1-4): ");
            int opcija = scanner.nextInt();
            scanner.nextLine();

            switch (opcija) {
                case 1:
                    unosNovogPolaznika();
                    break;
                case 2:
                    ispisSvihPolaznika();
                    break;
                case 3:
                    pretrazivanjePolaznikaPoEmailAdresi();
                    break;
                case 4:
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

        Polaznik noviPolaznik = new Polaznik(ime, prezime, email);
        polaznici.add(noviPolaznik);
        System.out.println("Uspiješno dodan: " + ime + " " + prezime + "\n");
    }

    private static void ispisSvihPolaznika() {
        System.out.println("Ispis svih polaznika: ");
        int i = 1;
        for (Polaznik p : polaznici ) {
            System.out.println(i + ". " + p.toString());
            i++;
        }
        System.out.println();
    }

    private static void pretrazivanjePolaznikaPoEmailAdresi() {
        System.out.print("Unesite email adresu polaznika: ");
        String email = scanner.nextLine();

        for (Polaznik p : polaznici) {
            if (p.getEmail().equals(email)) {
                System.out.println("Polaznik pronađen!");
                System.out.println(p.toString() + "\n");
                return;
            }
        }
        System.out.println("Polaznik nije pronađen!");
    }
}