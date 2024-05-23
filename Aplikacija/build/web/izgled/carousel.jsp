
<%@page import="beans.Proizvod"%>
<%@page import="java.util.ArrayList"%>
<%@page import="IO.DbBroker"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div>
    <img src="slike/hrana-baner.png" width="100%" class="rounded" alt="baner">
    <br>
</div>

&nbsp

<% 
    Proizvod p = new Proizvod();
    
    String upit = "Select cenaSaPopustom from ponuda where naziv='Tiramisu'";
    
    ArrayList<String[]> tir = DbBroker.getArr(upit);
    
    String[] niz = tir.get(0);
    
    double tiramisu = Double.parseDouble(niz[0]);
    
    String upit1 = "Select cenaSaPopustom from ponuda where naziv='Cevapi'";
    
    ArrayList<String[]> tir1 = DbBroker.getArr(upit1);
    
    String[] niz1 = tir1.get(0);
    
    double cevapi = Double.parseDouble(niz1[0]);
    
    String upit2 = "Select cenaSaPopustom from ponuda where naziv='Svinjsko pecenje'";
    
    ArrayList<String[]> tir2 = DbBroker.getArr(upit2);
    
    String[] niz2 = tir2.get(0);
    
    double pecenje = Double.parseDouble(niz2[0]);

%>

    <div class="row">
        <div class="col-sm ">
            <div class="jumbotron col-md-10" aria-hidden="true">
                <img src="slike/cevapi.jpg" width="220px" class="rounded mx-auto d-block" alt="cevapi">
                <div class="dropdown-divider"></div>
                <div class="text">
                    <label class="debljina">Najlepši su Banjalučki ćevapi</label><br>
                    <label class="debljina"><%= cevapi %> din.</label>
                </div>  
            </div>
        </div>
        <div class="col-sm ">
            <div class="jumbotron col-md-10 " aria-hidden="true">
                <img src="slike/prasece_pecenje.jpg" width="245px" class="rounded mx-auto d-block" alt="pecenje">
                <div class="dropdown-divider"></div>
                <div class="text">
                    <label class="debljina">Topi se u ustima kao da je slatkis</label><br>
                    <label class="debljina"><%= pecenje %> din.</label>
                </div>
            </div>

        </div>
        <div class="col-sm ">
            <div class="jumbotron col-md-10" aria-hidden="true">
                <img src="slike/tiramisu.jpeg" width="260px" class="rounded mx-auto d-block" alt="tiramisu">
                <div class="dropdown-divider"></div>
                <div class="text">
                    <label class="debljina">Uz dobru hranu ide i dobar dezert</label><br>
                    <label class="debljina"><%= tiramisu %> din.</label>
                </div>
            </div>

        </div>
    </div>

