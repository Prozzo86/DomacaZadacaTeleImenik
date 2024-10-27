import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*   Telefonski imenik:
        - Napravi program koji simulira telefonski imenik koristeći dvije paralelne liste:
        - Lista u koju se spremaju imena, i lista u kojoj se sprema brojevi
        - Kod prvog odabira korisnik unosi ime i broj koji se spremaju u svoje liste
        - Korisnik ima mogucnost odabira, te za svaki odabir treba omoguciti odredenu funkcionalnost:
          1. Dodavanje kontakta.
          2. Pretraži po imenu.
          3. Pretraži po broju.
          4. Ispiši sve.
          5. Izlaz
    */
    static ArrayList<String> imena = new ArrayList<>();
    static ArrayList<String> brojevi = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            prikaziIzbornik();
            int odabir = scanner.nextInt();
            scanner.nextLine(); // Prazan unos za preskakanje retka nakon int

            switch (odabir) {
                case 1:
                    dodajKontakt();
                    break;
                case 2:
                    pretraziPoImenu();
                    break;
                case 3:
                    pretraziPoBroju();
                    break;
                case 4:
                    ispisiSveKontakte();
                    break;
                case 5:
                    System.out.println("Izlaz iz programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Neispravan unos. Pokušajte ponovno.");
                    break;
            }
        }
    }

    private static void prikaziIzbornik() {
        System.out.println("Telefonski imenik - Izaberite opciju:");
        System.out.println("1. Dodavanje kontakta");
        System.out.println("2. Pretraži po imenu");
        System.out.println("3. Pretraži po broju");
        System.out.println("4. Ispiši sve");
        System.out.println("5. Izlaz");
        System.out.print("Vaš odabir: ");
    }

    private static void dodajKontakt() {
        System.out.print("Unesite ime: ");
        String ime = scanner.nextLine();

        System.out.print("Unesite broj: ");
        String broj = scanner.nextLine();

        imena.add(ime);
        brojevi.add(broj);
        System.out.println("Kontakt dodan.");
    }

    private static void pretraziPoImenu() {
        System.out.print("Unesite ime za pretragu: ");
        String imeZaPretragu = scanner.nextLine();
        boolean pronaden = false;

        for (int i = 0; i < imena.size(); i++) {
            if (imena.get(i).equalsIgnoreCase(imeZaPretragu)) {
                System.out.println("Pronađeno: " + imena.get(i) + " - " + brojevi.get(i));
                pronaden = true;
            }
        }
        if (!pronaden) {
            System.out.println("Kontakt nije pronađen.");
        }
    }

    private static void pretraziPoBroju() {
        System.out.print("Unesite broj za pretragu: ");
        String brojZaPretragu = scanner.nextLine();
        boolean pronaden = false;

        for (int i = 0; i < brojevi.size(); i++) {
            if (brojevi.get(i).equals(brojZaPretragu)) {
                System.out.println("Pronađeno: " + imena.get(i) + " - " + brojevi.get(i));
                pronaden = true;
            }
        }
        if (!pronaden) {
            System.out.println("Kontakt nije pronađen.");
        }
    }

    private static void ispisiSveKontakte() {
        System.out.println("Svi kontakti:");

        for (int i = 0; i < imena.size(); i++) {
            System.out.println((i + 1) + ". " + imena.get(i) + " - " + brojevi.get(i));
        }
    }
}