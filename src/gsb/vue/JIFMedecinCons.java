package gsb.vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.Border;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.service.MedecinService;
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

public class JIFMedecinCons extends JInternalFrame {
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldCodeMed;
	private JTextField textFieldAdresse;
	private JTextField textFieldTel;
	private JTextField textFieldCp;
	private JTextField textFieldSpe;
	private int counter;
	private ArrayList<Medecin> liste;

	/**
	 * Create the frame.
	 */
	public JIFMedecinCons(Medecin medic) {
		
		
		 liste = new ArrayList<Medecin>();
		try {
			liste = MedecinService.RechercherToutMedecins();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Fiche Médecin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		Medecin med;
		
		if(medic == null){
			
			med = liste.get(0);
			counter = 0;
			
			
		}
		else{
		     med = medic;
		     
		     for(int i = 0; i < liste.size();i++){
		    	 if(liste.get(i).getCodeMed() == med.getCodeMed()){
		    		 counter = i;
		    	 }
		     }
		}
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		JLabel lblNewLabel_2 = new JLabel("Code medecin");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		textFieldCodeMed = new JTextField();
		textFieldCodeMed.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldCodeMed);
		textFieldCodeMed.setColumns(10);
		textFieldCodeMed.setText(med.getCodeMed());
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		textFieldNom = new JTextField();
		textFieldNom.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldNom.setText(med.getNom());
		
		JLabel lblPrenom = new JLabel("Prneom");
		lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblPrenom);
		
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setText(med.getPrenom());
		
		JLabel laelAdresse = new JLabel("Adresse");
		laelAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(laelAdresse);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldAdresse);
		textFieldAdresse.setColumns(10);
		
		textFieldAdresse.setText(med.getAdresse());
		
		
		JLabel lblEffet_1 = new JLabel("Code Postal");
		lblEffet_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEffet_1);
		
		textFieldCp = new JTextField();
		textFieldCp.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldCp);
		textFieldCp.setColumns(10);
		
		textFieldCp.setText(med.getLaLocalite().getCodePostal());
		
		JLabel Telephone = new JLabel("Telephone");
		Telephone.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(Telephone);
		
		textFieldTel = new JTextField();
		textFieldTel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldTel);
		textFieldTel.setColumns(10);
		
		textFieldTel.setText(med.getTelephone());
			
		
		JLabel spe = new JLabel("Specialité");
		spe.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(spe);
		
		textFieldSpe = new JTextField();
		textFieldSpe.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textFieldSpe);
		textFieldSpe.setColumns(10);
		
		textFieldSpe.setText(med.getSpecialite());
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPrecedent = new JButton("Precedent");
		btnPrecedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(counter > 0){
				  counter = counter - 1;
				  remplirText(liste.get(counter));
				}				
				
			}
		});
		panel_2.add(btnPrecedent);
		
		JButton btnSuivant = new JButton("Suivant");
		btnSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(counter < liste.size()-1){
				counter = counter + 1;
				remplirText(liste.get(counter));
				}
				
				
			}
		});
		panel_2.add(btnSuivant);
		
		
		textFieldNom.setBorder(border);
		textFieldPrenom.setBorder(border);
		textFieldCodeMed.setBorder(border);
		textFieldAdresse.setBorder(border);
		textFieldTel.setBorder(border);
		textFieldCp.setBorder(border);
		textFieldSpe.setBorder(border);

		
		lblNewLabel_1.setBorder(border);	
		lblNewLabel_2.setBorder(border);
		spe.setBorder(border);
		Telephone.setBorder(border);
		lblEffet_1.setBorder(border);
		lblPrenom.setBorder(border);
		laelAdresse.setBorder(border);
		
		textFieldNom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldCodeMed.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldAdresse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldTel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldCp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldSpe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));	
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Telephone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEffet_1.setFont(new Font("Tahoma", Font.PLAIN, 17));		
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		laelAdresse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textFieldNom.setEditable(false);
		textFieldPrenom.setEditable(false);
		textFieldCodeMed.setEditable(false);
		textFieldAdresse.setEditable(false);
		textFieldTel.setEditable(false);
		textFieldCp.setEditable(false);
		textFieldSpe.setEditable(false);

		textFieldNom.setBackground(new Color(255, 255, 255));
		textFieldPrenom.setBackground(new Color(255, 255, 255));
		textFieldCodeMed.setBackground(new Color(255, 255, 255));
		textFieldAdresse.setBackground(new Color(255, 255, 255));	
		textFieldTel.setBackground(new Color(255, 255, 255));
		textFieldCp.setBackground(new Color(255, 255, 255));
		textFieldSpe.setBackground(new Color(255, 255, 255));		
		
		spe.setBorder(border);
		lblNewLabel_1.setBorder(border);	
		lblNewLabel_2.setBorder(border);
		Telephone.setBorder(border);
		lblEffet_1.setBorder(border);
		lblPrenom.setBorder(border);
		laelAdresse.setBorder(border);
		
	}
	
	public void remplirText(Medecin med){
		
		textFieldNom.setText(med.getNom());
		textFieldPrenom.setText(med.getPrenom());
		textFieldCodeMed.setText(med.getCodeMed());
		textFieldAdresse.setText(med.getAdresse());
		textFieldTel.setText(med.getTelephone());
		textFieldCp.setText(med.getLaLocalite().getCodePostal());
		textFieldSpe.setText(med.getSpecialite());		
		
	}
	
}
