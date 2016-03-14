package dao;

import meserreurs.MonException;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

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

    public static List<Reservation> gets() throws MonException {
        String mysql = "select * from reservation";
        List<Object> rs;
        List<Reservation> mesReservation = new ArrayList<>();
        int index = 0;
        try{
            rs = DialogueBd.lecture(mysql);
            while (index < rs.size()) {
                Reservation reservation = new Reservation();
                reservation.setOeuvrevente(ServiceOeuvre.get(Integer.parseInt(rs.get(index).toString())));
                reservation.setAdherent(ServiceAdherent.consulter(Integer.parseInt(rs.get(index + 1).toString())));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(rs.get(index + 2).toString());
                reservation.setDate(date);

                reservation.setStatut(rs.get(index + 3).toString());
                index = index + 4;
                mesReservation.add(reservation);
            }

            return mesReservation;

        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

}