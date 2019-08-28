package gsb.vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import gsb.modele.Medicament;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.MedicamentService;

import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class JIFMedicamentStock extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private HashMap<Medicament,Integer> liste;
	private String[] columnNames = {"Depot legal", "Nom","Effets","Libelle Famille","Quantité"};
	private JComboBox jbox;
	
	public JIFMedicamentStock(MenuPrincipal menu,String matricule) {
		
		liste = new HashMap<Medicament,Integer>();
		
		ArrayList<Visiteur> listeVisiteur = VisiteurDao.rechercherToutVisiteur();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Liste du Stock des echantillons");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Code Visiteur");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		//panel_1.add(textField);
		textField.setColumns(10);
		
		ArrayList<String> listeStringCodeVisiteur = new ArrayList<String>();
		
		for(int i = 0; i < listeVisiteur.size();i++){
			
			listeStringCodeVisiteur.add(listeVisiteur.get(i).getMatricule());
			
		}		
		
		jbox = new JComboBox(listeStringCodeVisiteur.toArray());
		panel_1.add(jbox);
		
		JButton btnRechercher = new JButton("Rechercher");
		panel_1.add(btnRechercher);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menu.ouvrirFenetre(new JIFMedicamentStock(menu,jbox.getSelectedItem().toString()));
				
			}
		});
		
		String[][] data;
		if(matricule != null){
			
			try {
				liste = MedicamentService.RechercherMedicamentStocker(matricule);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			data = new String[liste.size()][5];
				
			int count = 0;
			
			for (Medicament key : liste.keySet()) {
				

				
				data[count][0] = key.getDepotLegal();
				data[count][1] = key.getNomCommercial();
				data[count][2] = key.getEffets();
				data[count][3] = key.getLibellefamille();
				data[count][4] = liste.get(key).toString();				

				count++;
				
			}
			
			table = new JTable(data,columnNames);
			panel_3.add(table);				
			
			JScrollPane scrollPane = new JScrollPane(table);
			panel_3.add(scrollPane);
			
		}

		
	}

}
