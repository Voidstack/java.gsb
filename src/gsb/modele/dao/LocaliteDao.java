/*
 * Créé le 22 févr. 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.modele.dao;

import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Visiteur;

import java.sql.ResultSet;

/**
 * @author Isabelle 22 févr. 2015 TODO Pour changer le modèle de ce commentaire
 *         de type généré, allez à : Fenêtre - Préférences - Java - Style de
 *         code - Modèles de code
 */
public class LocaliteDao {

	public static Localite rechercher(String codeLocalite) {
		Localite uneLocalite = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from LOCALITE where CODEPOSTAL='" + codeLocalite + "'");
		try {
			if (reqSelection.next()) {
				uneLocalite = new Localite(reqSelection.getString(1), reqSelection.getString(2));
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from LOCALITE where CODEPOSTAL='"
					+ codeLocalite + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return uneLocalite;
	}

	public static int AjouterLocalite(Localite loc){
			
			int result = 0;
			String requette = "INSERT INTO `LOCALITE` (`CODEPOSTAL`, `VILLE`) VALUES ('" + loc.getCodePostal() + "','" + loc.getVille() + "');";
			result = ConnexionMySql.execReqMaj(requette);
			ConnexionMySql.fermerConnexionBd();
			return result;
			
	
	}
	
	public static int SupprimerLocalite(Localite loc){
		
		int result = 0;
		String requette = "DELETE FROM LOCALITE WHERE CODEPOSTAL='" + loc.getCodePostal() + "';";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;		
	}
	
}
