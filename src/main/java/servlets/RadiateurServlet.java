package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import beans.Radiateur;

@WebServlet("/RadiateurServlet")
public class RadiateurServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Création du radiateur à partir des paramètres du formulaire
        Radiateur radiateur = new Radiateur();
        radiateur.setNom(request.getParameter("nom"));
        radiateur.setTemperatureDesiree(Double.parseDouble(request.getParameter("temperatureDesiree")));
        radiateur.setPresencePersonne(Boolean.parseBoolean(request.getParameter("presencePersonne")));
        radiateur.setHeureDebut(request.getParameter("heureDebut"));
        radiateur.setHeureFin(request.getParameter("heureFin"));

        // Logique d'adaptation de l'état et de la température
        LocalTime currentTime = LocalTime.now();
        LocalTime debut = LocalTime.parse(radiateur.getHeureDebut());
        LocalTime fin = LocalTime.parse(radiateur.getHeureFin());

        if (currentTime.isBefore(debut) || currentTime.isAfter(fin)) {
            radiateur.setEtat(false); // Radiateur éteint
        } else {
            radiateur.setEtat(true); // Radiateur allumé
            if (!radiateur.isPresencePersonne()) {
                radiateur.setTemperatureDesiree(radiateur.getTemperatureDesiree() - 2.0); // Réduction de la température
            }
        }

        // Gestion de la liste des radiateurs dans la session
        HttpSession session = request.getSession();
        List<Radiateur> radiateurs = (List<Radiateur>) session.getAttribute("radiateurs");

        // Si la liste n'existe pas encore, la créer
        if (radiateurs == null) {
            radiateurs = new ArrayList<>();
            session.setAttribute("radiateurs", radiateurs);
        }

        // Ajouter le radiateur à la liste
        radiateurs.add(radiateur);

        // Passer l'objet radiateur à la JSP
        request.setAttribute("radiateur", radiateur);

        // Rediriger vers la fiche du radiateur
        RequestDispatcher dispatcher = request.getRequestDispatcher("ficheRadiateur.jsp");
        dispatcher.forward(request, response);
    }
}
