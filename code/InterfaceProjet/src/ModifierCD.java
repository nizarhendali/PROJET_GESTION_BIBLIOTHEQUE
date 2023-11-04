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
import java.time.LocalDate;

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

public class ModifierCD extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JSpinner textField_3;
	private JDateChooser Date;
	private int id;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param nbr 
	 * @param date 
	 * @param langue 
	 * @param auteur 
	 * @param titre 
	 * @param id 
	 */
	public ModifierCD(final int id, String titre, String auteur, String langue, String date, int nbr) {
		this.id=id;
		
		
		contentPane = new JPanel();

		setContentPane(contentPane);
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
		setTitle("Modifier CD");
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
		
		
		Date = new JDateChooser();
		
		
	//	java.util.Date date2 = new SimpleDateFormat(date);
		String pattern = "yyyy-MM-dd";
	//	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Date.setDate(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		//Date.setDate(date2);
		//Date.setDate(date2);
		//Date.setDateFormatString("yyyy-mm-dd");
		Date.setBounds(280, 249, 238, 38);
		panel.add(Date);
	
		
		JLabel lblNewLabel_2 =new JLabel("Date de Publication :");
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
		
		textField_4 = new JTextField(langue);
		textField_4.setColumns(10);
		textField_4.setBounds(280, 406, 238, 38);
		panel.add(textField_4);
		
		JLabel lblNewLabel_4 = new JLabel("Langue :");
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel_4.setBounds(82, 406, 188, 31);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(238,164,0));
		btnNewButton.setBounds(242, 480, 111, 38);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField.getText().equals("") || textField_1.getText().equals("") || Date.getDate().equals(null) || textField_3.getValue().equals(null) || textField_4.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Champs Vide");
				}
				else{
					OperationDocument o = new OperationDocument();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String startDateString = dateFormat.format(Date.getDate());
					Disquecompact c= new Disquecompact(textField.getText() ,(Integer) textField_3.getValue() , textField_1.getText() , textField_4.getText() , startDateString ,id);//String titre, int nbrExp, String auteur, String langue, Date datePub,int id
					o.modifierCD(c);
					DocumentInterface d= new DocumentInterface();
					d.setVisible(true);
					setVisible(false);
					//JOptionPane.showMessageDialog(null, "Livre ajouter");
				}
			}
			
		});
		
		
		JButton btnNewButton_1 = new JButton("Annuler");
	
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(0, 204, 204));
		btnNewButton_1.setBounds(421, 480, 111, 38);
		panel.add(btnNewButton_1);
	}

}
