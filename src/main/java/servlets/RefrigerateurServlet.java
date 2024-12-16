package servlets;

import beans.Refrigerateur;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Récupérer la liste des réfrigérateurs de la session
        List<Refrigerateur> refrigerateurs = (List<Refrigerateur>) session.getAttribute("refrigerateurs");
        if (refrigerateurs == null) {
            refrigerateurs = new ArrayList<>();
            session.setAttribute("refrigerateurs", refrigerateurs);
        }

        // Récupérer ou créer un nouveau réfrigérateur
        String idParam = request.getParameter("id");
        Refrigerateur refrigerateur = null;
        
        if (idParam != null && !idParam.isEmpty()) {
            // Recherche du réfrigérateur existant dans la liste
            int id = Integer.parseInt(idParam);
            for (Refrigerateur r : refrigerateurs) {
                if (r.getId() == id) {
                    refrigerateur = r;
                    break;
                }
            }
        }

        // Si le réfrigérateur n'existe pas, en créer un nouveau
        if (refrigerateur == null) {
            refrigerateur = new Refrigerateur();
           
            refrigerateurs.add(refrigerateur);
        }

        // Mise à jour des informations de base du réfrigérateur
        String nom = request.getParameter("nom");
        if (nom != null && !nom.isEmpty()) {
            refrigerateur.setNom(nom);
        }

        String tempParam = request.getParameter("temperature");
        if (tempParam != null && !tempParam.isEmpty()) {
            double temperature = Double.parseDouble(tempParam);
            refrigerateur.setTemperature(temperature);
        }

        // Mise à jour des produits dans le réfrigérateur
        String[] nomsProduits = request.getParameterValues("nomProduit[]");
        String[] quantitesProduits = request.getParameterValues("quantiteProduit[]");

        if (nomsProduits != null && quantitesProduits != null) {
            for (int i = 0; i < nomsProduits.length; i++) {
                String nomProduit = nomsProduits[i];
                if (nomProduit != null && !nomProduit.isEmpty()) {
                    int quantite = Integer.parseInt(quantitesProduits[i]);
                    refrigerateur.ajouterProduit(nomProduit, quantite);
                }
            }
        }
        
        request.setAttribute("refrigerateur.produits", refrigerateur.getProduits());
        session.setAttribute("refrigerateur.produits", refrigerateur.getProduits());


        // Mise à jour de la session et redirection vers la fiche du réfrigérateur
        session.setAttribute("refrigerateurs", refrigerateurs);
        request.setAttribute("refrigerateur", refrigerateur);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ficheRefrigerateur.jsp");
        dispatcher.forward(request, response);
    }
}
