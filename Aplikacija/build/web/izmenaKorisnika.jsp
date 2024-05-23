<%@page import="IO.DbBroker"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Korisnik kor = (session.getAttribute("korisnikZaIzmenu") != null) ? (Korisnik) session.getAttribute("korisnikZaIzmenu") : null;
    Korisnik ulogovan = (session.getAttribute("korisnik") != null) ? (Korisnik) session.getAttribute("korisnik") : null;
    int rola = (ulogovan != null) ? ulogovan.getUloga() : -1;
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Izmena podataka o korisniku</title>
        <link rel="stylesheet" type="text/css" href="style/css.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>>
    <body>
    <body>
        <div class="container">


            <%@include file="izgled/slika.jsp"%>

            <%@include file="izgled/header.jsp"%>


            <!--Pocetak Forme -->

            <div class="row mt-4">
                <div class="col-12">
                    <h2 class="boja">Izmena korisničkih podataka</h2>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <%
                        if (kor != null) {
                    %>

                    <form method="Post" action="Korisnik">
                        <input type="hidden" name="korisnikId" value="<%=kor.getKorisnikID()%>">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputEmail4">Email:</label>
                                <input type="email" class="form-control" id="inputEmail4" name="Email" value ="<%=kor.getKorisnickoIme()%>">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="Pass">Šifra:</label>
                                <input type="password" class="form-control" id="Pass" name="sifra" value ="<%=kor.getSifra()%>">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="ImePrezime">Ime i Prezime:</label>
                                <input type="text" class="form-control" id="ImePrezime" name="ImePrezime" value ="<%=kor.getImeKorisnika()%>">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="Kontakt">Kontakt:</label>
                                <input type="text" class="form-control" id="Kontakt" name="Kontakt" value ="<%=kor.getKontakt()%>">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="adresa">Adresa:</label>
                                <input type="text" class="form-control" id="adresa" name="Adresa" value ="<%=kor.getAdresa()%>">
                            </div>
                        </div>
                            
                                <%
                                    if (rola > 1) {
                                        %>
                                        
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="uloga">Rola</label>
                                                <input type="text" class="form-control" id="uloga" name="Uloga" value ="<%=kor.getUloga()%>">
                                            </div>
                                        </div>  

                                <%
                                    }
                                %>
                            
                        <div>
                            <button type="submit" class="btn btn-primary btn-sm" name="zapamtiPromene">Zapamti promene</button>
                        </div>

                        &nbsp
                    </form>
                     <%
                        }
                     %>

                </div>
            </div>


            <%@include file="izgled/footer.jsp"%>
        </div>
        <br>
        <br>
        <br>
        <br>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>