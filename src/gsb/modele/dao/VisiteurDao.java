package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class VisiteurDao {
	
	public static Visiteur rechercher(String MatriculeVisiteur) {
		Visiteur unVisiteur = null;
		String req = "select * from VISITEUR where `MATRICULE`='" + MatriculeVisiteur + "';";
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection(req);
		try {
			if (reqSelection.next()) {
				
				Localite loc = LocaliteDao.rechercher(reqSelection.getString(7));
				
				unVisiteur = new Visiteur(
						reqSelection.getString(1),
						reqSelection.getString(2), 
						reqSelection.getString(3), 
						reqSelection.getString(4), 
						reqSelection.getString(5), 
						reqSelection.getString(6),
						loc,
						reqSelection.getDate(8), 
						reqSelection.getString(9), 
						reqSelection.getString(10)
						);
				
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - " + req);
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
	
	
	public static ArrayList<Visiteur> rechercherToutVisiteur() {
		Visiteur unVisiteur = null;
		ArrayList<Visiteur> res = new ArrayList<Visiteur>();
		String req = "select * from VISITEUR;";
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection(req);
		try {
			while (reqSelection.next()) {
				
				Localite loc = LocaliteDao.rechercher(reqSelection.getString(7));
				
				 res.add(new Visiteur(
						reqSelection.getString(1),
						reqSelection.getString(2), 
						reqSelection.getString(3), 
						reqSelection.getString(4), 
						reqSelection.getString(5), 
						reqSelection.getString(6),
						loc,
						reqSelection.getDate(8), 
						reqSelection.getString(9), 
						reqSelection.getString(10)
						));
				
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - " + req);
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return res;
	}
	
	public static int AjouterVisiteur(Visiteur visiteur){
		
		int result = 0;
		String requette = "INSERT INTO `VISITEUR` (`MATRICULE`, `NOM`, `PRENOM`, `LOGIN`, `MDP`, `ADRESSE`, `CODEPOSTAL`, `DATEENTREE`, `CODEUNIT`, `NOMUNIT`) VALUES ("
				+ "'" + visiteur.getMatricule() + "', "
				+ "'" + visiteur.getNom() + "', "
				+ "'" + visiteur.getPrenom() + "', "
				+ "'" + visiteur.getLogin() + "', "
				+ "'" + visiteur.getMdp() + "', "
				+ "'" + visiteur.getAdresse() + "', "
				+ "'" + visiteur.getUneLocalite().getCodePostal() + "', "
				+ "'" + visiteur.getDateEntree().toString() + "', "
				+ "'" + visiteur.getCodeUnite() + "', "
				+ " '" + visiteur.getNomUnite() + "');";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	public static int SupprimerVisiteur(String matricule){
		
		int result = 0;
		String requette = "DELETE FROM VISITEUR WHERE `MATRICULE`='" + matricule + "';";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;		
	}
	
	public static int SupprimerVisiteur(Visiteur visiteur){
		
		int result = 0;
		String requette = "DELETE FROM VISITEUR WHERE `MATRICULE`='" + visiteur.getMatricule() + "';";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;		
	}
	
	public static boolean VisiteurExist(String Matricule){
		
		boolean result = false;;
		String requette = "SELECT COUNT(*) FROM VISITEUR WHERE `MATRICULE`= '" + Matricule + "';";
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
	
	public static int ModifierVisiteur(Visiteur visiteur){
		
		int result = 0;
		String requette = "UPDATE `visiteur` SET `NOM`='" + visiteur.getNom() + "',`PRENOM`='" + visiteur.getPrenom() + "',`LOGIN`='" + visiteur.getNom() + "',`MDP`='" + visiteur.getMdp() + "',`ADRESSE`='" + visiteur.getAdresse() + "',`CODEPOSTAL`='" + visiteur.getUneLocalite().getCodePostal() + "',`DATEENTREE`='" + visiteur.getDateEntree() + "',`CODEUNIT`='" + visiteur.getCodeUnite() + "',`NOMUNIT`='" + visiteur.getNomUnite() + "' WHERE MATRICULE='" + visiteur.getMatricule() + "'";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;		
	}

}
