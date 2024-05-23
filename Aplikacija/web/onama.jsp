
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

            <!--Pocetak Forme -->

            <!--Treba podesiti css kod za text i srediti vizuelno malo stranicu-->

            <div class="row mt-4">
                <div class="col-12">
                    <h2 class="boja">Kratak opis projekta</h2>
                    <hr>
                </div>
            </div>
            <form class="form-inline my-2 my-lg-0 mr-auto" method="POST" action="#">
                <div class="boja">
                    <p>
                        Projektni zadatak je projektovanje i implementacija aplikaciju za <strong>"Podršku ketering službe"</strong> koja omogućava online pregled ponude i naručivanje. Aplikacija treba da ima mogućnost unosa ponude hrane iz slanog i slatkog programa, registraciju i logovanje korisnika, naručivanje kroz implementaciju funkcije korpe sa opcijom popusta, evidentiranje i pregled porudžbina. 
                        <strong>Kupac</strong> nema mogućnost dodavanja niti izmena artikala već može samo da vidi šta je sve u ponudi i da poruči artikale iz ponude dodavanjem istih u korpu a zatim realizacijom porudžbine. Unos i brisanje artikala može da vrši samo <strong>administrator</strong> dok izmenu artikala kao i pregled porudžbina pored administratora može da vrši i <strong>moderator</strong>.
                    </p>   
                </div>
            </form>


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
