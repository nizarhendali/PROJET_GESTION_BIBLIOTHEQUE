import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class WelcomePage extends JFrame {

	private JPanel contentPane;
	private JPanel PanelWelcome;
	/**
	 * Launch the application.
	 */
	
public static void main(String [] arg) {
	

	WelcomePage frame= new WelcomePage();
	frame.setVisible(true);
}
	/**
	 * Create the frame.
	 */
	public ImageIcon Resize(ImageIcon c,int w,int h) {
		Image image=((ImageIcon) c).getImage();
		image=image.getScaledInstance(w, h, DO_NOTHING_ON_CLOSE);
		c= new ImageIcon(image);
		return c;
	}
	public WelcomePage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,0,1178, 719);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		ImageIcon icon ;
		icon= new ImageIcon(getClass().getClassLoader().getResource("imageicon/user_icon1.jpg"));
		icon=Resize(icon,160, 100);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon logo =new ImageIcon(getClass().getClassLoader().getResource("imageicon/lib_logo1.jpg"));
		logo=Resize(logo,100, 70);
		ImageIcon icon_dec =new ImageIcon(getClass().getClassLoader().getResource("imageicon/dec_icon.png"));
		icon_dec=Resize(icon_dec,68, 51);
		ImageIcon icon_doc =new ImageIcon(getClass().getClassLoader().getResource("imageicon/doc_icon.jpg"));
		icon_doc=Resize(icon_doc,160,100);
		ImageIcon icon_res =new ImageIcon(getClass().getClassLoader().getResource("imageicon/reserv_icon.jpg"));
		icon_res=Resize(icon_res,200,130);
		ImageIcon icon_stat =new ImageIcon(getClass().getClassLoader().getResource("imageicon/statique_icon.jpg"));
		icon_stat=Resize(icon_stat,200,130);
		ImageIcon icon_consu =new ImageIcon(getClass().getClassLoader().getResource("imageicon/consu_icon.jpg"));
		icon_consu=Resize(icon_consu,200,130);
		ImageIcon icon_emp =new ImageIcon(getClass().getClassLoader().getResource("imageicon/emp_icon.jpg"));
		icon_emp=Resize(icon_emp,200,130);
		
		PanelWelcome = new JPanel();
		PanelWelcome.setBackground(SystemColor.activeCaption);
		PanelWelcome.setBounds(0, 0, 1284, 711);
		PanelWelcome.setVisible(true);
		contentPane.add(PanelWelcome);
		PanelWelcome.setLayout(null);
		
		JButton BtnBarUser = new JButton(icon);
		BtnBarUser.setBounds(122, 167, 238, 164);
		PanelWelcome.add(BtnBarUser);
		BtnBarUser.setBackground(new Color(0, 153, 153));
		
		
		
		BtnBarUser.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		
		JButton BtnDocuments = new JButton(icon_doc);
		BtnDocuments.setBounds(835, 167, 238, 164);
		PanelWelcome.add(BtnDocuments);
		BtnDocuments.setBackground(new Color(0, 153, 153));
		BtnDocuments.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		
		JButton BtnReservation = new JButton(icon_res);
		BtnReservation.setBounds(498, 167, 238, 164);
		PanelWelcome.add(BtnReservation);
		BtnReservation.setBackground(new Color(0, 153, 153));
		BtnReservation.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		
		JButton BtnStatique = new JButton(icon_stat);
		BtnStatique.setBounds(122, 399, 238, 164);
		PanelWelcome.add(BtnStatique);
		BtnStatique.setBackground(new Color(0, 153, 153));
		BtnStatique.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		JButton Btndeconnect = new JButton(icon_dec);
		Btndeconnect.setBounds(10, 621, 68, 51);
		PanelWelcome.add(Btndeconnect);
		
		JLabel LabelLogo = new JLabel(logo);
		LabelLogo.setBounds(10, 11, 238, 71);
		PanelWelcome.add(LabelLogo);
		
		JLabel lblNewLabel = new JLabel("Clients");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblNewLabel.setBounds(184, 335, 120, 32);
		PanelWelcome.add(lblNewLabel);
		
		JLabel lblStatistique = new JLabel("Statistique");
		lblStatistique.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistique.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblStatistique.setBounds(184, 566, 120, 32);
		PanelWelcome.add(lblStatistique);
		
		JLabel lblConsultation = new JLabel("Emprunter");
		lblConsultation.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultation.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblConsultation.setBounds(559, 566, 120, 32);
		PanelWelcome.add(lblConsultation);
		
		JLabel lblReservation = new JLabel("Reservation");
		lblReservation.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservation.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblReservation.setBounds(559, 335, 120, 32);
		PanelWelcome.add(lblReservation);
		
		JLabel lblDocuments = new JLabel("Documents");
		lblDocuments.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocuments.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblDocuments.setBounds(897, 335, 120, 32);
		PanelWelcome.add(lblDocuments);
		
		JButton BtnEmprunter = new JButton(icon_emp);
		BtnEmprunter.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		BtnEmprunter.setBackground(new Color(0, 153, 153));
		BtnEmprunter.setBounds(498, 399, 238, 164);
		PanelWelcome.add(BtnEmprunter);
		
		BtnEmprunter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EmprunterInterface i= new EmprunterInterface();
				i.setVisible(true);
				setVisible(false);
				
			}
			
		});
		Btndeconnect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				LoginInterface l = new LoginInterface();
				l.setVisible(true);
				setVisible(false);
				
			}
			
		});
		BtnReservation.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ReservationInterface l = new ReservationInterface();
				l.setVisible(true);
				setVisible(false);
				
			}
			
		});
		BtnDocuments.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				DocumentInterface d= new DocumentInterface();
				setVisible(false);
				d.setVisible(true);
				
				
			}
			
		});
		BtnBarUser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MembresInterface l=new MembresInterface();
				l.setVisible(true);
				setVisible(false);
				
			}
			
		});
		BtnStatique.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				StatiqueInterface l = new StatiqueInterface();
				l.setVisible(true);
				
				
			}
			
		});
		
	}
}
