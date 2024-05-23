
<%@page import="beans.Poruke"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >

<%
    String putanjaDoSlika = "slike/";
    String poruka = "", klasaporuke = "info", dugmeispis = "Početna", link = "Ponuda", slika = putanjaDoSlika + "Preloader_4.gif", bojaNaslova = "blue";
    String dugme2ispis = "", link2 = "", cmd = "";
    String naslov = "Nemam šta da Vam kažem...";
    int tip = 1, cekanje = 0;
    Poruke p = null;
    if (session.getAttribute("poruka") != null) {
        p = (Poruke) session.getAttribute("poruka");
        poruka = p.getPoruka();
        klasaporuke = p.getTip();
        link = p.getLink();
        link2 = p.getLink2();
        //cmd = p.getKomanda();
        dugmeispis = p.getIspisDugme();
        dugme2ispis = p.getIspisDugme2();
        session.removeAttribute("info");
        tip = p.getBrDugmica();

        if (klasaporuke.equals("info")) {
            slika = putanjaDoSlika + "warning.jpg";
            bojaNaslova = "blue";
            naslov = "Info";
        }
        if (klasaporuke.equals("warning")) {
            slika = putanjaDoSlika + "Ketering_korpa_warning.png";
            bojaNaslova = "orange";
            naslov = "Upozorenje!";
        }
        if (klasaporuke.equals("neuspesno")) {
            slika = putanjaDoSlika + "Ketering_korpa_neuspesno.png";
            bojaNaslova = "red";
            naslov = "Greška!";
        }
        if (klasaporuke.equals("uspesno")) {
            slika = putanjaDoSlika + "Ketering_korpa_uspesno.png";
            bojaNaslova = "green";
            naslov = "Uspešno!";
        }
    }
%>
<html>

    <style>
        body
        {
            width: 600px;
            border: 1px solid #006666;
            padding: 0px;
            margin: 5px auto;
            background-color: #FFBD59;
        }

        a
        {
            padding: 4px;
            border: 1px solid #006666;
            background-color: #0099CC;
            font: bold 14px Tahoma;
            color: white;
            text-decoration: none;
        }
    </style>

    <link rel="stylesheet" type="text/css" href="style/css.css">

    <body>
        <br>
        <div style="text-align: center;">
            <img src="<%=slika%>" width="250px" />
            <br>
        </div>

        <br/><br/>
        <!-- <a href="Ponuda"> Početna </a> -->
        <br /> <br /> <br /> 
        <h4 class="<%=klasaporuke%> ispisInfo"><%=poruka%></h4>
        <br /> <br />


        <!-- <input type="hidden" name="cmd" value="<%=cmd%>"> -->
        <%
            if (tip == 2) {
        %>
        <form action="<%=link2%>" method="POST">     
            <div style="margin:30px"> <input with="100px" style="float: left;" type="submit" name="dugme2" value="<%=dugme2ispis%>" class="btn-delete" /> </div>
        </form>
        <%
            }
        %>
        <form action="<%=link%>" method="POST">
            <div style="margin:30px"> <input with="100px" style="float: right;" type="submit" name="dugme1" value="<%=dugmeispis%>" class="btn-succes" /> </div>
        </form>

        <br /> <br /> <br /> 
        <br /><br /><br />
    </body>
</html>
