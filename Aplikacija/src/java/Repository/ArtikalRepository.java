/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import IO.DbBroker;
import java.util.ArrayList;
import beans.Proizvod;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nikol
 */
public class ArtikalRepository 
{
    ArrayList<String[]> lista;
    
    HttpSession sesija;
    
    public ArrayList<Proizvod> VratiPonudu(String program, String NazivKategorije)
    {
        ArrayList<Proizvod> slatki = new ArrayList<>();
        
        String uslov = "where a.brisano = 0";
        //program=program.trim();
        System.out.println("Program je: "+program+ ", naziv kat je: "+NazivKategorije);
        
        if(program.equals("slatki") || program.equals("slani"))
        {
            uslov+=" and p.naziv ='"+program+"'";
            
            if(NazivKategorije != null && !NazivKategorije.isEmpty())
            {
                uslov+=" and k.naziv='"+NazivKategorije+"'";
            }
            
        }

        String upit= "Select  a.ponudaID ,a.naziv, a.cena, a.cenaSaPopustom, a.kategorijaID, a.kolicina, k.naziv, a.slika from \n" +
        "ponuda a join kategorija k on a.kategorijaID = k.kategorijaID join program p on k.programID = p.programID "
                + uslov+ " order by a.ponudaID";
        
        System.out.println(upit);
        
        lista = DbBroker.getArr(upit);
        
        System.out.println("Lista 1 je velika: "+lista.size());
        
        for(String[] p:lista)
        {
            Proizvod pr = new Proizvod();

            try 
            {
                pr.setPonudaID(Integer.parseInt(p[0]));
                
                pr.setNaziv(p[1]);
                
                pr.setCena(Double.parseDouble(p[2]));
                
                double cenaSaPopustom = (p[3] != null) ? Double.parseDouble(p[3]): Double.parseDouble(p[2]);
                pr.setCenaSaPopustom(cenaSaPopustom);
                
                pr.setKategorijaID(Integer.parseInt(p[4]));
                
                pr.setKolicina(Integer.parseInt(p[5]));
                
                pr.setNazivKategorije(p[6]);
                
                pr.setSlika(p[7]);
                
                slatki.add(pr);
            } 
            catch (Exception e) 
            {
                System.out.println("Greska je: "+e.getMessage());
            }
       }
        
        //System.out.println("Lista 2 je velika: "+lista.size());
        
        return slatki;
    }
    
   /* public ArrayList<Proizvod> VratiProizvodeKategorije(int kategorija)
    {
        ArrayList<Proizvod> proizvodi = new ArrayList<>();    
        
        String upit = "Select a.ponudaID ,a.naziv, a.cena, a.cenaSaPopustom, a.kategorijaID, a.kolicina "
                + "from ponuda a where a.kategorijaID="+kategorija;
        
        lista = DbBroker.getArr(upit);
        
        for(String[] p:lista)
        {
            Proizvod pr = new Proizvod();

            try 
            {
                pr.setPonudaID(Integer.parseInt(p[0]));
                
                pr.setNaziv(p[1]);
                
                pr.setCena(Double.parseDouble(p[2]));
                
                double cenaSaPopustom = (p[3] != null) ? Double.parseDouble(p[3]): Double.parseDouble(p[2]);
                pr.setCenaSaPopustom(cenaSaPopustom);
                
                pr.setKategorijaID(Integer.parseInt(p[4]));
                
                pr.setKolicina(Integer.parseInt(p[5]));
                
                proizvodi.add(pr);
            } 
            catch (Exception e) 
            {
                System.out.println("Greska je: "+e.getMessage());
            }
        }
        return proizvodi;
    }*/
    
    public String VratiKategoriju(int kategorijaID)
    {
        Proizvod p = new Proizvod();
        
        String upit = "select naziv from kategorija k where k.kategorijaID ="+kategorijaID;
        
        ArrayList<String[]> program = DbBroker.getArr(upit);
        
        String[] programID = program.get(0);
        
        p.setNazivKategorije(programID[0]);
        
        return p.getNazivKategorije();
    }
    
    public boolean KreirajArtikal(Proizvod p)
    {

        String upit = "Insert into ponuda (naziv,kategorijaID,kolicina,cena,cenaSaPopustom,slika,brisano) "
                + "values ('"+p.getNaziv()+"','"+p.getKategorijaID()+"','"+p.getKolicina()+"','"+p.getCena()+"','"+p.getCenaSaPopustom()+"','"+p.getSlika()+"','"+0+"')";
        
        return DbBroker.simpleQuery(upit);
        
    }
    
    public boolean ObrisiArtikal(Proizvod p)
    {
        ArrayList<String []> update;
        
        String upit = "Select p.ponudaID from ponuda p where p.ponudaID="+p.getPonudaID()+" and p.brisano=0";
        
        update = (ArrayList<String[]>) DbBroker.getArr(upit);
        
        Proizvod pa = new Proizvod();
        
        for(String[] i:update)
        {
            pa.setPonudaID(Integer.parseInt(i[0]));
        }
        
        upit = "Update ponuda set brisano=1 where ponudaID="+pa.getPonudaID();
        
        return DbBroker.simpleQuery(upit);
    }
    
    public Proizvod PreuzmiArtikal(int ponudaID)
    {
        String upit = "Select a.ponudaID, a.naziv, a.kolicina , a.cena, a.cenaSaPopustom, a.slika , a.kategorijaID\n" +
                "from ponuda a where a.ponudaID="+ponudaID;

                ArrayList<String []> lista = DbBroker.getArr(upit);
                
                String[] niz = lista.get(0);
                
                Proizvod p = new Proizvod();
                
                p.setPonudaID(ponudaID);
                p.setNaziv(niz[1]);
                p.setKolicina(Integer.parseInt(niz[2]));
                p.setCena(Double.parseDouble(niz[3]));
                p.setCenaSaPopustom(Double.parseDouble(niz[4]));
                p.setSlika(niz[5]);
                p.setKategorijaID(Integer.parseInt(niz[6]));
           
                return p;
    }
    
    public boolean IzmeniArtikal(Proizvod p, int ponudaID)
    {

        String upit = "Update ponuda set naziv='"+p.getNaziv()+"', kolicina="+p.getKolicina()+
                ", cena="+p.getCena()+", cenaSaPopustom="+p.getCenaSaPopustom()+", slika='"+p.getSlika()
                +"', kategorijaID="+p.getKategorijaID()+" where ponudaID="+ponudaID;
        
                return DbBroker.simpleQuery(upit);
    }
    
}
