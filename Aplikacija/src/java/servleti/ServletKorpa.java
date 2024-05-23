/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import IO.DbBroker;
import Repository.KorpaRepository;
import beans.Korisnik;
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
public class ServletKorpa extends HttpServlet {

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

        String dugme = (request.getParameter("dugme") != null) ? request.getParameter("dugme") : "";

        ArrayList<Proizvod> korpa;
        KorpaRepository kp;
        HttpSession sesija = request.getSession();

        Korisnik k = ((Korisnik) sesija.getAttribute("korisnik") != null) ? (Korisnik) sesija.getAttribute("korisnik") : new Korisnik();

        if (!dugme.isEmpty()) 
        {

            if (sesija.getAttribute("korpa") != null) 
            {
                korpa = (ArrayList<Proizvod>) sesija.getAttribute("korpa");
            } 
            else 
            {
                korpa = new ArrayList<>();
                sesija.setAttribute("korpa", korpa);
            }

            kp = new KorpaRepository();

            kp.dodajUKorpu(1, dugme, korpa, k.getKorisnikID());

            Poruke p = new Poruke();

            p.setPoruka("Uspesno dodat Artikal!");
            p.setTip("uspesno");
            p.setLink("Korpa");
            p.setIspisDugme("Prikaz korpe");

            sesija.setAttribute("poruka", p);

            response.sendRedirect("poruka.jsp");
        }
        
        if (request.getParameter("dugme1") != null || request.getParameter("komanda") != null) 
        {
            kp = new KorpaRepository();

            if (request.getParameter("korisnikID") != null) 
            {
                korpa = kp.VratiKorpu(Integer.parseInt(request.getParameter("korisnikID")));
                
            } else 
            {
                korpa = kp.VratiKorpu(k.getKorisnikID());
            }
            sesija.setAttribute("korpa", korpa);
            int brArt = korpa.size();
            sesija.setAttribute("ukorpi", brArt);
            //System.out.println("Velicina korpe je: " + korpa.size());
            response.sendRedirect("korpa.jsp");

        }

        if (request.getParameter("izbaci") != null) 
        {
            kp = new KorpaRepository();

            int korisnikID = k.getKorisnikID();
            int ponudaID = Integer.parseInt(request.getParameter("izbaci"));

            if (kp.UkloniIzKorpe(korisnikID, ponudaID)) 
            {

                sesija.setAttribute("korpa", kp.VratiKorpu(korisnikID));
                
                Poruke po = new Poruke();

                po.setPoruka("Uspesno brisanje iz korpe !!!");
                po.setTip("uspesno");
                po.setLink("korpa.jsp");
                po.setIspisDugme("Vratite se u korpu");

                //System.out.println("Podesio sam poruku");
                sesija.setAttribute("poruka", po);

                //System.out.println("Kreirao sam sesiju");
                response.sendRedirect("poruka.jsp");
                return;
            } 
            else 
            {
                Poruke po = new Poruke();

                po.setPoruka("Neuspesno brisanje iz korpe !!!");
                po.setTip("neuspesno");
                po.setLink("korpa.jsp");
                po.setIspisDugme("Pokusajte ponovo vracanjem u korpu");

                //System.out.println("Podesio sam poruku");
                sesija.setAttribute("poruka", po);

                //System.out.println("Kreirao sam sesiju");
                response.sendRedirect("poruka.jsp");
                return;
            }
        }
        
        if(request.getParameter("izmeni") != null)
        {
            
            k = (Korisnik)sesija.getAttribute("korisnik");
            
            int ponudaID = Integer.parseInt(request.getParameter("izmeni"));
            String naziv = "kolicina"+ponudaID;
            int kolicina = Integer.parseInt(request.getParameter(naziv));
            
            kp = new KorpaRepository();
            
            if(kp.IzmeniKolicinu(k.getKorisnikID(), ponudaID, kolicina))
            {
                sesija.setAttribute("korpa", kp.VratiKorpu(k.getKorisnikID()));
                response.sendRedirect("korpa.jsp");
                return;
            }
            else
            {
                Poruke po = new Poruke();

                po.setPoruka("Neuspesno menjanje kolicine u korpi !!!");
                po.setTip("neuspesno");
                po.setLink("korpa.jsp");
                po.setIspisDugme("Pokusajte ponovo vracanjem u korpu");

                //System.out.println("Podesio sam poruku");
                sesija.setAttribute("poruka", po);

                //System.out.println("Kreirao sam sesiju");
                response.sendRedirect("poruka.jsp");
                return;
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
