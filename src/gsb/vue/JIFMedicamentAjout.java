package gsb.vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.Border;


import gsb.modele.Medicament;
import gsb.service.MedicamentService;

import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JIFMedicamentAjout extends JInternalFrame {
	private JTextField textFieldDepotLegal;
	private JTextField textFieldCodeFamille;
	private JTextField textFieldNomCommercial;
	private JTextField textFieldLibelleFamille;
	private JTextArea textAreaComposant;
	private JTextArea textAreaEffet;
	private JTextArea textAreaContreIndic;
	private int counter;
	private ArrayList<Medicament> liste;

	/**
	 * Create the frame.
	 */
	public JIFMedicamentAjout() {
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ajout d'un Medicament");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		JLabel lblNewLabel_2 = new JLabel("Nom Commercial");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		textFieldNomCommercial = new JTextField();
		textFieldNomCommercial.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNomCommercial.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(textFieldNomCommercial);
		textFieldNomCommercial.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Depot Legal");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		textFieldDepotLegal = new JTextField();
		textFieldDepotLegal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldDepotLegal);
		textFieldDepotLegal.setColumns(10);
		
		JLabel lblEffet = new JLabel("Code Famille");
		lblEffet.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEffet);
		
		
		textFieldCodeFamille = new JTextField();
		textFieldCodeFamille.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldCodeFamille);
		textFieldCodeFamille.setColumns(10);
		
		JLabel laelFamillelibelle = new JLabel("Libelle Famille");
		laelFamillelibelle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(laelFamillelibelle);
		
		textFieldLibelleFamille = new JTextField();
		textFieldLibelleFamille.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldLibelleFamille);
		textFieldLibelleFamille.setColumns(10);
		
		JLabel lblEffet_1 = new JLabel("Effet");
		lblEffet_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEffet_1);
		
		textAreaEffet = new JTextArea();
		textAreaEffet.setWrapStyleWord(true);
		textAreaEffet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(textAreaEffet);
		textAreaEffet.setLineWrap(true);
		textAreaEffet.setRows(5);
		

		textAreaEffet.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(2, 2, 2, 2)));		
		
		JLabel Composant = new JLabel("Composant");
		Composant.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(Composant);
		
		textAreaComposant = new JTextArea();
		textAreaComposant.setWrapStyleWord(true);
        textAreaComposant.setRows(5);
		textAreaComposant.setLineWrap(true);
		textAreaComposant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(textAreaComposant);

		textAreaComposant.setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(2, 2, 2, 2)));
			
		
		JLabel lblContreindic = new JLabel("ContreIndic");
		lblContreindic.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblContreindic);
		
		textAreaContreIndic = new JTextArea();
		textAreaContreIndic.setWrapStyleWord(true);
		textAreaContreIndic.setRows(5);
		textAreaContreIndic.setLineWrap(true);
		textAreaContreIndic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(textAreaContreIndic);
		
		textAreaContreIndic.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSuivant = new JButton("Ajouter");
		btnSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ajouter();
				
				
			}
		});
		panel_2.add(btnSuivant);
		
		textFieldDepotLegal.setBorder(border);
		textFieldCodeFamille.setBorder(border);
		textFieldNomCommercial.setBorder(border);
		textFieldLibelleFamille.setBorder(border);
		lblContreindic.setBorder(border);
		lblNewLabel_1.setBorder(border);	
		lblNewLabel_2.setBorder(border);
		lblEffet.setBorder(border);
		laelFamillelibelle.setBorder(border);
		lblEffet_1.setBorder(border);
		Composant.setBorder(border);
	
		textFieldDepotLegal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldCodeFamille.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldNomCommercial.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldLibelleFamille.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblContreindic.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));	
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEffet.setFont(new Font("Tahoma", Font.PLAIN, 17));
		laelFamillelibelle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEffet_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Composant.setFont(new Font("Tahoma", Font.PLAIN, 17));		

		
	}
	
	public void Ajouter(){
		
		Medicament med = new Medicament(textFieldDepotLegal.getText(),textFieldNomCommercial.getText(),textAreaComposant.getText(),textAreaEffet.getText(),textAreaContreIndic.getText(),0F,textFieldCodeFamille.getText(),textFieldLibelleFamille.getText());
	
		try {
			MedicamentService.AjouterMedicament(med);
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Erreur, "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
}
