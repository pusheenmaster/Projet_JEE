<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultat</title>
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
        <table border="1" cellpadding="10">


            <TR>
                <c:forEach items="${colonnes}" var="col">
                    <TD>${col}</TD> 
                    </c:forEach>
            </TR>

            <c:forEach items="${liste}" var="client" varStatus="row" >
                <TR>
                    <c:forEach items="${client}" var="cli" >  
                        <TD>${cli}
                        </TD>
                    </c:forEach>
                    <TD>
                        <form name="Result" action="detailProd.htm"  method="POST">
                            <input type=hidden name="num"  value="${liste[row.index][0]}"/>
                            <input type=submit  value="Détail"  />
                        </form>


                    </TD>
                </TR>
            </c:forEach>

        </table>
        <p>
    </p>
</body>
</html>
