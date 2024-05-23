/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import IO.DbBroker;
import beans.Narudzbina;
import beans.Proizvod;
import java.util.ArrayList;

/**
 *
 * @author nikol
 */
public class NarudzbenicaRepository  
{
    public boolean Naruci(int korisnikID, double ukupno, String nacinPlacanja)
    {
        
        String upit ="Insert into narudzbina(ukupaniznos,datum,korisnikID,nacinplacanja,zavrsena) "
                + "values ('"+ukupno+"','2022-06-14 14:50','"+korisnikID+"','"+nacinPlacanja+"','0')";
        
        boolean uspeh = DbBroker.simpleQuery(upit);
               
        
        int narudzbinaID = IzvuciIdNarudzbine();
        
        //System.out.println("Upit za izvlacenje poslednje naurdzbenice sa vrednoscu: "+narudzbinaID);
        
        boolean radi = true;
        
        if(uspeh)
        {
            
            KorpaRepository kp = new KorpaRepository();
            ArrayList<Proizvod> lista = kp.VratiKorpu(korisnikID);
            
            for(Proizvod i:lista)
            {
                upit = "Insert into stavkenarudzbine(narudzbinaID,ponudaID,cena,kolicina) "
                        + "values ('"+narudzbinaID+"','"+i.getPonudaID()+"','"+i.getCenaSaPopustom()+"','"+i.getKolicina()+"')";
                
                radi &= DbBroker.simpleQuery(upit);
            }
            if(radi)
            {
                upit = "Delete from korpa where korisnikID="+korisnikID;
                
                radi &= DbBroker.simpleQuery(upit);
            }
        }
        
        return radi&uspeh;
    }
    
    public int IzvuciIdNarudzbine()
    {
        String upit = "Select max(narudzbinaID) from narudzbina";
        
        int narudzbinaID = DbBroker.scalar(upit);
        
        return narudzbinaID;
    }
    
    public ArrayList<Proizvod> VratiNarudzbenicu()
    {
        
        
        ArrayList<Proizvod> lista = new ArrayList<Proizvod>();
        
        String upit = "select p.naziv,p.cenaSaPopustom, p.slika,s.kolicina,p.ponudaID from stavkenarudzbine s join ponuda p on s.ponudaID=p.ponudaID where s.narudzbinaID="+IzvuciIdNarudzbine();
        
        ArrayList<String []> nar = DbBroker.getArr(upit);
        
        
        for(String [] i : nar)
        {
            Proizvod p = new Proizvod();

            try 
            {
                p.setNaziv(i[0]);
                
                p.setCena(Double.parseDouble(i[1]));
                
                p.setSlika(i[2]);
                
                p.setKolicina(Integer.parseInt(i[3]));
                
                p.setPonudaID(Integer.parseInt(i[4]));

                lista.add(p);
                
            } 
            catch (Exception e) 
            {
                System.out.println("Greska kod: "+e.getMessage());
            }
        }
        
        
        return lista;
    }
    
    public boolean UmanjiKolicinu(ArrayList<Proizvod> kolicine)
    {
        int kolicina =0;
        String upit="";
        boolean uspeh=true;
        for(Proizvod i : kolicine)
        {
            upit = "Select kolicina from ponuda where ponudaID="+i.getPonudaID();
            
            kolicina= DbBroker.scalar(upit);
            
            kolicina-=i.getKolicina();
            
            upit = "Update ponuda set kolicina="+kolicina+" where ponudaID="+i.getPonudaID(); 
            
            if(DbBroker.simpleQuery(upit))
            {
                uspeh&=true;
            }
        }
 
        return uspeh;
    }
    
    public ArrayList<Proizvod> VratiNarudzbenicu(String narudzbinaId) {
        String upit = "select p.naziv, p.cenaSaPopustom, p.slika, s.kolicina, p.cena, k.naziv from stavkenarudzbine s join ponuda p on s.ponudaID=p.ponudaID join kategorija k on p.kategorijaId = k.kategorijaId where s.narudzbinaID=" + narudzbinaId;
        ArrayList<Proizvod> proizvodi = new ArrayList<>();
        ArrayList<String[]> lista = DbBroker.getArr(upit);

        for (String[] str : lista) {
            Proizvod p = new Proizvod();
            try {
                p.setNaziv(str[0]);
                p.setCenaSaPopustom(Double.parseDouble(str[1]));
                p.setCena(Double.parseDouble(str[4]));
                p.setSlika(str[2]);
                p.setNazivKategorije(str[5]);
                p.setKolicina(Integer.parseInt(str[3]));

                proizvodi.add(p);

            } catch (Exception e) {
                System.out.println("Greska kod: " + e.getMessage());
            }

        }

        return proizvodi;
    }

    public ArrayList<Narudzbina> getNarudzbine() {
        String upit = "select n.narudzbinaId, n.ukupanIznos, n.datum, n.korisnikId, n.nacinPlacanja, n.zavrsena, k.imeKorisnika from narudzbina n join korisnik k on n.korisnikID = k.KorisnikID";
        ArrayList<String[]> lista = DbBroker.getArr(upit);
        ArrayList<Narudzbina> narudzbine = new ArrayList<>();
        if (lista != null && lista.size() > 0 && !lista.get(0)[0].contains("ERROR")) {
            for (String[] str : lista) {
                Narudzbina n = new Narudzbina();

                try {
                    n.setDatum(str[2]);
                    n.setKupac(str[6]);
                    n.setKupacId(Integer.parseInt(str[3]));
                    n.setNacinPlacanja(str[4]);
                    n.setNarudzbinaId(Integer.parseInt(str[0]));
                    n.setUkupanIznos(Double.parseDouble(str[1]));
                    n.setZavrsena(str[5].contains("1"));
                    System.out.println("Zavrsena: " + str[5] + ", prevedeno: " + n.isZavrsena());

                    narudzbine.add(n);
                } catch (NumberFormatException ex) {
                    System.err.println("GREŠKA kod konverzije broja u getNarudzbine: " + ex);
                }
            }
        }
        return narudzbine;
    }

    public boolean zatvoriNarudzbinu(String narudzbinaId) {
        String upit = "update narudzbina set zavrsena=1 where narudzbinaID=" + narudzbinaId;
        return DbBroker.simpleQuery(upit);
    }
}
