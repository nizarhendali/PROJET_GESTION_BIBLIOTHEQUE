import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import Traitement.OperationStatistique;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class StatiqueInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatiqueInterface frame = new StatiqueInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StatiqueInterface() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 20, 1200, 723);
		setTitle("Statistique");
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		OperationStatistique info=new OperationStatistique();
		
	
		
		
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Total des CDs",info.nbrTotalDeCD() );
		dataset.setValue("CD Emprunter par Membre",info.nbrCDsEmprunterParLesNonMembres( ));
        dataset.setValue("CD Perdu", info.CDsPerdu());
        dataset.setValue("CD Emprunter par Membre", info.nbrCDsEmprunterParLesMembres());
        dataset.setValue("Total des livres",info.nbrTotalDeLivres() );
        dataset.setValue("Livres Perdu",info.livresPerdu());
        dataset.setValue("Livres emprunter par memebre",info.nbrLivresEmprunterParLesMembres() );
        dataset.setValue("Livres emprunter par non membre",info.nbrLivresEmprunterParLesNonMembres() );
        
       
        
       
        dataset.setValue("Total des Periodiques", info.nbrTotalDePeriodiques());
        dataset.setValue("Periodiques Perdu",info.peridiquePerdu());
        dataset.setValue("Periodiques emprunter par memebre", info.nbrPeriodiquesEmprunterParLesMembres());
        dataset.setValue("Periodiques emprunter par non membre",info.nbrPeriodiquesEmprunterParLesNonMembres());
        
        
        JFreeChart chart = ChartFactory.createPieChart(
            "Statistiques", dataset, true, true, false);
        ChartPanel frame = new ChartPanel(chart);
        
        //frame.setMouseWheelEnabled(true);
        frame.setVisible(true);
        frame.setBounds(100,0,1000, 600);
        contentPane.add(frame);
	}
}
