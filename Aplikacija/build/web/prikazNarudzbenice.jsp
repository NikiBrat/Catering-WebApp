<%@page import="beans.Proizvod"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style/css.css">
        <title>Pregled Korpe</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="izgled/slika.jsp"%>

            <h1>Hvala sto ste porucili kod nas</h1>
            <%
                ArrayList<Proizvod> lista;
                double ukupna = 0;
                String placanje="";
                if (session.getAttribute("narudzbenica") != null && session.getAttribute("ukupna")!=null 
                        && session.getAttribute("nacinPlacanja")!=null) 
                {
                    lista = (ArrayList<Proizvod>) session.getAttribute("narudzbenica");
                    
                    ukupna = Double.parseDouble(session.getAttribute("ukupna").toString());
                    
                    placanje = (String)session.getAttribute("nacinPlacanja");
                    
                    
                    if(placanje.equals("Kartica"))
                    {
                        ukupna = ukupna*1.05;
                    }
                    if(placanje.equals("Gotovina"))
                    {
                        ukupna = ukupna*1.12;
                    }
                    if(placanje.equals("Racun"))
                    {
                        ukupna = ukupna*1.17;
                    }
            %>
            
             <form method="post" action="Korpa">
                <table class="table table-sm table-bordered table-hover">
                    <tr>
                        <th>Slika</th>
                        <th>Naziv</th>
                        <th>Porucena kolicina</th>
                        <th>Jedinicna cena</th>
                    </tr>
                    <%

                        for (Proizvod p : lista) {
       
                    %>

                    <tr>
                        <td><img src="slike/<%=p.getSlika()%>" width="150px"></td>
                        <td><%= p.getNaziv()%></td>
                        <td><%= p.getKolicina()%></td>
                        <td><%= p.getCena()%></td>
                    </tr>
                    <%}%>

                       
                </table>
            </form>
                <h3>Nacin Placanja je: <%= placanje %></h3>
                <h3>Ukupna cena sa dostavom je: <%=ukupna%></h3>
                <br>
            <%}%>
            <a href="index.jsp" class="btn-details-info" >Vrati se na pocetnu stranu</a>
            <br>
            
            <%@include file="izgled/footer.jsp"%>
        </div>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
