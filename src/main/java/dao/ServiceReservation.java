package dao;

import meserreurs.MonException;

import java.text.SimpleDateFormat;
import java.util.*;

import metier.*;
import persistance.*;

public class ServiceReservation {

    public static void insert(Reservation reservation) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd");
            mysql = "insert into reservation  (id_oeuvrevente,id_adherent,date_reservation, statut)  " + "values ('"
                    + reservation.getOeuvrevente().getIdOeuvrevente();
            mysql += "'" + ",'" + reservation.getAdherent().getIdAdherent() + "','" + ft.format(dNow) +  "', 'confirmee')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }

}