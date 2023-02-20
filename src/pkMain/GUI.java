package pkMain;

//Alexandre Bourque 2191473
//PROJET SYNTHESE
//GUI

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import pkClassSpecial.BDEmployer;
import pkDirection.DirectionEtude;
import pkDirection.DirectionInformatique;
import pkDirection.Tutorat;
import pkEnseignant.TempsComplet;
import pkEnseignant.TempsPartiel;
import pkMembrePersonnel.MembrePersonnel;
import pkSoutien.PersonnelSoutien;

public class GUI extends JFrame {

	/**
	 * 
	 */
///////////////////////////////////////////////////////////////////////////////
/////// Array list
///////////////////////////////////////////////////////////////////////////////
	protected static MembrePersonnel donnees[] = {
			new DirectionEtude("Davis", "Alex", 123456789, 20, 'm', 1, new GregorianCalendar(2020, 01, 03),
					new GregorianCalendar(2002, 01, 01), 5, "Directeur", 1),
			new DirectionEtude("Scott", "Alexe", 223456789, 21, 'f', 2, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(2001, 01, 01), 10, "Directrice", 2),
			new DirectionEtude("Jobs", "Steve", 323456789, 22, 'm', 3, new GregorianCalendar(2020, 01, 02),
					new GregorianCalendar(2000, 01, 01), 3, "Directeur", 1),
			new DirectionEtude("Vincent", "Vincent", 423456789, 23, 'm', 4, new GregorianCalendar(2020, 0, 01),
					new GregorianCalendar(1999, 01, 01), 5, "Directeur", 2),

			new DirectionInformatique("Bourk", "Bob", 523456789, 24, 'm', 5, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(1998, 01, 01), 5, "Directeur", 1),
			new DirectionInformatique("Philips", "George", 623456789, 25, 'm', 6, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(1997, 01, 01), 5, "Directeur", 1),
			new DirectionInformatique("Torvals", "Linus", 723456789, 26, 'm', 7, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(1996, 01, 01), 5, "Directeur", 1),
			new DirectionInformatique("Gates", "Bill", 823456789, 27, 'm', 8, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(1995, 01, 01), 5, "Directeur", 1),

			new Tutorat("Chan", "Jackie", 923456789, 20, 'm', 9, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(2002, 01, 01), 5, "Tutorat", 1, 1),
			new Tutorat("Lee", "Bruce", 113456789, 20, 'm', 10, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(2002, 01, 01), 5, "Tutorat", 1, 1),
			new Tutorat("Norris", "Chuck", 133456789, 20, 'm', 11, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(2002, 01, 01), 5, "Tutorat", 1, 1),
			new Tutorat("Skywalker", "Luke", 143456789, 20, 'm', 12, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(2002, 01, 01), 5, "Tutorat", 1, 1),

			new TempsComplet("Faucher", "Alexis", 928416789, 20, 'm', 13, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(2002, 01, 01), 1, "Informatique", 1, "prog", 2, 80),
			new TempsComplet("Brouillette", "Nicolas", 923518789, 20, 'm', 14, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(2002, 01, 01), 1, "tech po", 1, "radar", 2, 80),
			new TempsComplet("Thibault", "Fannie", 154856789, 20, 'f', 15, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(2002, 01, 01), 1, "philo", 1, "philo 2", 2, 80),
			new TempsComplet("Thibeau", "Maxime", 923455149, 20, 'm', 16, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(2002, 01, 01), 1, "français", 1, "littérature", 2, 80),

			new TempsPartiel("Lafontaine", "Marco", 921586854, 30, 'm', 17, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(1992, 01, 01), 1, "Informatique", 1, "prog", 2, "hiver"),
			new TempsPartiel("Trudeau", "Alexis", 945289439, 30, 'm', 18, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(1992, 01, 01), 1, "tech po", 1, "radar", 2, "hiver"),
			new TempsPartiel("Beaulieu", "Philippe", 532356789, 30, 'm', 19, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(1992, 01, 01), 1, "philo", 1, "philo 1", 2, "hiver"),
			new TempsPartiel("Isabelle", "René", 854256951, 30, 'm', 20, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(1992, 01, 01), 1, "français", 1, "littérature", 2, "hiver"),

			new PersonnelSoutien("Boucher", "Alex", 854564951, 30, 'm', 21, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(1992, 01, 01), "Sciences", "8h à 16h", "Soutenir la science"),
			new PersonnelSoutien("Boulanger", "Antony", 235456951, 30, 'm', 22, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(1992, 01, 01), "Humanités", "8h à 16h", "Soutenir l'humanité"),
			new PersonnelSoutien("Légarer", "Josuez", 742616951, 30, 'm', 23, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(1992, 01, 01), "Sciences", "8h à 16h", "Soutenir la science"),
			new PersonnelSoutien("Boucher", "Julia", 632146951, 30, 'f', 24, new GregorianCalendar(2020, 01, 01),
					new GregorianCalendar(1992, 01, 01), "Humanités", "8h à 16h", "Soutenir l'humanité") };

