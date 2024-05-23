<%@page import="beans.Proizvod"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style/css.css">
        <title>Pregled Korpe</title>
    </head>
    <body>
        <div class="container">

            <%@include file="izgled/slika.jsp"%>
            <%@include file="izgled/header.jsp"%>
            <%
                ArrayList<Proizvod> lista;
                double ukupna = 0;

                if (session.getAttribute("korpa") != null) {
                    lista = (ArrayList<Proizvod>) session.getAttribute("korpa");

            %>
            <form method="post" action="Korpa">
                <table class="table table-sm table-bordered table-hover">
                    <tr>
                        <th>Slike</th>
                        <th>Naziv</th>
                        <th>Naziv kategorije</th>
                        <th>Kolicina u korpi</th>
                        <th>Cena</th>
                    </tr>
                    <%
                        int brojac=0;
                        for (Proizvod p : lista) {
                            brojac++;
                            ukupna += p.getCenaSaPopustom() * p.getKolicina();
                    %>

                    <tr>
                        <td><img src="slike/<%=p.getSlika()%>" width="150px"></td>
                        <td><%= p.getNaziv()%></td>
                        <td><%= p.getNazivKategorije()%></td>
                        <td><input type="number" name="kolicina<%= p.getPonudaID() %>" value="<%= p.getKolicina()%>" width="20"></td>
                        <% System.out.println("Artikal broj: "+brojac+" ima kolicinu: "+p.getKolicina());%>
                        <td><%= p.getCenaSaPopustom()%></td>
                        <td>
                            <button class="btn-change" value="<%=p.getPonudaID()%>" name="izmeni">Izmeni</button>
                            <button class="btn-delete" value="<%=p.getPonudaID()%>" name="izbaci">Izbaci</button>
                        </td>
                    </tr>
                    <%}
                        }%>
                    <% session.setAttribute("ukupna", ukupna);%>
                </table>
            </form>
            <div>
                <label>Ukupna cena: <%= ukupna%> , U cenu će biti uračunata i cena dostave.</label><br>
            </div>
            <div>
                <hr>
            </div>
            <form method="post" action="Narudzbenica">
                <div>
                    <button type="submit" class='btn btn-outline-primary' name="placanje" value="placanje">Izaberi Nacin placanja</button>
                </div>
            </form>
            <br>

        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
