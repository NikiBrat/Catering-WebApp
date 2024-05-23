
<%@page import="beans.Proizvod"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Web Prodavnica</title>
        <link rel="stylesheet" type="text/css" href="style/css.css">
    </head>
    <body>
        <div class="container">

            <%@include file="izgled/slika.jsp"%>
            <%@include file="izgled/header.jsp"%>
            
            <div>
                <br><h3>Detalji narudžbine</h3><br>
                
                <table class="table table-sm table-bordered table-hover">
                    <tr>
                        <th>Naziv</th>
                        <th>Kategorija</th>
                        <th>Količina</th>
                        <th>Cena</th>
                        <th>Cena sa popustom</th>
                    </tr>

                    <%
                        ArrayList<Proizvod> lista;

                        if (session.getAttribute("lista") != null) {
                            lista = (ArrayList<Proizvod>) session.getAttribute("lista");

                            for (Proizvod p : lista) {%>
                    <tr>


                        <td><%= p.getNaziv()%></td>
                        <td><%= p.getNazivKategorije()%></td>
                        <td><%= p.getKolicina()%></td>
                        <td><%= p.getCena()%></td>
                        <td><%= p.getCenaSaPopustom()%></td>


                    </tr>
                    <% } %>

                </table>

                <%
                    }%>
                &nbsp

                <a  href="prikazNarudzbina.jsp"><button class="btn-details-info"><- Nazad </button></a>
            <br><br><br>
            </div>

            <%@include file="izgled/footer.jsp"%> 

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

