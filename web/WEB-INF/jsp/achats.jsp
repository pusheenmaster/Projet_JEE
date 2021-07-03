<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Achats</title>
    </head>
    <body>
        <div style="display:flex;">
            User : ${user.login}

            <form name="form"  method="POST" style="margin-left: 20px">
                <input type="submit" formaction="logout.htm" value="Se déconnecter"  />
            </form>
        </div>   
        <br> 
        
        <H1>Achats du client n°<%=request.getParameter("numero")%></H1>
        <table border="1" cellpadding="10">
        
                
                  <c:forEach items="${achats}" var="cli"> 
                      <TR>
                      <TD>${cli.orderNum}</TD>
                      <TD>${cli.customerId}</TD>
                      <TD>${cli.productId}</TD>
                      <TD>${cli.quantity}</TD>
                      <TD>${cli.shippingCost}</TD>
                      <TD>${cli.salesDate}</TD>
                      <TD>${cli.shippingDate}</TD>
                      <TD>${cli.freightCompany}</TD>
                      </TR> 
                  </c:forEach>
                 
        </table>
       
        <p>
        <form name="Return" action="menu.htm"  method="POST">
            <input type=submit  value="Retour au Menu Principal"  />
        </form>
        </p>
    </body>
</html>
