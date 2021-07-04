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
            <p><label for="manId">Manufacturer ID</label>
          <select name="manId" id="dc">
               <c:forEach items="${manID}" var="dc">
                <option>${dc}</option>
               </c:forEach>
          </select>
            </p>
            <p><label for="product_code">Product Code</label>
          <select name="product_code" id="dc">
               <c:forEach items="${code}" var="dc">
                <option>${dc}</option>
               </c:forEach>
          </select>
            </p>
            <p>
                <label for="cost">Product Cost</label>
                <input type="text" name="cost" value="" size="10" id="cost" />
            </p>
            <p>
                <label for="quantity">Quantity on Hand</label>
                <input type="text" name="quantity" value="" size="10" id="quantity" />
            </p>
            <p>
                <label for="markup">Markup</label>
                <input type="text" name="markup" value="" size="10" id="markup"/>
            </p>
            <p>
                <label for="available">Available</label>
                <input type="text" name="available" value="" size="10" id="available"/>
            </p>
            <p>
                <label for="description">Description</label>
                <input type="text" name="description" value="" size="10" id="description"/>
            </p>
            <input type="submit" value="Enregistrer" formaction="saveProduct.htm" />
        </form>
    </body>
</html>
