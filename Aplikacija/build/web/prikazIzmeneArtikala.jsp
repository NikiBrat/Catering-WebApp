
<%@page import="beans.Korisnik"%>
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
            <%
                String ispis = "";
                ArrayList<Proizvod> slatki;
                if (session.getAttribute("ispis") != null && session.getAttribute("ponuda") != null) {
                    ispis = (String) session.getAttribute("ispis");
                    slatki = (ArrayList<Proizvod>) session.getAttribute("ponuda");
                }

            %>

            <div>
                <form method="POST" action="Artikal">

                    <% String program = (request.getParameter("komanda") != null) ? request.getParameter("komanda") : "";

                        if (program.isEmpty()) {
                            program = (request.getAttribute("komanda") != null) ? (String) request.getAttribute("komanda") : "";
                        }
                    %>
                    <input type="hidden" name="pgm" value="<%=program%>">
                    <% if (program.equals("slatki")) {%>
                    <label>Kategorije slatkisa: </label>
                    <select name="odaberi" class="btn btn-secondary dropdown-toggle">
                        <option value="1">Kolaci</option>
                        <option value="2">Palacinke</option>
                        <option value="3">Slatko od</option>
                    </select>
                    <button type="submit" name="izaberi" class="btn btn-outline-light" value="izaberi">Izaberi</button><br>
                    <%}%>

                    <% if (program.equals("slani")) {%>
                    <label>Kategorije slanog: </label>
                    <select name="odaberi" class="btn btn-secondary dropdown-toggle">
                        <option value="4">Supe</option>
                        <option value="5">Rostilj</option>
                        <option value="6">Pecenje</option>
                        <option value="7">Kuvana jela</option>
                        <option value="8">Specijaliteti</option>
                        <option value="9">Jela na Zaru</option>
                    </select>
                    <button type="submit" name="izaberi" class="btn btn-outline-light" value="izaberi">Izaberi</button><br>
                    <% } %>
                    &nbsp
                </form>
                <%
                    ArrayList<Proizvod> lista;
                    //Korisnik k = (Korisnik)session.getAttribute("korisnik");
                    //System.out.println("Ulazimo u IF !!!!");

                    if (request.getAttribute("ponuda") != null) {
                        lista = (ArrayList<Proizvod>) request.getAttribute("ponuda");

                        //System.out.println("Lista za izmenu je: "+lista.size());
                        //int uloga = k.getUloga();
                %>
                <table class="table table-sm table-bordered table-hover">
                    <tr>
                        <th>Slike</th>
                        <th>Naziv</th>
                        <th>Naziv kategorije</th>
                        <th>Kolicina na stanju</th>
                        <th>Cena</th>
                        <th>Cena sa popustom</th>
                            <% if (uloga > 0) {%>
                        <th>Moguce operacije </th>
                            <%}%>
                    </tr>
                    <%

                        for (Proizvod p : lista) {
                            //System.out.println("Slika je: " + p.getSlika());
                    %>
                    <tr>
                        <td><img src="slike/<%=p.getSlika()%>" width="150px"></td>
                        <td><%= p.getNaziv()%></td>
                        <td><%= p.getNazivKategorije()%></td>
                        <td><%= p.getKolicina()%></td>
                        <td><%= p.getCena()%></td>
                        <td><%= p.getCenaSaPopustom()%></td>
                        <td><% if (uloga == 2 || uloga == 3) {%>
                            <form method="post" action="Artikal"><button class="btn-change" value="<%= p.getPonudaID()%>" name="promeni">Izmeni</button></form>
                            <%}%>
                        </td>
                    </tr>

                    <%}
                    }%>
                </table>  
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

