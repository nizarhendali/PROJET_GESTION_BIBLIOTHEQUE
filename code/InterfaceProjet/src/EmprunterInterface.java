import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Traitement.Emprunter;
import Traitement.OperationEmprunter;
import javax.swing.JSpinner;

public class EmprunterInterface extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField ClientID;
	private JTextField IDexemplaire;
	private JComboBox comboBox;
	private ButtonGroup gb;
	private int n;
	private JSpinner Duree ;
	private JRadioButton rdbtnNonMembre,rdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmprunterInterface frame = new EmprunterInterface();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DefaultTableModel tableLivre() {
		DefaultTableModel table=new DefaultTableModel();
		String []col= {"ID","ID Exemplaire","ID Client","Date d'emprunt","Date de retour","Type","Durre"};
		for(String e:col) {
			table.addColumn(e);
		}
OperationEmprunter o=new OperationEmprunter();
		
		for(Emprunter e:o.afficherLivre()) {
			table.addRow(new Object []{e.getId(),e.getIdex(),e.getIdcli(),e.getDate(),e.getDatere(),e.getType(),e.getDuree()});
		}
		return table;
	}
	public DefaultTableModel tableCD() {
		DefaultTableModel table=new DefaultTableModel();
		String []col= {"ID","ID Exemplaire","ID Client","Date d'emprunt","Date de retour","Type","Duree" };
		for(String e:col) {
			table.addColumn(e);
		}
		OperationEmprunter o=new OperationEmprunter();
		
		for(Emprunter e:o.afficherCD()) {
			table.addRow(new Object []{e.getId(),e.getIdex(),e.getIdcli(),e.getDate(),e.getDatere(),e.getType(),e.getDuree()});
		}
		return table;
	}
	public DefaultTableModel tableP() {
		DefaultTableModel table=new DefaultTableModel();
		String []col= {"ID","ID Exemplaire","ID Client","Date d'emprunt","Date de retour","Type","Duree" };
		for(String e:col) {
			table.addColumn(e);
		}
		OperationEmprunter o=new OperationEmprunter();
		
		for(Emprunter e:o.afficherP()) {
			table.addRow(new Object []{e.getId(),e.getIdex(),e.getIdcli(),e.getDate(),e.getDatere(),e.getType(),e.getDuree()});
		}
		return table;
	}
	public DefaultTableModel tableLivren() {
		DefaultTableModel table=new DefaultTableModel();
		String []col= {"ID","ID Exemplaire","ID Client","Date d'emprunt","Date de retour","Type","Durre"};
		for(String e:col) {
			table.addColumn(e);
		}
OperationEmprunter o=new OperationEmprunter();
		
		for(Emprunter e:o.afficherLivren()) {
			table.addRow(new Object []{e.getId(),e.getIdex(),e.getIdcli(),e.getDate(),e.getDatere(),e.getType(),e.getDuree()});
		}
		return table;
	}
	public DefaultTableModel tableCDn() {
		DefaultTableModel table=new DefaultTableModel();
		String []col= {"ID","ID Exemplaire","ID Client","Date d'emprunt","Date de retour","Type","Duree" };
		for(String e:col) {
			table.addColumn(e);
		}
		OperationEmprunter o=new OperationEmprunter();
		
		for(Emprunter e:o.afficherCDn()) {
			table.addRow(new Object []{e.getId(),e.getIdex(),e.getIdcli(),e.getDate(),e.getDatere(),e.getType(),e.getDuree()});
		}
		return table;
	}
	public DefaultTableModel tablePn() {
		DefaultTableModel table=new DefaultTableModel();
		String []col= {"ID","ID Exemplaire","ID Client","Date d'emprunt","Date de retour","Type","Duree" };
		for(String e:col) {
			table.addColumn(e);
		}
		OperationEmprunter o=new OperationEmprunter();
		
		for(Emprunter e:o.afficherPn()) {
			table.addRow(new Object []{e.getId(),e.getIdex(),e.getIdcli(),e.getDate(),e.getDatere(),e.getType(),e.getDuree()});
		}
		return table;
	}
	/**
	 * Create the frame.
	 */
	public EmprunterInterface() {
		setTitle("Emprunter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1300, 750);
		setTitle("Emprunter");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("Membre");
		rdbtnNewRadioButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton.setBounds(243, 118, 109, 23);
		rdbtnNewRadioButton.setSelected(true);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				table.setModel(tableLivre());
				comboBox.setSelectedIndex(0);
				
				
				
			}
			
		});
		
		
		rdbtnNonMembre = new JRadioButton("Non Membre");
		rdbtnNonMembre.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		rdbtnNonMembre.setBackground(SystemColor.activeCaption);
		rdbtnNonMembre.setBounds(375, 118, 141, 23);
		gb= new ButtonGroup();
		gb.add(rdbtnNewRadioButton);
		gb.add(rdbtnNonMembre);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNonMembre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int x=JOptionPane.showConfirmDialog(null, "Non Membre deja inscri ?");
				
				if(x==1) {
					AjouterNonMemebre o = new AjouterNonMemebre();
					o.setVisible(true);
					
				}
				table.setModel(tableLivren());
				comboBox.setSelectedIndex(0);
				
				
				
			}
			
		});
		contentPane.add(rdbtnNonMembre);
		ImageIcon r= new ImageIcon(ConsultationInterface.class.getResource("/imageicon/r_icon.jpg"));
		Image image=((ImageIcon) r).getImage();
		image=image.getScaledInstance(70,60, DO_NOTHING_ON_CLOSE);
		r= new ImageIcon(image);
		JButton btnNewButton_1 = new JButton(r);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage l = new WelcomePage();
				l.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		btnNewButton_1.setBounds(10, 11, 70, 60);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(617, 78, 700, 607);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable(tableLivre());
		scrollPane.setViewportView(table);
		
		ClientID = new JTextField();
		ClientID.setBounds(244, 177, 197, 36);
		contentPane.add(ClientID);
		ClientID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Client ID :");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel.setBounds(79, 177, 88, 29);
		contentPane.add(lblNewLabel);
		
		IDexemplaire = new JTextField();
		IDexemplaire.setColumns(10);
		IDexemplaire.setBounds(244, 251, 197, 36);
		contentPane.add(IDexemplaire);
		
		JLabel lblNewLabel_1 = new JLabel("ID Exemplaire  :");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel_1.setBounds(79, 251, 102, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Duree :");
		lblNewLabel_1_1_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(79, 381, 123, 29);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperationEmprunter o= new OperationEmprunter();
				if(!rdbtnNonMembre.isSelected()) {	
					System.out.println("membre");
					if(comboBox.getSelectedItem().equals("Livre")) {
						JOptionPane.showMessageDialog(null, o.memberEmpruntLiver(Integer.parseInt(IDexemplaire.getText()),Integer.parseInt(ClientID.getText()), "Location",(Integer)Duree.getValue()));						
						table.setModel(tableLivre());
					}
					else if(comboBox.getSelectedItem().equals("CD")) {JOptionPane.showMessageDialog(null, o.memberEmpruntCD(Integer.parseInt(IDexemplaire.getText()),Integer.parseInt(ClientID.getText()),"Location",(Integer)Duree.getValue()));	
					table.setModel(tableCD());
					comboBox.setSelectedIndex(1);}
					else {
						JOptionPane.showMessageDialog(null, o.memberEmpruntP(Integer.parseInt(IDexemplaire.getText()),Integer.parseInt(ClientID.getText()),"Consultation sur place",0));
					table.setModel(tableP());comboBox.setSelectedIndex(2);
					}
				}
				else {
					System.out.println("nonmemebre");
					if(comboBox.getSelectedItem().equals("Livre")) {
						JOptionPane.showMessageDialog(null, o.nMemberEmpruntLiver(Integer.parseInt(IDexemplaire.getText()),Integer.parseInt(ClientID.getText()), "Location",(Integer)Duree.getValue()));						
						table.setModel(tableLivren());
					}
					else if(comboBox.getSelectedItem().equals("CD")) {JOptionPane.showMessageDialog(null, o.nMemberEmpruntCD(Integer.parseInt(IDexemplaire.getText()),Integer.parseInt(ClientID.getText()),"Location",(Integer)Duree.getValue()));	
					table.setModel(tableCDn());
					comboBox.setSelectedIndex(1);}
					else {
						JOptionPane.showMessageDialog(null, o.nMemberEmpruntP(Integer.parseInt(IDexemplaire.getText()),Integer.parseInt(ClientID.getText()),"Consumtation sur place",0));
					table.setModel(tablePn());comboBox.setSelectedIndex(2);
					}
					
				}
										
			
			//int idExP,int idM,String t,String duree
			
			
					
				
			
			}
		});
		btnNewButton.setBackground(new Color(51, 204, 0));
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton.setBounds(162, 466, 123, 36);
		contentPane.add(btnNewButton);
		
		JButton btnRetourner = new JButton("Retourner");
		btnRetourner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OperationEmprunter o=new OperationEmprunter();
				if(!rdbtnNonMembre.isSelected()) {
					
				
				if(comboBox.getSelectedItem().equals("Livre")) {
					
					Recus r= new Recus(Integer.parseInt(ClientID.getText()),Integer.parseInt(IDexemplaire.getText()),"Livre");
					r.setVisible(true);
					JOptionPane.showMessageDialog(null, o.memberReturnLiver(Integer.parseInt(ClientID.getText()),Integer.parseInt(IDexemplaire.getText())));						
					
					table.setModel(tableLivre());
					ClientID.setText("");
					IDexemplaire.setText("");
					comboBox.setSelectedIndex(0);
					
				}
				else if(comboBox.getSelectedItem().equals("CD")) {
					Recus r= new Recus(Integer.parseInt(ClientID.getText()),Integer.parseInt(IDexemplaire.getText()),"CD");
					r.setVisible(true);
					JOptionPane.showMessageDialog(null, o.memberReturnCD(Integer.parseInt(ClientID.getText()),Integer.parseInt(IDexemplaire.getText())));			
					table.setModel(tableCD());
					comboBox.setSelectedIndex(1);
					
				}
				else 		 {
					
					JOptionPane.showMessageDialog(null, o.memberReturnP(Integer.parseInt(ClientID.getText()),Integer.parseInt(IDexemplaire.getText())));				
					
					table.setModel(tableP());
					comboBox.setSelectedIndex(2);
				
				}
				}
				else {
					if(comboBox.getSelectedItem().equals("Livre")) {
						Recus r= new Recus(Integer.parseInt(ClientID.getText()),Integer.parseInt(IDexemplaire.getText()),"Nlivre");
						r.setVisible(true);
						JOptionPane.showMessageDialog(null, o.nMemberReturnLiver(Integer.parseInt(ClientID.getText()),Integer.parseInt(IDexemplaire.getText())));						
						table.setModel(tableLivren());
						ClientID.setText("");
						IDexemplaire.setText("");
						comboBox.setSelectedIndex(0);
						rdbtnNonMembre.setSelected(true);
						table.setModel(tableLivren());
						
					}
					else if(comboBox.getSelectedItem().equals("CD")) {
						Recus r= new Recus(Integer.parseInt(ClientID.getText()),Integer.parseInt(IDexemplaire.getText()),"NCD");
						r.setVisible(true);
						JOptionPane.showMessageDialog(null, o.nmemberReturnCD(Integer.parseInt(ClientID.getText()),Integer.parseInt(IDexemplaire.getText())));				
						table.setModel(tableCDn());
						comboBox.setSelectedIndex(1);
					}
					else 		 {
					
						JOptionPane.showMessageDialog(null, o.nMemberReturnP(Integer.parseInt(ClientID.getText()),Integer.parseInt(IDexemplaire.getText())));				
						table.setModel(tablePn());
						comboBox.setSelectedIndex(2);
					}
					}
				 
				
					
					
				
			}
		});
		
		btnRetourner.setBackground(new Color(255, 204, 0));
		btnRetourner.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		btnRetourner.setBounds(340, 466, 123, 36);
		contentPane.add(btnRetourner);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Type du document :");
		lblNewLabel_1_1_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(79, 323, 123, 29);
		contentPane.add(lblNewLabel_1_1_2);
		String []c= {"Livre","CD","Periodique"};
		comboBox = new JComboBox(c);
		comboBox.setBounds(244, 320, 197, 36);
		contentPane.add(comboBox);
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				if(!rdbtnNonMembre.isSelected()) {
					int choix=comboBox.getSelectedIndex();
					switch(choix) {
					case 0: table.setModel(tableLivre()) ;ClientID.setText("");IDexemplaire.setText("");Duree.setValue(0); break;
					case 1: table.setModel(tableCD());ClientID.setText("");IDexemplaire.setText("");Duree.setValue(0); break;
					case 2: table.setModel(tableP());ClientID.setText("");IDexemplaire.setText("");Duree.setValue(0); break;
					
				}
					

				}
				else {
					int choix=comboBox.getSelectedIndex();
					switch(choix) {
					case 0: table.setModel(tableLivren()) ;ClientID.setText("");IDexemplaire.setText("");Duree.setValue(0); break;
					case 1: table.setModel(tableCDn());ClientID.setText("");IDexemplaire.setText("");Duree.setValue(0); break;
					case 2: table.setModel(tablePn());ClientID.setText("");IDexemplaire.setText("");Duree.setValue(0); break;
				}
				
			}
			
			}});
		final ListSelectionModel model1= table.getSelectionModel();
		model1.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(! model1.isSelectionEmpty()) {
					n=model1.getMinSelectionIndex();
					ClientID.setText(table.getValueAt(n,2).toString());
					IDexemplaire.setText(table.getValueAt(n,1).toString());
					Duree.setValue(table.getValueAt(n,6));
					
				
				}
				
				
				
			}
			
		});
		
		JLabel lblTypeDeClient = new JLabel("Type de client :");
		lblTypeDeClient.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblTypeDeClient.setBounds(79, 112, 123, 29);
		contentPane.add(lblTypeDeClient);
		
		Duree = new JSpinner();
		Duree.setBounds(243, 378, 197, 36);
		contentPane.add(Duree);
		
	}
}
