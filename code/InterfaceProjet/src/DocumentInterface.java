import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Traitement.Client;
import Traitement.Disquecompact;
import Traitement.Livre;
import Traitement.OperationClient;
import Traitement.OperationDocument;
import Traitement.Periodique;

import java.awt.SystemColor;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class DocumentInterface extends JFrame {

	private JPanel contentPane;
	private JTable table,table1,table2;
	private JTextField textField;
	private JComboBox comboBox;
	private int n,id=0,nbr=0;
	private String catego="",titre="",auteur="",date="",langue="",period="";
	ListSelectionModel model3,model1,model2;
	private JScrollPane scrollPane,scrollPane1,scrollPane2;
	
	
	public static void main(String [] args) {
		DocumentInterface p = new DocumentInterface();
		p.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * 
	 */
	public DefaultTableModel tablelivre() {
		OperationDocument o = new OperationDocument();
	
		
			String [] col= {"ID","Titre","Auteur","Categorie","Nombre d'exemplaire"};
	 	DefaultTableModel model = new DefaultTableModel();
	 	for(String v : col) {
	 		model.addColumn(v);
	 	}
	   
	   Vector<Livre> livres= o.afficherTtL();
	   for (int i = 0; i < livres.size(); i++) {
		   
		   model.addRow(new Object []{
	 	        	livres.get(i).getIdLivres(),livres.get(i).getTitre(),livres.get(i).getAuteur(),livres.get(i).getCategorie(),livres.get(i).getNbreExemplaire()});
	}
	return model;

		
	}
	public DefaultTableModel tableCD() {
		OperationDocument o = new OperationDocument();
	
		
			String [] col= {"ID","Titre","Auteur","Langue","Date de publication","Nombre d'exemplaire"};
	 	DefaultTableModel model = new DefaultTableModel();
	 	for(String v : col) {
	 		model.addColumn(v);
	 	}
	   
	  Vector<Disquecompact> cds= o.afficherTtCD();
	   for (int i = 0; i < cds.size(); i++) {
		   
		   model.addRow(new Object []{
	 	        	cds.get(i).getId(),cds.get(i).getTitre(),cds.get(i).getAuteur(),cds.get(i).getLangue(),cds.get(i).getDatePub(),cds.get(i).getNbrExp()});
	}
	return model;

		
	}
	public DefaultTableModel tablePD() {
		OperationDocument o = new OperationDocument();
	
		
			String [] col= {"ID","Titre","Date Edition","Periodicite","Nombre d'exemplaire"};
	 	DefaultTableModel model = new DefaultTableModel();
	 	for(String v : col) {
	 		model.addColumn(v);
	 	}
	   
	 Vector<Periodique> pds= o.afficherTtP();
	   for (int i = 0; i < pds.size(); i++) {
		   
		   model.addRow(new Object []{
	 	        	pds.get(i).getId(),pds.get(i).getTitre(),pds.get(i).getDateEdition(),pds.get(i).getPeriodicite(),pds.get(i).getNbreExemplaire()});
	}
	return model;

		
	}
	public DocumentInterface() {
		
		setBounds(0,0,1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(71, 71, 251, 261);
		panel.setBounds(0,0,1300, 750);
		contentPane.add(panel);
		String []c = {"livre","CD","Periodique"};
		panel.setLayout(null);
		comboBox = new JComboBox(c);
		comboBox.setBounds(278, 111, 221, 31);
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				int choix=comboBox.getSelectedIndex();
				switch(choix) {
				case 0: scrollPane.setVisible(true);scrollPane1.setVisible(false);scrollPane2.setVisible(false); break;
				case 1:scrollPane.setVisible(false);scrollPane1.setVisible(true);scrollPane2.setVisible(false); ; break;
				case 2:  scrollPane.setVisible(false);scrollPane1.setVisible(false);scrollPane2.setVisible(true); break;
				}
				
			}
			
		});
		
		panel.add(comboBox);
		
		
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(641, 61, 610, 631);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tablelivre());	
		
		 model1= table.getSelectionModel();
		model1.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(! model1.isSelectionEmpty()) {
					n=model1.getMinSelectionIndex();
					//JOptionPane.showMessageDialog(null,"Row selected "+n);
					
					
					id=(Integer) tablelivre().getValueAt(n,0);
					titre=tablelivre().getValueAt(n,1).toString();
					auteur=tablelivre().getValueAt(n,2).toString();
					catego=tablelivre().getValueAt(n,3).toString();
					nbr=(Integer) tablelivre().getValueAt(n,4);
					
				}
				
				
				
			}
			
		});

		//// table CD
	 scrollPane1 = new JScrollPane();
	scrollPane1.setBounds(641, 61, 610, 631);
	panel.add(scrollPane1);
	
	table1 = new JTable();
	scrollPane1.setViewportView(table1);
	table1.setModel(tableCD());	
		 model2= table1.getSelectionModel();
		model2.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(! model2.isSelectionEmpty()) {
					n=model2.getMinSelectionIndex();
					//JOptionPane.showMessageDialog(null,"Row selected "+n);
					id=(Integer) tableCD().getValueAt(n,0);
					titre=tableCD().getValueAt(n,1).toString();
					auteur=tableCD().getValueAt(n,2).toString();
					langue=tableCD().getValueAt(n,3).toString();
					date=tableCD().getValueAt(n,4).toString();
					nbr=(Integer) tableCD().getValueAt(n,5);
		
				
				}
				
				
				
			}
			
		});
		////////    table PD
		 scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(641, 61, 610, 631);
		panel.add(scrollPane2);
		
		table2 = new JTable();
		scrollPane2.setViewportView(table2);
		table2.setModel(tablePD());	
		 model3= table2.getSelectionModel();
		model3.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(! model3.isSelectionEmpty()) {
					n=model3.getMinSelectionIndex();
					//JOptionPane.showMessageDialog(null,"Row selected "+n);
					id=(Integer) tablePD().getValueAt(n,0);
					titre=tablePD().getValueAt(n,1).toString();
					date=tablePD().getValueAt(n,2).toString();
					period=tablePD().getValueAt(n,3).toString();
					nbr=(Integer) tablePD().getValueAt(n,4);
					
				
				
				}
				
				
				
			}
			
		});
		JLabel lblNewLabel = new JLabel("Type de documents :");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel.setBounds(84, 111, 147, 31);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBackground(new Color(0, 153, 51));
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("livre")) {
					AjouterLivre l=new AjouterLivre();
					setVisible(false);
					l.setVisible(true);
					
				}
				if(comboBox.getSelectedItem().equals("CD")) {
					AjouterCD l=new AjouterCD();
					setVisible(false);
					l.setVisible(true);
				}
				if(comboBox.getSelectedItem().equals("Periodique")) {
					AjouterPeriodique l=new AjouterPeriodique();
					l.setVisible(true);
					setVisible(false);
				}
				
				
			}
		});
		btnNewButton.setBounds(84, 333, 98, 31);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBackground(new Color(255, 153, 0));
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("livre")) {
					if(titre.equals("")) {
						JOptionPane.showMessageDialog(null, "choisie un Livre");
					}
					else {
						ModifierLivre l=new ModifierLivre(id,titre,auteur,catego,nbr);
					l.setVisible(true);
					
					setVisible(false);
					}
					
				}
				if(comboBox.getSelectedItem().equals("CD")) {
					if(titre.equals("")) {
						JOptionPane.showMessageDialog(null, "choisie une CD");
					}
					else {
						ModifierCD l=new ModifierCD(id,titre,auteur,langue,date,nbr);
					l.setVisible(true);

					setVisible(false);
					}
					
				}
				if(comboBox.getSelectedItem().equals("Periodique")) {
					if(titre.equals("")) {
						
						JOptionPane.showMessageDialog(null, "choisie une periodique");
					}
					else {
						ModifierPeriodique l=new ModifierPeriodique(id,titre,date,period,nbr);
					l.setVisible(true);

					setVisible(false);
					}
					
				}
				
				
			}
		});
		btnNewButton_1.setBounds(228, 333, 98, 31);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBackground(new Color(204, 0, 0));
		btnNewButton_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		btnNewButton_2.setBounds(381, 333, 98, 31);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getSelectedItem().equals("livre")) {
					if(titre.equals("")) {
						JOptionPane.showMessageDialog(null, "choisie un Livre");
					}
					else {
						OperationDocument o =new OperationDocument();
						JOptionPane.showMessageDialog(null, id);
						o.SupprimerLivre(id);
					}
					
				}
				if(comboBox.getSelectedItem().equals("CD")) {
					if(titre.equals("")) {
						JOptionPane.showMessageDialog(null, "choisie une CD");
					}
					else {
						JOptionPane.showMessageDialog(null, id);
						OperationDocument o =new OperationDocument();
						o.SupprimerCD(id);
					}
					
				}
				if(comboBox.getSelectedItem().equals("Periodique")) {
					if(titre.equals("")) {
						JOptionPane.showMessageDialog(null, "choisie une Periodique");
					}
					else {
						OperationDocument o =new OperationDocument();
						JOptionPane.showMessageDialog(null, id);
						o.SupprimerPeriodique(id);
					}
					
				}
				
			}
			
		});
		
		JButton btnNewButton_3 = new JButton("Exemplaire");
		btnNewButton_3.setBackground(new Color(0, 153, 153));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(titre.equals("")) {
					JOptionPane.showMessageDialog(null, "choisie une Document");
				}
				else {
					if(comboBox.getSelectedItem().equals("livre")) {
						Exemplaire ex= new Exemplaire("Livre",(Integer) tablelivre().getValueAt(n,0),tablelivre().getValueAt(n,1).toString(),(Integer) tablelivre().getValueAt(n,4));
						ex.setVisible(true);
					}
					else if(comboBox.getSelectedItem().equals("CD")) {
						Exemplaire ex= new Exemplaire("CD",(Integer) tableCD().getValueAt(n,0),tableCD().getValueAt(n,1).toString(),(Integer) tableCD().getValueAt(n,5));
						ex.setVisible(true);
					}
					else {
						Exemplaire ex= new Exemplaire("Periodique",(Integer) tablePD().getValueAt(n,0),tablePD().getValueAt(n,1).toString(),(Integer) tablePD().getValueAt(n,4));
						ex.setVisible(true);
					}
					
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		btnNewButton_3.setBounds(228, 431, 98, 46);
		panel.add(btnNewButton_3);
		ImageIcon r= new ImageIcon(ConsultationInterface.class.getResource("/imageicon/r_icon.jpg"));
		Image image=((ImageIcon) r).getImage();
		image=image.getScaledInstance(70,60, DO_NOTHING_ON_CLOSE);
		r= new ImageIcon(image);
		JButton btnNewButton_4 = new JButton(r);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WelcomePage l= new WelcomePage();
				l.setVisible(true);
				}
		});
		btnNewButton_4.setBounds(10, 11, 70, 60);
		panel.add(btnNewButton_4);
		
		textField = new JTextField();
		textField.setBounds(641, 19, 311, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Chercher...");
		btnNewButton_5.setBackground(new Color(0, 153, 153));
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_5.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		btnNewButton_5.setBounds(976, 19, 103, 31);
		panel.add(btnNewButton_5);
	}
}
