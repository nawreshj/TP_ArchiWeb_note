package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import beans.Refrigerateur;

import java.io.IOException;
import java.util.List;

@WebServlet("/FicheRefrigerateurServlet")
public class FicheRefrigerateurServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'ID depuis la requête
        String idParam = request.getParameter("id");
        Refrigerateur refrigerateur = null;

        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);

                // Récupérer la liste des réfrigérateurs depuis la session
                List<Refrigerateur> refrigerateurs = (List<Refrigerateur>) request.getSession().getAttribute("refrigerateurs");
                if (refrigerateurs != null) {
                    for (Refrigerateur r : refrigerateurs) {
                        if (r.getId() == id) {
                            refrigerateur = r;
                            break;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "ID invalide");
            }
        }

        if (refrigerateur != null) {
            request.setAttribute("refrigerateur", refrigerateur);
        } else {
            request.setAttribute("error", "Réfrigérateur introuvable");
        }

        // Redirection vers la fiche du réfrigérateur
        RequestDispatcher dispatcher = request.getRequestDispatcher("ficheRefrigerateur.jsp");
        dispatcher.forward(request, response);
    }
}
