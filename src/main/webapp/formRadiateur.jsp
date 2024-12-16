<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Créer un Radiateur</title>
</head>
<body>
    <%@ include file="header.jsp" %> <!-- Inclusion du header -->

    <h1>Création d'un Radiateur</h1>
    <form action="RadiateurServlet" method="post">
        <label for="nom">Nom du radiateur :</label>
        <input type="text" id="nom" name="nom" required><br><br>
        
        <label for="temperatureDesiree">Température désirée :</label>
        <input type="number" id="temperatureDesiree" name="temperatureDesiree" step="0.1" required><br><br>
        
        <label for="presencePersonne">Présence de personne :</label>
        <select id="presencePersonne" name="presencePersonne">
            <option value="true">Oui</option>
            <option value="false">Non</option>
        </select><br><br>
        
        <label for="heureDebut">Heure de début :</label>
        <input type="time" id="heureDebut" name="heureDebut" required><br><br>
        
        <label for="heureFin">Heure de fin :</label>
        <input type="time" id="heureFin" name="heureFin" required><br><br>
        
        <button type="submit">Créer Radiateur</button>
    </form>
</body>
</html>
