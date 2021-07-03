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
                <label for="numero">Product Id</label>
                <input type="text" name="numero" value="${client.productId}" size="30" id="numero" readonly/>
            </p>
            <p>
           <label for="nom">Product Code</label>
                <input type="text" name="nom" value="${client.productCode}" size="30" id="nom" />
            </p>
            <p>
            <label for="adresse">Purchase Cost</label>
            <input type="text" name="adresse" value="${client.purchaseCost}" size="30" id="adresse" />
            </p>
            <p>
            <label for="adresse2">Qty on Hand</label>
            <input type="text" name="adresse2" value="${client.quantityOnHand}" size="30" id="adresse2" />
            </p>
            <p>
            <label for="telephone">Markup</label>
            <input type="text" name="telephone" value="${client.markup}" size="30" id="tel" />
            </p>
            <p>
            <label for="email">Available</label>
            <input type="text" name="email" value="${client.available}" size="30" id="email"/>
            </p>
            <p>
            <label for="zip">Description</label>
            <input type="text" name="zip" value="${client.description}" size="30" id="zip"/>
            </p>
            
            <input type="submit" value="Modifier" formaction="update.htm" />
            <input type="submit" value="Supprimer" formaction="delete.htm" />
        </form>
    </body>
</html>

