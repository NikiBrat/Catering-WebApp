
<%@page import="beans.Korisnik"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Web Prodavnica</title>
        <link rel="stylesheet" type="text/css" href="style/css.css">
    </head>
    <body>
        <div class="container">


            <%@include file="izgled/slika.jsp"%>

            <%@include file="izgled/header.jsp"%>

            <h1>Lista korisnika</h1>

            <%
                int brojac=0;
                ArrayList<Korisnik> korisnici = (session.getAttribute("korisnici") != null) ? (ArrayList<Korisnik>) session.getAttribute("korisnici") : null;
                if (korisnici != null) {
            %>


            <div>
                <label>Lista je veličine: <%=korisnici.size()%></label>

                <table class="table table-sm table-bordered table-hover">
                    <tr>
                        <th>Red br.</th>
                        <th>imeKorisnika</th>
                        <th>korisnickoIme</th>
                        <th>adresa</th>
                        <th>kontakt</th>
                        <th>uloga</th>
                            <% if (uloga > 0) {%>
                        <th>Moguce operacije </th>
                            <%}%>
                    </tr>

                    <%for (Korisnik kor : korisnici) {
                        brojac++;
                    %>
                    <tr>
                        <td><%= brojac %>.</td>
                        <td><%= kor.getImeKorisnika()%></td>
                        <td><%= kor.getKorisnickoIme()%></td>
                        <td><%= kor.getAdresa()%></td>
                        <td><%= kor.getKontakt()%></td>
                        <td><%= kor.getUloga()%></td>
                        <td><% if (uloga > 0) {%>
                            <form method="post" action="Korisnik">
                                <input type="hidden" name ="korisnikID" value="<%=kor.getKorisnikID()%>" >
                                <button class="btn-change" value="<%= kor.getKorisnikID()%>" name="dugmeIzmeni">Izmeni</button>
                                <button class="btn-delete" value="<%= kor.getKorisnikID()%>" name="dugmeBrisi">Briši</button>
                            </form>
                            <%}%>
                    </tr>

                    <%
                        }
                    %>


                    <%
                        }
                    %>

                </table>
                <%@include file="izgled/footer.jsp"%>
            </div>
        </div>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
