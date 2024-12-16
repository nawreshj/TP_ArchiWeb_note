<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Fiche du Réfrigérateur</title>
</head>
<body>
    <%@ include file="header.jsp" %> <!-- Inclusion du header -->

    <h2>Fiche du Réfrigérateur</h2>
    
    <%
        // Récupérer l'objet Réfrigérateur depuis la requête
        beans.Refrigerateur refrigerateur = (beans.Refrigerateur) request.getAttribute("refrigerateur");
        if (refrigerateur != null) {
    %>
        <p><strong>Nom :</strong> <%= refrigerateur.getNom() %></p>
        <p><strong>Température :</strong> <%= refrigerateur.getTemperature() %> °C</p>
        
        <h3>Produits :</h3>
        <ul>
            <%
                java.util.Map<String, Integer> produits = refrigerateur.getProduits();
                if (produits != null && !produits.isEmpty()) {
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
    <%
        } else {
    %>
        <p><strong>Erreur :</strong> Réfrigérateur introuvable.</p>
    <%
        }
    %>
</body>
</html>
