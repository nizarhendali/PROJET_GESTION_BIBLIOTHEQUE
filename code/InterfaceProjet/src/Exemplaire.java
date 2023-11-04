import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Traitement.OperationDocument;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exemplaire extends JFrame {

	private JPanel contentPane;
	private Integer id,nbr;
	private String titre,type;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Exemplaire(final String type,final Integer id,String titre,final Integer nbr) {
		this.titre=titre;
		this.id=id;
		this.nbr=nbr;
		this.type=type;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		System.out.println(type+" / "+id+" / "+titre+" / "+nbr);
		setBounds(400, 200, 448, 321);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(type+" de titre : "+titre+" a "+nbr+" exemplaires.");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel.setBounds(22, 46, 351, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre d'exemplaire :");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		lblNewLabel_1.setBounds(33, 150, 151, 31);
		contentPane.add(lblNewLabel_1);
		
		spinner = new JSpinner();
		spinner.setBounds(236, 150, 109, 31);
		contentPane.add(spinner);
		
		
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperationDocument d= new OperationDocument();
				if(type.equals("Livre")) {for (int i=0;i<(Integer)spinner.getValue();i++) {d.ajouterExemplaireLivre(id);}}
				else if (type.equals("CD")) {for (int i=0;i<(Integer)spinner.getValue();i++) {d.ajouterExemplaireCD(id);}}
				else {for (int i=0;i<(Integer)spinner.getValue();i++) {d.afficherExemplaireP();}}
			}
		});
		btnAjouter.setBackground(new Color(0, 153, 102));
		btnAjouter.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnAjouter.setBounds(160, 212, 125, 42);
		contentPane.add(btnAjouter);
	}
}
