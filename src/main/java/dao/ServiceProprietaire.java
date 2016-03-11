package dao;

import meserreurs.MonException;
import java.util.*;

import metier.*;
import persistance.*;

public class ServiceProprietaire {

    public static void insert(Proprietaire p) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "INSERT INTO proprietaire (nom_proprietaire, prenom_proprietaire) values ('"
                    + p.getNomProprietaire() + "', '"
                    + p.getPrenomProprietaire() + "')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }

    public static void modif(Proprietaire p) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "UPDATE proprietaire SET nom_proprietaire = '" + p.getNomProprietaire()
                    + "', prenom_proprietaire = '" + p.getPrenomProprietaire()
                    + "' WHERE id_proprietaire = " + p.getIdProprietaire();

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }

    public static Proprietaire get(int id) throws MonException {
        String mysql = "select * from proprietaire where id_proprietaire=" + id;
        List<Proprietaire> maListe = gets(mysql);
        if (maListe.isEmpty())
            return null;
        else {
            return maListe.get(0);
        }
    }

    public static List<Proprietaire> gets() throws MonException {
        String mysql = "select * from proprietaire";
        return gets(mysql);
    }

    private static List<Proprietaire> gets(String mysql) throws MonException {
        List<Object> rs;
        List<Proprietaire> mesProprietaires = new ArrayList<>();
        int index = 0;
        try {
            DialogueBd.getInstance();
            rs = DialogueBd.lecture(mysql);
            while (index < rs.size()) {
                Proprietaire p = new Proprietaire();
                p.setIdProprietaire(Integer.parseInt(rs.get(index + 0).toString()));
                p.setNomProprietaire(rs.get(index + 1).toString());
                p.setPrenomProprietaire(rs.get(index + 2).toString());
                index = index + 3;
                mesProprietaires.add(p);
            }

            return mesProprietaires;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

}
