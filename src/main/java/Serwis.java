import java.util.List;
import java.util.Scanner;


public class Serwis {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteka biblioteka = new Biblioteka();

    public static void main(String[] args) {
        boolean czyWyjsc = false;
        while (!czyWyjsc) {
            wyswietlMenu();
            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    dodajKsiazke();
                    break;
                case 2:
                    usunKsiazke();
                    break;
                case 3:
                    aktualizujKsiazke();
                    break;
                case 4:
                    wyszukajKsiazki();
                    break;
                case 5:
                    wyswietlWszystkieKsiazki();
                    break;
                case 6:
                    czyWyjsc = true;
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private static void wyswietlMenu() {
        System.out.println(ANSI_YELLOW+"----- MENU -----"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"1. Dodaj książkę"+ANSI_RESET);
        System.out.println(ANSI_RED+"2. Usuń książkę"+ANSI_RESET);
        System.out.println("3. Aktualizuj książkę");
        System.out.println("4. Wyszukaj książki");
        System.out.println("5. Wyświetl wszystkie książki");
        System.out.println(ANSI_PURPLE+"6. Wyjdź"+ANSI_RESET);
        System.out.print(ANSI_CYAN+"Wybierz opcję: "+ANSI_RESET);
    }

    private static void dodajKsiazke() {
        System.out.print("Podaj tytuł książki: ");
        String tytul = scanner.nextLine();
        System.out.print("Podaj autora książki: ");
        String autor = scanner.nextLine();
        System.out.print("Podaj rok wydania książki: ");
        int rokWydania = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Podaj wydawcę książki: ");
        String wydawca = scanner.nextLine();
        System.out.print("Podaj numer ISBN książki: ");
        String numerISBN = scanner.nextLine();
        System.out.print("Podaj gatunek książki: ");
        String gatunek = scanner.nextLine();
        System.out.print("Podaj liczbę dostępnych egzemplarzy książki: ");
        int liczbaDostepnychEgzemplarzy = scanner.nextInt();
        scanner.nextLine();

        Ksiazka ksiazka = new Ksiazka(tytul, autor, rokWydania, wydawca, numerISBN, gatunek, liczbaDostepnychEgzemplarzy);
        biblioteka.dodajKsiazke(ksiazka);

        System.out.println("Książka została dodana do biblioteki.");
    }

    private static void usunKsiazke() {
        System.out.print("Podaj tytuł książki do usunięcia: ");
        String tytul = scanner.nextLine();
        System.out.print("Podaj autora książki do usunięcia: ");
        String autor = scanner.nextLine();

        List<Ksiazka> znalezioneKsiazki = biblioteka.wyszukajKsiazki("tytul", tytul);
        znalezioneKsiazki.retainAll(biblioteka.wyszukajKsiazki("autor", autor));

        if (znalezioneKsiazki.isEmpty()) {
            System.out.println("Nie znaleziono książki o podanym tytule i autorze.");
        } else {
            for (Ksiazka ksiazka : znalezioneKsiazki) {
                biblioteka.usunKsiazke(ksiazka);
            }
            System.out.println("Książka została usunięta z biblioteki.");
        }
    }

    private static void aktualizujKsiazke() {
        System.out.print("Podaj tytuł książki do aktualizacji: ");
        String tytul = scanner.nextLine();
        System.out.print("Podaj autora książki do aktualizacji: ");
        String autor = scanner.nextLine();

        List<Ksiazka> znalezioneKsiazki = biblioteka.wyszukajKsiazki("tytul", tytul);
        znalezioneKsiazki.retainAll(biblioteka.wyszukajKsiazki("autor", autor));

        if (znalezioneKsiazki.isEmpty()) {
            System.out.println("Nie znaleziono książki o podanym tytule i autorze.");
        } else if (znalezioneKsiazki.size() > 1) {
            System.out.println("Znaleziono więcej niż jedną książkę o podanym tytule i autorze.");
        } else {
            Ksiazka staraKsiazka = znalezioneKsiazki.get(0);

            System.out.println("Podaj nowe dane dla książki:");
            System.out.print("Tytuł: ");
            String nowyTytul = scanner.nextLine();
            System.out.print("Autor: ");
            String nowyAutor = scanner.nextLine();
            System.out.print("Rok wydania: ");
            int nowyRokWydania = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Wydawca: ");
            String nowyWydawca = scanner.nextLine();
            System.out.print("Numer ISBN: ");
            String nowyNumerISBN = scanner.nextLine();
            System.out.print("Gatunek: ");
            String nowyGatunek = scanner.nextLine();
            System.out.print("Liczba dostępnych egzemplarzy: ");
            int nowaLiczbaDostepnychEgzemplarzy = scanner.nextInt();
            scanner.nextLine();

            Ksiazka nowaKsiazka = new Ksiazka(nowyTytul, nowyAutor, nowyRokWydania, nowyWydawca, nowyNumerISBN, nowyGatunek, nowaLiczbaDostepnychEgzemplarzy);
            biblioteka.aktualizujKsiazke(staraKsiazka, nowaKsiazka);

            System.out.println("Książka została zaktualizowana.");
        }
    }

    private static void wyszukajKsiazki() {
        System.out.println("Wyszukiwanie książek:");
        System.out.println("1. Według tytułu");
        System.out.println("2. Według autora");
        System.out.println("3. Według gatunku");
        System.out.print("Wybierz opcję: ");
        int wybor = scanner.nextInt();
        scanner.nextLine();

        String kryterium;
        switch (wybor) {
            case 1:
                kryterium = "tytul";
                System.out.print("Podaj tytuł książki: ");
                break;
            case 2:
                kryterium = "autor";
                System.out.print("Podaj autora książki: ");
                break;
            case 3:
                kryterium = "gatunek";
                System.out.print("Podaj gatunek książki: ");
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Wyszukiwanie przerwane.");
                return;
        }

        String wartosc = scanner.nextLine();
        List<Ksiazka> znalezioneKsiazki = biblioteka.wyszukajKsiazki(kryterium, wartosc);

        if (znalezioneKsiazki.isEmpty()) {
            System.out.println("Nie znaleziono książek spełniających podane kryterium.");
        } else {
            System.out.println("Znalezione książki:");
            for (Ksiazka ksiazka : znalezioneKsiazki) {
                System.out.println("Tytuł: " + ksiazka.getTytul());
                System.out.println("Autor: " + ksiazka.getAutor());
                System.out.println("Rok wydania: " + ksiazka.getRokWydania());
                System.out.println("Wydawca: " + ksiazka.getWydawca());
                System.out.println("Numer ISBN: " + ksiazka.getNumerISBN());
                System.out.println("Gatunek: " + ksiazka.getGatunek());
                System.out.println("Liczba dostępnych egzemplarzy: " + ksiazka.getLiczbaDostepnychEgzemplarzy());
                System.out.println("-----------------------");
            }
        }
    }

    private static void wyswietlWszystkieKsiazki() {
        List<Ksiazka> wszystkieKsiazki = biblioteka.getListaKsiazek();

        if (wszystkieKsiazki.isEmpty()) {
            System.out.println("Brak książek w bibliotece.");
        } else {
            System.out.println("Wszystkie książki w bibliotece:");
            for (Ksiazka ksiazka : wszystkieKsiazki) {
                System.out.println("Tytuł: " + ksiazka.getTytul());
                System.out.println("Autor: " + ksiazka.getAutor());
                System.out.println("Rok wydania: " + ksiazka.getRokWydania());
                System.out.println("Wydawca: " + ksiazka.getWydawca());
                System.out.println("Numer ISBN: " + ksiazka.getNumerISBN());
                System.out.println("Gatunek: " + ksiazka.getGatunek());
                System.out.println("Liczba dostępnych egzemplarzy: " + ksiazka.getLiczbaDostepnychEgzemplarzy());
                System.out.println("-----------------------");
            }
        }
    }
}