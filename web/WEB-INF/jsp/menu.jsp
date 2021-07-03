<%-- 
    Document   : menu
    Created on : 4 mars 2018, 16:59:09
    Author     : faycal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
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
        <h1>Choisissez une opération dans la liste suivante :</h1>
        
        <form name="form"  method="POST">    
            <input type="submit" formaction="list.htm"  value="Lister les clients"  />
            <input type="submit" formaction="add.htm" value="Ajouter un client"  />
            <input type="submit" formaction="formfind.htm" value="Rechercher un client"  />
        </form>
        
        <br>
        
        <form name="formManufact"  method="POST">  
            <input type="submit" formaction="listMan.htm"  value="Lister les manufactures"  />
            <input type="submit" formaction="addMan.htm" value="Ajouter une manufacture"  />
            <input type="submit" formaction="formfindMan.htm" value="Rechercher une manufacture"  />
        </form>
        
        <br>
        
        <form name="formProduit"  method="POST">  
            <input type="submit" formaction="listProd.htm"  value="Lister les produits"  />
            <input type="submit" formaction="addProd.htm" value="Ajouter un produit"  />
            <input type="submit" formaction="formfindProd.htm" value="Rechercher un produit"  />
        </form>
    </body>
</html>
