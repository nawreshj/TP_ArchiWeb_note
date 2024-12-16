<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title>Fiche du Radiateur</title>
</head>
<body>
    <%@ include file="header.jsp" %> <!-- Inclusion du header -->

<h2>Fiche du Radiateur</h2>
<p><strong>Nom :</strong> ${radiateur.nom}</p>
<p><strong>Température désirée :</strong> ${radiateur.temperatureDesiree} °C</p>
<p><strong>Présence de personnes :</strong> ${radiateur.presencePersonne ? "Oui" : "Non"}</p>
<p><strong>État :</strong> ${radiateur.etat ? "Allumé" : "Éteint"}</p>
</body>
</html>