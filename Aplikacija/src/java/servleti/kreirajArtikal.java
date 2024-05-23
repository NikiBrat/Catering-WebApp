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
public class kreirajArtikal extends HttpServlet {

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
             
            HttpSession sesija = request.getSession();
            
            if(request.getParameter("Email")!=null &&  request.getParameter("Pass")!=null && request.getParameter("ImePrezime")!=null
                  && request.getParameter("Kontakt")!=null && request.getParameter("Adresa")!=null) 
          {
              String Naziv = request.getParameter("Naziv");
              String Kategorija = request.getParameter("Kategorija");
              String Kolicina = request.getParameter("Kolicina");
              String Cena = request.getParameter("Cena");
              String CenaSaPopustom = request.getParameter("CenaSaPopustom");
              String Slika = request.getParameter("Slika");
              
              String upit = "Insert into korisnik (naziv,kategorija,kolicina,cena,cenaSaPopustom,slika) "
                      + "values ('"+Naziv+"','"+Kategorija+"','"+Kolicina+"','"+Cena+"','"+CenaSaPopustom+"','"+Slika+".jpg')";
              
              boolean uspesno = DbBroker.simpleQuery(upit);
              System.out.println("Upit je zavrsen: "+uspesno);
              response.sendRedirect("index.jsp");
           }
          else
          {
              String msg = "Dogodila se greska pri kreiranju novog artikla!";
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
