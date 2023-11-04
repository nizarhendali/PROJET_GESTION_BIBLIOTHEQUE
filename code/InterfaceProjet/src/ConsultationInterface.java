import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class ConsultationInterface extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;
	private int id;

	/**
	 * Launch the application.
	 */
	
public static void main(String [] args) {
	ConsultationInterface o=new ConsultationInterface();
	o.setVisible(true);
}
	/**
	 * Create the frame.
	 */
public DefaultTableModel table() {
	DefaultTableModel table = new DefaultTableModel();
	String [] col= {"ID","ID Exemplaire","ID Document","Date d'emprunt","Date de retour","Type"};
	for(String e:col) {
		table.addColumn(e);
	}
	
	
	
	return table;
	
}
public void ClientId(int id) {
	
	this.id=id;
	
	
}
	public ConsultationInterface() {
		setTitle("Consultation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1300, 750);
		setTitle("Emprunter");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Membre");
		rdbtnNewRadioButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton.setBounds(243, 118, 109, 23);
		rdbtnNewRadioButton.setSelected(true);
		
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
			});
		
		
		JRadioButton rdbtnNonMembre = new JRadioButton("Non Membre");
		rdbtnNonMembre.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		rdbtnNonMembre.setBackground(SystemColor.activeCaption);
		rdbtnNonMembre.setBounds(375, 118, 141, 23);
		ButtonGroup gb= new ButtonGroup();
		gb.add(rdbtnNewRadioButton);
		gb.add(rdbtnNonMembre);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNonMembre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AjouterNonMemebre o = new AjouterNonMemebre();
				o.setVisible(true);
				
				
				
			}
			
		});
		contentPane.add(rdbtnNonMembre);
		ImageIcon r= new ImageIcon(ConsultationInterface.class.getResource("/imageicon/r_icon.jpg"));
		Image image=((ImageIcon) r).getImage();
		image=image.getScaledInstance(70,60, DO_NOTHING_ON_CLOSE);
		r= new ImageIcon(image);
		JButton btnNewButton_1 = new JButton(r);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage l = new WelcomePage();
				l.setVisible(true);
				setVisible(false);
				
			}
		});
		
		
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		btnNewButton_1.setBounds(10, 11, 70, 60);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(617, 78, 657, 607);
		contentPane.add(scrollPane);
		
		table = new JTable(table());
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		
		textField.setBounds(244, 177, 197, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Client ID :");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel.setBounds(79, 177, 88, 29);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(244, 251, 197, 36);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Titre :");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel_1.setBounds(79, 251, 88, 29);
		contentPane.add(lblNewLabel_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(244, 387, 197, 36);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date de consultation :");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(79, 394, 123, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBackground(new Color(51, 204, 0));
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton.setBounds(165, 467, 123, 36);
		contentPane.add(btnNewButton);
		
		JButton btnRetourner = new JButton("Retourner");
		btnRetourner.setBackground(new Color(255, 204, 0));
		btnRetourner.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		btnRetourner.setBounds(343, 467, 123, 36);
		contentPane.add(btnRetourner);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Type du document :");
		lblNewLabel_1_1_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(79, 323, 123, 29);
		contentPane.add(lblNewLabel_1_1_2);
		String []c= {"Livre","CD","Périodique"};
		comboBox = new JComboBox(c);
		comboBox.setBounds(244, 320, 197, 36);
		contentPane.add(comboBox);
		
		JLabel lblTypeDeClient = new JLabel("Type de client :");
		lblTypeDeClient.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblTypeDeClient.setBounds(79, 112, 123, 29);
		contentPane.add(lblTypeDeClient);
		String []c1= {"Location","Consultation sur place ","Pret"};
	}
}
