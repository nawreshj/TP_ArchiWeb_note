package servlets;

import beans.Refrigerateur;
import beans.Commande;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RefrigerateurServlet")
public class RefrigerateurServlet extends HttpServlet {
    private Refrigerateur refrigerateur;

    @Override
    public void init() throws ServletException {
        refrigerateur = new Refrigerateur();
        refrigerateur.setId(1);
        refrigerateur.setNom("Mon Réfrigérateur");
        refrigerateur.setTemperature(5.0);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les informations de base du réfrigérateur
        String nom = request.getParameter("nom");
        refrigerateur.setNom(nom);

        double temperature = Double.parseDouble(request.getParameter("temperature"));
        refrigerateur.setTemperature(temperature);

        // Récupérer les produits envoyés par le formulaire
        String[] nomsProduits = request.getParameterValues("nomProduit[]");
        String[] quantitesProduits = request.getParameterValues("quantiteProduit[]");

        if (nomsProduits != null && quantitesProduits != null) {
            for (int i = 0; i < nomsProduits.length; i++) {
                String nomProduit = nomsProduits[i];
                int quantite = Integer.parseInt(quantitesProduits[i]);
                if (nomProduit != null && !nomProduit.isEmpty()) {
                    refrigerateur.ajouterProduit(nomProduit, quantite);
                }
            }
        }
        
        
     // Ajout du réfrigérateur à la session
        HttpSession session = request.getSession();
        List<Refrigerateur> refrigerateurs = (List<Refrigerateur>) session.getAttribute("refrigerateurs");
        
        // Si la liste des réfrigérateurs n'existe pas, la créer
        if (refrigerateurs == null) {
            refrigerateurs = new ArrayList<>();
            session.setAttribute("refrigerateurs", refrigerateurs);
        }
        
        // Ajouter le réfrigérateur créé à la liste
        refrigerateurs.add(refrigerateur);

        request.setAttribute("refrigerateur.produits", refrigerateur.getProduits());
        request.setAttribute("refrigerateur", refrigerateur);
        
     // Ajouter le réfrigérateur à la session
       request.getSession().setAttribute("refrigerateur", refrigerateur);
        request.setAttribute("refrigerateur.produits", refrigerateur.getProduits());
        request.setAttribute("refrigerateur", refrigerateur);

        // Rediriger vers la page "ficheRefrigerateur.jsp" test commit
        RequestDispatcher dispatcher = request.getRequestDispatcher("ficheRefrigerateur.jsp");
        dispatcher.forward(request, response);
    }
}
