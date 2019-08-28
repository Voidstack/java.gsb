package gsb.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.border.BevelBorder;

import gsb.modele.Medicament;
import gsb.service.MedicamentService;

import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JIFMedicamentListeDic extends JInternalFrame {

	private JFrame frame;
	private JTable table;
	private ArrayList<Medicament> ListeMedicament;
	private MenuPrincipal menu;
	
	
	public JIFMedicamentListeDic(MenuPrincipal menu) {
		
		this.menu = menu;
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		ListeMedicament = null;
		
		try {
			ListeMedicament = MedicamentService.RechercherToutMedicament();
		} catch (Exception e) {
			
			//MSGBOX
			e.printStackTrace();
			
		}

		String[][] data = new String[ListeMedicament.size()][4];
		
		for(int i = 0; i < ListeMedicament.size();i++){
			
			data[i][0] = ListeMedicament.get(i).getDepotLegal();
			data[i][1] = ListeMedicament.get(i).getNomCommercial();
			data[i][2] = ListeMedicament.get(i).getComposition();
			data[i][3] = ListeMedicament.get(i).getLibellefamille();
		}
		
		String[] columnNames = {"Depot legal", "Nom","Composant","Libelle Famille"};
		
		
		table = new JTable(data,columnNames);
		
		//JScrollPane pane = new JScrollPane(table);
		
		panel.add(table);
		panel.add(new JScrollPane( table ));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Liste des Medicaments");
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Afficher la page du medicament");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i < ListeMedicament.size();i++){
					
					Medicament med = ListeMedicament.get(i);
					if(med.getDepotLegal() == table.getValueAt(table.getSelectedRow(), 0)){
						
						menu.ouvrirFenetre(new JIFMedicamentCons(med));
						
					}
					
					
				}
				
			}
		});
		panel_2.add(btnNewButton);
				
		
	}


}
