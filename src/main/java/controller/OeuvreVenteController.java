package controller;

import dao.ServiceOeuvre;
import dao.ServiceProprietaire;
import meserreurs.MonException;
import metier.Oeuvrevente;
import metier.Proprietaire;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AdherentController
 */
@WebServlet("/oeuvre")
public class OeuvreVenteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OeuvreVenteController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processusTraiteRequete(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processusTraiteRequete(request, response);
    }

    protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actionName = request.getParameter("action");
        String destinationPage = "/pages/erreur.jsp";

        // execute l'action
        switch(actionName)
        {
            case "lister":
                try {
                    request.setAttribute("mesOeuvres", ServiceOeuvre.gets());
                } catch (MonException e) {
                    e.printStackTrace();
                }

                destinationPage = "/pages/oeuvre/liste.jsp";
                break;
            case "ajout" :
                try {
                    request.setAttribute("proprios", ServiceProprietaire.gets());
                } catch (MonException e) {
                    e.printStackTrace();
                }
                destinationPage = "/pages/oeuvre/ajout.jsp";
                break;
            case "modif" :
                try {
                    request.setAttribute("proprios", ServiceProprietaire.gets());
                    request.setAttribute("o", ServiceOeuvre.get(Integer.parseInt(request.getParameter("oeuvre"))));
                } catch (MonException e) {
                    e.printStackTrace();
                }

                destinationPage = "/pages/oeuvre/modif.jsp";
                break;
            case "modifier" :
                try {
                    Oeuvrevente ov = ServiceOeuvre.get(Integer.parseInt(request.getParameter("id")));
                    ov.setTitreOeuvrevente(request.getParameter("titre"));
                    ov.setEtatOeuvrevente(request.getParameter("etat"));
                    ov.setPrixOeuvrevente(Float.parseFloat(request.getParameter("prix")));
                    ov.setProprietaire(ServiceProprietaire.get(Integer.parseInt(request.getParameter("proprio"))));
                    ServiceOeuvre.modif(ov);

                } catch (MonException e) {
                    e.printStackTrace();
                }
                destinationPage = "/index.jsp";
                break;
            case "proprio" :
                destinationPage = "/pages/oeuvre/proprio.jsp";
                break;
            case "insertion" :
                try {
                    Proprietaire p = new Proprietaire();
                    p.setNomProprietaire(request.getParameter("nom"));
                    p.setPrenomProprietaire(request.getParameter("prenom"));
                    ServiceProprietaire.insert(p);

                } catch (MonException e) {
                    e.printStackTrace();
                }
                destinationPage = "/index.jsp";
                break;
            case "inserer" :
                try {
                    Oeuvrevente ov = new Oeuvrevente();
                    ov.setTitreOeuvrevente(request.getParameter("titre"));
                    ov.setEtatOeuvrevente(request.getParameter("etat"));
                    ov.setPrixOeuvrevente(Float.parseFloat(request.getParameter("prix")));
                    ov.setProprietaire(ServiceProprietaire.get(Integer.parseInt(request.getParameter("proprio"))));
                    ServiceOeuvre.insert(ov);

                } catch (MonException e) {
                    e.printStackTrace();
                }
                destinationPage = "/index.jsp";
                break;
            default:
                String messageErreur = "[" + actionName + "] n'est pas une action valide.";
                request.setAttribute("messageErreur", messageErreur);
        }

        // Redirection vers la page jsp appropriee
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
        dispatcher.forward(request, response);
    }

}

