package servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beans.Radiateur;
import beans.Refrigerateur;



@WebServlet("/VisualiserObjetsConnectes")
public class VisualiserObjetsConnectesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer tous les objets de la session
        List<Radiateur> radiateurs = (List<Radiateur>) request.getSession().getAttribute("radiateurs");
        List<Refrigerateur> refrigerateurs = (List<Refrigerateur>) request.getSession().getAttribute("refrigerateurs");

        // Si la session ne contient pas encore les objets, initialiser les listes vides
        if (radiateurs == null) radiateurs = new ArrayList<>();
        if (refrigerateurs == null) refrigerateurs = new ArrayList<>();

        // Ajouter les objets à la requête pour les afficher dans la JSP
        request.setAttribute("radiateurs", radiateurs);
        request.setAttribute("refrigerateurs", refrigerateurs);

        // Rediriger vers la JSP d'affichage
        RequestDispatcher dispatcher = request.getRequestDispatcher("visualiserObjets.jsp");
        dispatcher.forward(request, response);
    }
}
