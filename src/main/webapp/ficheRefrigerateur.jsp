<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Fiche du Réfrigérateur</title>
</head>
<body>
    <%@ include file="header.jsp" %> <!-- Inclusion du header -->

<h2>Fiche du Réfrigérateur</h2>
<p><strong>Nom :</strong> ${refrigerateur.nom}</p>
<p><strong>Température :</strong> ${refrigerateur.temperature} °C</p>
<h3>Produits :</h3>
<ul>
    <% 
        // Récupérer la Map des produits passée depuis le servlet
        java.util.Map<String, Integer> produits = (java.util.Map<String, Integer>) request.getAttribute("refrigerateur.produits");
        if (produits != null) {
            // Parcourir la Map et afficher les produits
            for (java.util.Map.Entry<String, Integer> entry : produits.entrySet()) {
    %>
                <li><%= entry.getKey() %> : <%= entry.getValue() %> unités</li>
    <% 
            }
        } else {
    %>
            <li>Aucun produit ajouté.</li>
    <% 
        }
    %>
</ul>
</body>
</html>
