package gsb.vue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.Border;

import gsb.modele.Visite;
import gsb.service.VisiteService;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JIFVisiteCons extends JInternalFrame {
	private JTextField textFieldDate;
	private JTextField textFieldCommentaire;
	private JTextField textFieldReference;
	private JTextField textFieldCodeMed;
	private JTextField textFieldVisiteur;
	private int counter;
	private ArrayList<Visite> liste;

	/**
	 * Create the frame.
	 */
	public JIFVisiteCons(Visite visite) {

		liste = new ArrayList<Visite>();
		try {
			liste = VisiteService.rechercherTouteVisite();
		} catch (Exception e) {

			e.printStackTrace();
		}
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Fiche Visite");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		Visite vis;

		if (visite == null) {

			vis = liste.get(0);
			counter = 0;

		} else {
			vis = visite;

			for (int i = 0; i < liste.size(); i++) {
				if (liste.get(i).getReference() == vis.getReference()) {
					counter = i;
				}
			}
		}

		Border border = BorderFactory.createLineBorder(Color.BLACK);

		JLabel lblNewLabel_2 = new JLabel("Reference");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		textFieldReference = new JTextField();
		textFieldReference.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldReference);
		textFieldReference.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Date de la visite");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);

		textFieldDate = new JTextField();
		textFieldDate.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldDate);
		textFieldDate.setColumns(10);

		JLabel lblEffet = new JLabel("Commentaire");
		lblEffet.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEffet);

		textFieldCommentaire = new JTextField();
		textFieldCommentaire.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldCommentaire);
		textFieldCommentaire.setColumns(10);

		JLabel laelFamillelibelle = new JLabel("Code medecin");
		laelFamillelibelle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(laelFamillelibelle);

		textFieldCodeMed = new JTextField();
		textFieldCodeMed.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldCodeMed);
		textFieldCodeMed.setColumns(10);

		JLabel lblEffet_1 = new JLabel("Matricule visiteur");
		lblEffet_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEffet_1);

		textFieldVisiteur = new JTextField();
		textFieldVisiteur.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldVisiteur);
		textFieldVisiteur.setColumns(10);

		textFieldVisiteur
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnPrecedent = new JButton("Precedent");
		btnPrecedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (counter > 0) {
					counter = counter - 1;
					remplirText(liste.get(counter));
				}

			}
		});
		panel_2.add(btnPrecedent);

		JButton btnSuivant = new JButton("Suivant");
		btnSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (counter < liste.size() - 1) {
					counter = counter + 1;
					remplirText(liste.get(counter));
				}

			}
		});
		panel_2.add(btnSuivant);

		textFieldCodeMed.setBorder(border);
		textFieldCommentaire.setBorder(border);
		textFieldDate.setBorder(border);
		textFieldReference.setBorder(border);
		lblNewLabel_1.setBorder(border);
		lblNewLabel_2.setBorder(border);
		lblEffet.setBorder(border);
		laelFamillelibelle.setBorder(border);
		lblEffet_1.setBorder(border);

		textFieldCodeMed.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldCommentaire.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldReference.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEffet.setFont(new Font("Tahoma", Font.PLAIN, 17));
		laelFamillelibelle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEffet_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldVisiteur.setFont(new Font("Tahoma", Font.PLAIN, 17));

		textFieldCodeMed.setEditable(false);
		textFieldCommentaire.setEditable(false);
		textFieldDate.setEditable(false);
		textFieldReference.setEditable(false);
		textFieldVisiteur.setEditable(false);

		textFieldCodeMed.setBackground(new Color(255, 255, 255));
		textFieldCommentaire.setBackground(new Color(255, 255, 255));
		textFieldDate.setBackground(new Color(255, 255, 255));
		textFieldReference.setBackground(new Color(255, 255, 255));
		textFieldVisiteur.setBackground(new Color(255, 255, 255));

		lblNewLabel_1.setBorder(border);
		lblNewLabel_2.setBorder(border);
		lblEffet.setBorder(border);
		laelFamillelibelle.setBorder(border);
		lblEffet_1.setBorder(border);

		remplirText(vis);

	}

	public void remplirText(Visite vis) {

		textFieldCodeMed.setText(vis.getUnMedecin().getCodeMed() + " - " + vis.getUnMedecin().getNom() + " / "
				+ vis.getUnMedecin().getPrenom());
		textFieldDate.setText(vis.getDate().toString());
		textFieldReference.setText(vis.getReference());
		textFieldVisiteur.setText(vis.getUnVisiteur().getMatricule() + " - " + vis.getUnVisiteur().getNom() + " / "
				+ vis.getUnMedecin().getPrenom());

		if (vis.getCommentaire().equals("") || vis.getCommentaire() == null) {

			textFieldCommentaire.setText("Aucun commentaire");

		} else {

			textFieldCommentaire.setText(vis.getCommentaire());

		}

	}

}
