package servleti;

import IO.DbBroker;
import Repository.KorisnikRepository;
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

public class ServletKorisnik extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesija = request.getSession();
            KorisnikRepository rep = new KorisnikRepository();
            if (request.getParameter("Email") != null && request.getParameter("Pass") != null) {
                String korisnickoIme = request.getParameter("Email");
                String sifra = request.getParameter("Pass");

                Korisnik k = rep.UlogujMe(korisnickoIme, sifra);

                if (k != null) 
                {
                    sesija.setAttribute("korisnik", k);
                    
                    ArrayList<Proizvod> korpa;
                    
                    KorpaRepository kp = new KorpaRepository();
                    
                    korpa = kp.VratiKorpu(k.getKorisnikID());
                    
                    int brArt = korpa.size();
                    
                    sesija.setAttribute("ukorpi", brArt);
                    
                    Poruke po = new Poruke();

                    po.setPoruka("Dobrodosli nazad !!!");
                    po.setTip("uspesno");
                    po.setLink("index.jsp");
                    po.setIspisDugme("Idite na pocetnu");

                    //System.out.println("Podesio sam poruku");
                    sesija.setAttribute("poruka", po);

                    //System.out.println("Kreirao sam sesiju");
                    response.sendRedirect("poruka.jsp");
                    return;
                    
                } else {

                    //System.out.println("Usao sam u if sa true");
                    Poruke po = new Poruke();

                    po.setPoruka("Neuspesan Log IN !!!");
                    po.setTip("neuspesno");
                    po.setLink("logIn.jsp");
                    po.setIspisDugme("Pokusajte ponovo Log IN");

                    //System.out.println("Podesio sam poruku");
                    sesija.setAttribute("poruka", po);

                    //System.out.println("Kreirao sam sesiju");
                    response.sendRedirect("poruka.jsp");
                    return;
                }
            }

            String komanda = (request.getParameter("komanda") != null) ? request.getParameter("komanda") : "";
            if (request.getParameter("dugmeBrisi") != null) {
                komanda = "brisi";
            }
            if (request.getParameter("dugmeIzmeni") != null) {
                komanda = "izmeni";
            }
            if (request.getParameter("zapamtiPromene") != null) {
                komanda = "memorisi";
            }

            switch (komanda) {
                case "logOut": {
                    sesija.invalidate();
                    Poruke po = new Poruke();
                    po.setPoruka("Uspesno ste se Log Out-ovali !!!");
                    po.setTip("uspesno");
                    po.setLink("index.jsp");
                    po.setIspisDugme("Pocetna strana");

                    sesija = request.getSession();

                    sesija.setAttribute("poruka", po);

                    response.sendRedirect("poruka.jsp");
                    break;
                }

                case "sve": {
                    ArrayList korisnici = rep.getKorisnici();
                    sesija.setAttribute("korisnici", korisnici);
                    response.sendRedirect("korisnici.jsp");
                    break;
                }

                case "brisi": {
                    String korisnikID = request.getParameter("korisnikID");
                    Poruke p = new Poruke();
                    p.setIspisDugme("Lista korisnika");
                    p.setLink("Korisnik?komanda=sve");

                    if (rep.brisiKorisnika(korisnikID)) {
                        p.setPoruka("Korisnik je obrisan");
                        p.setTip("uspesno");
                    } else {
                        p.setPoruka("Korisnik nije izbrisan");
                        p.setTip("neuspesno");

                    }
                    sesija.setAttribute("poruka", p);
                    response.sendRedirect("poruka.jsp");
                    break;
                }

                case "izmeni": {
                    String korisnikID = request.getParameter("korisnikID");
                    Korisnik k = rep.getKorisnik(korisnikID);
                    sesija.setAttribute("korisnikZaIzmenu", k);
                    response.sendRedirect("izmenaKorisnika.jsp");
                    break;
                }

                case "memorisi": {
                    int uloga = -1, korisnikID=0;
                    Korisnik k = new Korisnik();
                    
                    Korisnik ulo = (Korisnik)sesija.getAttribute("korisnik");
                    int ulogaa = ulo.getUloga();
                    int sesijakorisnikID = ulo.getKorisnikID();
                    
                    String email = request.getParameter("Email");
                    String sifra = request.getParameter("sifra");
                    String imePrezime = request.getParameter("ImePrezime");
                    String kontakt = request.getParameter("Kontakt");
                    String adresa = request.getParameter("Adresa");
                    try {
                        uloga = (request.getParameter("Uloga") != null) ? Integer.parseInt(request.getParameter("Uloga")) : -1;
                        korisnikID = (request.getParameter("korisnikId") != null) ? Integer.parseInt(request.getParameter("korisnikId")) : 0;
                    }
                    catch (NumberFormatException ex) {
                        System.err.println("GREŠKA kod parsiranja role: " + ex);
                    }
                    
                    k.setKorisnikID(korisnikID);
                    k.setAdresa(adresa);
                    k.setImeKorisnika(imePrezime);
                    k.setSifra(sifra);
                    k.setKorisnickoIme(email);
                    k.setKontakt(kontakt);
                    k.setAdresa(adresa);
                    k.setUloga(uloga);
                    
                    KorisnikRepository kr = new KorisnikRepository();
                    boolean uspeh = kr.izmeniKorisnika(k);
                    
                    Poruke p = new Poruke();
                    if (ulogaa > 1) 
                    {
                        if (uspeh) 
                        {
                            p.setIspisDugme("Lista korisnika");
                            p.setLink("Korisnik?komanda=sve"); 
                            p.setPoruka("Podaci su uspešno izmenjeni");
                            p.setTip("uspesno");
                            
                            if(sesijakorisnikID == k.getKorisnikID())
                            {
                                sesija.setAttribute("novoIme", k.getImeKorisnika());
                            }
                        } 
                            else 
                        {
                            p.setIspisDugme("Vratite se na izmene");
                            p.setLink("Korisnik?komanda=izmeni"); 
                            p.setPoruka("Greška kod izmene podataka");
                            p.setTip("neuspesno");
                        }
                        
                    } 
                    else
                    {
                        if (uspeh) 
                        {
                            p.setIspisDugme("Vratite se na pocetnu");
                            p.setLink("index.jsp");
                            p.setPoruka("Podaci su uspešno izmenjeni");
                            p.setTip("uspesno");
                            
                             if(sesijakorisnikID == k.getKorisnikID())
                            {
                                sesija.setAttribute("novoIme", k.getImeKorisnika());
                            }
                            
                        } 
                            else 
                        {
                            p.setIspisDugme("Vratite se na izmene");
                            p.setLink("Korisnik?komanda=izmeni"); 
                            p.setPoruka("Greška kod izmene podataka");
                            p.setTip("neuspesno");
                        }     
                    }
                    sesija.setAttribute("poruka", p);
                    response.sendRedirect("poruka.jsp");

                    break;
                }
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