	protected static BDEmployer listeEmployer = new BDEmployer(donnees);
	protected static DefaultListModel<Object> liste = new DefaultListModel<Object>();
	static protected int INDEXSUPPRIMER = -1;
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
	private static final long serialVersionUID = 4630934961929633354L;
	private JPanel contentPane;
	private JTextField txtMandatInfo;
	private JTextField txtNbrDepDeserInfo;
	private JTextField txtNasInfo;
	private JTextField txtAgeInfo;
	private final ButtonGroup buttonGroupInfo = new ButtonGroup();
	private JTextField txtNomInfo;
	private JTextField txtPrenomInfo;
	private JTextField txtPosteInfo;
	private JTextField txtNbrPersSuperInfo;
	private JTextField txtNbrServicesOffertsEtude;
	private JTextField txtNasEtude;
	private JTextField txtAgeEtude;
	private JTextField txtPosteEtude;
	private JTextField txtNbrPersSuperEtude;
	private JTextField txtMandatEtude;
	private JTextField txtNbrEtuAideTutorat;
	private JTextField txtNasTutorat;
	private JTextField txtAgeTutorat;
	private JTextField txtPrenomTutorat;
	private JTextField txtNomTutorat;
	private JTextField txtPosteTutorat;
	private JTextField txtNbrPersSuperTutorat;
	private JTextField txtMandatTutorat;
	private JTextField txtNoCoursPartiel;
	private JTextField txtNasPartiel;
	private JTextField txtAgePartiel;
	private JTextField txtPrenomPartiel;
	private JTextField txtNomPartiel;
	private JTextField txtPostePartiel;
	private JTextField txtNoDepPartiel;
	private JTextField txtNomDepPartiel;
	private JTextField txtNasComplet;
	private JTextField txtAgeComplet;
	private JTextField txtPrenomComplet;
	private JTextField txtNomComplet;
	private JTextField txtPosteComplet;
	private JTextField txtGenreTravailSoutien;
	private JTextField txtNasSoutien;
	private JTextField txtAgeSoutien;
	private JTextField txtPrenomSoutien;
	private JTextField txtNomSoutien;
	private JTextField txtPosteSoutien;
	private JTextField txtNbrSuperTutorat;
	private JButton btnAjouterInfo;
	private JDateChooser txtDateNaissanceInfo;
	private DateFormat fmt = new SimpleDateFormat("yyyy-M-dd");
	private JDateChooser txtDateEmbaucheInfo;
	private JButton btnAnnulerInfo;
	private final ButtonGroup buttonGroupEtude = new ButtonGroup();
	private final ButtonGroup buttonGroupTutorat = new ButtonGroup();
	private final ButtonGroup buttonGroupPartiel = new ButtonGroup();
	private final ButtonGroup buttonGroupComplet = new ButtonGroup();
	private final ButtonGroup buttonGroupSexeSoutien = new ButtonGroup();
	private JButton btnAjouterEtude;
	private JDateChooser txtDateEmbaucheEtude;
	private JDateChooser txtDateNaissanceEtude;
	private JTextField txtNomEtude;
	private JTextField txtPrenomEtude;
	private JButton btnAnnulerEtude;
	private JButton btnAjouterTutorat;
	private JButton btnAnnulerTutorat;
	private JDateChooser txtDateEmbaucheTutorat;
	private JDateChooser txtDateNaissanceTutorat;
	private JDateChooser txtDateEmbauchePartiel;
	private JDateChooser txtDateNaissancePartiel;
	private JButton btnAjouterPartiel;
	private JButton btnAnnulerPartiel;
	private JTextField txtNomCoursPartiel;
	private JTextField txtClSessionPartiel;
	private JTextField txtSessionActuellePartiel;
	private JDateChooser txtDateEmbaucheComplet;
	private JDateChooser txtDateNaissanceComplet;
	private JButton btnAjouterComplet;
	private JButton btnAnnulerComplet;
	private JTextField txtNomDepComplet;
	private JTextField txtNoDepComplet;
	private JTextField txtNoCoursComplet;
	private JTextField txtNomCoursComplet;
	private JTextField txtClSessionComplet;
	private JTextField txtNbrAnneeAncienComplet;
	private final ButtonGroup buttonGroupPavillonSoutien = new ButtonGroup();
	private final ButtonGroup buttonGroupQuartSoutien = new ButtonGroup();
	private JButton btnAjouterSoutien;
	private JButton btnAnnulerSoutien;
	private JDateChooser txtDateNaissanceSoutien;
	private JDateChooser txtDateEmbaucheSoutien;
	private JRadioButton rdHommeInfo;
	private JRadioButton rdFemmeInfo;
	private JRadioButton rdHommeEtude;
	private JRadioButton rdFemmeEtude;
	private JRadioButton rdHommeTutorat;
	private JRadioButton rdFemmeTutorat;
	private JRadioButton rdHommePartiel;
	private JRadioButton rdFemmePartiel;
	private JRadioButton rdHommeComplet;
	private JRadioButton rdFemmeComplet;
	private JRadioButton rdHommeSoutien;
	private JRadioButton rdFemmeSoutien;
	private JRadioButton rdScienceSoutien;
	private JRadioButton rdHumaniteSoutien;
	private JRadioButton rdQuartNuitSoutien;
	private JRadioButton rdQuartJourSoutien;
	private JRadioButton rdQuartSoirSoutien;
	private JScrollPane scrEmployerSupprimer;
	protected static JList lstEmployerSupprimer;
	private JButton btnSupprimer;
	private JButton btnAnnulerSupprimer;
	private JButton btnEnregistrerSupprimer;
	protected static JList lstEmployerModifier;
	private JButton btnModifier;
	protected static MembrePersonnel personnelModifier;
	protected static ModifierInfo modifierInfo;
	protected static ModifierInfo info;
	protected static ModifierEtude etude;
	protected static ModifierTutorat tutorat;
	protected static ModifierComplet complet;
	protected static ModifierPartiel partiel;
	protected static ModifierSoutien soutien;
	private JButton btnModifierAnnuler;
	private JButton btnModifierEnregistrer;
	private JTextField txtRechercheNo;
	private JTextField txtRechercheNom;
	private JButton btnRechercheNo;
	private JTextPane textPaneRecherche;
	protected static MembrePersonnel test;
	private JButton btnRechercherNom;
	private JButton btnRechercheReinitialiser;
	private JButton btnAfficherTrier;
	private JButton btnAfficherReinitialiser;
	private JTextPane textPaneAfficherTrier;
	private JButton btnFichierTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
			listeEmployer.chargerSauvegarde();	
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				listeEmployer.sauvegarder();
			}
		});
		initComponents();
		initListe();
		createEvents();
	}

	//////////////////////////////////////////////////////////////////////////////
	////Initialiser les composantes
	//////////////////////////////////////////////////////////////////////////////
	private void initComponents() {
		setTitle("Projet Synth\u00E8se");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBackground(Color.WHITE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.addTab("Ajouter", null, tabbedPane, null);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Direction de l'informatique", null, panel, null);
		panel.setLayout(null);

		txtNbrDepDeserInfo = new JTextField();
		txtNbrDepDeserInfo.setBounds(481, 135, 30, 20);
		panel.add(txtNbrDepDeserInfo);
		txtNbrDepDeserInfo.setColumns(10);

		txtNasInfo = new JTextField();
		txtNasInfo.setBounds(139, 104, 70, 20);
		panel.add(txtNasInfo);
		txtNasInfo.setColumns(10);

		txtAgeInfo = new JTextField();
		txtAgeInfo.setEditable(false);
		txtAgeInfo.setBounds(139, 135, 30, 20);
		panel.add(txtAgeInfo);
		txtAgeInfo.setColumns(10);

		rdHommeInfo = new JRadioButton("Homme");
		rdHommeInfo.setActionCommand("m");
		rdHommeInfo.setBounds(139, 162, 61, 23);
		buttonGroupInfo.add(rdHommeInfo);
		rdHommeInfo.setSelected(true);
		panel.add(rdHommeInfo);

		rdFemmeInfo = new JRadioButton("Femme");
		rdFemmeInfo.setActionCommand("f");
		rdFemmeInfo.setBounds(202, 162, 59, 23);
		buttonGroupInfo.add(rdFemmeInfo);
		panel.add(rdFemmeInfo);

		Label lblSexeInfo = new Label("Sexe:");
		lblSexeInfo.setBounds(91, 162, 42, 22);
		panel.add(lblSexeInfo);

		txtNomInfo = new JTextField();
		txtNomInfo.setBounds(139, 11, 135, 20);
		panel.add(txtNomInfo);
		txtNomInfo.setColumns(10);

		txtPrenomInfo = new JTextField();
		txtPrenomInfo.setBounds(139, 42, 135, 20);
		panel.add(txtPrenomInfo);
		txtPrenomInfo.setColumns(10);

		txtPosteInfo = new JTextField();
		txtPosteInfo.setBounds(481, 11, 70, 20);
		panel.add(txtPosteInfo);
		txtPosteInfo.setColumns(10);

		Label lblNbrDepDeserInfo = new Label("Nombre d\u00E9partements desservis:");
		lblNbrDepDeserInfo.setBounds(301, 135, 174, 22);
		panel.add(lblNbrDepDeserInfo);

		txtNbrPersSuperInfo = new JTextField();
		txtNbrPersSuperInfo.setBounds(481, 73, 30, 20);
		panel.add(txtNbrPersSuperInfo);
		txtNbrPersSuperInfo.setColumns(10);

		txtDateNaissanceInfo = new JDateChooser();
		txtDateNaissanceInfo.setBounds(139, 73, 100, 20);
		txtDateNaissanceInfo.setDateFormatString("yyyy-MM-dd");
		panel.add(txtDateNaissanceInfo);

		txtDateEmbaucheInfo = new JDateChooser();
		txtDateEmbaucheInfo.setBounds(481, 42, 100, 20);
		txtDateEmbaucheInfo.setDateFormatString("yyyy-MM-dd");
		panel.add(txtDateEmbaucheInfo);

		Label tagNom = new Label("Nom:");
		tagNom.setBounds(91, 11, 38, 22);
		panel.add(tagNom);

		Label lblPrenomInfo = new Label("Pr\u00E9nom:");
		lblPrenomInfo.setBounds(78, 42, 53, 22);
		panel.add(lblPrenomInfo);

		Label tagNas = new Label("NAS:");
		tagNas.setBounds(94, 104, 39, 22);
		panel.add(tagNas);

		Label lblAgeInfo = new Label("\u00C2ge:");
		lblAgeInfo.setBounds(96, 135, 37, 22);
		panel.add(lblAgeInfo);

		txtMandatInfo = new JTextField();
		txtMandatInfo.setBounds(481, 104, 180, 20);
		panel.add(txtMandatInfo);
		txtMandatInfo.setColumns(10);

		Label lblPosteInfo = new Label("Poste:");
		lblPosteInfo.setBounds(431, 11, 44, 22);
		panel.add(lblPosteInfo);

		Label lbDateEmbaucheInfo = new Label("Date d'embauche:");
		lbDateEmbaucheInfo.setBounds(375, 42, 100, 22);
		panel.add(lbDateEmbaucheInfo);

		Label lblDateNaissanceInfo = new Label("Date de naissance:");
		lblDateNaissanceInfo.setBounds(26, 71, 107, 22);
		panel.add(lblDateNaissanceInfo);

		Label lblNbrPersSuperInfo = new Label("Nombre personnes supervis\u00E9:");
		lblNbrPersSuperInfo.setBounds(311, 73, 164, 22);
		panel.add(lblNbrPersSuperInfo);

		Label lblMandatInfo = new Label("Mandat:");
		lblMandatInfo.setBounds(422, 104, 52, 22);
		panel.add(lblMandatInfo);

		btnAjouterInfo = new JButton("Ajouter");
		btnAjouterInfo.setBounds(202, 249, 89, 23);
		panel.add(btnAjouterInfo);

		btnAnnulerInfo = new JButton("Annuler");
		btnAnnulerInfo.setBounds(422, 249, 89, 23);
		panel.add(btnAnnulerInfo);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Direction des \u00E9tudes", null, panel_5, null);

		JPanel panel_11 = new JPanel();

		txtNbrServicesOffertsEtude = new JTextField();
		txtNbrServicesOffertsEtude.setBounds(481, 135, 30, 20);
		txtNbrServicesOffertsEtude.setColumns(10);

		txtNasEtude = new JTextField();
		txtNasEtude.setBounds(139, 104, 70, 20);
		txtNasEtude.setColumns(10);

		txtAgeEtude = new JTextField();
		txtAgeEtude.setEditable(false);
		txtAgeEtude.setBounds(139, 135, 30, 20);
		txtAgeEtude.setColumns(10);

		rdHommeEtude = new JRadioButton("Homme");
		buttonGroupEtude.add(rdHommeEtude);
		rdHommeEtude.setActionCommand("m");
		rdHommeEtude.setBounds(139, 162, 61, 23);
		rdHommeEtude.setSelected(true);

		rdFemmeEtude = new JRadioButton("Femme");
		buttonGroupEtude.add(rdFemmeEtude);
		rdFemmeEtude.setActionCommand("f");
		rdFemmeEtude.setBounds(202, 162, 59, 23);

		Label lblSexeEtude = new Label("Sexe:");
		lblSexeEtude.setBounds(91, 162, 42, 22);

		txtPrenomEtude = new JTextField();
		txtPrenomEtude.setBounds(139, 42, 135, 20);
		txtPrenomEtude.setColumns(10);

		txtNomEtude = new JTextField();
		txtNomEtude.setBounds(139, 11, 135, 20);
		txtNomEtude.setColumns(10);

		txtPosteEtude = new JTextField();
		txtPosteEtude.setBounds(481, 11, 70, 20);
		txtPosteEtude.setColumns(10);

		txtNbrPersSuperEtude = new JTextField();
		txtNbrPersSuperEtude.setBounds(481, 73, 30, 20);
		txtNbrPersSuperEtude.setColumns(10);

		txtDateNaissanceEtude = new JDateChooser();
		txtDateNaissanceEtude.setBounds(139, 73, 100, 20);
		txtDateNaissanceEtude.setDateFormatString("yyyy-MM-dd");

		txtDateEmbaucheEtude = new JDateChooser();
		txtDateEmbaucheEtude.setBounds(481, 42, 100, 20);
		txtDateEmbaucheEtude.setDateFormatString("yyyy-MM-dd");

		Label lblNomEtude = new Label("Nom:");
		lblNomEtude.setBounds(95, 11, 38, 22);

		Label lblPrenomEtude = new Label("Pr\u00E9nom:");
		lblPrenomEtude.setBounds(80, 42, 53, 22);

		Label lblNasEtude = new Label("NAS:");
		lblNasEtude.setBounds(94, 104, 39, 22);

		Label lblAgeEtude = new Label("\u00C2ge:");
		lblAgeEtude.setBounds(96, 135, 37, 22);

		txtMandatEtude = new JTextField();
		txtMandatEtude.setBounds(481, 104, 180, 20);
		txtMandatEtude.setColumns(10);

		Label lblPosteEtude = new Label("Poste:");
		lblPosteEtude.setBounds(431, 11, 44, 22);

		Label lblDateEmbaucheEtude = new Label("Date d'embauche:");
		lblDateEmbaucheEtude.setBounds(375, 42, 100, 22);

		Label lblDateNaissanceEtude = new Label("Date de naissance:");
		lblDateNaissanceEtude.setBounds(26, 70, 107, 22);

		Label lblNbrPersSuperEtude = new Label("Nombre personnes supervis\u00E9:");
		lblNbrPersSuperEtude.setBounds(311, 73, 164, 22);

		Label lblMandatEtude = new Label("Mandat:");
		lblMandatEtude.setBounds(423, 104, 52, 22);

		btnAjouterEtude = new JButton("Ajouter");
		btnAjouterEtude.setBounds(202, 249, 89, 23);

		btnAnnulerEtude = new JButton("Annuler");
		btnAnnulerEtude.setBounds(422, 249, 89, 23);

		Label lblNbrServicesOfferts = new Label("Nombre services offerts:");
		lblNbrServicesOfferts.setBounds(340, 135, 135, 22);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addComponent(panel_11,
				GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addComponent(panel_11,
				GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE));
		panel_11.setLayout(null);
		panel_11.add(txtNbrServicesOffertsEtude);
		panel_11.add(txtNasEtude);
		panel_11.add(txtAgeEtude);
		panel_11.add(rdHommeEtude);
		panel_11.add(rdFemmeEtude);
		panel_11.add(lblSexeEtude);
		panel_11.add(txtPrenomEtude);
		panel_11.add(txtNomEtude);
		panel_11.add(txtPosteEtude);
		panel_11.add(txtNbrPersSuperEtude);
		panel_11.add(txtDateNaissanceEtude);
		panel_11.add(txtDateEmbaucheEtude);
		panel_11.add(lblNomEtude);
		panel_11.add(lblPrenomEtude);
		panel_11.add(lblNasEtude);
		panel_11.add(lblAgeEtude);
		panel_11.add(txtMandatEtude);
		panel_11.add(lblPosteEtude);
		panel_11.add(lblDateEmbaucheEtude);
		panel_11.add(lblDateNaissanceEtude);
		panel_11.add(lblNbrPersSuperEtude);
		panel_11.add(lblMandatEtude);
		panel_11.add(btnAjouterEtude);
		panel_11.add(btnAnnulerEtude);
		panel_11.add(lblNbrServicesOfferts);
		panel_5.setLayout(gl_panel_5);

		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Tutorat", null, panel_6, null);

		JPanel panel_12 = new JPanel();

		txtNbrEtuAideTutorat = new JTextField();
		txtNbrEtuAideTutorat.setColumns(10);

		txtNasTutorat = new JTextField();
		txtNasTutorat.setColumns(10);

		txtAgeTutorat = new JTextField();
		txtAgeTutorat.setEditable(false);
		txtAgeTutorat.setColumns(10);

		rdHommeTutorat = new JRadioButton("Homme");
		buttonGroupTutorat.add(rdHommeTutorat);
		rdHommeTutorat.setActionCommand("m");
		rdHommeTutorat.setSelected(true);

		rdFemmeTutorat = new JRadioButton("Femme");
		buttonGroupTutorat.add(rdFemmeTutorat);
		rdFemmeTutorat.setActionCommand("f");

		Label lblSexeTutorat = new Label("Sexe:");

		txtPrenomTutorat = new JTextField();
		txtPrenomTutorat.setColumns(10);

		txtNomTutorat = new JTextField();
		txtNomTutorat.setColumns(10);

		txtPosteTutorat = new JTextField();
		txtPosteTutorat.setColumns(10);

		Label lblNbrEtuAideTutorat = new Label("Nombre d'\u00E9tudiants aid\u00E9s:");

		txtNbrPersSuperTutorat = new JTextField();
		txtNbrPersSuperTutorat.setColumns(10);

		txtDateNaissanceTutorat = new JDateChooser();
		txtDateNaissanceTutorat.setDateFormatString("yyyy-MM-dd");

		txtDateEmbaucheTutorat = new JDateChooser();
		txtDateEmbaucheTutorat.setDateFormatString("yyyy-MM-dd");

		Label lblNomTutorat = new Label("Nom:");

		Label lblPrenomTutorat = new Label("Pr\u00E9nom:");

		Label lblNasTutorat = new Label("NAS:");

		Label lblAgeTutorat = new Label("\u00C2ge:");

		txtMandatTutorat = new JTextField();
		txtMandatTutorat.setColumns(10);

		Label lblPosteTutorat = new Label("Poste:");

		Label lblDateEmbaucheTutorat = new Label("Date d'embauche:");

		Label lblDateNaissanceTutorat = new Label("Date de naissance:");

		Label lblNbrPersSuperTutorat = new Label("Nombre personnes supervis\u00E9:");

		Label lblMandatTutorat = new Label("Mandat:");

		btnAjouterTutorat = new JButton("Ajouter");

		btnAnnulerTutorat = new JButton("Annuler");

		txtNbrSuperTutorat = new JTextField();
		txtNbrSuperTutorat.setColumns(10);

		Label lblNbrSuperTutorat = new Label("Nombre de superviseurs:");
		GroupLayout gl_panel_12 = new GroupLayout(panel_12);
		gl_panel_12
				.setHorizontalGroup(
						gl_panel_12
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_panel_12.createSequentialGroup().addGap(95)
										.addComponent(lblNomTutorat, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtNomTutorat, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)
										.addGap(157)
										.addComponent(lblPosteTutorat, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtPosteTutorat, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_12.createSequentialGroup().addGap(80)
										.addComponent(lblPrenomTutorat, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtPrenomTutorat, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)
										.addGap(101)
										.addComponent(lblDateEmbaucheTutorat, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtDateEmbaucheTutorat, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_12.createSequentialGroup().addGap(26)
										.addComponent(lblDateNaissanceTutorat, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtDateNaissanceTutorat, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)
										.addGap(72)
										.addComponent(lblNbrPersSuperTutorat, GroupLayout.PREFERRED_SIZE, 164,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtNbrPersSuperTutorat, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_12.createSequentialGroup().addGap(94)
										.addComponent(lblNasTutorat, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtNasTutorat, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE)
										.addGap(214)
										.addComponent(lblMandatTutorat, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtMandatTutorat, GroupLayout.PREFERRED_SIZE, 180,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_12.createSequentialGroup().addGap(96)
										.addComponent(lblAgeTutorat, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtAgeTutorat, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addGap(168)
										.addComponent(lblNbrEtuAideTutorat, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtNbrEtuAideTutorat, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_12.createSequentialGroup().addGap(91)
										.addComponent(lblSexeTutorat, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(rdHommeTutorat).addGap(2).addComponent(rdFemmeTutorat)
										.addGap(79)
										.addComponent(lblNbrSuperTutorat, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtNbrSuperTutorat, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_12.createSequentialGroup().addGap(202)
										.addComponent(btnAjouterTutorat, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addGap(131).addComponent(btnAnnulerTutorat, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)));
		gl_panel_12.setVerticalGroup(gl_panel_12.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_12
				.createSequentialGroup().addGap(11)
				.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPosteTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPosteTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrenomTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrenomTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateEmbaucheTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDateEmbaucheTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDateNaissanceTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDateNaissanceTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNbrPersSuperTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNbrPersSuperTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNasTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNasTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMandatTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMandatTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAgeTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAgeTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNbrEtuAideTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNbrEtuAideTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(5)
				.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSexeTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(rdHommeTutorat).addComponent(rdFemmeTutorat)
						.addComponent(lblNbrSuperTutorat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_12.createSequentialGroup().addGap(4).addComponent(txtNbrSuperTutorat,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(63).addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING).addComponent(btnAjouterTutorat)
						.addComponent(btnAnnulerTutorat))));
		panel_12.setLayout(gl_panel_12);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING).addComponent(panel_12,
				GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE));
		gl_panel_6.setVerticalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING).addComponent(panel_12,
				GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE));
		panel_6.setLayout(gl_panel_6);

		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Enseignant temps partiel", null, panel_7, null);

		JPanel panel_13 = new JPanel();

		txtNoCoursPartiel = new JTextField();
		txtNoCoursPartiel.setColumns(10);

		txtNasPartiel = new JTextField();
		txtNasPartiel.setColumns(10);

		txtAgePartiel = new JTextField();
		txtAgePartiel.setEditable(false);
		txtAgePartiel.setColumns(10);

		rdHommePartiel = new JRadioButton("Homme");
		buttonGroupPartiel.add(rdHommePartiel);
		rdHommePartiel.setActionCommand("m");
		rdHommePartiel.setSelected(true);

		rdFemmePartiel = new JRadioButton("Femme");
		buttonGroupPartiel.add(rdFemmePartiel);
		rdFemmePartiel.setActionCommand("f");

		Label lblSexePartiel = new Label("Sexe:");

		txtPrenomPartiel = new JTextField();
		txtPrenomPartiel.setToolTipText("");
		txtPrenomPartiel.setColumns(10);

		txtNomPartiel = new JTextField();
		txtNomPartiel.setColumns(10);

		txtPostePartiel = new JTextField();
		txtPostePartiel.setColumns(10);

		Label lblNoCoursPartiel = new Label("num\u00E9ro du cours:");

		txtNoDepPartiel = new JTextField();
		txtNoDepPartiel.setColumns(10);

		txtDateNaissancePartiel = new JDateChooser();
		txtDateNaissancePartiel.setDateFormatString("yyyy-MM-dd");

		txtDateEmbauchePartiel = new JDateChooser();
		txtDateEmbauchePartiel.setDateFormatString("yyyy-MM-dd");

		Label lblNomPartiel = new Label("Nom:");

		Label lblPrenomPartiel = new Label("Pr\u00E9nom:");

		Label lblNasPartiel = new Label("NAS:");

		Label lblAgePartiel = new Label("\u00C2ge:");

		txtNomDepPartiel = new JTextField();
		txtNomDepPartiel.setColumns(10);

		Label lblPostePartiel = new Label("Poste:");

		Label lblDateEmbauchePartiel = new Label("Date d'embauche:");

		Label lblDateNaissancePartiel = new Label("Date de naissance:");

		Label lblNomDepPartiel = new Label("Nom d\u00E9partement:");

		btnAjouterPartiel = new JButton("Ajouter");

		btnAnnulerPartiel = new JButton("Annuler");

		Label lblNumeroDepPartiel = new Label("Num\u00E9ro d\u00E9partement:");

		txtNomCoursPartiel = new JTextField();
		txtNomCoursPartiel.setColumns(10);

		txtClSessionPartiel = new JTextField();
		txtClSessionPartiel.setColumns(10);

		txtSessionActuellePartiel = new JTextField();
		txtSessionActuellePartiel.setColumns(10);

		Label lblNomCoursPartiel = new Label("Nom du cours:");

		Label lblClSessionPartiel = new Label("Cl session:");

		Label lblSessionActuellePartiel = new Label("Session actuelle:");
		GroupLayout gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13
				.setHorizontalGroup(
						gl_panel_13
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_panel_13.createSequentialGroup().addGap(95)
										.addComponent(lblNomPartiel, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtNomPartiel, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)
										.addGap(157)
										.addComponent(lblPostePartiel, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtPostePartiel, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_13.createSequentialGroup().addGap(80)
										.addComponent(lblPrenomPartiel, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtPrenomPartiel, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)
										.addGap(101)
										.addComponent(lblDateEmbauchePartiel, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtDateEmbauchePartiel, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_13.createSequentialGroup().addGap(26)
										.addComponent(lblDateNaissancePartiel, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtDateNaissancePartiel, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)
										.addGap(119)
										.addComponent(lblNumeroDepPartiel, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtNoDepPartiel, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_13.createSequentialGroup().addGap(94)
										.addComponent(lblNasPartiel, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtNasPartiel, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE)
										.addGap(166)
										.addComponent(lblNomDepPartiel, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtNomDepPartiel, GroupLayout.PREFERRED_SIZE, 176,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_13.createSequentialGroup().addGap(96)
										.addComponent(lblAgePartiel, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(txtAgePartiel, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addGap(207)
										.addComponent(lblNoCoursPartiel, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtNoCoursPartiel, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_13.createSequentialGroup().addGap(91)
										.addComponent(lblSexePartiel, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(rdHommePartiel).addGap(2).addComponent(rdFemmePartiel)
										.addGap(134)
										.addComponent(lblNomCoursPartiel, GroupLayout.PREFERRED_SIZE, 80,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtNomCoursPartiel, GroupLayout.PREFERRED_SIZE, 176,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_13.createSequentialGroup().addGap(413)
										.addComponent(lblClSessionPartiel, GroupLayout.PREFERRED_SIZE, 62,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtClSessionPartiel, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_13.createSequentialGroup().addGap(386)
										.addComponent(lblSessionActuellePartiel, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtSessionActuellePartiel, GroupLayout.PREFERRED_SIZE,
												176, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_13.createSequentialGroup().addGap(202)
										.addComponent(btnAjouterPartiel, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addGap(140).addComponent(btnAnnulerPartiel, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)));
		gl_panel_13.setVerticalGroup(gl_panel_13.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_13
				.createSequentialGroup().addGap(11)
				.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPostePartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPostePartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrenomPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrenomPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateEmbauchePartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDateEmbauchePartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_13.createSequentialGroup().addGap(3).addComponent(lblDateNaissancePartiel,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_13.createSequentialGroup().addGap(3).addComponent(txtDateNaissancePartiel,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNumeroDepPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_13.createSequentialGroup().addGap(3).addComponent(txtNoDepPartiel,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(9)
				.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNasPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNasPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomDepPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomDepPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAgePartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAgePartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNoCoursPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoCoursPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(5)
				.addGroup(
						gl_panel_13.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSexePartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(rdHommePartiel).addComponent(rdFemmePartiel)
								.addComponent(lblNomCoursPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNomCoursPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addGap(8)
				.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClSessionPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtClSessionPartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSessionActuellePartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSessionActuellePartiel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(61).addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING).addComponent(btnAjouterPartiel)
						.addComponent(btnAnnulerPartiel))));
		panel_13.setLayout(gl_panel_13);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING).addComponent(panel_13,
				GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE));
		gl_panel_7.setVerticalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING).addComponent(panel_13,
				GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE));
		panel_7.setLayout(gl_panel_7);

		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("Enseignant temps complet", null, panel_8, null);

		JPanel panel_14 = new JPanel();

		txtNasComplet = new JTextField();
		txtNasComplet.setColumns(10);

		txtAgeComplet = new JTextField();
		txtAgeComplet.setEditable(false);
		txtAgeComplet.setColumns(10);

		rdHommeComplet = new JRadioButton("Homme");
		buttonGroupComplet.add(rdHommeComplet);
		rdHommeComplet.setActionCommand("m");
		rdHommeComplet.setSelected(true);

		rdFemmeComplet = new JRadioButton("Femme");
		buttonGroupComplet.add(rdFemmeComplet);
		rdFemmeComplet.setActionCommand("f");

		Label lblSexeComplet = new Label("Sexe:");

		txtPrenomComplet = new JTextField();
		txtPrenomComplet.setColumns(10);

		txtNomComplet = new JTextField();
		txtNomComplet.setColumns(10);

		txtPosteComplet = new JTextField();
		txtPosteComplet.setColumns(10);

		txtDateNaissanceComplet = new JDateChooser();
		txtDateNaissanceComplet.setDateFormatString("yyyy-MM-dd");

		txtDateEmbaucheComplet = new JDateChooser();
		txtDateEmbaucheComplet.setDateFormatString("yyyy-MM-dd");

		Label lblNomComplet = new Label("Nom:");

		Label lblPrenomComplet = new Label("Pr\u00E9nom:");

		Label lblNasComplet = new Label("NAS:");

		Label lblAgeComplet = new Label("\u00C2ge:");

		Label lblPosteComplet = new Label("Poste:");

		Label lblDateEmbaucheComplet = new Label("Date d'embauche:");

		Label lblDateNaissanceComplet = new Label("Date de naissance:");

		btnAjouterComplet = new JButton("Ajouter");

		btnAnnulerComplet = new JButton("Annuler");

		Label lblNomDepComplet = new Label("Nom d\u00E9partement:");

		txtNomDepComplet = new JTextField();
		txtNomDepComplet.setColumns(10);

		txtNoDepComplet = new JTextField();
		txtNoDepComplet.setColumns(10);

		Label lblNoCoursComplet = new Label("num\u00E9ro du cours:");

		txtNoCoursComplet = new JTextField();
		txtNoCoursComplet.setColumns(10);

		Label lblNumeroDepComplet = new Label("Num\u00E9ro d\u00E9partement:");

		txtNomCoursComplet = new JTextField();
		txtNomCoursComplet.setColumns(10);

		txtClSessionComplet = new JTextField();
		txtClSessionComplet.setColumns(10);

		txtNbrAnneeAncienComplet = new JTextField();
		txtNbrAnneeAncienComplet.setEditable(false);
		txtNbrAnneeAncienComplet.setColumns(10);

		Label lblNomCoursComplet = new Label("Nom du cours:");

		Label lblClAnnuelComplet = new Label("Cl annuel:");

		Label lblNbrAnneeAncienComplet = new Label("Ann\u00E9e d'anciennet\u00E9:");
		GroupLayout gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14
				.setHorizontalGroup(
						gl_panel_14
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_panel_14.createSequentialGroup().addGap(95)
										.addComponent(lblNomComplet, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtNomComplet, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)
										.addGap(157)
										.addComponent(lblPosteComplet, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtPosteComplet, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_14.createSequentialGroup().addGap(80)
										.addComponent(lblPrenomComplet, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtPrenomComplet, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)
										.addGap(101)
										.addComponent(lblDateEmbaucheComplet, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtDateEmbaucheComplet, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_14.createSequentialGroup().addGap(26)
										.addComponent(lblDateNaissanceComplet, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtDateNaissanceComplet, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)
										.addGap(119)
										.addComponent(lblNumeroDepComplet, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtNoDepComplet, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_14.createSequentialGroup().addGap(94)
										.addComponent(lblNasComplet, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtNasComplet, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE)
										.addGap(166)
										.addComponent(lblNomDepComplet, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtNomDepComplet, GroupLayout.PREFERRED_SIZE, 176,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_14.createSequentialGroup().addGap(96)
										.addComponent(lblAgeComplet, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtAgeComplet, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addGap(209)
										.addComponent(lblNoCoursComplet, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE)
										.addGap(5).addComponent(txtNoCoursComplet, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_14.createSequentialGroup().addGap(91)
										.addComponent(lblSexeComplet, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(rdHommeComplet).addGap(2).addComponent(rdFemmeComplet)
										.addGap(134)
										.addComponent(lblNomCoursComplet, GroupLayout.PREFERRED_SIZE, 80,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtNomCoursComplet, GroupLayout.PREFERRED_SIZE, 176,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_14.createSequentialGroup().addGap(368)
										.addComponent(lblNbrAnneeAncienComplet, GroupLayout.PREFERRED_SIZE, 107,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtNbrAnneeAncienComplet, GroupLayout.PREFERRED_SIZE,
												30, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_14.createSequentialGroup().addGap(422)
										.addComponent(lblClAnnuelComplet, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtClSessionComplet, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_14.createSequentialGroup().addGap(202)
										.addComponent(btnAjouterComplet, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addGap(131).addComponent(btnAnnulerComplet, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)));
		gl_panel_14.setVerticalGroup(gl_panel_14.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_14
				.createSequentialGroup().addGap(11)
				.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPosteComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPosteComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrenomComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrenomComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateEmbaucheComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDateEmbaucheComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDateNaissanceComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_14.createSequentialGroup().addGap(3).addComponent(txtDateNaissanceComplet,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_14.createSequentialGroup().addGap(3).addComponent(lblNumeroDepComplet,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_14.createSequentialGroup().addGap(3).addComponent(txtNoDepComplet,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(9)
				.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNasComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNasComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomDepComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomDepComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAgeComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAgeComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNoCoursComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoCoursComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(5)
				.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSexeComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(rdHommeComplet).addComponent(rdFemmeComplet)
						.addComponent(lblNomCoursComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_14.createSequentialGroup().addGap(1).addComponent(txtNomCoursComplet,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(9)
				.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNbrAnneeAncienComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNbrAnneeAncienComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClAnnuelComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtClSessionComplet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(56).addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING).addComponent(btnAjouterComplet)
						.addComponent(btnAnnulerComplet))));
		panel_14.setLayout(gl_panel_14);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING).addComponent(panel_14,
				GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE));
		gl_panel_8.setVerticalGroup(gl_panel_8.createParallelGroup(Alignment.LEADING).addComponent(panel_14,
				GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE));
		panel_8.setLayout(gl_panel_8);

		JPanel panel_9 = new JPanel();
		tabbedPane.addTab("Personnel de soutien", null, panel_9, null);

		JPanel panel_15 = new JPanel();

		txtGenreTravailSoutien = new JTextField();
		txtGenreTravailSoutien.setColumns(10);

		txtNasSoutien = new JTextField();
		txtNasSoutien.setColumns(10);

		txtAgeSoutien = new JTextField();
		txtAgeSoutien.setEditable(false);
		txtAgeSoutien.setColumns(10);

		rdHommeSoutien = new JRadioButton("Homme");
		buttonGroupSexeSoutien.add(rdHommeSoutien);
		rdHommeSoutien.setActionCommand("m");
		rdHommeSoutien.setSelected(true);

		rdFemmeSoutien = new JRadioButton("Femme");
		buttonGroupSexeSoutien.add(rdFemmeSoutien);
		rdFemmeSoutien.setActionCommand("f");

		Label lblSexeSoutien = new Label("Sexe:");

		txtPrenomSoutien = new JTextField();
		txtPrenomSoutien.setColumns(10);

		txtNomSoutien = new JTextField();
		txtNomSoutien.setColumns(10);

		txtPosteSoutien = new JTextField();
		txtPosteSoutien.setColumns(10);

		Label lblGenreTravailSoutien = new Label("Genre de travail:");

		txtDateNaissanceSoutien = new JDateChooser();
		txtDateNaissanceSoutien.setDateFormatString("yyyy-MM-dd");

		txtDateEmbaucheSoutien = new JDateChooser();
		txtDateEmbaucheSoutien.setDateFormatString("yyyy-MM-dd");

		Label lblNomSoutien = new Label("Nom:");

		Label lblPrenomSoutien = new Label("Pr\u00E9nom:");

		Label lblNasSoutien = new Label("NAS:");

		Label lblAgeSoutien = new Label("\u00C2ge:");

		Label lblPosteSoutien = new Label("Poste:");

		Label lblDateEmbaucheSoutien = new Label("Date d'embauche:");

		Label lblDateNaissanceSoutien = new Label("Date de naissance:");

		Label lblQuartTravailSoutien = new Label("Quart de travail:");

		btnAjouterSoutien = new JButton("Ajouter");

		btnAnnulerSoutien = new JButton("Annuler");

		Label lblPavillonSoutien = new Label("Pavillon:");

		rdScienceSoutien = new JRadioButton("Sciences");
		buttonGroupPavillonSoutien.add(rdScienceSoutien);
		rdScienceSoutien.setActionCommand("Sciences");
		rdScienceSoutien.setSelected(true);

		rdHumaniteSoutien = new JRadioButton("Humanit\u00E9s");
		buttonGroupPavillonSoutien.add(rdHumaniteSoutien);
		rdHumaniteSoutien.setActionCommand("Humanités");

		rdQuartNuitSoutien = new JRadioButton("Minuit \u00E0 8h");
		buttonGroupQuartSoutien.add(rdQuartNuitSoutien);
		rdQuartNuitSoutien.setActionCommand("Minuit à 8h");
		rdQuartNuitSoutien.setSelected(true);

		rdQuartJourSoutien = new JRadioButton("8h \u00E0 16h");
		buttonGroupQuartSoutien.add(rdQuartJourSoutien);
		rdQuartJourSoutien.setActionCommand("8h à 16h");

		rdQuartSoirSoutien = new JRadioButton("16h \u00E0 minuit");
		buttonGroupQuartSoutien.add(rdQuartSoirSoutien);
		rdQuartSoirSoutien.setActionCommand("16h à minuit");
		GroupLayout gl_panel_15 = new GroupLayout(panel_15);
		gl_panel_15
				.setHorizontalGroup(
						gl_panel_15
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_panel_15.createSequentialGroup().addGap(95)
										.addComponent(lblNomSoutien, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtNomSoutien, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)
										.addGap(157)
										.addComponent(lblPosteSoutien, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtPosteSoutien, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_15.createSequentialGroup().addGap(80)
										.addComponent(lblPrenomSoutien, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtPrenomSoutien, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)
										.addGap(101)
										.addComponent(lblDateEmbaucheSoutien, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtDateEmbaucheSoutien, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_15.createSequentialGroup().addGap(26)
										.addComponent(lblDateNaissanceSoutien, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtDateNaissanceSoutien, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)
										.addGap(183)
										.addComponent(lblPavillonSoutien, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(7)
										.addComponent(rdScienceSoutien, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE)
										.addGap(9).addComponent(rdHumaniteSoutien, GroupLayout.PREFERRED_SIZE, 109,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_15.createSequentialGroup().addGap(94)
										.addComponent(lblNasSoutien, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtNasSoutien, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE)
										.addGap(178)
										.addComponent(lblQuartTravailSoutien, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(rdQuartNuitSoutien).addGap(2)
										.addComponent(rdQuartJourSoutien, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE)
										.addGap(2).addComponent(rdQuartSoirSoutien, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_15.createSequentialGroup().addGap(96)
										.addComponent(lblAgeSoutien, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtAgeSoutien, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addGap(217)
										.addComponent(lblGenreTravailSoutien, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtGenreTravailSoutien, GroupLayout.PREFERRED_SIZE, 189,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_15.createSequentialGroup().addGap(91)
										.addComponent(lblSexeSoutien, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(rdHommeSoutien).addGap(2).addComponent(rdFemmeSoutien))
								.addGroup(gl_panel_15.createSequentialGroup().addGap(202)
										.addComponent(btnAjouterSoutien, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addGap(171).addComponent(btnAnnulerSoutien, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)));
		gl_panel_15.setVerticalGroup(gl_panel_15.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_15
				.createSequentialGroup().addGap(11)
				.addGroup(gl_panel_15.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPosteSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPosteSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_panel_15.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrenomSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrenomSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateEmbaucheSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDateEmbaucheSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(gl_panel_15.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDateNaissanceSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_15.createSequentialGroup().addGap(3).addComponent(txtDateNaissanceSoutien,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_15.createSequentialGroup().addGap(3).addComponent(lblPavillonSoutien,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdScienceSoutien).addComponent(rdHumaniteSoutien))
				.addGap(8)
				.addGroup(gl_panel_15.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_15.createSequentialGroup().addGap(1).addComponent(lblNasSoutien,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_15.createSequentialGroup().addGap(1).addComponent(txtNasSoutien,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_15.createSequentialGroup().addGap(1).addComponent(lblQuartTravailSoutien,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdQuartNuitSoutien).addComponent(rdQuartJourSoutien)
						.addComponent(rdQuartSoirSoutien))
				.addGap(9)
				.addGroup(gl_panel_15.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAgeSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAgeSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGenreTravailSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtGenreTravailSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(5)
				.addGroup(gl_panel_15.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSexeSoutien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(rdHommeSoutien).addComponent(rdFemmeSoutien))
				.addGap(79).addGroup(gl_panel_15.createParallelGroup(Alignment.LEADING).addComponent(btnAjouterSoutien)
						.addComponent(btnAnnulerSoutien))));
		panel_15.setLayout(gl_panel_15);
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(gl_panel_9.createParallelGroup(Alignment.LEADING).addComponent(panel_15,
				GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE));
		gl_panel_9.setVerticalGroup(gl_panel_9.createParallelGroup(Alignment.LEADING).addComponent(panel_15,
				GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE));
		panel_9.setLayout(gl_panel_9);

		JPanel panel_1 = new JPanel();
		tabbedPane_2.addTab("Supprimer", null, panel_1, null);

		scrEmployerSupprimer = new JScrollPane();

		btnSupprimer = new JButton("Supprimer");

		btnAnnulerSupprimer = new JButton("Annuler");

		btnEnregistrerSupprimer = new JButton("Enregistrer");

		lstEmployerSupprimer = new JList();
		scrEmployerSupprimer.setViewportView(lstEmployerSupprimer);
		lstEmployerSupprimer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(237).addComponent(btnSupprimer).addGap(18)
						.addComponent(btnAnnulerSupprimer).addGap(98).addComponent(btnEnregistrerSupprimer))
				.addComponent(scrEmployerSupprimer, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE));
		gl_panel_1
				.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_panel_1.createSequentialGroup()
								.addComponent(scrEmployerSupprimer, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
								.addGap(18)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(btnSupprimer)
										.addComponent(btnAnnulerSupprimer).addComponent(btnEnregistrerSupprimer))
								.addGap(29)));
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		tabbedPane_2.addTab("Modifier", null, panel_2, null);

		JScrollPane scrEmployerModifier = new JScrollPane();

		btnModifier = new JButton("Modifier");

		btnModifierAnnuler = new JButton("Annuler");

		btnModifierEnregistrer = new JButton("Enregistrer");

		lstEmployerModifier = new JList();
		lstEmployerModifier.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrEmployerModifier.setViewportView(lstEmployerModifier);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrEmployerModifier, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(202).addComponent(btnModifier).addGap(28)
						.addComponent(btnModifierAnnuler).addGap(140).addComponent(btnModifierEnregistrer)));
		gl_panel_2
				.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(scrEmployerModifier, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
								.addGap(18)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(btnModifier)
										.addComponent(btnModifierAnnuler).addComponent(btnModifierEnregistrer))
								.addGap(72)));
		panel_2.setLayout(gl_panel_2);
		getContentPane().setLayout(new FlowLayout());

		JPanel panel_3 = new JPanel();
		tabbedPane_2.addTab("Rechercher et visualiser", null, panel_3, null);

		textPaneRecherche = new JTextPane();
		textPaneRecherche.setEditable(false);

		txtRechercheNo = new JTextField();
		txtRechercheNo.setColumns(10);

		txtRechercheNom = new JTextField();
		txtRechercheNom.setColumns(10);

		btnRechercheNo = new JButton("Rechercher");

		btnRechercherNom = new JButton("Rechercher");

		Label lblRecherNoEmployer = new Label("Rechercher par num\u00E9ro d'employ\u00E9:");

		Label lblRechercheNom = new Label("Rechercher par nom complet:");

		btnRechercheReinitialiser = new JButton("R\u00E9initialiser");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(textPaneRecherche, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(179)
						.addComponent(lblRecherNoEmployer, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(txtRechercheNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(10).addComponent(btnRechercheNo))
				.addGroup(gl_panel_3.createSequentialGroup().addGap(207)
						.addComponent(lblRechercheNom, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(txtRechercheNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(10).addComponent(btnRechercherNom))
				.addGroup(gl_panel_3.createSequentialGroup().addGap(457).addComponent(btnRechercheReinitialiser,
						GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3
				.createSequentialGroup().addComponent(textPaneRecherche, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
				.addGap(30)
				.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup().addGap(1).addComponent(lblRecherNoEmployer,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup().addGap(1).addComponent(txtRechercheNo,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnRechercheNo))
				.addGap(18)
				.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup().addGap(1).addComponent(lblRechercheNom,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup().addGap(1).addComponent(txtRechercheNom,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnRechercherNom))
				.addGap(11).addComponent(btnRechercheReinitialiser).addGap(76)));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_4 = new JPanel();
		tabbedPane_2.addTab("Afficher et trier", null, panel_4, null);

		JScrollPane scrollPane = new JScrollPane();

		btnAfficherTrier = new JButton("Afficher/Trier");

		btnAfficherReinitialiser = new JButton("R\u00E9initialiser");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE).addGroup(Alignment.LEADING,
						gl_panel_4.createSequentialGroup().addGap(323).addComponent(btnAfficherTrier).addGap(66)
								.addComponent(btnAfficherReinitialiser).addContainerGap(361, Short.MAX_VALUE)));
		gl_panel_4
				.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE).addGap(20)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAfficherTrier).addComponent(btnAfficherReinitialiser))
								.addGap(31)));

		textPaneAfficherTrier = new JTextPane();
		textPaneAfficherTrier.setEditable(false);
		scrollPane.setViewportView(textPaneAfficherTrier);
		panel_4.setLayout(gl_panel_4);

		JPanel panel_10 = new JPanel();
		tabbedPane_2.addTab("G\u00E9n\u00E9rer fichier txt", null, panel_10, null);

		btnFichierTxt = new JButton("G\u00E9n\u00E9rer");
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(gl_panel_10.createParallelGroup(Alignment.LEADING).addComponent(btnFichierTxt,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE));
		gl_panel_10.setVerticalGroup(gl_panel_10.createParallelGroup(Alignment.LEADING).addComponent(btnFichierTxt,
				GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE));
		panel_10.setLayout(gl_panel_10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_2, GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(tabbedPane_2, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE).addGap(1)));
		contentPane.setLayout(gl_contentPane);
	}

	//////////////////////////////////////////////////////////////////////////////
	////Gestion des evenements
	//////////////////////////////////////////////////////////////////////////////
	private void createEvents() {
		
		//Gestion du bouton ajouter pour la direction informatique
		btnAjouterInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String date1 = fmt.format(txtDateEmbaucheInfo.getDate());
					String date2 = fmt.format(txtDateNaissanceInfo.getDate());
					int pos1 = date1.indexOf("-");
					int pos2 = date1.indexOf("-", pos1 + 1);
					int y1 = Integer.parseInt(date1.substring(0, pos1));
					int m1 = Integer.parseInt(date1.substring(pos1 + 1, pos2));
					int d1 = Integer.parseInt(date1.substring(pos2 + 1));

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					DirectionInformatique directionInfo = new DirectionInformatique(txtNomInfo.getText(),
							txtPrenomInfo.getText(), Integer.parseInt(txtNasInfo.getText()),
							Integer.parseInt(txtAgeInfo.getText()),
							(buttonGroupInfo.getSelection().getActionCommand()).charAt(0),
							Integer.parseInt(txtPosteInfo.getText()), new GregorianCalendar(y1, m1 - 1, d1),
							new GregorianCalendar(y2, m2 - 1, d2), Integer.parseInt(txtNbrPersSuperInfo.getText()),
							txtMandatInfo.getText(), Integer.parseInt(txtNbrDepDeserInfo.getText()));

					listeEmployer.ajouter(directionInfo);

					txtNomInfo.setText("");
					txtPrenomInfo.setText("");
					txtNasInfo.setText("");
					txtAgeInfo.setText("");
					txtPosteInfo.setText("");
					txtNbrPersSuperInfo.setText("");
					txtMandatInfo.setText("");
					txtNbrDepDeserInfo.setText("");
					txtDateEmbaucheInfo.setCalendar(null);
					txtDateNaissanceInfo.setCalendar(null);
					rdHommeInfo.setSelected(true);
					initListe();
					JOptionPane.showMessageDialog(null, "Ajout effectué avec succès");
					
				} catch (NumberFormatException | NullPointerException e1) {
					System.err.println("Message d'erreur: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Échec de l'ajout");
				}
			}
		});
		
		//Gestion du bouton annuler pour la direction informatique
		btnAnnulerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomInfo.setText("");
				txtPrenomInfo.setText("");
				txtNasInfo.setText("");
				txtAgeInfo.setText("");
				txtPosteInfo.setText("");
				txtNbrPersSuperInfo.setText("");
				txtMandatInfo.setText("");
				txtNbrDepDeserInfo.setText("");
				txtDateEmbaucheInfo.setCalendar(null);
				txtDateNaissanceInfo.setCalendar(null);
				rdHommeInfo.setSelected(true);
			}
		});
		
		//Gestion du bouton ajouter pour la direction des études
		btnAjouterEtude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String date1 = fmt.format(txtDateEmbaucheEtude.getDate());
					String date2 = fmt.format(txtDateNaissanceEtude.getDate());
					int pos1 = date1.indexOf("-");
					int pos2 = date1.indexOf("-", pos1 + 1);
					int y1 = Integer.parseInt(date1.substring(0, pos1));
					int m1 = Integer.parseInt(date1.substring(pos1 + 1, pos2));
					int d1 = Integer.parseInt(date1.substring(pos2 + 1));

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					DirectionEtude directionEtude = new DirectionEtude(txtNomEtude.getText(), txtPrenomEtude.getText(),
							Integer.parseInt(txtNasEtude.getText()), Integer.parseInt(txtAgeEtude.getText()),
							(buttonGroupEtude.getSelection().getActionCommand()).charAt(0),
							Integer.parseInt(txtPosteEtude.getText()), new GregorianCalendar(y1, m1 - 1, d1),
							new GregorianCalendar(y2, m2 - 1, d2), Integer.parseInt(txtNbrPersSuperEtude.getText()),
							txtMandatEtude.getText(), Integer.parseInt(txtNbrServicesOffertsEtude.getText()));

					listeEmployer.ajouter(directionEtude);

					txtNomEtude.setText("");
					txtPrenomEtude.setText("");
					txtNasEtude.setText("");
					txtAgeEtude.setText("");
					txtPosteEtude.setText("");
					txtNbrPersSuperEtude.setText("");
					txtMandatEtude.setText("");
					txtNbrServicesOffertsEtude.setText("");
					txtDateEmbaucheEtude.setCalendar(null);
					txtDateNaissanceEtude.setCalendar(null);
					rdHommeEtude.setSelected(true);
					initListe();
					JOptionPane.showMessageDialog(null, "Ajout effectué avec succès");
					
				} catch (NumberFormatException | NullPointerException e1) {
					System.err.println("Message d'erreur: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Échec de l'ajout");
				}
			}
		});

		//Gestion du bouton annuler pour la direction des études
		btnAnnulerEtude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomEtude.setText("");
				txtPrenomEtude.setText("");
				txtNasEtude.setText("");
				txtAgeEtude.setText("");
				txtPosteEtude.setText("");
				txtNbrPersSuperEtude.setText("");
				txtMandatEtude.setText("");
				txtNbrServicesOffertsEtude.setText("");
				txtDateEmbaucheEtude.setCalendar(null);
				txtDateNaissanceEtude.setCalendar(null);
				rdHommeEtude.setSelected(true);
			}
		});

		//Gestion du bouton ajouter pour le tutorat
		btnAjouterTutorat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String date1 = fmt.format(txtDateEmbaucheTutorat.getDate());
					String date2 = fmt.format(txtDateNaissanceTutorat.getDate());
					int pos1 = date1.indexOf("-");
					int pos2 = date1.indexOf("-", pos1 + 1);
					int y1 = Integer.parseInt(date1.substring(0, pos1));
					int m1 = Integer.parseInt(date1.substring(pos1 + 1, pos2));
					int d1 = Integer.parseInt(date1.substring(pos2 + 1));

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					Tutorat tutorat = new Tutorat(txtNomTutorat.getText(), txtPrenomTutorat.getText(),
							Integer.parseInt(txtNasTutorat.getText()), Integer.parseInt(txtAgeTutorat.getText()),
							(buttonGroupTutorat.getSelection().getActionCommand()).charAt(0),
							Integer.parseInt(txtPosteTutorat.getText()), new GregorianCalendar(y1, m1 - 1, d1),
							new GregorianCalendar(y2, m2 - 1, d2), Integer.parseInt(txtNbrPersSuperTutorat.getText()),
							txtMandatTutorat.getText(), Integer.parseInt(txtNbrEtuAideTutorat.getText()),
							Integer.parseInt(txtNbrSuperTutorat.getText()));

					listeEmployer.ajouter(tutorat);

					txtNomTutorat.setText("");
					txtPrenomTutorat.setText("");
					txtNasTutorat.setText("");
					txtAgeTutorat.setText("");
					txtPosteTutorat.setText("");
					txtNbrPersSuperTutorat.setText("");
					txtMandatTutorat.setText("");
					txtNbrEtuAideTutorat.setText("");
					txtNbrSuperTutorat.setText("");
					txtDateEmbaucheTutorat.setCalendar(null);
					txtDateNaissanceTutorat.setCalendar(null);
					rdHommeTutorat.setSelected(true);
					initListe();
					JOptionPane.showMessageDialog(null, "Ajout effectué avec succès");
					
				} catch (NumberFormatException | NullPointerException e1) {
					System.err.println("Message d'erreur: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Échec de l'ajout");
				}
			}
		});

		//Gestion du bouton annuler pour le tutorat
		btnAnnulerTutorat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomTutorat.setText("");
				txtPrenomTutorat.setText("");
				txtNasTutorat.setText("");
				txtAgeTutorat.setText("");
				txtPosteTutorat.setText("");
				txtNbrPersSuperTutorat.setText("");
				txtMandatTutorat.setText("");
				txtNbrEtuAideTutorat.setText("");
				txtNbrSuperTutorat.setText("");
				txtDateEmbaucheTutorat.setCalendar(null);
				txtDateNaissanceTutorat.setCalendar(null);
				rdHommeTutorat.setSelected(true);
			}
		});

		//Gestion du bouton ajouter pour enseignant temps partiel
		btnAjouterPartiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String date1 = fmt.format(txtDateEmbauchePartiel.getDate());
					String date2 = fmt.format(txtDateNaissancePartiel.getDate());
					int pos1 = date1.indexOf("-");
					int pos2 = date1.indexOf("-", pos1 + 1);
					int y1 = Integer.parseInt(date1.substring(0, pos1));
					int m1 = Integer.parseInt(date1.substring(pos1 + 1, pos2));
					int d1 = Integer.parseInt(date1.substring(pos2 + 1));

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					TempsPartiel enseignantPartiel = new TempsPartiel(txtNomPartiel.getText(),
							txtPrenomPartiel.getText(), Integer.parseInt(txtNasPartiel.getText()),
							Integer.parseInt(txtAgePartiel.getText()),
							(buttonGroupPartiel.getSelection().getActionCommand()).charAt(0),
							Integer.parseInt(txtPostePartiel.getText()), new GregorianCalendar(y1, m1 - 1, d1),
							new GregorianCalendar(y2, m2 - 1, d2), Integer.parseInt(txtNoDepPartiel.getText()),
							txtNomDepPartiel.getText(), Integer.parseInt(txtNoCoursPartiel.getText()),
							txtNomCoursPartiel.getText(), Double.parseDouble(txtClSessionPartiel.getText()),
							txtSessionActuellePartiel.getText());

					listeEmployer.ajouter(enseignantPartiel);

					txtNomPartiel.setText("");
					txtPrenomPartiel.setText("");
					txtNasPartiel.setText("");
					txtAgePartiel.setText("");
					txtPostePartiel.setText("");
					txtNoDepPartiel.setText("");
					txtNomDepPartiel.setText("");
					txtNoCoursPartiel.setText("");
					txtNomCoursPartiel.setText("");
					txtClSessionPartiel.setText("");
					txtSessionActuellePartiel.setText("");
					txtDateEmbauchePartiel.setCalendar(null);
					txtDateNaissancePartiel.setCalendar(null);
					rdHommePartiel.setSelected(true);
					initListe();
					JOptionPane.showMessageDialog(null, "Ajout effectué avec succès");
					
				} catch (NumberFormatException | NullPointerException e1) {
					System.err.println("Message d'erreur: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Échec de l'ajout");
				}
			}
		});

		//Gestion du bouton annuler pour enseignant temps partiel
		btnAnnulerPartiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomPartiel.setText("");
				txtPrenomPartiel.setText("");
				txtNasPartiel.setText("");
				txtAgePartiel.setText("");
				txtPostePartiel.setText("");
				txtNoDepPartiel.setText("");
				txtNomDepPartiel.setText("");
				txtNoCoursPartiel.setText("");
				txtNomCoursPartiel.setText("");
				txtClSessionPartiel.setText("");
				txtSessionActuellePartiel.setText("");
				txtDateEmbauchePartiel.setCalendar(null);
				txtDateNaissancePartiel.setCalendar(null);
				rdHommePartiel.setSelected(true);
			}
		});

		//Gestion du bouton ajouter pour enseignant temps complet
		btnAjouterComplet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String date1 = fmt.format(txtDateEmbaucheComplet.getDate());
					String date2 = fmt.format(txtDateNaissanceComplet.getDate());
					int pos1 = date1.indexOf("-");
					int pos2 = date1.indexOf("-", pos1 + 1);
					int y1 = Integer.parseInt(date1.substring(0, pos1));
					int m1 = Integer.parseInt(date1.substring(pos1 + 1, pos2));
					int d1 = Integer.parseInt(date1.substring(pos2 + 1));

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					TempsComplet enseignantComplet = new TempsComplet(txtNomComplet.getText(),
							txtPrenomComplet.getText(), Integer.parseInt(txtNasComplet.getText()),
							Integer.parseInt(txtAgeComplet.getText()),
							(buttonGroupComplet.getSelection().getActionCommand()).charAt(0),
							Integer.parseInt(txtPosteComplet.getText()), new GregorianCalendar(y1, m1 - 1, d1),
							new GregorianCalendar(y2, m2 - 1, d2), Integer.parseInt(txtNoDepComplet.getText()),
							txtNomDepComplet.getText(), Integer.parseInt(txtNoCoursComplet.getText()),
							txtNomCoursComplet.getText(), Integer.parseInt(txtNbrAnneeAncienComplet.getText()),
							Double.parseDouble(txtClSessionComplet.getText()));

					listeEmployer.ajouter(enseignantComplet);

					txtNomComplet.setText("");
					txtPrenomComplet.setText("");
					txtNasComplet.setText("");
					txtAgeComplet.setText("");
					txtPosteComplet.setText("");
					txtNoDepComplet.setText("");
					txtNomDepComplet.setText("");
					txtNoCoursComplet.setText("");
					txtNomCoursComplet.setText("");
					txtClSessionComplet.setText("");
					txtNbrAnneeAncienComplet.setText("");
					txtDateEmbaucheComplet.setCalendar(null);
					txtDateNaissanceComplet.setCalendar(null);
					rdHommeComplet.setSelected(true);
					initListe();
					JOptionPane.showMessageDialog(null, "Ajout effectué avec succès");

				} catch (NumberFormatException | NullPointerException e1) {
					System.err.println("Message d'erreur: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Échec de l'ajout");
				}
			}
		});

		//Gestion du bouton annuler pour enseignant temps complet
		btnAnnulerComplet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomComplet.setText("");
				txtPrenomComplet.setText("");
				txtNasComplet.setText("");
				txtAgeComplet.setText("");
				txtPosteComplet.setText("");
				txtNoDepComplet.setText("");
				txtNomDepComplet.setText("");
				txtNoCoursComplet.setText("");
				txtNomCoursComplet.setText("");
				txtClSessionComplet.setText("");
				txtNbrAnneeAncienComplet.setText("");
				txtDateEmbaucheComplet.setCalendar(null);
				txtDateNaissanceComplet.setCalendar(null);
				rdHommeComplet.setSelected(true);
			}
		});

		//Gestion du bouton ajouter pour le personnel de soutien
		btnAjouterSoutien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String date1 = fmt.format(txtDateEmbaucheSoutien.getDate());
					String date2 = fmt.format(txtDateNaissanceSoutien.getDate());
					int pos1 = date1.indexOf("-");
					int pos2 = date1.indexOf("-", pos1 + 1);
					int y1 = Integer.parseInt(date1.substring(0, pos1));
					int m1 = Integer.parseInt(date1.substring(pos1 + 1, pos2));
					int d1 = Integer.parseInt(date1.substring(pos2 + 1));

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					PersonnelSoutien soutien = new PersonnelSoutien(txtNomSoutien.getText(), txtPrenomSoutien.getText(),
							Integer.parseInt(txtNasSoutien.getText()), Integer.parseInt(txtAgeSoutien.getText()),
							(buttonGroupSexeSoutien.getSelection().getActionCommand()).charAt(0),
							Integer.parseInt(txtPosteSoutien.getText()), new GregorianCalendar(y1, m1 - 1, d1),
							new GregorianCalendar(y2, m2 - 1, d2),
							buttonGroupPavillonSoutien.getSelection().getActionCommand(),
							buttonGroupQuartSoutien.getSelection().getActionCommand(),
							txtGenreTravailSoutien.getText());

					listeEmployer.ajouter(soutien);

					txtNomSoutien.setText("");
					txtPrenomSoutien.setText("");
					txtNasSoutien.setText("");
					txtAgeSoutien.setText("");
					txtPosteSoutien.setText("");
					txtGenreTravailSoutien.setText("");
					txtDateEmbaucheComplet.setCalendar(null);
					txtDateNaissanceComplet.setCalendar(null);
					rdHommeSoutien.setSelected(true);
					rdQuartNuitSoutien.setSelected(true);
					rdScienceSoutien.setSelected(true);
					initListe();
					JOptionPane.showMessageDialog(null, "Ajout effectué avec succès");

				} catch (NumberFormatException | NullPointerException e1) {
					System.err.println("Message d'erreur: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Échec de l'ajout");
				}
			}
		});

		//Gestion du bouton annuler pour le personnel de soutien
		btnAnnulerSoutien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomSoutien.setText("");
				txtPrenomSoutien.setText("");
				txtNasSoutien.setText("");
				txtAgeSoutien.setText("");
				txtPosteSoutien.setText("");
				txtGenreTravailSoutien.setText("");
				txtDateEmbaucheComplet.setCalendar(null);
				txtDateNaissanceComplet.setCalendar(null);
				rdHommeSoutien.setSelected(true);
				rdQuartNuitSoutien.setSelected(true);
				rdScienceSoutien.setSelected(true);
			}
		});

		//Retourne l'index de la liste supprimer
		lstEmployerSupprimer.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				INDEXSUPPRIMER = lstEmployerSupprimer.getSelectedIndex();
			}
		});

		//Gestion du bouton supprimer
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listeEmployer.supprimer(INDEXSUPPRIMER);
					initListe();
					INDEXSUPPRIMER = -1;
				} catch (IndexOutOfBoundsException e1) {
					System.err.println("Message d'erreur: " + e1);
				}
			}
		});
		
		//Gestion du bouton annuler supprimer qui annule la supression.
		btnAnnulerSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeEmployer.chargerSauvegarde();
				initListe();
				INDEXSUPPRIMER = -1;
			}
		});

		//Enregistre la suppression
		btnEnregistrerSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeEmployer.sauvegarder();
				initListe();
				INDEXSUPPRIMER = -1;
			}
		});

		//Retourne l'index de la liste modifier
		lstEmployerModifier.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				INDEXSUPPRIMER = lstEmployerModifier.getSelectedIndex();
			}
		});

		//Bouton modifier qui ouvre les pages modifier pour chacun des membres du personnels
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					personnelModifier = (MembrePersonnel) listeEmployer.lire(INDEXSUPPRIMER);

					if (personnelModifier instanceof DirectionInformatique) {
						info = new ModifierInfo();
						info.setModal(true);
						info.setVisible(true);
					}

					if (personnelModifier instanceof DirectionEtude) {
						etude = new ModifierEtude();
						etude.setModal(true);
						etude.setVisible(true);
					}

					if (personnelModifier instanceof Tutorat) {
						tutorat = new ModifierTutorat();
						tutorat.setModal(true);
						tutorat.setVisible(true);
					}

					if (personnelModifier instanceof TempsComplet) {
						complet = new ModifierComplet();
						complet.setModal(true);
						complet.setVisible(true);
					}

					if (personnelModifier instanceof TempsPartiel) {
						partiel = new ModifierPartiel();
						partiel.setModal(true);
						partiel.setVisible(true);
					}

					if (personnelModifier instanceof PersonnelSoutien) {
						soutien = new ModifierSoutien();
						soutien.setModal(true);
						soutien.setVisible(true);
					}
					initListe();
				} catch (IndexOutOfBoundsException e1) {
				}
			}
		});

		//Calcule l'age automatiquement pour la direction info
		txtDateNaissanceInfo.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					String date2 = fmt.format(txtDateNaissanceInfo.getDate());

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					LocalDate naissance = LocalDate.of(y2, m2, d2);
					LocalDate maintenant = LocalDate.now();
					long age = ChronoUnit.YEARS.between(naissance, maintenant);

					txtAgeInfo.setText(String.valueOf(age));
				} catch (NullPointerException e) {
				}
			}
		});

		//Calcule l'age automatiquement pour la direction etude
		txtDateNaissanceEtude.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					String date2 = fmt.format(txtDateNaissanceEtude.getDate());

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					LocalDate naissance = LocalDate.of(y2, m2, d2);
					LocalDate maintenant = LocalDate.now();
					long age = ChronoUnit.YEARS.between(naissance, maintenant);

					txtAgeEtude.setText(String.valueOf(age));
				} catch (NullPointerException e) {
				}
			}
		});

		//Calcule l'age automatiquement pour enseignant complet
		txtDateNaissanceComplet.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					String date2 = fmt.format(txtDateNaissanceComplet.getDate());

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					LocalDate naissance = LocalDate.of(y2, m2, d2);
					LocalDate maintenant = LocalDate.now();
					long age = ChronoUnit.YEARS.between(naissance, maintenant);

					txtAgeComplet.setText(String.valueOf(age));
				} catch (NullPointerException e) {
				}
			}
		});

		//Calcule l'age automatiquement pour enseignant partiel
		txtDateNaissancePartiel.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					String date2 = fmt.format(txtDateNaissancePartiel.getDate());

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					LocalDate naissance = LocalDate.of(y2, m2, d2);
					LocalDate maintenant = LocalDate.now();
					long age = ChronoUnit.YEARS.between(naissance, maintenant);

					txtAgePartiel.setText(String.valueOf(age));
				} catch (NullPointerException e) {
				}
			}
		});

		//Calcule l'age automatiquement pour personnel de soutien
		txtDateNaissanceSoutien.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					String date2 = fmt.format(txtDateNaissanceSoutien.getDate());

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					LocalDate naissance = LocalDate.of(y2, m2, d2);
					LocalDate maintenant = LocalDate.now();
					long age = ChronoUnit.YEARS.between(naissance, maintenant);

					txtAgeSoutien.setText(String.valueOf(age));
				} catch (NullPointerException e) {
				}
			}
		});

		//Calcule l'age automatiquement pour tutorat
		txtDateNaissanceTutorat.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					String date2 = fmt.format(txtDateNaissanceTutorat.getDate());

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					LocalDate naissance = LocalDate.of(y2, m2, d2);
					LocalDate maintenant = LocalDate.now();
					long age = ChronoUnit.YEARS.between(naissance, maintenant);

					txtAgeTutorat.setText(String.valueOf(age));
				} catch (NullPointerException e) {
				}
			}
		});

		//Calcule l'annee d'anciennete automatiquement pour enseignant complet
		txtDateEmbaucheComplet.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					String date2 = fmt.format(txtDateEmbaucheComplet.getDate());

					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));

					LocalDate embauche = LocalDate.of(y2, m2, d2);
					LocalDate maintenant = LocalDate.now();
					long annee = ChronoUnit.YEARS.between(embauche, maintenant);

					txtNbrAnneeAncienComplet.setText(String.valueOf(annee));
				} catch (NullPointerException e) {
				}
			}
		});

		//Bouton qui annuler les modifications
		btnModifierAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeEmployer.chargerSauvegarde();
				initListe();
				INDEXSUPPRIMER = -1;
			}
		});

		//Bouton qui enregistre les modifications
		btnModifierEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeEmployer.sauvegarder();
				initListe();
				INDEXSUPPRIMER = -1;
			}
		});

		//Bouton qui recherche un employe avec son numero d'employe
		btnRechercheNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textPaneRecherche.setText("");
					
					int index = 0;
					boolean validation = false;
					for (int ctr = 0; ctr < listeEmployer.size(); ctr++) {
						test = (MembrePersonnel) listeEmployer.lire(ctr);
						if (test.getnumeroEmployer() == (Integer.parseInt(txtRechercheNo.getText()))) {
							index = ctr;
							textPaneRecherche.setText(String.valueOf(listeEmployer.lire(index)));			
							txtRechercheNo.setText("");
							validation = true;
						}
					}
					if (validation == false) {
						textPaneRecherche.setText("Il n'y a pas d'employé avec le numéro suivant: " + txtRechercheNo.getText());
					}
				} catch (NullPointerException | NumberFormatException e1) {
				}
			}
		});

		//Bouton qui recherche un employe avec son nom
		btnRechercherNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textPaneRecherche.setText("");
					int incrementer = 0;
					int ctr;
					int index = -1;
					for (ctr = 0; ctr < listeEmployer.size(); ctr++) {
						test = (MembrePersonnel) listeEmployer.lire(ctr);
						if (String.valueOf((test.getPrenom() + " " + test.getNom()))
								.equalsIgnoreCase(String.valueOf(txtRechercheNom.getText()))) {
							incrementer++;
							index = ctr;
						}
					}
					if (incrementer >= 1) {
						textPaneRecherche.setText(String.valueOf(listeEmployer.lire(index)));
						txtRechercheNom.setText("");
					} else {
						textPaneRecherche.setText("Il n'y a pas d'employé avec le nom suivant: " + txtRechercheNom.getText() + ".");		
						txtRechercheNom.setText("");
					}
				} catch (NullPointerException | NumberFormatException e1) {
				}
			}
		});

		//Bouton qui vide les champs de recherche
		btnRechercheReinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRechercheNo.setText("");
				txtRechercheNom.setText("");
				textPaneRecherche.setText("");
			}
		});

		//Bouton qui tri et affiche la liste
		btnAfficherTrier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneAfficherTrier.setText(String.valueOf(listeEmployer.trierListe()));
				JOptionPane.showMessageDialog(null, "La liste des employés a été triée avec succès");
				initListe();
			}
		});

		//Bouton qui vide le champ de dans la page afficher
		btnAfficherReinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneAfficherTrier.setText("");
			}
		});

		//Bouton qui genere les fichers .txt
		btnFichierTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeEmployer.fichierTxt();
				JOptionPane.showMessageDialog(null, "Les fichiers .txt ont été créé avec succès");
			}
		});
		//////////////////////////////////////////////////////////////////////////
	}

	//////////////////////////////////////////////////////////////////////////////
	////Rafraichir la liste
	//////////////////////////////////////////////////////////////////////////////
	private void initListe() {
		liste.clear();
		lstEmployerSupprimer.setModel(liste);
		lstEmployerModifier.setModel(liste);
		for (int i = 0; i < listeEmployer.size(); i++) {
			liste.add(i, listeEmployer.lire(i));
		}
	}
}
