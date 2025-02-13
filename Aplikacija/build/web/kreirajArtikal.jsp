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
                    <h2 class="boja">Kreiraj artikal: </h2>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <form method="Post" action="Artikal">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputEmail4" class="label">Naziv proizvoda:</label>
                                <input type="text" class="form-control" id="inputEmail4" name="Naziv" placeholder="Unesite naziv novog proizvoda:">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="Kategorija" class="label" >Izaberite kategoriju proizvoda:</label>
                                <select class="form-control" id="Kategorija"  name="Kategorija" >
                                    <option value="1">Kolaci</option>
                                    <option value="2">Palacinke</option>
                                    <option value="3">Slatko od</option>
                                    <option value="4">Supe</option>
                                    <option value="5">Rostilj</option>
                                    <option value="6">Pecenje</option>
                                    <option value="7">Kuvana jela</option>
                                    <option value="8">Specijaliteti</option>
                                    <option value="9">Jela na Zaru</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="Kolicina" class="label">Buduca kolicina proizvoda je:</label>
                                <input type="number" class="form-control" id="Kolicina" name="Kolicina" placeholder="Unesite kolicinu proizvoda:">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="Cena" class="label">Buduca cena proizvoda je:</label>
                                <input type="number" class="form-control" id="Cena" name="Cena" placeholder="Unesite cenu proizvoda:">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="CenaSaPopustom" class="label">Cena sa popustom proizvoda je:</label>
                                <input type="number" class="form-control" id="CenaSaPopustom" name="CenaSaPopustom" placeholder="Unesite cenu sa popustom proizvoda:">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="Slika" class="label">Unesite sliku proizvoda:</label>
                                <input type="text" class="form-control" id="Slika" name="Slika" placeholder="Unesite naziv slike:">
                            </div>
                        </div>
                        <div>
                            <button type="submit" class="btn btn-primary btn-sm" name="komanda" value="sacuvaj">Unesi prozivod</button>
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