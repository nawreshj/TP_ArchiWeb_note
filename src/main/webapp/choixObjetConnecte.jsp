<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cr�er un Objet Connect�</title>
</head>
<body>
    <%@ include file="header.jsp" %> <!-- Inclusion du header -->

    <h1>Cr�er un Objet Connect�</h1>
    <p>Choisissez le type d'objet � cr�er :</p>
    <div>
        <button onclick="location.href='formRadiateur.jsp'">Cr�er un Radiateur</button>
        <button onclick="location.href='formRefrigerateur.jsp'">Cr�er un R�frig�rateur</button>
    </div>
</body>
</html>
