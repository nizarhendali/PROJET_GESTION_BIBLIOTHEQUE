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
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Traitement.Livre;
import Traitement.OperationDocument;

public class ModifierLivre extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JSpinner textField_3;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param nbr 
	 * @param catego 
	 * @param auteur 
	 * @param titre 
	 * @param id 
	 */
	public ModifierLivre(final int id, String titre, String auteur, String catego, int nbr) {

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
		setTitle("Modifier Livre");
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 608, 568);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField(titre);
		textField.setBounds(280, 80, 238, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Titre :");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel.setBounds(82, 83, 141, 31);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField(auteur);
		textField_1.setColumns(10);
		textField_1.setBounds(280, 162, 238, 38);
		panel.add(textField_1);
		
		JLabel lblAuteur = new JLabel("Auteur  :");
		lblAuteur.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblAuteur.setBounds(82, 165, 141, 31);
		panel.add(lblAuteur);
		
		textField_2 = new JTextField(catego);
		textField_2.setColumns(10);
		textField_2.setBounds(280, 249, 238, 38);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2 =new JLabel("Categorie :");
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel_2.setBounds(82, 252, 141, 31);
		panel.add(lblNewLabel_2);
		
		textField_3 = new JSpinner();
		textField_3.setValue(nbr);
		textField_3.setBounds(280, 326, 238, 38);
		panel.add(textField_3);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre d'exemplaire :");
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel_3.setBounds(82, 329, 188, 31);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(238,164,0));
		btnNewButton.setBounds(242, 441, 111, 38);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OperationDocument d= new OperationDocument();
				Livre l=new Livre(textField.getText(),textField_1.getText(),textField_2.getText(),(Integer)textField_3.getValue(),id);//int id, String titre, String auteur, String catego, int nbr
				d.modifierLivre(l);//String titre, String auteur, String categorie, int i,int id
				DocumentInterface x= new DocumentInterface();
				x.setVisible(true);
				setVisible(false);
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(0, 204, 204));
		btnNewButton_1.setBounds(421, 441, 111, 38);
		panel.add(btnNewButton_1);
	}

}
