package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import IO.DbBroker;
import beans.Korisnik;
import beans.Korisnik;

public final class registrujSe_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/izgled/slika.jsp");
    _jspx_dependants.add("/izgled/header.jsp");
    _jspx_dependants.add("/izgled/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    if (session.getAttribute("msg") != null) {
      out.write('\n');
      out.print(session.getAttribute("msg"));
      out.write("  \n");
 session.removeAttribute("msg");
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" \n");
      out.write("              integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <title>Registracija</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/css.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    </head>>\n");
      out.write("    <body>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
      out.write("&nbsp\r\n");
      out.write("<h1>\r\n");
      out.write("\t<div>\r\n");
      out.write("     \t<a href=\"index.jsp\"><img src=\"slike/RLRS_SHOP_Catering.png\" width=\"100\" height=\"100\" alt=\"slika\"></a>\r\n");
      out.write("\t\t<small class=\"boja\"><b>RLRS Catering</b></small>\r\n");
      out.write("\t</div>\r\n");
      out.write("</h1>");
      out.write("\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\n");
      out.write("    <a class=\"navbar-brand\" href=\"index.jsp\">RLRS Ketering</a>\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" \n");
      out.write("            data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("    </button>\n");
      out.write("\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("        <ul class=\"navbar-nav \">\n");
      out.write("            <li class=\"nav-item active\">\n");
      out.write("                <a class=\"nav-link\" href=\"onama.jsp\">O nama <span class=\"sr-only\">(current)</span></a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item active\">\n");
      out.write("                <a class=\"nav-link\" href=\"Artikal?komanda=slatki\">Slatki program<span class=\"sr-only\">(current)</span></a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item active\">\n");
      out.write("                <a class=\"nav-link\" href=\"Artikal?komanda=slani\">Slani program<span class=\"sr-only\">(current)</span></a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item active\">\n");
      out.write("                <a class=\"nav-link\" href=\"Artikal?komanda=sve\">Cela ponuda<span class=\"sr-only\">(current)</span></a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item dropdown nav-item active\">\n");
      out.write("                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Izaberite</a>\n");
      out.write("                <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                    <a class=\"dropdown-item\" href=\"onama.jsp\">Kratak opis Projekta</a>\n");
      out.write("                    ");

                        int uloga = 0;
                        String ime = "";
                        int ID = 0;
                        Korisnik k;
                        if (session.getAttribute("korisnik") != null) {

                            k = (Korisnik) session.getAttribute("korisnik");

                            uloga = k.getUloga();
                            ime = k.getImeKorisnika();
                            ID = k.getKorisnikID();

                        }

                        if (uloga > 2) {
      out.write("\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"Artikal?komanda=kreiraj\">Kreiraj jelo</a>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    ");
 if(uloga>1) {
      out.write("\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"Artikal?komanda=preuzmi\">Izmeni jelo</a> \n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    ");
 if(uloga>2) {
      out.write("\n");
      out.write("                    <div class=\"dropdown-divider\"></div>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"Artikal?komanda=sve\">Obrisi jelo</a>\n");
      out.write("                    <div class=\"dropdown-divider\"></div>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"Korisnik?komanda=sve\">Pregled korisnika</a>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("        <form class=\"form-inline my-2 my-lg-0 mr-auto\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <!--<a href=\"korpa.php\"> <img src=\"Slike/korpa.png\" width=\"40\"></a><span class=\"badge\"><?php echo $brArt ?></span>  &nbsp; &nbsp; &nbsp; -->\n");
      out.write("\n");
      out.write("        <!-- <?php \n");
      out.write("     \n");
      out.write("         if (!isset($_SESSION['Ime']) ) \n");
      out.write("         {\n");
      out.write("            $ispis = '<a class=\"nav-link\" href=\"indexregistrujse.php\">Registruj se</a>';\n");
      out.write("            $ispis2 = '<a class=\"nav-link\" href=\"indexlogin.php\">Log in</a>';\n");
      out.write("         }\n");
      out.write("         else\n");
      out.write("         {\n");
      out.write("           $ispis = '<span class=\"nav-link\">Korisnik: '.$_SESSION['Ime']. '</span>';\n");
      out.write("           $ispis2 = '<a class=\"nav-link\" href=\"indexlogout.php\">Log out</a>';\n");
      out.write("         }\n");
      out.write("     \n");
      out.write("          ?> -->\n");
      out.write("        ");


            if (uloga > 0) {
      out.write("\n");
      out.write("        <a class=\"nav-link\" href=\"Korpa?komanda=dugme1&korisnikID=");
      out.print(ID);
      out.write("\"><img src=\"slike/Ketering_korpa.png\" width=\"40\"></a><span class=\"badge\"></span>\n");
      out.write("        <a class=\"nav-link\" href=\"Korisnik?komanda=izmeni&korisnikID=");
      out.print(ID);
      out.write('"');
      out.write('>');
      out.print(ime);
      out.write("</a>\n");
      out.write("        <a class=\"nav-link\" href=\"Korisnik?komanda=logOut\">Log out</a>\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        <a class=\"nav-link\" href=\"registrujSe.jsp\">Registruj se</a>\n");
      out.write("        <a class=\"nav-link\" href=\"logIn.jsp\">Log in</a>        \n");
      out.write("        ");
}
      out.write("\n");
      out.write("        <ul class=\"navbar-nav \">\n");
      out.write("            <li class=\"nav-item active\">\n");
      out.write("                <!--<?php echo $ispis; ?>-->\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item active\">\n");
      out.write("                <!-- <?php echo $ispis2; ?> -->\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!--Pocetak Forme -->\n");
      out.write("\n");
      out.write("            <div class=\"row mt-4\">\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <h2 class=\"boja\">Registruj se</h2>\n");
      out.write("                    <hr>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <form method=\"Post\" action=\"registrujSe\">\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label for=\"inputEmail4\">Vas Email:</label>\n");
      out.write("                                <input type=\"email\" class=\"form-control\" id=\"inputEmail4\" name=\"Email\" placeholder=\"Unesite vas E-mail:\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label for=\"inputEmail4\">Vasa sifra:</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"Pass\" name=\"Pass\" placeholder=\"Unesite vasu sifru:\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label for=\"inputEmail4\">Vase Ime i Prezime:</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"ImePrezime\" name=\"ImePrezime\" placeholder=\"Unesite vase Ime i prezime:\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label for=\"inputEmail4\">Vas kontakt:</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"Kontakt\" name=\"Kontakt\" placeholder=\"Unesite vas Broj Telefona:\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"form-group col-md-6\">\n");
      out.write("                                <label for=\"inputEmail4\">Vasa adresa:</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"adresa\" name=\"Adresa\" placeholder=\"Unesite vasu trenutnu adresu:\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>        \n");
      out.write("                        <div>\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary btn-sm\" name=\"dugme\">Registruj se</button>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        &nbsp\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
      out.write("\r\n");
      out.write("<div class=\"card-footer\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"col-md-6\">\r\n");
      out.write("            <ul class=\"list-inline\">\r\n");
      out.write("                <li class=\"list-inline-item\"><a href=\"onama.jsp\">O nama</a></li>\r\n");
      out.write("                    ");

                        int uloga1 = 0;
                        Korisnik k1;
                        if (session.getAttribute("korisnik") != null) 
                        {

                            k1 = (Korisnik) session.getAttribute("korisnik");

                            uloga1 = k1.getUloga();

                        }
                        
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                       ");
 if (uloga1==0) 
                       {
      out.write("\r\n");
      out.write("                <li class=\"list-inline-item\"><a href=\"registrujSe.jsp\">Registruj se</a></li>\r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-md-6\">\r\n");
      out.write("            <p class=\"text-right boja\">Copyright &copy; Ketering Projekat - Internet Programerski Alati 2022.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("    </div>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" \n");
      out.write("    integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" \n");
      out.write("    integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" \n");
      out.write("    integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
