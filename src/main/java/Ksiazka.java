public class Ksiazka {
    private String tytul;
    private String autor;
    private int rokWydania;
    private String wydawca;
    private String numerISBN;
    private String gatunek;
    private int liczbaDostepnychEgzemplarzy;

    public Ksiazka(String tytul, String autor, int rokWydania, String wydawca, String numerISBN, String gatunek, int liczbaDostepnychEgzemplarzy) {
        this.tytul = tytul;
        this.autor = autor;
        this.rokWydania = rokWydania;
        this.wydawca = wydawca;
        this.numerISBN = numerISBN;
        this.gatunek = gatunek;
        this.liczbaDostepnychEgzemplarzy = liczbaDostepnychEgzemplarzy;
    }

    // Gettery i Settery

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    public String getWydawca() {
        return wydawca;
    }

    public void setWydawca(String wydawca) {
        this.wydawca = wydawca;
    }

    public String getNumerISBN() {
        return numerISBN;
    }

    public void setNumerISBN(String numerISBN) {
        this.numerISBN = numerISBN;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public int getLiczbaDostepnychEgzemplarzy() {
        return liczbaDostepnychEgzemplarzy;
    }

    public void setLiczbaDostepnychEgzemplarzy(int liczbaDostepnychEgzemplarzy) {
        this.liczbaDostepnychEgzemplarzy = liczbaDostepnychEgzemplarzy;
    }
}

