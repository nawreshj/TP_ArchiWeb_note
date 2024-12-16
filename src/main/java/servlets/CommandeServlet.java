package servlets;
 
import beans.Commande;
 

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
 
@WebServlet("/CommandeServlet")
public class CommandeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomProduit = request.getParameter("nomProduit");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        String dateCommande = request.getParameter("dateCommande");
        String etatCommande = request.getParameter("etatCommande");
 
        Commande commande = new Commande();
        commande.setIdCommande((int) (Math.random() * 1000));
        commande.setNomProduit(nomProduit);
        commande.setQuantite(quantite);
        commande.setDateCommande(dateCommande);
        commande.setEtatCommande(etatCommande);
 
        request.setAttribute("commande", commande);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ficheCommande.jsp");
        dispatcher.forward(request, response);
    }
}
 