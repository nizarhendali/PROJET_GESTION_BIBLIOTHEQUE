import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Traitement.OperationLogin;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MotDePasseOublie extends JFrame {

	private JPanel contentPane;
	private JTextField prenom;
	private JLabel lblNewLabel_1;
	private JTextField Email;
	private JLabel lblNouveauMotDe;
	private JLabel lblNom;
	private JTextField Nom;
	private JPasswordField NMoteDePasse;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MotDePasseOublie() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 230, 538, 350);
		setTitle("Mot de passe oublié");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30,204,205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prénom");
		lblNewLabel.setBounds(66, 84, 82, 27);
		contentPane.add(lblNewLabel);
		
		prenom = new JTextField();
		prenom.setBounds(221, 84, 198, 27);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(66, 134, 82, 27);
		contentPane.add(lblNewLabel_1);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(221, 134, 198, 27);
		contentPane.add(Email);
		
		lblNouveauMotDe = new JLabel("Nouveau mot de passe");
		lblNouveauMotDe.setBackground(SystemColor.inactiveCaptionText);
		lblNouveauMotDe.setBounds(66, 187, 150, 27);
		contentPane.add(lblNouveauMotDe);
		
		lblNom = new JLabel("Nom");
		lblNom.setBounds(66, 34, 82, 27);
		contentPane.add(lblNom);
		
		Nom = new JTextField();
		Nom.setColumns(10);
		Nom.setBounds(221, 34, 198, 27);
		contentPane.add(Nom);
		
		NMoteDePasse = new JPasswordField();
		NMoteDePasse.setBounds(221, 187, 198, 27);
		contentPane.add(NMoteDePasse);
		
		btnNewButton = new JButton("Ajouter");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 102, 102));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Nom.getText().equals("") ||  prenom.getText().equals("") || Email.getText().equals("") || NMoteDePasse.getText().equals("")  ) {
					JOptionPane.showMessageDialog(null, "Champs vide !!!");
				}
				else {
				OperationLogin o = new OperationLogin();
				if(o.MotDePasse(Nom.getText(), prenom.getText(), Email.getText(), NMoteDePasse.getText())) {JOptionPane.showMessageDialog(null,"Mot de passe changer avec succes");
				Nom.setText("");
				prenom.setText("");
				Email.setText("");
				NMoteDePasse.setText("");
				setVisible(false);}
				else {
					JOptionPane.showMessageDialog(null,"des Champs invalide");
					Nom.setText("");
					prenom.setText("");
					Email.setText("");
					NMoteDePasse.setText("");
				}
			}
			}
		});
		btnNewButton.setBounds(264, 242, 104, 32);
		contentPane.add(btnNewButton);
	}
}
