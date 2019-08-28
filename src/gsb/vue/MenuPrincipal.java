/*
 * Créé le 22 févr. 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultDesktopManager;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author Isabelle 22 févr. 2015 TODO Pour changer le modèle de ce commentaire
 *         de type généré, allez à : Fenêtre - Préférences - Java - Style de
 *         code - Modèles de code
 */
public class MenuPrincipal extends JFrame implements ActionListener {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2591453837113855452L;

	protected JInternalFrame myJInternalFrame;
	protected JDesktopPane desktopPane;
	protected JMenuBar mbar;
	protected JMenu mMedecins;
	protected JMenu mMedicaments;

	JMenu mVisites;

	/**
	 * 
	 */
	public MenuPrincipal() {

		myJInternalFrame = new JInternalFrame(); // pour affichage d'une seule
													// JInternalFrame à la fois
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.gray);
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		setTitle("GSB");
		
		Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
		
		//DimMax.setSize(DimMax.getWidth()/2, DimMax.getHeight()/2);
		
		DimMax.setSize(1920/2, 1200/2);
		
		
		setSize(DimMax);
		this.setResizable(false);
		
		//setSize(500, 400);

		// Ajout d'une barre de menus à la fenêtre
		mbar = new JMenuBar();
		mMedecins = new JMenu("Medecins");
		JMenuItem mC1 = new JMenuItem("Consultation Medecin");
		mC1.addActionListener(this); // installation d'un écouteur d'action
		mMedecins.add(mC1);
		JMenuItem mC2 = new JMenuItem("Liste Medecins");
		mC2.addActionListener(this);
		mMedecins.add(mC2);

		mMedicaments = new JMenu("Medicaments");
		JMenuItem mE1 = new JMenuItem("Consultation Medicament");
		mE1.addActionListener(this); // installation d'un écouteur d'action
		mMedicaments.add(mE1);
		JMenuItem mE2 = new JMenuItem("Ajout Medicaments");
		mE2.addActionListener(this);
		mMedicaments.add(mE2);

		mVisites = new JMenu("Visites");
		JMenuItem mA1 = new JMenuItem("Consultation Visite");
		mA1.addActionListener(this); // installation d'un écouteur d'action
		mVisites.add(mA1);
		JMenuItem mA2 = new JMenuItem("Ajout Visite");
		mA2.addActionListener(this);
		mVisites.add(mA2);

		JMenuItem mA21 = new JMenuItem("Liste Medicament");
		mA21.addActionListener(this);
		mMedicaments.add(mA21);
		
		JMenuItem mA22 = new JMenuItem("Stock Medicament");
		mA22.addActionListener(this);
		mMedicaments.add(mA22);	

		JMenuItem mA23 = new JMenuItem("Ajout Stock Medicament");
		mA23.addActionListener(this);
		mMedicaments.add(mA23);			
		
		mbar.add(mMedecins);
		mbar.add(mMedicaments);
		mbar.add(mVisites);
		setJMenuBar(mbar);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Raccord de méthode auto-généré
		if (evt.getSource() instanceof JMenuItem) {
			String ChoixOption = evt.getActionCommand();
			switch(ChoixOption){
			case "Consultation Visite": ouvrirFenetre(new JIFVisiteCons(null)); break;
			case "Ajout Visite": ouvrirFenetre(new JIFVisiteAjout()); break;	
			case "Ajout Medicaments": ouvrirFenetre(new JIFMedicamentAjout()); break;
			case "Ajout Stock Medicament": ouvrirFenetre(new JIFMedicamentAjoutStock()); break;
			case "Stock Medicament": ouvrirFenetre(new JIFMedicamentStock(this,null)); break;
			case "Liste Medicament": ouvrirFenetre(new JIFMedicamentListeDic(this)); break;
			case "Consultation Medicament": ouvrirFenetre(new JIFMedicamentCons(null)); break;
			case "Liste Medecins": ouvrirFenetre(new JIFMedecinListeDic(this)); break;
			case "Consultation Medecin": ouvrirFenetre(new JIFMedecinCons(null)); break;
			
			}
			
		}

	}

	public void ouvrirFenetre(JInternalFrame uneFenetre) {
		myJInternalFrame.dispose(); // si une fenêtre était dejà affichée, elle
									// est libérée
		myJInternalFrame = uneFenetre;
		myJInternalFrame.setVisible(true);
		myJInternalFrame.setResizable(false);
		myJInternalFrame.setMaximizable(false);
		myJInternalFrame.setClosable(false);
		//myJInternalFrame.setm
		
		myJInternalFrame.setSize(desktopPane.getSize());
		desktopPane.add(myJInternalFrame);
	}
	
}
