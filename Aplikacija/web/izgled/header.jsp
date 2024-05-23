<%@page import="beans.Korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="index.jsp">RLRS Ketering</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" 
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ">
            <li class="nav-item active">
                <a class="nav-link" href="onama.jsp">O nama <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="Artikal?komanda=slatki">Slatki program<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="Artikal?komanda=slani">Slani program<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="Artikal?komanda=sve">Cela ponuda<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown nav-item active">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Izaberite</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="onama.jsp">Kratak opis Projekta</a>
                    <%
                        int uloga = 0;
                        String ime = "";
                        int ID = 0;
                        Korisnik k;
                        if (session.getAttribute("korisnik") != null) {

                            k = (Korisnik) session.getAttribute("korisnik");

                            uloga = k.getUloga();
                            if(session.getAttribute("novoIme")!=null)
                            {
                                ime = (String)session.getAttribute("novoIme");
                            }
                            else
                            {
                                ime = k.getImeKorisnika();
                            }
                            ID = k.getKorisnikID();

                        }

                        if (uloga > 2) {%>
                        <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Artikal?komanda=kreiraj">Kreiraj jelo</a>
                    <%}%>
                    <% if(uloga>1) {%>
                        <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Artikal?komanda=preuzmi">Izmeni jelo</a> 
                    <%}%>
                    <% if(uloga>2) {%>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Artikal?komanda=sve">Obrisi jelo</a>
                    <%}%>
                    <% if(uloga>1) {%>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Korisnik?komanda=sve">Pregled korisnika</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Narudzbenica?komanda=sve">Pregled svih narudžbina</a>
                    <%}%>

                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0 mr-auto">
        </form>
        <%

            if (uloga > 0) {%>
        <!--<a class="nav-link" href="Korpa?komanda=dugme1&korisnikID=<%=ID%>"><img src="slike/Ketering_korpa.png" width="40"></a><span class="badge"></span>-->
            
            <div class="col-xs-12 col-sm-2 row">
                            <div class="column">
                                <a class="nav-link" href="Korpa?komanda=dugme1&korisnikID=<%=ID%>" title="Sadržaj stola" rel="korpa">
                                <%
                                    int uKorpi = 0;
                                    if (session.getAttribute("ukorpi") != null) uKorpi = Integer.parseInt(session.getAttribute("ukorpi").toString());
                                    
                                    if (uKorpi>0) {
                                %>
                                    <span class="badge badge-pill badge-success"><%=uKorpi%></span>
                                <%
                                    }
                                %>
                                    <img class="original_size" src="slike/Ketering_korpa.png" width="40px" alt="Sadržaj korpe">
                                </a>
                            </div>

                        </div>
        <a class="nav-link" href="Korisnik?komanda=izmeni&korisnikID=<%=ID%>"><%=ime%></a>
        <a class="nav-link" href="Korisnik?komanda=logOut">Log out</a>
        <%} else {%>
        <a class="nav-link" href="registrujSe.jsp">Registruj se</a>
        <a class="nav-link" href="logIn.jsp">Log in</a>        
        <%}%>
        <ul class="navbar-nav ">
            <li class="nav-item active">
            </li>
            <li class="nav-item active">
            </li>
        </ul>
    </div>
</nav>
