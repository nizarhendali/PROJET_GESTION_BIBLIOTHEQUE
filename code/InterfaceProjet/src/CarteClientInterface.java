import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class CarteClientInterface extends JFrame {

	private JPanel contentPane,panel;
	
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CarteClientInterface(int id,String nom ,String prenom,String ville,String tel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 150, 759, 510);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(92, 75, 563, 274);
		contentPane.add(panel);
		panel.setLayout(null);
		ImageIcon logo =new ImageIcon(getClass().getClassLoader().getResource("imageicon/lib_logo.png"));
		Image image1=((ImageIcon) logo).getImage();
		image1=image1.getScaledInstance( 90, 70, DO_NOTHING_ON_CLOSE);
		logo= new ImageIcon(image1);
		ImageIcon icon= new ImageIcon(getClass().getClassLoader().getResource("imageicon/user_icon1.jpg"));
		Image image=((ImageIcon) icon).getImage();
		image=image.getScaledInstance(151, 135, DO_NOTHING_ON_CLOSE);
		icon= new ImageIcon(image);
		
		JLabel PhotoLabel = new JLabel(icon);
		PhotoLabel.setForeground(Color.YELLOW);
		PhotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PhotoLabel.setBounds(25, 77, 151, 135);
		panel.add(PhotoLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel_1.setBounds(211, 112, 73, 23);
		panel.add(lblNewLabel_1);
		
		JLabel NomFiled = new JLabel();
		NomFiled.setForeground(new Color(0, 51, 102));
		NomFiled.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		NomFiled.setBounds(333, 112, 73, 23);
		NomFiled.setText(nom);
		panel.add(NomFiled);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prenom");
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(211, 141, 73, 23);
		panel.add(lblNewLabel_1_2);
		
		JLabel IdField = new JLabel();
		IdField.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		IdField.setBounds(82, 212, 73, 23);
		IdField.setText(String.valueOf(id));
		panel.add(IdField);
		
		JLabel PrenomField = new JLabel();
		PrenomField.setForeground(new Color(0, 51, 102));
		PrenomField.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		PrenomField.setBounds(333, 141, 73, 23);
		PrenomField.setText(prenom);
		panel.add(PrenomField);
		
		JLabel lblNewLabel_1_5 = new JLabel("Carte Client");
		lblNewLabel_1_5.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(298, 41, 243, 36);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ville");
		lblNewLabel_1_2_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(211, 180, 73, 23);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel VilleFiled = new JLabel();
		VilleFiled.setForeground(new Color(0, 51, 102));
		VilleFiled.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		VilleFiled.setBounds(333, 180, 73, 23);
		VilleFiled.setText(ville);
		panel.add(VilleFiled);
		
		JLabel LogoLabel = new JLabel(logo);
		LogoLabel.setBounds(10, 1, 145, 76);
		panel.add(LogoLabel);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Téléphone");
		lblNewLabel_1_2_1_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel_1_2_1_1.setBounds(211, 212, 73, 23);
		panel.add(lblNewLabel_1_2_1_1);
		
		JLabel TelFiled = new JLabel("SETTAT");
		TelFiled.setForeground(new Color(0, 51, 102));
		TelFiled.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		TelFiled.setBounds(333, 212, 73, 23);
		TelFiled.setText(tel);
		panel.add(TelFiled);
		
		JButton btnNewButton = new JButton("Generer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob job=PrinterJob.getPrinterJob();
				job.setJobName("print data");
				job.setPrintable(new Printable () {

					public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
						if(pageIndex > 0) {
							return Printable.NO_SUCH_PAGE;
						}
						Graphics2D g2d=(Graphics2D) graphics;
						g2d.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2);
						g2d.scale(0.7, 0.7);
						panel.paint(g2d);
						return Printable.PAGE_EXISTS;
					}
					
				});
				boolean r=job.printDialog();
				if(r) {
					try {
						job.print();
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null," erreur en printing "+e);
					}
				}
				}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(0, 153, 153));
		btnNewButton.setBounds(310, 376, 133, 41);
		contentPane.add(btnNewButton);
	}

}
