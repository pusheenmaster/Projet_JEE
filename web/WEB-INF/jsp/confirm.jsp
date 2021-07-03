<%-- 
    Document   : confirm
    Created on : 5 mars 2018, 22:16:48
    Author     : faycal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
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
        <h1>${confirm} </h1>
        <form action="list.htm"  method="POST">
        <input type="submit" value="Afficher tous les enregistrements"  />
        </form>
    </body>
</html>
