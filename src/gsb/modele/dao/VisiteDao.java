package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class VisiteDao {
	/*
	 * Fonction pour trouver une visite dans la base de données
	 */
	public static Visite rechercher(String referenceVisite) {
		Visite uneVisite = null;
		Medecin unMedecin = null;
		Visiteur unVisiteur = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from VISITE where REFERENCE='" + referenceVisite + "'");//Requette de selection d'une visite
		try {
			//Fonction de création de l'objet visite depuis les infos de la base de données
			//String reference, Date date, String commentaire, Medecin unMedecin, Visiteur unVisiteur
			//(`REFERENCE`, `DATEVISITE`, `COMMENTAIRE`, `MATRICULE`, `CODEMED`)
			if (reqSelection.next()) {
				unMedecin = MedecinDao.Rechercher(reqSelection.getString(4));
				unVisiteur = VisiteurDao.rechercher(reqSelection.getString(5));
				uneVisite = new Visite(reqSelection.getString(1), reqSelection.getDate(2),
						reqSelection.getString(3), unMedecin, unVisiteur);
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITE where REFERENCE='"
					+ referenceVisite + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}
	/* 
	 * Fonction de suppresion d'une viste
	 */
	public static int SupprimerVisite(Visite visite){
		
		int result = 0;
		//Requette de suppression de la visite dans la base de données
		String requette = "DELETE FROM VISITE WHERE REFERENCE='" + visite.getReference() + "';";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;		
	}
	/*
	 * Fonction d'ajout d'une visite
	 */
	public static int AjouterVisite(Visite visite){
		
		int result = 0;
		//Requette d'insertion de la visite dans la base de données
		String requette = "INSERT INTO `VISITE` (`REFERENCE`, `DATEVISITE`, `COMMENTAIRE`, `MATRICULE`, `CODEMED`) VALUES ('" + visite.getReference() + "', '" + visite.getDate().toString() + "', '" + visite.getCommentaire() + "', '" + visite.getUnVisiteur().getMatricule() + "', '" + visite.getUnMedecin().getCodeMed() + "')";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

	public static boolean VisiteExist(String ref){
		
		boolean result = false;;
		String requette = "SELECT COUNT(*) FROM VISITE WHERE `REFERENCE`= '" + ref + "';";
		ResultSet reqSelection = ConnexionMySql.execReqSelection(requette);
		try {
			if(reqSelection.next()) {
				if(reqSelection.getInt(1) > 0){
					
					result = true;
					
				}
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - " + requette);
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();			
		
		
		return result;
		
	}
	
	public static int ModifierVisite(Visite visite){
		
		int result = 0;
		String requette = "UPDATE VISITE SET `DATEVISITE` = '"+ visite.getDate() +"', `COMMENTAIRE` = '"+ visite.getCommentaire() +"', `MATRICULE`= '"+ visite.getUnVisiteur().getMatricule() +"', `CODEMED` = '" + visite.getUnMedecin().getCodeMed() + "' WHERE REFERENCE='" + visite.getReference() + "';";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;		
	}
	

	public static ArrayList<Visite> rechercherTouteVisite() {
		ArrayList<Visite> list = new ArrayList<Visite>();
		Visite uneVisite = null;
		Medecin unMedecin = null;
		Visiteur unVisiteur = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from VISITE");
		try {
			while(reqSelection.next()) {
				unMedecin = MedecinDao.Rechercher(reqSelection.getString(5));
				unVisiteur = VisiteurDao.rechercher(reqSelection.getString(4));
				list.add(new Visite(reqSelection.getString(1), reqSelection.getDate(2),
						reqSelection.getString(3), unMedecin, unVisiteur));
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête ");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return list;
	}
}
