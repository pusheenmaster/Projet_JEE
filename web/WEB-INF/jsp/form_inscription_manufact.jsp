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
                <label for="ville">Ville</label>
                <input type="text" name="ville" value="" size="10" id="ville" />
            </p>
            <p>
                <label for="state">State</label>
                <input type="text" name="state" value="" size="10" id="state"/>
            </p>
            <p>
                <label for="cp">Code Postal</label>
                <input type="text" name="cp" value="" size="10" id="cp"/>
            </p>
            <p>
                <label for="phone">Telephone</label>
                <input type="text" name="phone" value="" size="10" id="phone"/>
            </p>
            <p>
                <label for="fax">Fax</label>
                <input type="text" name="fax" value="" size="10" id="fax"/>
            </p>
            <p>
                <label for="mail">Email</label>
                <input type="text" name="mail" value="" size="10" id="mail"/>
            </p>
            <p>
                <label for="rep">Rep</label>
                <input type="text" name="rep" value="" size="10" id="rep"/>
            </p>
            <input type="submit" value="Enregistrer" formaction="saveManufact.htm" />
        </form>
    </body>
</html>
