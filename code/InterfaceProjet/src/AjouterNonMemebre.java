import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Traitement.Client;
import Traitement.Livre;
import Traitement.OperationClient;
import Traitement.OperationDocument;

public class AjouterNonMemebre extends JFrame {

	private JPanel contentPane;
	private JTextField NomField;
	private JTextField PrenomFiled;
	private JTextField TelField;
	private JTextField EmailField;
	private JTextField VilleField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterNonMemebre frame = new AjouterNonMemebre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AjouterNonMemebre() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(300, 100, 624, 607);
		setTitle("Ajouter Client Non Membre");
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 608, 568);
		contentPane.add(panel);
		panel.setLayout(null);
		
		NomField = new JTextField();
		NomField.setBounds(280, 80, 238, 38);
		panel.add(NomField);
		NomField.setColumns(10);
		
		JLabel Nom = new JLabel("Nom :");
		Nom.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		Nom.setBounds(82, 83, 141, 31);
		panel.add(Nom);
		
		PrenomFiled = new JTextField();
		PrenomFiled.setColumns(10);
		PrenomFiled.setBounds(280, 162, 238, 38);
		panel.add(PrenomFiled);
		
		JLabel Prenom = new JLabel("Prénom  :");
		Prenom.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		Prenom.setBounds(82, 165, 141, 31);
		panel.add(Prenom);
		
		TelField = new JTextField();
		TelField.setColumns(10);
		TelField.setBounds(280, 249, 238, 38);
		panel.add(TelField);
		
		JLabel Tel =new JLabel("Téléphone :");
		Tel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		Tel.setBounds(82, 252, 141, 31);
		panel.add(Tel);
		
		JLabel Ville = new JLabel("Ville :");
		Ville.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		Ville.setBounds(82, 329, 188, 31);
		panel.add(Ville);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NomField.getText().equals("")||PrenomFiled.getText().equals("")||VilleField.getText().equals("")||TelField.getText().equals("")||	EmailField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Champs vide !!");
				}
				else {
					
				OperationClient c= new OperationClient();
				
				c.ajouterClientN(new Client(0,NomField.getText(),PrenomFiled.getText(),TelField.getText(),VilleField.getText(),EmailField.getText()));//int ID,String nom, String prenom, String telephone, String ville,String email
				NomField.setText("");
				PrenomFiled.setText("");
				VilleField.setText("");
				TelField.setText("");
				EmailField.setText("");
				
				setVisible(false);
				}
				
				}
			
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 204, 51));
		btnNewButton.setBounds(241, 492, 111, 38);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NomField.setText("");
				PrenomFiled.setText("");
				VilleField.setText("");
				TelField.setText("");
				EmailField.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(0, 204, 204));
		btnNewButton_1.setBounds(420, 492, 111, 38);
		panel.add(btnNewButton_1);
		
		JLabel Email = new JLabel(" Email :");
		Email.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		Email.setBounds(82, 404, 141, 31);
		panel.add(Email);
		
		EmailField = new JTextField();
		EmailField.setColumns(10);
		EmailField.setBounds(280, 401, 238, 38);
		panel.add(EmailField);
		
		VilleField = new JTextField();
		VilleField.setColumns(10);
		VilleField.setBounds(280, 329, 238, 38);
		panel.add(VilleField);
		
	}
}
