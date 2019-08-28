/*
 * Cr�� le 23 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.service;

import java.util.ArrayList;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.MedicamentDao;

/**
 * @author Isabelle 23 f�vr. 2015 TODO Pour changer le mod�le de ce commentaire
 *         de type g�n�r�, allez � : Fen�tre - Pr�f�rences - Java - Style de
 *         code - Mod�les de code
 */
public class MedecinService {

	public static Medecin rechercherMedecin(String unCodeMedecin) throws Exception {
		Medecin unMedecin = null;
			if (unCodeMedecin == null) {
				throw new Exception("Donn�e obligatoire : code");
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
