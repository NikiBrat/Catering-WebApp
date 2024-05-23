
package beans;


public class Narudzbina {

    private String kupac;
    private String datum;
    private int kupacId;
    private boolean zavrsena=false;
    private String nacinPlacanja;
    private int narudzbinaId;
    private Double ukupanIznos=0.0;
    

    public String getKupac() {
        return kupac;
    }

    public void setKupac(String kupac) {
        this.kupac = kupac;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getKupacId() {
        return kupacId;
    }

    public void setKupacId(int kupacId) {
        this.kupacId = kupacId;
    }

    public boolean isZavrsena() {
        return zavrsena;
    }

    public void setZavrsena(boolean zavrsena) {
        this.zavrsena = zavrsena;
    }

    public String getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(String nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public int getNarudzbinaId() {
        return narudzbinaId;
    }

    public void setNarudzbinaId(int narudzbinaId) {
        this.narudzbinaId = narudzbinaId;
    }

    public Double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(Double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }
}
