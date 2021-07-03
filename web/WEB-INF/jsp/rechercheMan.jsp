<%-- 
    Document   : recherche
    Created on : 7 juin 2019, 11:52:07
    Author     : faycal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche</title>
    </head>
    <body>
        <div style="display:flex;">
            User : ${user.login}

            <form name="Return" action="menu.htm"  method="POST" style="margin-left: 20px">
                <input type=submit  value="Retour au Menu Principal"  />
            </form>
            <form name="form"  method="POST" style="margin-left: 20px">
                <input type="submit" formaction="logout.htm" value="Se déconnecter"  />
            </form>
        </div>   
        <br>
        
        <form name="recherche" action="findMan.htm" method="POST">
            <p>
                <label for="nom">Nom de manufacture</label>
                <input type="text" name="nom"  size="30" id="nom" />
            </p>
            <input type="submit" value="Rechercher par nom"  />
        </form>
        <form name="rechercheId" action="findByIdMan.htm" method="POST">
            <p>
                <label for="num">ID Manufacture</label>
                <input type="text" name="num"  size="30" id="num" />
            </p>
            <input type="submit" value="Rechercher par ID"  />
        </form>
        <p>
    </p>
</body>
</html>


