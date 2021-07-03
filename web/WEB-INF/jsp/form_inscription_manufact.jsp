<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enregistrement</title>
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

        <form name="inscription"  method="POST">
            <p>
                <label for="nom">Nom</label>
                <input type="text" name="nom" value="" size="10" id="nom" />
            </p>
            <p>
                <label for="adresse">Adresse</label>
                <input type="text" name="adresse" value="" size="10" id="adresse" />
            </p>
            <p>
                <label for="adresse2">Adresse 2</label>
                <input type="text" name="adresse2" value="" size="10" id="adresse2" />
            </p>
            <p>
                <label for="Ville">Ville</label>
                <input type="text" name="Ville" value="" size="10" id="Ville" />
            </p>
            <p>
                <label for="State">State</label>
                <input type="text" name="State" value="" size="10" id="State"/>
            </p>
            <p>
                <label for="cp">Code Postal</label>
                <input type="text" name="cp" value="" size="10" id="cp"/>
            </p>
            <input type="submit" value="Enregistrer" formaction="save.htm" />
        </form>
    </body>
</html>
