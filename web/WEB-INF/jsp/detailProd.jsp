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
                <label for="manId">Manufacturer ID</label>
                <input type="text" name="manId" value="${client.manufacturerId}" size="30" id="manId" readonly/>
            </p>
            <p>
                <label for="product_code">Product Code</label>
                <input type="text" name="product_code" value="${client.productCode}" size="30" id="product_code" readonly/>
            </p>
            <p>
                <label for="cost">Purchase Cost</label>
                <input type="text" name="cost" value="${client.purchaseCost}" size="30" id="cost" />
            </p>
            <p>
                <label for="quantity">Qty on Hand</label>
                <input type="text" name="quantity" value="${client.quantityOnHand}" size="30" id="quantity" />
            </p>
            <p>
                <label for="markup">Markup</label>
                <input type="text" name="markup" value="${client.markup}" size="30" id="markup" />
            </p>
            <p>
                <label for="available">Available</label>
                <input type="text" name="available" value="${client.available}" size="30" id="available"/>
            </p>
            <p>
                <label for="description">Description</label>
                <input type="text" name="description" value="${client.description}" size="30" id="description"/>
            </p>

            <input type="submit" value="Modifier" formaction="updateProd.htm" />
            <input type="submit" value="Supprimer" formaction="deleteProd.htm" />
        </form>
    </body>
</html>

