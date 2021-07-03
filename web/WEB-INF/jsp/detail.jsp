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

            <form name="form"  method="POST" style="margin-left: 20px">
                <input type="submit" formaction="logout.htm" value="Se déconnecter"  />
            </form>
        </div>   
        <br>
        
        <form name="detail" method="POST">
           <p>
                <label for="numero">Numero</label>
                <input type="text" name="numero" value="${client.customerId}" size="30" id="numero" readonly/>
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
            <label for="telephone">Téléphone</label>
            <input type="text" name="telephone" value="${client.phone}" size="30" id="tel" />
            </p>
            <p>
            <label for="email">E-mail</label>
            <input type="text" name="email" value="${client.email}" size="30" id="email"/>
            </p>
            <p>
            <label for="Remise">Remise</label>
            <select name="code_remise" id="dc">
               <c:forEach items="${code}" var="dc">
                      <option <c:if test="${dc==client.discountCode}"> selected </c:if>>${dc}</option>
               </c:forEach>
            </select>
            </p>
            <p>
            <label for="zip">Code Postal</label>
            <input type="text" name="zip" value="${client.zip}" size="30" id="zip"/>
            </p>
            
            <input type="submit" value="Modifier" formaction="update.htm" />
            <input type="submit" value="Supprimer" formaction="delete.htm" />
            <input type="submit" value="Afficher les achats" formaction="achats.htm" />
        </form>
    </body>
</html>
