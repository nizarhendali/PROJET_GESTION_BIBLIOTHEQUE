import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import Traitement.OperationDocument;
import Traitement.Periodique;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class AjouterPeriodique extends JFrame {

	private JPanel contentPane;

	private JTextField TitreField;
	private JTextField Periodicite;
	private JSpinner nbrex;
	private JDateChooser Date;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AjouterPeriodique() {
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
		setTitle("Ajouter Periodique");
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
		
		TitreField = new JTextField();
		TitreField.setBounds(280, 80, 238, 38);
		panel.add(TitreField);
		TitreField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Titre :");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel.setBounds(82, 83, 141, 31);
		panel.add(lblNewLabel);
		
		JLabel lblAuteur = new JLabel("Date Edition :");
		lblAuteur.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblAuteur.setBounds(82, 165, 141, 31);
		panel.add(lblAuteur);
		
		Periodicite = new JTextField();
		Periodicite.setColumns(10);
		Periodicite.setBounds(280, 249, 238, 38);
		panel.add(Periodicite);
		
		JLabel lblNewLabel_2 =new JLabel("Periodicite :");
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel_2.setBounds(82, 252, 141, 31);
		panel.add(lblNewLabel_2);
		
		nbrex = new JSpinner();
		nbrex.setBounds(280, 326, 238, 38);
		panel.add(nbrex);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre d'exemplaire :");
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel_3.setBounds(82, 329, 188, 31);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(Date.getDate().equals(null) ||TitreField.getText().equals("") ||Periodicite.getText().equals("") || 	nbrex.getValue().equals("") )
				{
					JOptionPane.showConfirmDialog(null, "Champs vide");
				}
				else {
					OperationDocument o = new OperationDocument();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String startDateString = dateFormat.format(Date.getDate());
					o.AjouterPeriodique(new Periodique(TitreField.getText(), startDateString,Periodicite.getText(),(Integer) (nbrex.getValue()),0));
					Date.setDate(null);
					TitreField.setText("");
					Periodicite.setText("");
					nbrex.setValue(0);
					DocumentInterface d= new DocumentInterface();
					d.setVisible(true);
					setVisible(false);
					
					JOptionPane.showConfirmDialog(null, "Periodique ajouter");
				}
			
			
				
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 204, 51));
		btnNewButton.setBounds(242, 441, 111, 38);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(0, 204, 204));
		btnNewButton_1.setBounds(421, 441, 111, 38);
		panel.add(btnNewButton_1);
		
		Date = new JDateChooser();
	//	Date.setDateFormatString("yyyy-mm-dd");
		Date.setBounds(280, 162, 238, 38);
		panel.add(Date);
	}
}
