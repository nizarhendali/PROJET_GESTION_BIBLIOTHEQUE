import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Traitement.Disquecompact;
import Traitement.OperationDocument;
import Traitement.Periodique;

public class ModifierPeriodique extends JFrame {

	private JPanel contentPane;


	private JTextField textField;
	// private JTextField textField_1;
	private JTextField textField_2;
	private JSpinner textField_3;
	private JDateChooser Date;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param nbr 
	 * @param period 
	 * @param date2 
	 * @param titre 
	 * @param id 
	 */
	public ModifierPeriodique(final int id, String titre, String date2, String period, int nbr) {
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
		setTitle("Modifier Periodique");
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
		
		
		Date = new JDateChooser();
		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
			Date.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		//Date.setDateFormatString("yyyy-mm-dd");
		
		
		Date.setBounds(280, 162, 238, 38);
		panel.add(Date);
		
		JLabel lblAuteur = new JLabel("Date Edition  :");
		lblAuteur.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblAuteur.setBounds(82, 165, 141, 31);
		panel.add(lblAuteur);
		
		textField_2 = new JTextField(period);
		textField_2.setColumns(10);
		textField_2.setBounds(280, 249, 238, 38);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2 =new JLabel("Periodicite :");
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
				if(textField.getText().equals("") || textField_2.getText().equals("") || Date.getDate().equals(null) || textField_3.getValue().equals(null))
				{
					JOptionPane.showMessageDialog(null, "Champs Vide");
				}
				else{
					OperationDocument o = new OperationDocument();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String startDateString = dateFormat.format(Date.getDate());//String titre,String date ,String perio,int i,int id
					Periodique c= new Periodique(textField.getText(),startDateString,textField_2.getText(),(Integer) textField_3.getValue(),id) ; //  (String text,String date ,String text1,int i,int id)             
					o.modifierPeriodique(c);
					DocumentInterface d= new DocumentInterface();
					d.setVisible(true);
					setVisible(false);
					//JOptionPane.showMessageDialog(null, "Livre ajouter");
				}
				
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DocumentInterface d= new DocumentInterface();
				d.setVisible(true);
				setVisible(false);
				
			}
			
		});
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(0, 204, 204));
		btnNewButton_1.setBounds(421, 441, 111, 38);
		panel.add(btnNewButton_1);
	}

}
