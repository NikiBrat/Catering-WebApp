
package Repository;

import IO.DbBroker;
import beans.Korisnik;
import java.util.ArrayList;


public class KorisnikRepository {

    public Korisnik UlogujMe(String korisnickoIme, String sifra) {
        Korisnik k = null;

        String upit = "Select count(*) from korisnik k where korisnickoIme='" + korisnickoIme + "' and sifra='" + sifra + "'";

        //System.out.println(upit);
        int ima = DbBroker.scalar(upit);

        if (ima > 0) {
            upit = "Select korisnickoIme,kontakt,uloga,adresa,imeKorisnika,korisnikID from Korisnik k where korisnickoIme='" + korisnickoIme + "' and sifra='" + sifra + "'";

            k = new Korisnik();

            ArrayList<String[]> korisnik = DbBroker.getArr(upit);

            String[] i = korisnik.get(0);

            k.setKorisnickoIme(i[0]);
            k.setKontakt(i[1]);
            k.setUloga(Integer.parseInt(i[2]));
            k.setAdresa(i[3]);
            k.setImeKorisnika(i[4]);
            k.setKorisnikID(Integer.parseInt(i[5]));

            //System.out.println("Korisnik "+k.getImeKorisnika());
        }
        return k;
    }

    public ArrayList getKorisnici() {
        String upit = "select korisnikId, korisnickoIme, sifra, kontakt, uloga, adresa, imeKorisnika FROM korisnik ";
        ArrayList<String[]> lista = DbBroker.getArr(upit);
        ArrayList<Korisnik> korisnici = new ArrayList<>();
        if (lista != null && lista.size() > 0 && !lista.get(0)[0].contains("ERROR")) {
            for (String[] str : lista) {
                Korisnik k = new Korisnik();
                try {
                    k.setKorisnikID(Integer.parseInt(str[0]));
                    k.setKorisnickoIme(str[1]);
                    k.setSifra(str[2]);
                    k.setKontakt(str[3]);
                    k.setUloga(Integer.parseInt(str[4]));
                    k.setAdresa(str[5]);
                    k.setImeKorisnika(str[6]);
                    korisnici.add(k);
                } catch (NumberFormatException ex) {
                    System.err.println("REŠKA kod kreiranja korisnika - parsiranje nedozvoljenog stringa u int " + ex);
                }

            }
        }
        return korisnici;
    }

    public boolean brisiKorisnika(String korisnikID) {
        String upit = "delete from korisnik where korisnikId =" + korisnikID;
        return DbBroker.simpleQuery(upit);
    }

    public Korisnik getKorisnik(String korisnikID) {
        String upit = "select korisnikId, korisnickoIme, sifra, kontakt, uloga, adresa, imeKorisnika FROM korisnik where korisnikId=" + korisnikID;
        ArrayList<String[]> kor = DbBroker.getArr(upit);
        String[] str = kor.get(0);

        Korisnik k = new Korisnik();
        try {
            k.setKorisnikID(Integer.parseInt(str[0]));
            k.setKorisnickoIme(str[1]);
            k.setSifra(str[2]);
            k.setKontakt(str[3]);
            k.setUloga(Integer.parseInt(str[4]));
            k.setAdresa(str[5]);
            k.setImeKorisnika(str[6]);
        } catch (NumberFormatException ex) {
            System.err.println("REŠKA kod kreiranja korisnika - parsiranje nedozvoljenog stringa u int " + ex);
        }
        return k;
    }

    public boolean izmeniKorisnika(Korisnik k) {
        String uloga = "";
        if (k.getUloga() > 0 ) {
            uloga = "uloga='" + k.getUloga() + "', ";
        }
        
        String upit = "UPDATE korisnik SET korisnickoIme='" + k.getKorisnickoIme() + "', sifra='" + k.getSifra()
                + "', kontakt='" + k.getKontakt()
                + "', " + uloga + " adresa='" + k.getAdresa() + "', imeKorisnika='" + k.getImeKorisnika()
                + "' where korisnikId=" + k.getKorisnikID();

        boolean uspesno = DbBroker.simpleQuery(upit);
        
        System.out.println("Upit je zavrsen: " + uspesno);
        return uspesno;
    }

}
