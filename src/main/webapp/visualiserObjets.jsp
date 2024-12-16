<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Refrigerateur" %>
<%@ page import="beans.Radiateur" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Visualiser les Objets Connectés</title>
</head>
<body>
    <%@ include file="header.jsp" %> <!-- Inclusion du header -->

    <h2>Objets Connectés</h2>

    <h3>Réfrigérateurs :</h3>
    <ul>
        <% 
            List<Refrigerateur> refrigerateurs = (List<Refrigerateur>) session.getAttribute("refrigerateurs");
            if (refrigerateurs != null) {
                for (Refrigerateur refrigerateur : refrigerateurs) {
        %>
            <li>
                <a href="FicheRefrigerateurServlet?id=<%= refrigerateur.getId() %>">
                    <%= refrigerateur.getNom() %> - <%= refrigerateur.getTemperature() %>°C
                </a>
            </li>
        <% 
                }
            } else {
        %>
            <li>Aucun réfrigérateur disponible</li>
        <% 
            }
        %>
    </ul>

    <h3>Radiateurs :</h3>
    <ul>
        <% 
            List<Radiateur> radiateurs = (List<Radiateur>) session.getAttribute("radiateurs");
            if (radiateurs != null) {
                for (Radiateur radiateur : radiateurs) {
        %>
            <li>
                <a href="FicheRadiateurServlet?id=<%= radiateur.getId() %>">
                    <%= radiateur.getNom() %> - <%= radiateur.getTemperatureDesiree() %>°C
                </a>
            </li>
        <% 
                }
            } else {
        %>
            <li>Aucun radiateur disponible</li>
        <% 
            }
        %>
    </ul>

</body>
</html>
