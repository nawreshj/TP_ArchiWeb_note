<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Créer un Objet Connecté</title>
</head>
<body>
    <%@ include file="header.jsp" %> <!-- Inclusion du header -->

    <h1>Créer un Objet Connecté</h1>
    <p>Choisissez le type d'objet à créer :</p>
    <div>
        <button onclick="location.href='formRadiateur.jsp'">Créer un Radiateur</button>
        <button onclick="location.href='formRefrigerateur.jsp'">Créer un Réfrigérateur</button>
    </div>
</body>
</html>
