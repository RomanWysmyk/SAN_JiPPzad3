import java.util.ArrayList;
import java.util.List;

class Biblioteka {
    private List<Ksiazka> listaKsiazek;

    public Biblioteka() {
        listaKsiazek = new ArrayList<>();
    }

    public void dodajKsiazke(Ksiazka ksiazka) {
        listaKsiazek.add(ksiazka);
    }

    public void usunKsiazke(Ksiazka ksiazka) {
        listaKsiazek.remove(ksiazka);
    }

    public void aktualizujKsiazke(Ksiazka staraKsiazka, Ksiazka nowaKsiazka) {
        int index = listaKsiazek.indexOf(staraKsiazka);
        if (index != -1) {
            listaKsiazek.set(index, nowaKsiazka);
        }
    }

    public List<Ksiazka> wyszukajKsiazki(String kryterium, String wartosc) {
        List<Ksiazka> wynik = new ArrayList<>();
        for (Ksiazka ksiazka : listaKsiazek) {
            if (kryterium.equals("tytul") && ksiazka.getTytul().equalsIgnoreCase(wartosc)) {
                wynik.add(ksiazka);
            } else if (kryterium.equals("autor") && ksiazka.getAutor().equalsIgnoreCase(wartosc)) {
                wynik.add(ksiazka);
            } else if (kryterium.equals("gatunek") && ksiazka.getGatunek().equalsIgnoreCase(wartosc)) {
                wynik.add(ksiazka);
            }
        }
        return wynik;
    }

    public void wyswietlWszystkieKsiazki() {
        for (Ksiazka ksiazka : listaKsiazek) {
            System.out.println(ksiazka.getTytul());
        }
    }

    public List<Ksiazka> getListaKsiazek() {
        return listaKsiazek;
    }
}