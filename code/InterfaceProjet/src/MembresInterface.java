import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Traitement.Client;
import Traitement.OperationClient;

import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class MembresInterface extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField RechField;
	private JTextField NomField;
	private JTextField PrenomField;
	private JTextField TeleField;
	private JTextField VilleField;
	private JTextField EmailField;
	DefaultTableModel model;
	private JTextField IdField;
	private JComboBox comboBox;
	private JButton btnNewButton_3 ;
	int n;

	/**
	 * Launch the application.
	 */
	
public static void main(String [] args) {
	MembresInterface m = new MembresInterface();
	m.setVisible(true);
}
public DefaultTableModel table() {
	OperationClient o= new OperationClient();
	
	
	o.ColNom();
	

 	model = new DefaultTableModel();
 	for (int i = 0; i <o.ColNom().size(); i++) {
		model.addColumn(o.ColNom().get(i));
	}
  
   
   Vector<Client> clients= o.ToutClient();
   for (int i = 0; i < clients.size(); i++) {
	   
	   model.addRow(new Object []{
 	        	clients.get(i).getID(),clients.get(i).getNom(),clients.get(i).getPrenom(),clients.get(i).getTelephone(),clients.get(i).getVille(),clients.get(i).getEmail()
 	        });
}
return model;

	
}
public DefaultTableModel tablen() {
	OperationClient o= new OperationClient();
	
	
	o.ColNom();
	

 	model = new DefaultTableModel();
 	for (int i = 0; i <o.ColNom().size(); i++) {
		model.addColumn(o.ColNom().get(i));
	}
  
   
   Vector<Client> clients= o.ToutClientNon();
   for (int i = 0; i < clients.size(); i++) {
	   
	   model.addRow(new Object []{
 	        	clients.get(i).getID(),clients.get(i).getNom(),clients.get(i).getPrenom(),clients.get(i).getTelephone(),clients.get(i).getVille(),clients.get(i).getEmail()
 	        });
}
return model;

	
}

	/**
	 * Create the frame.
	 */
	public MembresInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10,-16,1300, 750);
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
	      
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(583, 68, 688, 619);
		panel.add(scrollPane);
	       
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(table());
		table.setEnabled(true);
		final ListSelectionModel model1= table.getSelectionModel();
		model1.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(! model1.isSelectionEmpty()) {
					n=model1.getMinSelectionIndex();
					//JOptionPane.showMessageDialog(null,"Row selected "+n);
					IdField.setText(model.getValueAt(n,0).toString());
					NomField.setText(model.getValueAt(n,1).toString());
					PrenomField.setText(model.getValueAt(n,2).toString());
					VilleField.setText(model.getValueAt(n,4).toString());
					EmailField.setText(model.getValueAt(n,5).toString());
					TeleField.setText(model.getValueAt(n,3).toString());
					RechField.setText("");
				
				}
				
				
				
			}
			
		});
		
		
		RechField = new JTextField();
	
		
		RechField.setBounds(583, 21, 393, 36);
		panel.add(RechField);
		RechField.setColumns(10);
		
		JButton btnNewButton = new JButton("Chercher...");
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(994, 21, 107, 36);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String search=RechField.getText();
				OperationClient o = new OperationClient();
				DefaultTableModel m=(DefaultTableModel) table.getModel();	
				Client c;
				
				if(! search.equals("")) {
					if(comboBox.getSelectedIndex()==1) {
						 c=o.rechercherClientn(Integer.parseInt(search));
					}else {
						c=o.rechercherClient(Integer.parseInt(search));
					}
					
						IdField.setText(String.valueOf(c.getID()));
						NomField.setText(c.getNom());
						PrenomField.setText(c.getPrenom());
						VilleField.setText(c.getVille());
						EmailField.setText(c.getEmail());
						TeleField.setText(c.getTelephone());
						RechField.setText("");
			}
				else {
					JOptionPane.showMessageDialog(null, "champ null");
				}}
			
		});
		
		NomField = new JTextField();
		NomField.setBounds(196, 192, 208, 36);
		panel.add(NomField);
		NomField.setColumns(10);
		
		PrenomField = new JTextField();
		PrenomField.setColumns(10);
		PrenomField.setBounds(196, 245, 208, 36);
		panel.add(PrenomField);
		
		TeleField = new JTextField();
		TeleField.setColumns(10);
		TeleField.setBounds(196, 303, 208, 36);
		panel.add(TeleField);
		
		VilleField = new JTextField();
		VilleField.setColumns(10);
		VilleField.setBounds(196, 356, 208, 36);
		panel.add(VilleField);
		
		EmailField = new JTextField();
		EmailField.setColumns(10);
		EmailField.setBounds(196, 408, 208, 36);
		panel.add(EmailField);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel.setBounds(53, 194, 107, 30);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.setBackground(new Color(0, 153, 102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( NomField.getText().equals("") || PrenomField.getText().equals("")|| TeleField.getText().equals("") || VilleField.getText().equals("") || EmailField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"remplie tour les field !!");
				}
				else {
					if(comboBox.getSelectedIndex()==1) {
						Client c= new Client(0,NomField.getText(),PrenomField.getText(),TeleField.getText(),VilleField.getText(),EmailField.getText());//String nom, String prenom, String telephone, String ville,String email
						OperationClient o =new OperationClient();
						o.ajouterClientN(c);
						table.setModel(tablen());
						comboBox.setSelectedIndex(1);
					}
					else {
						Client c= new Client(0,NomField.getText(),PrenomField.getText(),TeleField.getText(),VilleField.getText(),EmailField.getText());//String nom, String prenom, String telephone, String ville,String email
						OperationClient o =new OperationClient();
						o.ajouterclient(c);
						table.setModel(table());
						comboBox.setSelectedIndex(0);
						
					}
				
				
				
				PrenomField.setText("");
				NomField.setText("");
				EmailField.setText("");
				VilleField.setText("");
				TeleField.setText("");
				IdField.setText("");
				
				
				}
			}
		});
		btnNewButton_1.setBounds(109, 498, 102, 30);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBackground(new Color(255, 51, 51));
		btnNewButton_2.setBounds(402, 498, 100, 30);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IdField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "choisie un client");
				}
				else {
					OperationClient o= new OperationClient();
					if(comboBox.getSelectedIndex()==1) {
						o.supprimerClientN(Integer.parseInt(IdField.getText()));
						table.setModel(tablen());
						comboBox.setSelectedIndex(1);
						
					}
					else {
						o.supprimerClient(Integer.parseInt(IdField.getText()));
						table.setModel(table());
						comboBox.setSelectedIndex(0);
						
						
					}
				PrenomField.setText("");
				NomField.setText("");
				EmailField.setText("");
				VilleField.setText("");
				TeleField.setText("");
				IdField.setText("");
				
				
				
			
				
				
				
				
			}}
		});
		
		
		btnNewButton_3 = new JButton("Carte client");
		btnNewButton_3.setBackground(new Color(0, 153, 255));
		btnNewButton_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Integer.parseInt(IdField.getText()), NomField.getText(), PrenomField.getText(), TeleField.getText(), VilleField.getText(),EmailField.getText()
				//int id,String nom ,String prenom,String ville,String tel
				if( NomField.getText().equals("") || PrenomField.getText().equals("")|| TeleField.getText().equals("") || VilleField.getText().equals("") || EmailField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Choisie un client");}
					else {
				CarteClientInterface c= new CarteClientInterface(Integer.parseInt(IdField.getText()),NomField.getText(),PrenomField.getText(),VilleField.getText(), TeleField.getText());
				c.setVisible(true);}
				
			}
			
		});
		btnNewButton_3.setBounds(248, 560, 114, 43);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Modifier");
		btnNewButton_4.setBackground(new Color(255, 255, 102));
		btnNewButton_4.setBounds(254, 498, 102, 30);
		panel.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OperationClient o= new  OperationClient();
				if( IdField.getText().equals("")|| NomField.getText().equals("") || PrenomField.getText().equals("")|| TeleField.getText().equals("") || VilleField.getText().equals("") || EmailField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"remplie tout les field !!");
				}
				else {
					Client c= new Client(Integer.parseInt(IdField.getText()), NomField.getText(), PrenomField.getText(), TeleField.getText(), VilleField.getText(),EmailField.getText() );//int ID,String nom, String prenom, String telephone, String ville,String email
					
					
					if(comboBox.getSelectedIndex()==1) {
						o.modifierClientN(c);
						table.setModel(tablen());
						comboBox.setSelectedIndex(1);
					}
					else {
						o.modifierClient(c);
						table.setModel(table());
						comboBox.setSelectedIndex(0);
					}
					
					//int ID,String nom, String prenom, String telephone, String ville,String email
				
				
				PrenomField.setText("");
				NomField.setText("");
				EmailField.setText("");
				VilleField.setText("");
				TeleField.setText("");
			
				}
				
				
				
			}
			
		});
		
		
		ImageIcon r= new ImageIcon(ConsultationInterface.class.getResource("/imageicon/r_icon.jpg"));
		Image image=((ImageIcon) r).getImage();
		image=image.getScaledInstance(70,60, DO_NOTHING_ON_CLOSE);
		r= new ImageIcon(image);
		JButton btnNewButton_5 = new JButton(r);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage l = new WelcomePage();
				l.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_5.setBounds(10, 11, 70, 60);
		panel.add(btnNewButton_5);
		
		JLabel lblPrnom = new JLabel("Prénom :");
		lblPrnom.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblPrnom.setBounds(53, 245, 107, 30);
		panel.add(lblPrnom);
		
		JLabel lblTlphone = new JLabel("Téléphone  :");
		lblTlphone.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblTlphone.setBounds(53, 303, 107, 30);
		panel.add(lblTlphone);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblVille.setBounds(53, 356, 107, 30);
		panel.add(lblVille);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblEmail.setBounds(53, 408, 107, 30);
		panel.add(lblEmail);
		
		IdField = new JTextField();
		IdField.setBounds(215, 100, 86, 20);
		IdField.setVisible(false);
		panel.add(IdField);
		IdField.setColumns(10);
		
		JLabel lblTypeDeClient = new JLabel("Type de client :");
		lblTypeDeClient.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblTypeDeClient.setBounds(53, 135, 123, 29);
		panel.add(lblTypeDeClient);
		
		comboBox = new JComboBox(new Object[]{"Membre","Non Membre"});
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
					int choix=comboBox.getSelectedIndex();
					switch(choix) {
					case 0:{btnNewButton_3.setVisible(true);table.setModel(table()); PrenomField.setText("");
					NomField.setText("");
					EmailField.setText("");
					VilleField.setText("");
					TeleField.setText("");
					IdField.setText(""); break;}
					case 1:{btnNewButton_3.setVisible(false); table.setModel(tablen());PrenomField.setText("");
					NomField.setText("");
					EmailField.setText("");
					VilleField.setText("");
					TeleField.setText("");
					IdField.setText(""); break;}
		
					}
			}});
		comboBox.setBounds(196, 132, 208, 36);
		panel.add(comboBox);
		
		
		
	}
}
