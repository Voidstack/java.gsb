package gsb.tests.units;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.modele.dao.VisiteurDao;

public class VisiteurDaoTestUnit {

	Visiteur visiteur;
	Localite loc;
	
	@Before
	public void setUp() throws Exception {
		
		loc = new Localite("code","ville");
		visiteur = new Visiteur("test", "", "", "", "", "",
				loc, new Date(0), "", "");
		
		LocaliteDao.AjouterLocalite(loc);
		VisiteurDao.AjouterVisiteur(visiteur);
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		VisiteurDao.SupprimerVisiteur(visiteur);
		LocaliteDao.SupprimerLocalite(loc);
	}

	@Test
	public void testAjoutVisiteur() {
		Visiteur visiteur2 = new Visiteur("tes2", "", "", "", "", "",
				loc, new Date(0), "", "");
		VisiteurDao.AjouterVisiteur(visiteur2);
		assertNotSame(visiteur2.getMatricule(),VisiteurDao.rechercher(visiteur2.getMatricule()).getMatricule());
		VisiteurDao.SupprimerVisiteur(visiteur2);
	}

	@Test
	public void testSuppresionVisiteur() {
		VisiteurDao.SupprimerVisiteur(visiteur);
		assertEquals(false,VisiteurDao.VisiteurExist(visiteur.getMatricule()));
	}
	
	@Test
	public void testModificationVisiteur() {
		visiteur.setPrenom("test");
		assertNotEquals(-1,VisiteurDao.ModifierVisiteur(visiteur));
	}
	
}
