<%@page import="IO.DbBroker"%>


<%
    if (session.getAttribute("msg") != null) {%>
<%=session.getAttribute("msg")%>  
<% session.removeAttribute("msg");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Registracija</title>
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
                    <h2 class="boja">Registruj se</h2>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <form method="Post" action="registrujSe">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputEmail4">Vas Email:</label>
                                <input type="email" class="form-control" id="inputEmail4" name="Email" placeholder="Unesite vas E-mail:">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="Pass">Vasa sifra:</label>
                                <input type="password" class="form-control" id="Pass" name="Pass" placeholder="Unesite vasu sifru:">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="ImePrezime">Vase Ime i Prezime:</label>
                                <input type="text" class="form-control" id="ImePrezime" name="ImePrezime" placeholder="Unesite vase Ime i prezime:">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="Kontakt">Vas kontakt:</label>
                                <input type="text" class="form-control" id="Kontakt" name="Kontakt" placeholder="Unesite vas Broj Telefona:">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="adresa">Vasa adresa:</label>
                                <input type="text" class="form-control" id="adresa" name="Adresa" placeholder="Unesite vasu trenutnu adresu:">
                            </div>
                        </div>        
                        <div>
                            <button type="submit" class="btn btn-primary btn-sm" name="dugme">Registruj se</button>
                        </div>

                        &nbsp
                    </form>
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