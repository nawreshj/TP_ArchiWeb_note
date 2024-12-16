<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Créer un Réfrigérateur</title>
</head>
<body>
    <%@ include file="header.jsp" %> <!-- Inclusion du header -->

    <h1>Gestion du Réfrigérateur</h1>
    <form action="RefrigerateurServlet" method="post">
        <!-- Informations de base du réfrigérateur -->
        <label for="nom">Nom du réfrigérateur :</label>
        <input type="text" id="nom" name="nom" value="Mon Réfrigérateur" required><br><br>

        <label for="temperature">Température :</label>
        <input type="number" id="temperature" name="temperature" step="0.1" value="5.0" required><br><br>

        <!-- Ajout de produit -->
        <fieldset>
            <legend>Ajouter des produits</legend>

            <div id="produits">
                <!-- Champ de produit initial -->
                <div class="produit">
                    <label for="nomProduit">Nom du produit :</label>
                    <input type="text" name="nomProduit[]" required><br><br>

                    <label for="quantiteProduit">Quantité :</label>
                    <input type="number" name="quantiteProduit[]" min="0" required><br><br>
                </div>
            </div>

            <button type="button" onclick="ajouterProduit()">Ajouter un autre produit</button><br><br>
        </fieldset>

        <button type="submit">Mettre à jour</button>
    </form>

    <script>
        function ajouterProduit() {
            // Crée un nouveau champ pour ajouter un produit
            var divProduit = document.createElement('div');
            divProduit.classList.add('produit');

            divProduit.innerHTML = `
                <label for="nomProduit">Nom du produit :</label>
                <input type="text" name="nomProduit[]" required><br><br>

                <label for="quantiteProduit">Quantité :</label>
                <input type="number" name="quantiteProduit[]" min="0" required><br><br>
            `;
            document.getElementById('produits').appendChild(divProduit);
        }
    </script>
</body>
</html>
