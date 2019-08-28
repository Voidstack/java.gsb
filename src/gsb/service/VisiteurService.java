package gsb.service;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

public class VisiteurService {
	
	
	public static Visiteur RechercherVisiteur(String matricule) throws Exception{
		
		if(matricule.equals(null) || matricule == ""){
			
			throw new Exception("Données invalide");
			
		}
		if(!VisiteurDao.VisiteurExist(matricule)){
			
			throw new Exception("Visiteur inexistant");			
			
		}
		
		return VisiteurDao.rechercher(matricule);
		
		
	}
	

}
