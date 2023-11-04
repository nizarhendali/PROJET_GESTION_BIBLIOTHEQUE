import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Traitement.OperationLogin;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class LoginInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textFielduser_id;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JButton Login;
	private JLabel lblNewLabel_2;
	private JButton PassFo;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public LoginInterface() {
		setBackground(new Color(0, 51, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Application Gestion bibliotheque");
		setBounds(300, 100, 738, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30,204,205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFielduser_id = new JTextField();
		textFielduser_id.setBounds(466, 122, 208, 31);
		contentPane.add(textFielduser_id);
		textFielduser_id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User ID :");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		lblNewLabel.setBounds(359, 122, 86, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		lblPassword.setBounds(359, 179, 86, 31);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(466, 174, 208, 31);
		contentPane.add(passwordField);
		
		lblNewLabel_1 = new JLabel("Bibliothèque municipale");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNewLabel_1.setBounds(469, 57, 243, 54);
		contentPane.add(lblNewLabel_1);
		
		Login = new JButton("Login");
		Login.setForeground(Color.WHITE);
		Login.setBackground(new Color(0, 102, 102));
		Login.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		Login.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					OperationLogin o=new OperationLogin();
					if(o.getUser(textFielduser_id.getText(),passwordField.getText())) {
						WelcomePage l= new WelcomePage();
						l.setVisible(true);
						setVisible(false);
					}
					
					//
				
				else {
					JOptionPane j= new JOptionPane();
					
				j.showMessageDialog(contentPane, "USER_ID or Password pas correct!!");
					
					
					textFielduser_id.setText("");
					passwordField.setText("");
				}
				
			}
			
		});
		Login.setBounds(401, 240, 79, 31);
		contentPane.add(Login);
		
		ImageIcon r= new ImageIcon(ConsultationInterface.class.getResource("/imageicon/icon_li.jpg"));
		Image image=((ImageIcon) r).getImage();
		image=image.getScaledInstance(356,478, DO_NOTHING_ON_CLOSE);
		r= new ImageIcon(image);
		
		lblNewLabel_2 = new JLabel(r);
		lblNewLabel_2.setBounds(0, 0, 356, 478);
		contentPane.add(lblNewLabel_2);
		
		PassFo = new JButton("Mot de passe oublié ?");
		PassFo.setForeground(Color.WHITE);
		PassFo.setHorizontalAlignment(SwingConstants.LEFT);
		PassFo.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		PassFo.setBackground(new Color(0, 102, 102));
		PassFo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MotDePasseOublie o= new MotDePasseOublie();
				o.setVisible(true);
				// TODO Auto-generated method stub
			}
			
		});
		PassFo.setBounds(493, 240, 181, 31);
		contentPane.add(PassFo);
	}
}
