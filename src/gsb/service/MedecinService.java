/*
 * Créé le 23 févr. 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.service;

import java.util.ArrayList;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.MedicamentDao;

/**
 * @author Isabelle 23 févr. 2015 TODO Pour changer le modèle de ce commentaire
 *         de type généré, allez à : Fenêtre - Préférences - Java - Style de
 *         code - Modèles de code
 */
public class MedecinService {

	public static Medecin rechercherMedecin(String unCodeMedecin) throws Exception {
		Medecin unMedecin = null;
			if (unCodeMedecin == null) {
				throw new Exception("Donnée obligatoire : code");
			}
			if(!MedecinDao.MedecinExist(unCodeMedecin)){
				
				throw new Exception("Medecin inexistant");				
				
			}
			
			unMedecin = MedecinDao.Rechercher(unCodeMedecin);
		
		return unMedecin;
	}

	public static ArrayList<Medecin> RechercherToutMedecins() throws Exception{
		
		
		return MedecinDao.retournerCollectionDesMedecins();
		
	}
	
}
