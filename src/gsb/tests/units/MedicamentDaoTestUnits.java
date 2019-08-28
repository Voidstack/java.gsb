package gsb.tests.units;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;

public class MedicamentDaoTestUnits {

	Medicament medicament;
	Visiteur visiteur;
	Localite loc;
	
	@Before
	public void setUp() throws Exception {
		
		medicament = new Medicament("TEST","","","","",0.0F,"","");
		MedicamentDao.AjouterMedicament(medicament);
		loc = new Localite("code","ville");
		visiteur = new Visiteur("test", "", "", "", "", "",
				loc, new Date(0), "", "");
		
		LocaliteDao.AjouterLocalite(loc);
		
		VisiteurDao.AjouterVisiteur(visiteur);
	}

	@After
	public void tearDown() throws Exception {
		
		MedicamentDao.SupprimerStock(visiteur.getMatricule(), medicament.getDepotLegal());
		MedicamentDao.SupprimerMedicament(medicament);
		VisiteurDao.SupprimerVisiteur(visiteur);
		LocaliteDao.SupprimerLocalite(loc);
	}

	
	@Test
	public void testAjouterMedicament() {
		
		Medicament medicamentTest = new Medicament("TEST1","","","","",0.0F,"","");
		assertNotSame(-1,MedicamentDao.AjouterMedicament(medicamentTest));
		MedicamentDao.SupprimerMedicament(medicamentTest);
		
		
	}	
	
	@Test
	public void testAjouterMedicamentStocker() {
		
		
		MedicamentDao.AjouterMedicamentStockerByVisiteur(medicament.getDepotLegal(),visiteur.getMatricule() ,1);
		boolean resultat = false;
		
		HashMap<Medicament,Integer> res = MedicamentDao.ListeMedicamentStockerByVisiteur(visiteur.getMatricule());
		
		for(Medicament med : res.keySet()){
			
			if(med.getDepotLegal().equals(medicament.getDepotLegal())){
				
				resultat = true;
				
			}
			
		}
	
		
		assertEquals(true,resultat);
	
		
	}	
	
	@Test
	public void testRechercherMedicament() {
		
		
		assertEquals(medicament.getDepotLegal(),MedicamentDao.RechercherMedicament("TEST").getDepotLegal());
		
	}
	
	@Test
	public void testModifierMedicament() {
		
		medicament.setEffets("test");
		
		assertNotEquals(-1,MedicamentDao.ModifierMedicament(medicament));
		
	}	
	
	@Test
	public void testSupprimerMedicament() {
		
		int res = MedicamentDao.SupprimerMedicament(medicament);
		assertNotEquals(-1,res);
		
	}

}
