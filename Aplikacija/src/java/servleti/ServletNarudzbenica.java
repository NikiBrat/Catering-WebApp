/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import Repository.NarudzbenicaRepository;
import beans.Korisnik;
import beans.Narudzbina;
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
public class ServletNarudzbenica extends HttpServlet {

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
        
        HttpSession sesija = request.getSession();
        
        
        if(request.getParameter("placanje") != null)
        {
           request.getRequestDispatcher("nacinPlacanja.jsp").forward(request, response);
        }
        
        if(request.getParameter("naruci")!=null)
        {
            NarudzbenicaRepository nar = new NarudzbenicaRepository();
            
            double ukupno = (double)sesija.getAttribute("ukupna");
            
            String nacinPlacanja = (String)request.getParameter("radio");
                       
            //System.out.println("Nacin placanja je: "+nacinPlacanja);
            
            Korisnik k = (Korisnik)sesija.getAttribute("korisnik");
            
            boolean uspeh=nar.Naruci(k.getKorisnikID(),ukupno,nacinPlacanja);
            
            if(uspeh)
            {
                
                ArrayList<Proizvod> lista = nar.VratiNarudzbenicu();
                sesija.setAttribute("nacinPlacanja", nacinPlacanja);
                sesija.setAttribute("narudzbenica", lista);
                
                if(nar.UmanjiKolicinu(lista))
                {
                    Poruke po = new Poruke();

                    po.setPoruka("Uspesno ste narucili vase Proizvode !!!");
                    po.setTip("uspesno");
                    po.setLink("prikazNarudzbenice.jsp");
                    po.setIspisDugme("Pogledaj narudzbinu");

                    //System.out.println("Podesio sam poruku");
                    sesija.setAttribute("poruka", po);

                    //System.out.println("Kreirao sam sesiju");
                    response.sendRedirect("poruka.jsp");
                    return;
                }
      
            }
            else
            {
                Poruke po = new Poruke();

                po.setPoruka("Dogodila se greska pri narucivanju, molimo Vas pokusajte ponovo!!!");
                po.setTip("neuspesno");
                po.setLink("korpa.jsp");
                po.setIspisDugme("Vrati se u korpu");

                //System.out.println("Podesio sam poruku");
                sesija.setAttribute("poruka", po);

                //System.out.println("Kreirao sam sesiju");
                response.sendRedirect("poruka.jsp");
                return;
            }
        }
        
        if(request.getParameter("komanda") !=null && request.getParameter("komanda").equals("sve"))
        {
            NarudzbenicaRepository nar = new NarudzbenicaRepository();
            ArrayList<Narudzbina> narudzbine = nar.getNarudzbine();
            System.out.println("Lista narudzbina je dugacka " + narudzbine.size());
            sesija.setAttribute("narudzbine", narudzbine);
            response.sendRedirect("prikazNarudzbina.jsp");
        }
        
        if(request.getParameter("zatvaranje") !=null) {
            NarudzbenicaRepository nar = new NarudzbenicaRepository();
            String narudzbinaId = request.getParameter("zatvaranje");
            boolean uspeh = nar.zatvoriNarudzbinu(narudzbinaId);
            Poruke po = new Poruke();
            po.setLink("Narudzbenica?komanda=sve");
            po.setIspisDugme("Nazad na narudžbine");
            
            if (uspeh) {
                po.setPoruka("Narudžbina je zatvorena");
                po.setTip("uspesno");
            }
            else {
                po.setPoruka("Greška kod zatvaranja narudžbine");
                po.setTip("neuspesno");
            }
            sesija.setAttribute("poruka", po);
            response.sendRedirect("poruka.jsp");
        }
        
        if(request.getParameter("detalji") !=null) {
            NarudzbenicaRepository nar = new NarudzbenicaRepository();
            String narudzbinaId = request.getParameter("detalji");
            
            ArrayList<Proizvod> lista = nar.VratiNarudzbenicu(narudzbinaId);
            sesija.setAttribute("lista", lista);
            response.sendRedirect("detaljiNarudzbine.jsp");
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
