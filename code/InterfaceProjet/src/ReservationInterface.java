import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Traitement.OperationReservation;
import Traitement.Reservation;

import java.awt.SystemColor;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ReservationInterface extends JFrame {

	private JPanel contentPane;
	private JTextField ClientId,ChercheField;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblTitre;
	private JTextField Titre;
	private JComboBox comboBox;
	JRadioButton rdbtnNonMembre,rdbtnNewRadioButton;
	private int n;

	/**
	 * Launch the application.
	 */
	public static void main(String [] args) {
		ReservationInterface o= new ReservationInterface();
		o.setVisible(true);
	}
	public DefaultTableModel tablelivre() {
		DefaultTableModel table = new DefaultTableModel();
		String [] col= {"ID Reservation","ID Document","Titre","ID Client","Date Reservation"};
		for(String e:col) {
			table.addColumn(e);
		}
		
		OperationReservation o = new OperationReservation();
		
		
		for(Reservation e: o.listReservation()){
			
			table.addRow(new Object[] {e.getId(),e.getIdcli(),e.getTitre(),e.getIdex(),e.getDateR()});
		 
				}
		
		return table;
		
	}
	public DefaultTableModel tableCD() {
		DefaultTableModel table = new DefaultTableModel();
		String [] col= {"ID Reservation","ID Document","Titre","ID Client","Date Reservation"};
		for(String e:col) {
			table.addColumn(e);
		}
		
		OperationReservation o = new OperationReservation();
		
		
		for(Reservation e: o.listReservationCD()){
			
			table.addRow(new Object[] {e.getId(),e.getIdcli(),e.getTitre(),e.getIdex(),e.getDateR()});
		 
				}
		
		return table;
		
	}
	public DefaultTableModel tablelivren() {
		DefaultTableModel table = new DefaultTableModel();
		String [] col= {"ID Reservation","ID Document","Titre","ID Client","Date Reservation"};
		for(String e:col) {
			table.addColumn(e);
		}
		
		OperationReservation o = new OperationReservation();
		
		
		for(Reservation e: o.listReservationLivreNon()){
			
			table.addRow(new Object[] {e.getId(),e.getIdcli(),e.getTitre(),e.getIdex(),e.getDateR()});
		 
				}
		
		return table;
		
	}
	public DefaultTableModel tableCDn() {
		DefaultTableModel table = new DefaultTableModel();
		String [] col= {"ID Reservation","ID Document","Titre","ID Client","Date Reservation"};
		for(String e:col) {
			table.addColumn(e);
		}
		
		OperationReservation o = new OperationReservation();
		
		
		for(Reservation e: o.listReservationCDNon()){
			
			table.addRow(new Object[] {e.getId(),e.getIdcli(),e.getTitre(),e.getIdex(),e.getDateR()});
		 
				}
		
		return table;
		
	}
	

	/**
	 * Create the frame.
	 */
	public ReservationInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1300, 750);//752
		setResizable(false);
		setTitle("Gestion De Resevation");
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon r= new ImageIcon(ConsultationInterface.class.getResource("/imageicon/r_icon.jpg"));
		Image image=((ImageIcon) r).getImage();
		image=image.getScaledInstance(70,60, DO_NOTHING_ON_CLOSE);
		r= new ImageIcon(image);
		JButton btnNewButton_3 = new JButton(r);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WelcomePage l =new WelcomePage();
				l.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(10, 11, 70, 60);
		contentPane.add(btnNewButton_3);
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(600, 78, 674, 607);
		contentPane.add(scrollPane);
		String []c= {"Livre","CD"};
		comboBox = new JComboBox(c);
		comboBox.setBounds(244, 320, 197, 36);
		contentPane.add(comboBox);
		table = new JTable(tablelivre());
		scrollPane.setViewportView(table);
		ChercheField = new JTextField();
		ChercheField.setBounds(600, 35, 317, 32);
		contentPane.add(ChercheField);
		ChercheField.setColumns(10);
		
		JButton Cherche = new JButton("Chercher...");
		Cherche.setBackground(new Color(51, 153, 153));
		Cherche.setBounds(955, 35, 109, 36);
		contentPane.add(Cherche);
		ClientId = new JTextField();
		ClientId.setBounds(244, 177, 197, 36);
		contentPane.add(ClientId);
		ClientId.setColumns(10);
		JLabel lblNewLabel_1_1_2 = new JLabel("Type du document :");
		lblNewLabel_1_1_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(79, 323, 123, 29);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel = new JLabel("Client ID :");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel.setBounds(79, 177, 88, 29);
		contentPane.add(lblNewLabel);
		
		lblTitre = new JLabel("Titre  :");
		lblTitre.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblTitre.setBounds(79, 252, 88, 29);
		contentPane.add(lblTitre);
		
		Titre = new JTextField();
		Titre.setColumns(10);
		Titre.setBounds(244, 252, 197, 36);
		contentPane.add(Titre);
		
		JButton Ajouter = new JButton("Ajouter");
		Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ClientId.getText().equals("") || Titre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Champs est vide !!!");
				}
				else {
					
					OperationReservation r= new OperationReservation();
					if(!rdbtnNonMembre.isSelected()) {
						if(comboBox.getSelectedItem().equals("CD")) {
							r.ajouterResCD(Integer.parseInt(ClientId.getText()),Titre.getText());
							table.setModel(tableCD());
						}
						else {
							r.ajouterResLivre(Integer.parseInt(ClientId.getText()),Titre.getText());
							table.setModel(tablelivre());
						}
					}else {
						if(comboBox.getSelectedItem().equals("CD")) {
							r.ajouterResCDNon(Integer.parseInt(ClientId.getText()),Titre.getText());
							table.setModel(tableCDn());
						}
						else {
							r.ajouterResLivreNon(Integer.parseInt(ClientId.getText()),Titre.getText());
							table.setModel(tablelivren());
						}
						
					}
					
					
					
					ClientId.setText("");
					Titre.setText("");
				}
				
			}
		});
		Ajouter.setBackground(new Color(0, 255, 51));
		Ajouter.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		Ajouter.setBounds(182, 508, 117, 36);
		contentPane.add(Ajouter);
		
		JButton Supprimer = new JButton("Supprimer");
		Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ClientId.getText().equals("") || Titre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Champs est vide !!!");
				}
				else {
					OperationReservation r= new OperationReservation();
					
					if(!rdbtnNonMembre.isSelected()) {
						if(comboBox.getSelectedItem().equals("Livre")) {
						r.supprimerResLivre(Integer.parseInt(ClientId.getText()),Titre.getText());
						table.setModel(tablelivre());
						}
						else {
							r.supprimerResCD((Integer) table.getValueAt(n,0));
							table.setModel(tableCD());
						}
					}
					else {
						if(comboBox.getSelectedItem().equals("Livre")) {
							r.supprimerResLivreNon(Integer.parseInt(ClientId.getText()),Titre.getText());
							table.setModel(tablelivren());
							}
							else {
								r.supprimerResCDNon((Integer) table.getValueAt(n,0));
								table.setModel(tableCDn());
							}
						
						
					}
					
				}
				
				
				
			}
		});
		final ListSelectionModel model1= table.getSelectionModel();
		model1.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(! model1.isSelectionEmpty()) {
					n=model1.getMinSelectionIndex();
					//JOptionPane.showMessageDialog(null,"Row selected "+n);
					ClientId.setText(table.getValueAt(n,3).toString());
					Titre.setText(table.getValueAt(n,2).toString());;
					
				}
				
				
				
			}
			
		});
		Supprimer.setBackground(new Color(255, 0, 51));
		Supprimer.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		Supprimer.setBounds(349, 508, 117, 36);
		contentPane.add(Supprimer);
		
		rdbtnNonMembre = new JRadioButton("Non Membre");
		rdbtnNonMembre.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		rdbtnNonMembre.setBackground(SystemColor.activeCaption);
		rdbtnNonMembre.setBounds(371, 123, 141, 23);
		contentPane.add(rdbtnNonMembre);
		
		JLabel lblTypeDeClient = new JLabel("Type de client :");
		lblTypeDeClient.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblTypeDeClient.setBounds(75, 117, 123, 29);
		contentPane.add(lblTypeDeClient);
		
		rdbtnNewRadioButton = new JRadioButton("Membre");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton.setBounds(239, 123, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		ButtonGroup gb= new ButtonGroup();
		gb.add(rdbtnNewRadioButton);
		gb.add(rdbtnNonMembre);
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				if(!rdbtnNonMembre.isSelected()) {
					int choix=comboBox.getSelectedIndex();
					switch(choix) {
					case 0: table.setModel(tablelivre()) ;ClientId.setText("");Titre.setText(""); break;
					case 1: table.setModel(tableCD());ClientId.setText("");Titre.setText("");break;
					
				}
					

				}
				else {
					int choix=comboBox.getSelectedIndex();
					switch(choix) {
					case 0: table.setModel(tablelivren()) ;ClientId.setText("");Titre.setText(""); break;
					case 1: table.setModel(tableCDn());ClientId.setText("");Titre.setText(""); break;
					}
				
			}
			
			}});
		rdbtnNonMembre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int x=JOptionPane.showConfirmDialog(null, "Non Membre deja inscri ?");
				
				if(x==1) {
					AjouterNonMemebre o = new AjouterNonMemebre();
					o.setVisible(true);
					
				}
				table.setModel(tablelivren());
				comboBox.setSelectedIndex(0);
				
				
				
			}
			
		});
	}
}
