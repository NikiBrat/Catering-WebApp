<%@page import="beans.Korisnik"%>
<div class="card-footer">
    <div class="row">
        <div class="col-md-6">
            <ul class="list-inline">
                <li class="list-inline-item"><a href="onama.jsp">O nama</a></li>
                    <%
                        int uloga1 = 0;
                        Korisnik k1;
                        if (session.getAttribute("korisnik") != null) 
                        {

                            k1 = (Korisnik) session.getAttribute("korisnik");

                            uloga1 = k1.getUloga();

                        }
                        %>
                
                       <% if (uloga1==0) 
                       {%>
                <li class="list-inline-item"><a href="registrujSe.jsp">Registruj se</a></li>
                <% } %>
            </ul>
        </div>
        <div class="col-md-6">
            <p class="text-right boja">Copyright &copy; Ketering Projekat - Internet Programerski Alati 2022.</p>
        </div>
    </div>
</div>