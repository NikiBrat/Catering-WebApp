/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author nikol
 */

public class Proizvod 
{
        private String Naziv="";
        private String NazivPrograma="";
        private String NazivKategorije="";
        private double cena=0;
        private double cenaSaPopustom=0;
        private int kolicina=0;
        private int ponudaID=0;
        private int kategorijaID=0;
        private int programID=0;
        private String slika="";
        private int korisnikID=0;
        private String datumVreme="";
        //private int korpaKolicina=0;

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(String datumVreme) {
        this.datumVreme = datumVreme;
    }

    /*public int getKorpaKolicina() {
        return korpaKolicina;
    }

    public void setKorpaKolicina(int korpaKolicina) {
        this.korpaKolicina = korpaKolicina;
    }*/

    public Proizvod() {
    }
        
        

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String Naziv) {
        this.Naziv = Naziv;
    }

    public String getNazivPrograma() {
        return NazivPrograma;
    }

    public void setNazivPrograma(String NazivPrograma) {
        this.NazivPrograma = NazivPrograma;
    }

    public String getNazivKategorije() {
        return NazivKategorije;
    }

    public void setNazivKategorije(String NazivKategorije) {
        this.NazivKategorije = NazivKategorije;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getCenaSaPopustom() {
        return cenaSaPopustom;
    }

    public void setCenaSaPopustom(double cenaSaPopustom) {
        this.cenaSaPopustom = cenaSaPopustom;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getPonudaID() {
        return ponudaID;
    }

    public void setPonudaID(int ponudaID) {
        this.ponudaID = ponudaID;
    }

    public int getKategorijaID() {
        return kategorijaID;
    }

    public void setKategorijaID(int kategorijaID) {
        this.kategorijaID = kategorijaID;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }
}
