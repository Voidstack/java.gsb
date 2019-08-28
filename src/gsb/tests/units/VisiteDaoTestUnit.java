package gsb.tests.units;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

public class VisiteDaoTestUnit {

	Visite visite;
	Medecin med;
	Localite loc;
	Visiteur vis;
	
	@Before
	public void setUp() throws Exception {
		
		loc = new Localite("code","ville");
		
		med = new Medecin ("test", "nom", "prenom", "adresse", loc, "telephone",
				"potentiel", "specialite");
		
		vis = new Visiteur("test", "", "", "", "", "",
				loc, new Date(0), "", "");
		
		visite = new Visite("test",new Date(0),"",med,vis);
		
		LocaliteDao.AjouterLocalite(loc);
		MedecinDao.AjouterMedecin(med);
		VisiteurDao.AjouterVisiteur(vis);
		VisiteDao.AjouterVisite(visite);
		
	}

	@After
	public void tearDown() throws Exception {
		
		VisiteDao.SupprimerVisite(visite);
		MedecinDao.SupprimerMedecin(med);
		VisiteurDao.SupprimerVisiteur(vis);
		LocaliteDao.SupprimerLocalite(loc);
		
	}

	@Test
	public void testVisiteRecherche() {
		
		assertEquals(visite.getReference(),VisiteDao.rechercher("test").getReference());
		
	}

	@Test
	public void testVisiteAjout() {
		
	Visite visite2 = new Visite("test2",new Date(0),"",med,vis);	
	assertNotSame(-1,VisiteDao.AjouterVisite(visite2));
	VisiteDao.SupprimerVisite(visite2);
	
	
	}
	
	@Test
	public void testVisiteSuppresion() {
		
		assertNotEquals(0,VisiteDao.SupprimerVisite(visite));
		
	}
	
	@Test
	public void testVisiteModification() {
		
		visite.setCommentaire("test");
		assertNotEquals(0,VisiteDao.ModifierVisite(visite));
		
	}
}
