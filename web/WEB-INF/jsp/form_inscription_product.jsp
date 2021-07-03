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
                <label for="Code">Product Code</label>
                <input type="text" name="Code" value="" size="10" id="Code" />
            </p>
            <p>
                <label for="Cost">Product Cost</label>
                <input type="text" name="Cost" value="" size="10" id="Cost" />
            </p>
            <p>
                <label for="Quantity">Quantity on Hand</label>
                <input type="text" name="Quantity" value="" size="10" id="Quantity" />
            </p>
            <p>
                <label for="Markup">Markup</label>
                <input type="text" name="Markup" value="" size="10" id="Markup"/>
            </p>
            <p>
                <label for="Available">Available</label>
                <input type="text" name="Available" value="" size="10" id="Available"/>
            </p>
            <p>
                <label for="Description">Description</label>
                <input type="text" name="Description" value="" size="10" id="Description"/>
            </p>
            <input type="submit" value="Enregistrer" formaction="save.htm" />
        </form>
    </body>
</html>
