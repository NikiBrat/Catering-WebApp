<%-- 
    Document   : narudzbenica
    Created on : Jun 24, 2022, 12:04:21 AM
    Author     : nikol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style/css.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
        <%@include file="izgled/slika.jsp"%>

        <%@include file="izgled/header.jsp"%>
        
        <h2>Izaberite nacin Placanja</h2>
        <br>
        <form method="post" action="Narudzbenica" >
            <fieldset border="2px">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="radio" id="flexRadioDefault1" value="Kartica" checked>
                    <label class="form-check-label" for="Kartica">
                        Kartica - +5% na Ukupnu Cenu 
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="radio" id="flexRadioDefault2" value="Gotovina">
                    <label class="form-check-label" for="Gotovina">
                        Gotovina - +12% na Ukupnu Cenu
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="radio" id="flexRadioDefault3" value="Racun">
                    <label class="form-check-label" for="Uplata na racun">
                        Uplata na racun - +17% na Ukupnu Cenu   
                    </label>
                </div>
                <br>
                <h3>Cena vasih proizvoda ce biti: </h3>
                <br>
                <button class="btn-succes" type="submit" name="naruci" value="naruci">Poruci</button>
                <br>
            </fieldset>
        </form>
        <%@include file="izgled/footer.jsp"%>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
