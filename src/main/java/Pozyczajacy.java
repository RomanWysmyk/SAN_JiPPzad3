import java.util.ArrayList;
import java.util.List;

class Pozyczajacy {
    private String imie;
    private String nazwisko;
    private String dataWypozyczenia;
    private String dataZwrotu;
    private List<Wypozyczenie> wypozyczenia;


    public Pozyczajacy(String imie, String nazwisko, String dataWypozyczenia, String dataZwrotu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataWypozyczenia = dataWypozyczenia;
        this.dataZwrotu = dataZwrotu;
        this.wypozyczenia = new ArrayList<>();
    }

    // Gettery i Settery

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(String dataWypozyczenia) {
        this.dataWypozyczenia = dataWypozyczenia;
    }

    public String getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDataZwrotu(String dataZwrotu) {
        this.dataZwrotu = dataZwrotu;
    }
    public void dodajWypozyczenie(Wypozyczenie wypozyczenie) {
        wypozyczenia.add(wypozyczenie);
    }
}