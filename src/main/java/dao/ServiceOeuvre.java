package dao;

import meserreurs.MonException;
import java.util.*;

import metier.*;
import persistance.*;

public class ServiceOeuvre {

	public static void insert(Oeuvrevente ov) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "INSERT INTO oeuvrevente (titre_oeuvrevente, etat_oeuvrevente, prix_oeuvrevente, id_proprietaire) values ('"
					+ ov.getTitreOeuvrevente() + "','"
                    + ov.getEtatOeuvrevente() + "','"
                    + ov.getPrixOeuvrevente() + "','"
                    + ov.getProprietaire().getIdProprietaire() + "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

    public static void modif(Oeuvrevente ov) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "UPDATE oeuvrevente SET titre_oeuvrevente = '" + ov.getTitreOeuvrevente()
                    + "', etat_oeuvrevente = '" + ov.getEtatOeuvrevente()
                    + "', prix_oeuvrevente = '" + ov.getPrixOeuvrevente()
                    + "', id_proprietaire = '" + ov.getProprietaire().getIdProprietaire()
                    + "' WHERE id_oeuvrevente = " + ov.getIdOeuvrevente();

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }

	public static Oeuvrevente get(int numero) throws MonException {
		String mysql = "select * from oeuvrevente where id_oeuvrevente=" + numero;
		List<Oeuvrevente> mesAdh = gets(mysql);
		if (mesAdh.isEmpty())
			return null;
		else {
			return mesAdh.get(0);
		}
	}

	public static List<Oeuvrevente> gets() throws MonException {
		String mysql = "select * from oeuvrevente";
		return gets(mysql);
	}

	private static List<Oeuvrevente> gets(String mysql) throws MonException {
		List<Object> rs;
		List<Oeuvrevente> mesOeuvres = new ArrayList<Oeuvrevente>();
		int index = 0;
		try{
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Oeuvrevente uneOeuvre = new Oeuvrevente();
				// il faut redecouper la liste pour retrouver les lignes
				uneOeuvre.setIdOeuvrevente(Integer.parseInt(rs.get(index + 0).toString()));
				uneOeuvre.setTitreOeuvrevente(rs.get(index + 1).toString());
				uneOeuvre.setEtatOeuvrevente(rs.get(index + 2).toString());
				uneOeuvre.setPrixOeuvrevente(Float.parseFloat(rs.get(index + 3).toString()));
				Proprietaire proprietaire = ServiceProprietaire.get(Integer.parseInt(rs.get(index + 4).toString()));
				uneOeuvre.setProprietaire(proprietaire);
				// On incr�mente tous les 5 champs
				index = index + 5;
				mesOeuvres.add(uneOeuvre);
			}

            return mesOeuvres;

        } catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

}
