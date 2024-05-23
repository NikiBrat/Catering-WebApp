/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import IO.DbBroker;
import beans.Korisnik;
import beans.Proizvod;
import java.util.ArrayList;

/**
 *
 * @author nikol
 */
public class KorpaRepository 
{
    
    public boolean dodajUKorpu( int kolicina, String ponudaID,ArrayList<Proizvod> korpa, int korisnikID)
    {
        
        int kol=0;
        
        String upit = "Select k.kolicina from korpa k where k.ponudaID = "+ponudaID + " and k.korisnikID = "+korisnikID;
        
        System.out.println(upit);
        
        kol = DbBroker.scalar(upit);
        
        if(kol<0)
        {
            upit = "Insert into korpa (korisnikID, datumVreme, ponudaID, kolicina) values "
                    + "('"+korisnikID+"','2022-05-22 15:22:00','"+ponudaID+"','"+kolicina+"')";
        }
        else
        {
            kol+=kolicina;
            upit = "Update korpa set kolicina="+kol+" where ponudaID = "+ponudaID+" and korisnikID="+korisnikID;
        }
        
        return DbBroker.simpleQuery(upit);
        
    }

    public ArrayList<Proizvod> VratiKorpu(int korisnikID) 
    {
        ArrayList<Proizvod> korpa = new ArrayList<>();
        
        String upit = "Select  k.korisnikID, k.datumvreme, k.ponudaID, k.kolicina ,a.naziv, a.cena, a.cenaSaPopustom, a.kategorijaID, ka.naziv, a.slika\n" +
        "from korpa k join ponuda a on k.ponudaID = a.ponudaID join kategorija ka on a.kategorijaID=ka.kategorijaID where k.korisnikID="+korisnikID;
        
        //System.out.println(upit);
        
        ArrayList<String []> artikli = DbBroker.getArr(upit);
        
        
        
        for(String [] p : artikli)
        {
            Proizvod pr = new Proizvod();

            try 
            {
                pr.setKorisnikID(Integer.parseInt(p[0]));
                
                pr.setDatumVreme("");
                
                pr.setPonudaID(Integer.parseInt(p[2]));
                
                pr.setKolicina(Integer.parseInt(p[3]));
                
                pr.setNaziv(p[4]);
               
                pr.setCena(Double.parseDouble(p[5]));
                
                double cenaSaPopustom = (p[6] != null) ? Double.parseDouble(p[6]): Double.parseDouble(p[5]);
                
                pr.setCenaSaPopustom(cenaSaPopustom);
                
                pr.setKategorijaID(Integer.parseInt(p[7]));
                
                pr.setNazivKategorije(p[8]);
                
                pr.setSlika(p[9]); 

                korpa.add(pr);
                
            } 
            catch (Exception e) 
            {
                System.out.println("Greska kod: "+e.getMessage());
            }
        }
        //System.out.println("Artikli su: "+korpa.size());
        return korpa;
    }
    
    public boolean IzmeniKolicinu(int korisnikID,int ponudaID,int kolicina)
    {
        //System.out.println("Korisnik id je: "+korisnikID);
        String upit = "select korpaID from korpa where korisnikID ='"+korisnikID+"' and ponudaID ='"+ponudaID+"'";
        
        int korpaID = DbBroker.scalar(upit);
        
        
        if(korpaID>0)
        {
            upit = "Update korpa set kolicina="+kolicina+" where korisnikID="+korisnikID+" and ponudaID="+ponudaID;
        }
        
       return DbBroker.simpleQuery(upit);
    }
    
    public boolean UkloniIzKorpe(int korisnikID, int ponudaID) 
    {
        String upit = "select korpaID from korpa where korisnikID ='"+korisnikID+"' and ponudaID ='"+ponudaID+"'";
        
        System.out.println(upit);
        
        ArrayList<String []> korpa = DbBroker.getArr(upit);
        
        String[] nizkorpa = korpa.get(0);
        
        int korpaID = Integer.parseInt(nizkorpa[0]);
        
        upit = "Delete from  korpa where korpaID='"+korpaID+"'";
        
        return DbBroker.simpleQuery(upit);
    }
}
