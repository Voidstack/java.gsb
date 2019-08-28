package gsb.vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.MedecinService;
import gsb.service.MedicamentService;
import gsb.service.VisiteurService;

import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JIFMedicamentAjoutStock extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox jbox;
	private JComboBox jbox2;

	public JIFMedicamentAjoutStock() {
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ajout Echantillon");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblQuantit = new JLabel("Quantit\u00E9");
		lblQuantit.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblQuantit);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDepotLegal = new JLabel("Depot Legal");
		lblDepotLegal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblDepotLegal);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		ArrayList<Medicament> listeMedicament = MedicamentDao.RechercherToutMedicament();
		
		ArrayList<String> listeStringMedicament = new ArrayList<String>();
		
		for(int i = 0; i < listeMedicament.size();i++){
			
			listeStringMedicament.add(listeMedicament.get(i).getDepotLegal() + " - " + listeMedicament.get(i).getNomCommercial());
			
		}
		
		//jbox = new JComboBox(new StringModel(strings));
		jbox2 = new JComboBox(listeStringMedicament.toArray());
		
		panel_1.add(jbox2);
		textField_1.setColumns(10);
		
		JLabel lblCodevisiteur = new JLabel("Code Visiteur");
		lblCodevisiteur.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblCodevisiteur);
		
		textField = new JTextField();
		ArrayList<Visiteur> listeVisiteur = VisiteurDao.rechercherToutVisiteur();
		
		ArrayList<String> listeStringVisiteur = new ArrayList<String>();
		
		for(int i = 0; i < listeVisiteur.size();i++){
			
			listeStringVisiteur.add(listeVisiteur.get(i).getMatricule() + " - " + listeVisiteur.get(i).getNom() + " / " + listeVisiteur.get(i).getPrenom());
			
		}
		
		//jbox = new JComboBox(new StringModel(strings));
		jbox = new JComboBox(listeStringVisiteur.toArray());
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		//panel_1.add(textField);
		panel_1.add(jbox);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					MedicamentService.AJouterMedicamentStocker(jbox.getSelectedItem().toString().substring(0,jbox.getSelectedItem().toString().indexOf("-")-1), jbox2.getSelectedItem().toString().substring(0,jbox2.getSelectedItem().toString().indexOf("-")-1), textField_2.getText());
					JOptionPane.showMessageDialog(null, "Ajout reussi");
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "Erreur, " + e.getMessage());
					e.printStackTrace();
				}
				
				
			}
		});
		panel_2.add(btnAjouter);
		

		lblDepotLegal.setBorder(border);
		lblQuantit.setBorder(border);
		lblCodevisiteur.setBorder(border);
		
		textField_2.setBorder(border);
		textField_1.setBorder(border);
		textField.setBorder(border);

		lblDepotLegal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblQuantit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCodevisiteur.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));		
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel_1.add(lblNewLabel_2);
		
	}

}
