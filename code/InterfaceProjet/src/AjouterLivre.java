import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import Traitement.Livre;
import Traitement.OperationDocument;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class AjouterLivre extends JFrame {

	private JPanel contentPane;
	private JTextField TitreField;
	private JTextField AuteurField;
	private JTextField CatField;
	private JSpinner NbField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AjouterLivre() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() { 
	        @Override
	        public void windowClosing(WindowEvent e) { 
	                setVisible(false);
	                DocumentInterface o = new DocumentInterface();
	                o.setVisible(true);
	        }
	    });
		setBounds(300, 100, 624, 607);
		setTitle("Ajouter Livre");
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 608, 499);
		contentPane.add(panel);
		panel.setLayout(null);
		
		TitreField = new JTextField();
		TitreField.setBounds(280, 80, 238, 38);
		panel.add(TitreField);
		TitreField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Titre :");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel.setBounds(82, 83, 141, 31);
		panel.add(lblNewLabel);
		
		AuteurField = new JTextField();
		AuteurField.setColumns(10);
		AuteurField.setBounds(280, 162, 238, 38);
		panel.add(AuteurField);
		
		JLabel lblAuteur = new JLabel("Auteur  :");
		lblAuteur.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblAuteur.setBounds(82, 165, 141, 31);
		panel.add(lblAuteur);
		
		CatField = new JTextField();
		CatField.setColumns(10);
		CatField.setBounds(280, 249, 238, 38);
		panel.add(CatField);
		
		JLabel lblNewLabel_2 =new JLabel("Categorie :");
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel_2.setBounds(82, 252, 141, 31);
		panel.add(lblNewLabel_2);
		
		NbField = new JSpinner();
		NbField.setBounds(280, 326, 238, 38);
		panel.add(NbField);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre d'exemplaire :");
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel_3.setBounds(82, 329, 188, 31);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperationDocument o = new OperationDocument();
				if(TitreField.getText().equals("") || AuteurField.getText().equals("") || CatField.getText().equals("") || NbField.getValue().equals("")) {
					JOptionPane.showMessageDialog(null, "champs vide");
				}
				else {
					Livre livre= new Livre(TitreField.getText(),AuteurField.getText(),CatField.getText(),(Integer) NbField.getValue(),0);//String titre, String auteur, String categorie, int i
					o.AjouterLivre(livre);
					DocumentInterface d= new DocumentInterface();
					d.setVisible(true);
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Livre ajouter");
				}
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 204, 51));
		btnNewButton.setBounds(236, 424, 111, 38);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(0, 204, 204));
		btnNewButton_1.setBounds(415, 424, 111, 38);
		panel.add(btnNewButton_1);
	}

}
