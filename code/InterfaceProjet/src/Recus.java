import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Traitement.OperationAmende;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JButton;

public class Recus extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Recus(int id,int idex,String t) {
		setTitle("Recus");
		Vector<Object> info=new Vector<Object>();
		OperationAmende n=new OperationAmende();
if(t.equals("Livre")) {
	info= n.amendMemberLivre(id, idex);
		}
else if(t.equals("CD")) {info= n.amendMemberCD(id, idex);}
else if(t.equals("Periodique")){info= n.amendMemberP(id, idex);}
else if(t.equals("Nlivre")) {info= n.amendNonMemberLivre(id, idex);}
else if(t.equals("NCD")) {info= n.amendNonMemberCD(id, idex);}
else if(t.equals("NP")) {info= n.amendNonMemberP(id, idex);}

		
			if(info==null) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Deja payer");
				
			}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 382, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(0, 0, 366, 408);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Nom = new JLabel("Nom:");
		Nom.setBounds(23, 71, 39, 36);
		panel.add(Nom);
		Nom.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		
		JLabel Prenom = new JLabel("Prénom :");
		Prenom.setBounds(159, 71, 132, 36);
		panel.add(Prenom);
		Prenom.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		
		JLabel lblTitre = new JLabel("Titre:");
		lblTitre.setBounds(23, 118, 132, 36);
		panel.add(lblTitre);
		lblTitre.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		
		JLabel lblDuree = new JLabel("Duree :");
		lblDuree.setBounds(23, 229, 132, 36);
		panel.add(lblDuree);
		lblDuree.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		
		JLabel lblPrix = new JLabel("Total :");
		lblPrix.setBounds(23, 361, 132, 36);
		panel.add(lblPrix);
		lblPrix.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		
		JLabel lblTypeDeDocument = new JLabel("Type de Document : ");
		lblTypeDeDocument.setBounds(23, 153, 132, 36);
		panel.add(lblTypeDeDocument);
		lblTypeDeDocument.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		
		JLabel lblDateDemprunter = new JLabel("Date d'Emprunter :");
		lblDateDemprunter.setBounds(23, 188, 132, 36);
		panel.add(lblDateDemprunter);
		lblDateDemprunter.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		
		JLabel lblRetard = new JLabel("Retard :");
		lblRetard.setBounds(23, 260, 132, 36);
		panel.add(lblRetard);
		lblRetard.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		
		JLabel lblNewLabel = new JLabel("Reçus");
		lblNewLabel.setBounds(142, 11, 174, 42);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 22));
		
		JLabel field1 = new JLabel((String) info.get(0));
		field1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		field1.setBounds(56, 71, 108, 36);
		panel.add(field1);
		
		JLabel field1_1 = new JLabel((String) info.get(1));
		field1_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		field1_1.setBounds(212, 71, 108, 36);
		panel.add(field1_1);
		
		JLabel field1_2 = new JLabel((String) info.get(2));
		field1_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		field1_2.setBounds(56, 118, 108, 36);
		panel.add(field1_2);
		
		JLabel field1_3 = new JLabel(t);
		field1_3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		field1_3.setBounds(142, 153, 108, 36);
		panel.add(field1_3);
		
		JLabel field1_4 = new JLabel((String) info.get(5));
		field1_4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		field1_4.setBounds(142, 188, 174, 36);
		panel.add(field1_4);
		
		JLabel field1_5 = new JLabel(String.valueOf((Integer) info.get(4)));
		field1_5.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		field1_5.setBounds(72, 229, 108, 36);
		panel.add(field1_5);
		int dure=(Integer) info.get(4);
		int x=(Integer) info.get(3);
		if(dure==x) {dure=0;}
		JLabel field1_6 = new JLabel(String.valueOf(x));
		field1_6.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		field1_6.setBounds(72, 260, 108, 36);
		panel.add(field1_6);
		
		JLabel field1_7 = new JLabel((dure*5+x*10)+" DH");
		field1_7.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		field1_7.setBounds(72, 361, 108, 36);
		panel.add(field1_7);
		
		JLabel field1_8 = new JLabel((String) info.get(6));
		field1_8.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		field1_8.setBounds(200, 361, 166, 36);
		panel.add(field1_8);}
	
}
