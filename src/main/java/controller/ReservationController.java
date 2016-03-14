package controller;

import dao.ServiceAdherent;
import dao.ServiceOeuvre;
import dao.ServiceProprietaire;
import dao.ServiceReservation;
import meserreurs.MonException;
import metier.Oeuvrevente;
import metier.Reservation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/reservation")
public class ReservationController extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationController() {
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
        String destinationPage = "/pages/error.jsp";
        int idOeuvre;
        switch(actionName) {
            case "resume":
                idOeuvre = Integer.parseInt(request.getParameter("oeuvre"));
                try {
                    request.setAttribute("adherents", ServiceAdherent.consulterListe());
                    request.setAttribute("oeuvre", ServiceOeuvre.get(idOeuvre));
                } catch (MonException e) {
                    e.printStackTrace();
                }
                destinationPage = "/pages/reservation/reservation.jsp";
                break;
            case "reserver":
                int idAdherent = Integer.parseInt(request.getParameter("adherent"));
                idOeuvre = Integer.parseInt(request.getParameter("oeuvre"));
                try {
                    Reservation re = new Reservation();
                    re.setAdherent(ServiceAdherent.consulter(idAdherent));
                    re.setDate(new Date());
                    re.setOeuvrevente(ServiceOeuvre.get(idOeuvre));
                    ServiceReservation.insert(re);

                    Oeuvrevente ov = ServiceOeuvre.get(idOeuvre);
                    ov.setEtatOeuvrevente("R");
                    ServiceOeuvre.modif(ov);

                } catch (MonException e) {
                    e.printStackTrace();
                }
                destinationPage = "/pages/reservation/reserve.jsp";
                break;
            case "lister":
                try {
                    request.setAttribute("reservations", ServiceReservation.gets());
                } catch (MonException e) {
                    e.printStackTrace();
                }
                destinationPage = "/pages/reservation/liste.jsp";
                break;
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
        dispatcher.forward(request, response);
    }
}
