package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

import beans.Radiateur;
@WebServlet("/RadiateurServlet")
public class RadiateurServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Radiateur radiateur = new Radiateur();
        radiateur.setNom(request.getParameter("nom"));
        radiateur.setTemperatureDesiree(Double.parseDouble(request.getParameter("temperatureDesiree")));
        radiateur.setPresencePersonne(Boolean.parseBoolean(request.getParameter("presencePersonne")));
        radiateur.setHeureDebut(request.getParameter("heureDebut"));
        radiateur.setHeureFin(request.getParameter("heureFin"));
 
        // Logique d'adaptation
        LocalTime currentTime = LocalTime.now();
        LocalTime debut = LocalTime.parse(radiateur.getHeureDebut());
        LocalTime fin = LocalTime.parse(radiateur.getHeureFin());
 
        if (currentTime.isBefore(debut) || currentTime.isAfter(fin)) {
            radiateur.setEtat(false);
        } else {
            radiateur.setEtat(true);
            if (!radiateur.isPresencePersonne()) {
                radiateur.setTemperatureDesiree(radiateur.getTemperatureDesiree() - 2.0);
            }
        }
 
        request.setAttribute("radiateur", radiateur);
        request.getSession().setAttribute("radiateur", radiateur);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ficheRadiateur.jsp");
        dispatcher.forward(request, response);
    }
}