<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail</title>
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

        <form name="detailMan" method="POST">
            <p>
                <label for="numero">Numero</label>
                <input type="text" name="numero" value="${client.manufacturerId}" size="30" id="numero" readonly/>
            </p>
            <p>
                <label for="nom">Nom</label>
                <input type="text" name="nom" value="${client.name}" size="30" id="nom" />
            </p>
            <p>
                <label for="adresse">Adresse</label>
                <input type="text" name="adresse" value="${client.addressline1}" size="30" id="adresse" />
            </p>
            <p>
                <label for="adresse2">Adresse 2</label>
                <input type="text" name="adresse2" value="${client.addressline2}" size="30" id="adresse2" />
            </p>
            <p>
                <label for="city">Ville</label>
                <input type="text" name="city" value="${client.city}" size="30" id="city" />
            </p>
            <p>
                <label for="state">State</label>
                <input type="text" name="state" value="${client.state}" size="30" id="state"/>
            </p>
            <p>
                <label for="zip">Code Postal</label>
                <input type="text" name="zip" value="${client.zip}" size="30" id="zip"/>
            </p>
            <p>
                <label for="phone">Telephone</label>
                <input type="text" name="phone" value="${client.phone}" size="10" id="phone"/>
            </p>
            <p>
                <label for="fax">Fax</label>
                <input type="text" name="fax" value="${client.fax}" size="10" id="fax"/>
            </p>
            <p>
                <label for="mail">Email</label>
                <input type="text" name="mail" value="${client.email}" size="30" id="mail"/>
            </p>
            <p>
                <label for="rep">Rep</label>
                <input type="text" name="rep" value="${client.rep}" size="10" id="rep"/>
            </p>

            <input type="submit" value="Modifier" formaction="updateMan.htm" />
            <input type="submit" value="Supprimer" formaction="deleteMan.htm" />
        </form>
    </body>
</html>
