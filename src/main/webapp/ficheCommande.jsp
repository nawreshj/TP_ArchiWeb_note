<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title>Fiche de Commande</title>
</head>
<body>
    <%@ include file="header.jsp" %> <!-- Inclusion du header -->

<h2>Fiche de Commande</h2>
<p><strong>ID de la commande :</strong> ${commande.idCommande}</p>
<p><strong>Nom du produit :</strong> ${commande.nomProduit}</p>
<p><strong>Quantité :</strong> ${commande.quantite}</p>
<p><strong>Date de la commande :</strong> ${commande.dateCommande}</p>
<p><strong>État :</strong> ${commande.etatCommande}</p>
</body>
</html>