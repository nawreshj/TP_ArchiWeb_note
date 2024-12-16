package servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import java.util.List;

import beans.Radiateur;

@WebServlet("/FicheRadiateurServlet")
public class FicheRadiateurServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'ID depuis la requête
        String idParam = request.getParameter("id");
        Radiateur radiateur = null;

        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);

                // Récupérer la liste des radiateurs depuis la session
                List<Radiateur> radiateurs = (List<Radiateur>) request.getSession().getAttribute("radiateurs");
                if (radiateurs != null) {
                    for (Radiateur r : radiateurs) {
                        if (r.getId() == id) {
                            radiateur = r;
                            break;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "ID invalide");
            }
        }

        if (radiateur != null) {
            request.setAttribute("radiateur", radiateur);
        } else {
            request.setAttribute("error", "Radiateur introuvable");
        }

        // Redirection vers la fiche du radiateur
        RequestDispatcher dispatcher = request.getRequestDispatcher("ficheRadiateur.jsp");
        dispatcher.forward(request, response);
    }
}
