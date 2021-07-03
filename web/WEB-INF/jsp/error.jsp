<%-- 
    Document   : error
    Created on : 4 mars 2018, 20:54:56
    Author     : faycal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erreur</title>
    </head>
    <body>
        <div style="display:flex;">
            User : ${user.login}

            <form name="form"  method="POST" style="margin-left: 20px">
                <input type="submit" formaction="logout.htm" value="Se déconnecter"  />
            </form>
        </div>   
        <br>
        <h1>${erreur} </h1>
    </body>
    <p>
    <form name="Return" action="menu.htm"  method="POST">
        <input type=submit  value="Retour au Menu Principal"  />
    </form>
</p>
</html>
