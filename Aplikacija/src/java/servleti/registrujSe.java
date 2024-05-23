/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import IO.DbBroker;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nikol
 */
public class registrujSe extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession sesija = request.getSession();
            
            if(request.getParameter("Email")!=null &&  request.getParameter("Pass")!=null && request.getParameter("ImePrezime")!=null
                  && request.getParameter("Kontakt")!=null && request.getParameter("Adresa")!=null) 
          {
              String email = request.getParameter("Email");
              String sifra = request.getParameter("Pass");
              String imePrezime = request.getParameter("ImePrezime");
              String kontakt = request.getParameter("Kontakt");
              String adresa = request.getParameter("Adresa");
              
              String upit = "Insert into korisnik (korisnickoIme,sifra,kontakt,uloga,adresa,imeKorisnika) "
                      + "values ('"+email+"','"+sifra+"','"+kontakt+"','"+1+"','"+adresa+"','"+imePrezime+"')";
              
              boolean uspesno = DbBroker.simpleQuery(upit);
              System.out.println("Upit je zavrsen: "+uspesno);
              response.sendRedirect("logIn.jsp");
           }
          else
          {
              String msg = "Dogodila se greska pri kreiranju novog korisnika!";
              sesija.setAttribute("msg", msg);
              response.sendRedirect("registrujSe.jsp");
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
