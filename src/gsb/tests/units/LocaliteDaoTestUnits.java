package gsb.tests.units;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;

public class LocaliteDaoTestUnits {

	Localite localite;
	
	@Before
	public void setUp() throws Exception {
		
		localite = new Localite("00000","Ville");
		LocaliteDao.AjouterLocalite(localite);
	}

	@After
	public void tearDown() throws Exception {
		
		LocaliteDao.SupprimerLocalite(localite);
		
	}
	
	@Test
	public void testAjouterLocalite() {
		
		Localite localiteTest = new Localite("00001","Ville");
		assertNotSame(-1,LocaliteDao.AjouterLocalite(localiteTest));
		LocaliteDao.SupprimerLocalite(localiteTest);
		
		
	}
	
	@Test
	public void testRechercherLocalite() {
		

		assertEquals(localite.getCodePostal(),LocaliteDao.rechercher(localite.getCodePostal()).getCodePostal());
		
		
	}

	@Test
	public void testSupprimerLocalite() {
		

		assertNotSame(-1,LocaliteDao.SupprimerLocalite(localite));
		
		
	}
}
