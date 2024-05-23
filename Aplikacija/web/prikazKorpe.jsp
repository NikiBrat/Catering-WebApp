

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

            <br>

            <div>
               
                <%
                    ArrayList<Proizvod> lista;

                    if (request.getAttribute("ponuda") != null) {
                        lista = (ArrayList<Proizvod>) request.getAttribute("ponuda");

                        for (Proizvod p : lista) {%>
                <form method="post" action="Korpa">
                    <label><%= p.getNaziv()%></label><br>
                    <% if (uloga > 0) {%>
                    <button value="<%= p.getPonudaID()%>" name="dugme">Dodaj u korpu</button>
                    <%}%>
                </form><br>
                <% if (uloga == 3) {%>
                <form method="post" action="Artikal"><button value="<%= p.getPonudaID()%>" name="brisanje">Obrisi</button></form><br>
                <%}%>
                <% if (uloga == 2 || uloga == 3) {%>
                <form method="post" action="Artikal"><button value="<%= p.getPonudaID()%>" name="izmeni">Izmeni</button></form><br><br>
                <%}%>
                <%}
                            }%>
                &nbsp
                
                <br><br>

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

