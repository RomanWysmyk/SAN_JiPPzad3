import java.time.LocalDate;

class Wypozyczenie {
    private Ksiazka ksiazka;
    private Pozyczajacy pozyczajacy;
    private String dataWypozyczenia;
    private String dataZwrotu;

    public Wypozyczenie(Ksiazka ksiazka, Pozyczajacy pozyczajacy, String dataWypozyczenia, String dataZwrotu) {
        this.ksiazka = ksiazka;
        this.pozyczajacy = pozyczajacy;
        this.dataWypozyczenia = dataWypozyczenia;
        this.dataZwrotu = dataZwrotu;
    }
}