package gsb.service;

import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;

public class MedicamentService {

	
	public static Medicament RechercherMedicament(String DepotLegal) throws Exception{
		
		
		if(DepotLegal == null || DepotLegal == ""){
			
			throw new Exception("Depot Legal Invalide");
			
		}
		
		return MedicamentDao.RechercherMedicament(DepotLegal);
		
	}

	public static ArrayList<Medicament> RechercherToutMedicament() throws Exception{
		
		
		return MedicamentDao.RechercherToutMedicament();
		
	}
	
	
	public static int AjouterMedicament(Medicament medicament) throws Exception{

		if(medicament.getDepotLegal() == null 
				|| medicament.getCodeFamille() == null 
				|| medicament.getComposition() == null 
				|| medicament.getContreIndication() == null
				|| medicament.getEffets() == null
				|| medicament.getLibellefamille() == null
				|| medicament.getNomCommercial() == null
				){
			
			throw new Exception("Donnée null");


		}
		if(medicament.getDepotLegal().equals("")
				|| medicament.getCodeFamille().equals("")
				|| medicament.getComposition().equals("")
				|| medicament.getContreIndication() .equals("")
				|| medicament.getEffets() .equals("")
				|| medicament.getLibellefamille() .equals("")
				|| medicament.getNomCommercial() .equals("")
				){
			
			
			throw new Exception("Donnée null");
		}
		if(MedicamentDao.MedicamentExist(medicament.getDepotLegal())){
			
			throw new Exception("Le medicament éxiste Deja");
			
		}
		if(medicament.getCodeFamille().length() > 3){
			
			throw new Exception("Code Famille Trop long");
			
		}
		
		return MedicamentDao.AjouterMedicament(medicament);


	}
	
	public static void ModifierMedicament(Medicament medicament) throws Exception{
		
		if(medicament.getDepotLegal() == null 
				|| medicament.getCodeFamille() == null 
				|| medicament.getComposition() == null 
				|| medicament.getContreIndication() == null
				|| medicament.getEffets() == null
				|| medicament.getLibellefamille() == null
				|| medicament.getNomCommercial() == null
				){
			
			throw new Exception("Donnée null");


		}
		
		MedicamentDao.ModifierMedicament(medicament);
		
		
		
	}
	
	public static void SuppprimerMedicament(Medicament medicament) throws Exception{
		
		if(medicament.getDepotLegal() == null 
				|| medicament.getCodeFamille() == null 
				|| medicament.getComposition() == null 
				|| medicament.getContreIndication() == null
				|| medicament.getEffets() == null
				|| medicament.getLibellefamille() == null
				|| medicament.getNomCommercial() == null
				){
			
			throw new Exception("Donnée null");


		}
		
		if(!MedicamentDao.MedicamentExist(medicament.getDepotLegal())){
			
			throw new Exception("Medicament Inexistant");			
			
		}
		
		MedicamentDao.SupprimerMedicament(medicament);
		
		
		
	}	
	
	public static HashMap<Medicament,Integer> RechercherMedicamentStocker(String matricule) throws Exception{
		
		if(matricule.equals("") || matricule == null){
			
			throw new Exception("Donnée null");
			
		}
		
		return MedicamentDao.ListeMedicamentStockerByVisiteur(matricule);
		
	}
	

	public static void AJouterMedicamentStocker(String matricule,String depot,String qte) throws Exception{
		
		if(matricule.equals("") || matricule == null || depot.equals("") || depot == null || qte.equals("") || qte == null){
			
			throw new Exception("Donnée null");
			
		}		
		if(!MedicamentDao.MedicamentExist(depot)){
			
			throw new Exception("Medicament inexistant");			
			
		}
		if(!VisiteurDao.VisiteurExist(matricule)){
			
			throw new Exception("Visiteur inexistant");			
			
		}
		
		if(CheckIfAlreadyStock(matricule,depot)){
			
			int prevQte = MedicamentDao.RechercherQteStock(depot, matricule);
			MedicamentDao.ModifierMedicamentStocker(matricule, depot, Integer.toString(prevQte + Integer.parseInt(qte)));
			
		}
		else{

		   MedicamentDao.AjouterMedicamentStockerByVisiteur(depot, matricule, Integer.parseInt(qte));
		
		}
		
	}
	
	private static boolean CheckIfAlreadyStock(String matricule,String depot) throws Exception{
		
		boolean res = false;
		
		HashMap<Medicament,Integer> liste = RechercherMedicamentStocker(matricule);
		
		for(Medicament key : liste.keySet()){
			
			if(key.getDepotLegal().equals(depot)){
				
				res = true;
				
			}
			
		}		
		
		return res;
		
		
	}
	

}
