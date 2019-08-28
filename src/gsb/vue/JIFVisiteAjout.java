package gsb.vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteDao;
import gsb.service.MedecinService;
import gsb.service.VisiteService;
import gsb.service.VisiteurService;

import java.awt.Font;

public class JIFVisiteAjout extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public JIFVisiteAjout() {

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("R\u00E9f\u00E9rence");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Date visite");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Commentaire");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("Code M\u00E9decin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Matricule visiteur");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Ajouter");
		/*
		 * Fonction de recupération des attributs et ajout d'une visite dans la base de
		 * données
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Visiteur vis = null;
				Medecin med = null;
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
				java.sql.Date sqlStartDate = null;
				// recupération des valeurs des champs de saisie
				try {
					//matricule visiteur
					vis = VisiteurService
							.RechercherVisiteur(textField_4.getText().substring(0, textField_4.getText().indexOf("-")));
					//cod médecin
					med = MedecinService
							.rechercherMedecin(textField_3.getText().substring(0, textField_3.getText().indexOf("-")));
					//date
					java.util.Date date = sdf1.parse(textField_1.getText());
					sqlStartDate = new java.sql.Date(date.getTime());
					// création de l'objet visite avec les différents paramètres
					Visite visite = new Visite(textField.getText(), sqlStartDate, textField_2.getText(), med, vis);
					if (VisiteService.AjouterVisite(visite) != 0) {

						JOptionPane.showMessageDialog(null, "Ajout reussi");

					}
				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "Erreur, " + e1.getMessage());
					e1.printStackTrace();
				}

			}
		});
		panel_1.add(btnNewButton);
		//Fonction de complétion du champ code médecin
		textField_3.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {

				if ((textField_3.getText().indexOf("-") == -1) || textField_3.getText().indexOf("-") < 5) {
					try {
						Medecin med = MedecinService.rechercherMedecin(textField_3.getText());
						textField_3.setText(med.getCodeMed() + " - " + med.getNom() + " / " + med.getPrenom());
					} catch (Exception e1) {

						textField_3.setText("");
					}
				}
			}

		});
		//Fonction de complétion du champ matricule visiteur
		textField_4.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {

				if ((textField_4.getText().indexOf("-") == -1) || textField_4.getText().indexOf("-") < 5) {
					try {
						Visiteur vis = VisiteurService.RechercherVisiteur(textField_4.getText());
						textField_4.setText(vis.getMatricule() + " - " + vis.getNom() + " / " + vis.getPrenom());
					} catch (Exception e1) {

						textField_4.setText("");
					}
				}
			}

		});

	}

}
