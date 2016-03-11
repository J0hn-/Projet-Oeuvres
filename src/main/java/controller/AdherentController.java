package controller;

import dao.ServiceAdherent;
import meserreurs.MonException;
import metier.Adherent;

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
@WebServlet("/adherent")
public class AdherentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdherentController() {
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
        ServiceAdherent serviceAdherent = new ServiceAdherent();
        // execute l'action
        switch(actionName)
        {
            case "lister":
                try {
                    request.setAttribute("mesAdherents", serviceAdherent.consulterListe());
                } catch (MonException e) {
                    e.printStackTrace();
                }

                destinationPage = "/pages/adherent/liste.jsp";
                break;
            case "ajout" :
                destinationPage = "/pages/adherent/ajout.jsp";
                break;
            case "modif" :
                try {
                    request.setAttribute("adherent", serviceAdherent.consulter(Integer.parseInt(request.getParameter("adherent"))));
                } catch (MonException e) {
                    e.printStackTrace();
                }

                destinationPage = "/pages/adherent/modif.jsp";
                break;
            case "modifier" :
                try {
                    Adherent unAdherent = serviceAdherent.consulter(Integer.parseInt(request.getParameter("txtid")));
                    unAdherent.setNomAdherent(request.getParameter("txtnom"));
                    unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
                    unAdherent.setVilleAdherent(request.getParameter("txtville"));
                    serviceAdherent.modif(unAdherent);

                } catch (MonException e) {
                    e.printStackTrace();
                }
                destinationPage = "/index.jsp";
                break;
            case "inserer" :
                try {
                    Adherent unAdherent = new Adherent();
                    unAdherent.setNomAdherent(request.getParameter("txtnom"));
                    unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
                    unAdherent.setVilleAdherent(request.getParameter("txtville"));
                    serviceAdherent.insert(unAdherent);

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

