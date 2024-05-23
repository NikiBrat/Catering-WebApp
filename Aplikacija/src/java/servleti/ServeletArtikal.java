/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import IO.DbBroker;
import Repository.ArtikalRepository;
import beans.Poruke;
import beans.Proizvod;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nikol
 */
public class ServeletArtikal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String komanda="";
        int kategorijaID=0;
        
        komanda = (request.getParameter("komanda") != null) ? request.getParameter("komanda") : "";
        
        HttpSession sesija = request.getSession();
        
        if(request.getParameter("brisanjeUpit")!=null)
        {
            komanda = "brisanjeUpit";
        }
        if(request.getParameter("izaberi")!=null)
        {
            komanda = "izaberi";
        }
        if(request.getParameter("odaberi")!=null)
        {
            kategorijaID = Integer.parseInt(request.getParameter("odaberi"));
        }
        if(request.getParameter("promeni")!=null)
        {
            komanda="promeni";
        }
        
        //System.out.println("Komanda je: "+komanda);
        
        switch (komanda) {
            
            case "preuzmi":
            {
                ArtikalRepository ar = new ArtikalRepository();
                
                ArrayList<Proizvod> sve = ar.VratiPonudu("sve","");
                
                request.setAttribute("ponuda", sve);

                request.setAttribute("ispis", "Ceo nas program");
                
                request.getRequestDispatcher("prikazIzmeneArtikala.jsp").forward(request, response);
                break;
            }
            
            case "promeni":
            {
                 ArtikalRepository ar = new ArtikalRepository();
                
                int ponudaID = Integer.parseInt(request.getParameter("promeni"));  
                
                Proizvod p = ar.PreuzmiArtikal(ponudaID);
                
                request.setAttribute("proizvod", p);
                
                request.getRequestDispatcher("izmeniArtikal.jsp").forward(request, response);
                break;
            }
            
            case "izmeni":
            {
                ArtikalRepository ar = new ArtikalRepository();
                
                Proizvod p = new Proizvod();
                //System.out.println("Nova Cena je: "+request.getParameter("Cena"));
                p.setPonudaID(Integer.parseInt(request.getParameter("ponudaID")));
                p.setNaziv(request.getParameter("Naziv"));
                p.setKolicina(Integer.parseInt(request.getParameter("Kolicina")));
                p.setCena(Double.parseDouble(request.getParameter("Cena")));
                p.setCenaSaPopustom(Double.parseDouble(request.getParameter("CenaSaPopustom")));
                p.setSlika(request.getParameter("Slika"));
                p.setKategorijaID(Integer.parseInt(request.getParameter("Kategorija")));
                        
                if(ar.IzmeniArtikal(p, p.getPonudaID()))
                {
                    //System.out.println("Usao sam u if sa true");
                               
                    Poruke po = new Poruke();

                    po.setPoruka("Uspesno izmenjen Artikal!");
                    po.setTip("uspesno");
                    po.setLink("index.jsp");
                    po.setIspisDugme("Vrati se pocetnu");
                    
                    //System.out.println("Podesio sam poruku");
                    
                    sesija.setAttribute("poruka", po);
                    
                    //System.out.println("Kreirao sam sesiju");

                    response.sendRedirect("poruka.jsp");
                }
                break;
            }
            
            case "izaberi": 
            {
                ArtikalRepository ar = new ArtikalRepository();
                
                String naziv="";
                
                naziv = ar.VratiKategoriju(kategorijaID);
                
                String pgm = request.getParameter("pgm");
                
                ArrayList<Proizvod> proizvodi;
                
                proizvodi = ar.VratiPonudu(pgm, naziv);
                
                request.setAttribute("ponuda", proizvodi);
                
                if(pgm.equals("slatki"))
                {
                    request.setAttribute("ispis", "slatkog");
                }
                if(pgm.equals("slani"))
                {
                    request.setAttribute("ispis", "slanog");
                }
                else
                {
                    request.setAttribute("ispis", "Svih");
                }
                
                request.setAttribute("komanda", pgm);
                
                request.getRequestDispatcher("ponuda.jsp").forward(request, response);
                
                break;
            }
            
            
            case "slatki": 
            {
                  
                ArtikalRepository ar = new ArtikalRepository();
                
                ArrayList<Proizvod> slatki;

                slatki = ar.VratiPonudu("slatki","");

                request.setAttribute("ponuda", slatki);

                request.setAttribute("ispis", "slatkog");

                request.getRequestDispatcher("ponuda.jsp").forward(request, response);

                break;
            }

            case "slani": 
            {
                ArtikalRepository ar = new ArtikalRepository();

                ArrayList<Proizvod> slani;

                slani = ar.VratiPonudu("slani","");

                request.setAttribute("ponuda", slani);

                request.setAttribute("ispis", "slanog");

                request.getRequestDispatcher("ponuda.jsp").forward(request, response);

                break;
            }

            case "sve": 
            {
                ArtikalRepository ar = new ArtikalRepository();

                ArrayList<Proizvod> sve;
                
                sve = ar.VratiPonudu("sve","");

                request.setAttribute("ponuda", sve);

                request.setAttribute("ispis", "Ceo nas program");

                request.getRequestDispatcher("ponuda.jsp").forward(request, response);

                break;
            }

            case "kreiraj": 
            {

                request.getRequestDispatcher("kreirajArtikal.jsp").forward(request, response);

                //ar.KreirajArtikal();
                break;

            }

            case "sacuvaj": {
                
                
                if(request.getParameter("Naziv") != null && request.getParameter("Kategorija") != null 
                        && request.getParameter("Cena") != null && request.getParameter("Kolicina") 
                        != null && request.getParameter("Slika") != null)
                {
                Proizvod p = new Proizvod();
                p.setNaziv(request.getParameter("Naziv"));
                p.setKategorijaID(Integer.parseInt(request.getParameter("Kategorija")));
                p.setKolicina(Integer.parseInt(request.getParameter("Kolicina")));
                p.setCena(Double.parseDouble(request.getParameter("Cena")));
                double cenaSaPopustom = (request.getParameter("CenaSaPopustom") != null && !request.getParameter("CenaSaPopustom").isEmpty())
                        ? Double.parseDouble(request.getParameter("CenaSaPopustom")) : Double.parseDouble(request.getParameter("Cena"));

                p.setCenaSaPopustom(cenaSaPopustom);

                p.setSlika(request.getParameter("Slika"));

                ArtikalRepository ar = new ArtikalRepository();

                if (ar.KreirajArtikal(p)) 
                {
                    //System.out.println("Usao sam u if sa true");
                    
                    Poruke po = new Poruke();

                    po.setPoruka("Uspesno kreiran Artikal!");
                    po.setTip("uspesno");
                    po.setLink("index.jsp");
                    po.setIspisDugme("Vrati se pocetnu");
                    
                    //System.out.println("Podesio sam poruku");
                    
                    sesija.setAttribute("poruka", po);
                    
                    //System.out.println("Kreirao sam sesiju");

                    response.sendRedirect("poruka.jsp");
                    
                }
                else
                {
                    Poruke po = new Poruke();

                    po.setPoruka("Neuspesno kreiran Artikal!");
                    po.setTip("neuspesno");
                    po.setLink("kreirajArtikal.jsp");
                    po.setIspisDugme("Vrati se na kreiranje");

                    sesija.setAttribute("poruka", po);

                    response.sendRedirect("poruka.jsp");
                    }
                }
                break;
            }  
            
            case "brisanjeUpit":
            {
                String ponudaID = request.getParameter("brisanjeUpit");
                
                Poruke po = new Poruke();
                
                po.setPoruka("Da li zelite da obrisete artikal?");
                po.setTip("warning");
                po.setLink("Artikal?komanda=brisanje&brisanje="+ponudaID);
                po.setLink2("Artikal?komanda=sve");
                po.setIspisDugme("Da");
                po.setIspisDugme2("Ne");
                po.setBrDugmica(2);
                
                sesija.setAttribute("poruka", po);
                System.out.println("ID je: "+ponudaID);
                response.sendRedirect("poruka.jsp");
                
                break;
            }
            
            case "brisanje": 
            {
                
                Proizvod p = new Proizvod();
                
                p.setPonudaID(Integer.parseInt(request.getParameter("brisanje")));
                
                ArtikalRepository ar = new ArtikalRepository();
                
                if(ar.ObrisiArtikal(p))
                {
                    System.out.println("Usao sam u if sa true");
                    
                    Poruke po = new Poruke();

                    po.setPoruka("Uspesno obrisan Artikal!");
                    po.setTip("uspesno");
                    po.setLink("Artikal?komanda=sve");
                    po.setIspisDugme("Vrati se na ponude");
                    
                    //System.out.println("Podesio sam poruku");
                    
                    sesija.setAttribute("poruka", po);
                    
                    //System.out.println("Kreirao sam sesiju");

                    response.sendRedirect("poruka.jsp");
                }
                else
                {
                    Poruke po = new Poruke();

                    po.setPoruka("Neuspesno obrisan Artikal!");
                    po.setTip("neuspesno");
                    po.setLink("ponuda.jsp");
                    po.setIspisDugme("Vrati se na sve artikle");

                    sesija.setAttribute("poruka", po);

                    response.sendRedirect("poruka.jsp");
                }
                
                break;
            }
            
            default: {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
