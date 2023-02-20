package pkMain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Label;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import com.toedter.calendar.JDateChooser;
import pkEnseignant.TempsComplet;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ModifierComplet extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNas;
	private JTextField txtAge;
	private JTextField txtPrenom;
	private JTextField txtNom;
	private JTextField txtPoste;
	private JTextField txtNomDep;
	private JTextField txtNumeroDep;
	private JTextField txtNoCours;
	private JTextField txtNomCours;
	private JTextField txtClAnnuel;
	private JTextField txtNbrAnneeAncien;
	private DateFormat fmt = new SimpleDateFormat("yyyy-M-dd");
	protected static TempsComplet completChamps;
	private JDateChooser txtDateNaissance;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdHomme;
	private JRadioButton rdFemme;
	private JDateChooser txtDateEmbauche;
	private JButton btnModifier;
	private JButton btnAnnuler;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModifierComplet dialog = new ModifierComplet();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModifierComplet() {
		initComponents();
		initChamp();
		initList();
		createEvents();
	}
	
	private void initComponents() {
		setTitle("Modification enseignant temps complet");
		setBounds(100, 100, 856, 492);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		{
			txtNas = new JTextField();
			txtNas.setColumns(10);
			txtNas.setBounds(139, 104, 70, 20);
			panel_14.add(txtNas);
		}
		{
			txtAge = new JTextField();
			txtAge.setEditable(false);
			txtAge.setColumns(10);
			txtAge.setBounds(139, 135, 30, 20);
			panel_14.add(txtAge);
		}
		{
			rdHomme = new JRadioButton("Homme");
			buttonGroup.add(rdHomme);
			rdHomme.setSelected(true);
			rdHomme.setActionCommand("m");
			rdHomme.setBounds(139, 162, 61, 23);
			panel_14.add(rdHomme);
		}
		{
			rdFemme = new JRadioButton("Femme");
			buttonGroup.add(rdFemme);
			rdFemme.setActionCommand("f");
			rdFemme.setBounds(202, 162, 59, 23);
			panel_14.add(rdFemme);
		}
		{
			Label lblSexe = new Label("Sexe:");
			lblSexe.setBounds(91, 162, 42, 22);
			panel_14.add(lblSexe);
		}
		{
			txtPrenom = new JTextField();
			txtPrenom.setColumns(10);
			txtPrenom.setBounds(139, 42, 135, 20);
			panel_14.add(txtPrenom);
		}
		{
			txtNom = new JTextField();
			txtNom.setColumns(10);
			txtNom.setBounds(139, 11, 135, 20);
			panel_14.add(txtNom);
		}
		{
			txtPoste = new JTextField();
			txtPoste.setColumns(10);
			txtPoste.setBounds(481, 11, 70, 20);
			panel_14.add(txtPoste);
		}
		{
			txtDateNaissance = new JDateChooser();
			txtDateNaissance.setDateFormatString("yyyy-MM-dd");
			txtDateNaissance.setBounds(139, 73, 100, 20);
			panel_14.add(txtDateNaissance);
		}
		{
			txtDateEmbauche = new JDateChooser();
			txtDateEmbauche.setDateFormatString("yyyy-MM-dd");
			txtDateEmbauche.setBounds(481, 42, 100, 20);
			panel_14.add(txtDateEmbauche);
		}
		{
			Label lblNom = new Label("Nom:");
			lblNom.setBounds(95, 11, 38, 22);
			panel_14.add(lblNom);
		}
		{
			Label lblPrenom = new Label("Pr\u00E9nom:");
			lblPrenom.setBounds(80, 42, 53, 22);
			panel_14.add(lblPrenom);
		}
		{
			Label lblNas = new Label("NAS:");
			lblNas.setBounds(94, 104, 39, 22);
			panel_14.add(lblNas);
		}
		{
			Label lblAge = new Label("\u00C2ge:");
			lblAge.setBounds(96, 135, 37, 22);
			panel_14.add(lblAge);
		}
		{
			Label lblPoste = new Label("Poste:");
			lblPoste.setBounds(431, 11, 44, 22);
			panel_14.add(lblPoste);
		}
		{
			Label lblDateEmbauche = new Label("Date d'embauche:");
			lblDateEmbauche.setBounds(375, 42, 100, 22);
			panel_14.add(lblDateEmbauche);
		}
		{
			Label lblDateNaissance = new Label("Date de naissance:");
			lblDateNaissance.setBounds(26, 70, 107, 22);
			panel_14.add(lblDateNaissance);
		}
		{
			Label lblNomDep = new Label("Nom d\u00E9partement:");
			lblNomDep.setBounds(375, 104, 100, 22);
			panel_14.add(lblNomDep);
		}
		{
			txtNomDep = new JTextField();
			txtNomDep.setColumns(10);
			txtNomDep.setBounds(481, 104, 176, 20);
			panel_14.add(txtNomDep);
		}
		{
			txtNumeroDep = new JTextField();
			txtNumeroDep.setColumns(10);
			txtNumeroDep.setBounds(481, 73, 30, 20);
			panel_14.add(txtNumeroDep);
		}
		{
			Label lblNoCours = new Label("num\u00E9ro du cours:");
			lblNoCours.setBounds(378, 135, 97, 22);
			panel_14.add(lblNoCours);
		}
		{
			txtNoCours = new JTextField();
			txtNoCours.setColumns(10);
			txtNoCours.setBounds(480, 135, 31, 20);
			panel_14.add(txtNoCours);
		}
		{
			Label lblNumeroDep = new Label("Num\u00E9ro d\u00E9partement:");
			lblNumeroDep.setBounds(358, 73, 117, 22);
			panel_14.add(lblNumeroDep);
		}
		{
			txtNomCours = new JTextField();
			txtNomCours.setColumns(10);
			txtNomCours.setBounds(481, 163, 176, 20);
			panel_14.add(txtNomCours);
		}
		{
			txtClAnnuel = new JTextField();
			txtClAnnuel.setColumns(10);
			txtClAnnuel.setBounds(481, 225, 31, 20);
			panel_14.add(txtClAnnuel);
		}
		{
			txtNbrAnneeAncien = new JTextField();
			txtNbrAnneeAncien.setEditable(false);
			txtNbrAnneeAncien.setColumns(10);
			txtNbrAnneeAncien.setBounds(481, 194, 30, 20);
			panel_14.add(txtNbrAnneeAncien);
		}
		{
			Label lblNomCours = new Label("Nom du cours:");
			lblNomCours.setBounds(395, 162, 80, 22);
			panel_14.add(lblNomCours);
		}
		{
			Label lblClAnnuel = new Label("Cl annuel:");
			lblClAnnuel.setBounds(422, 225, 53, 22);
			panel_14.add(lblClAnnuel);
		}
		{
			Label lblNbrAnneeAncien = new Label("Ann\u00E9e d'anciennet\u00E9:");
			lblNbrAnneeAncien.setBounds(368, 194, 107, 22);
			panel_14.add(lblNbrAnneeAncien);
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_14, GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_14, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModifier = new JButton("Modifier");
				btnModifier.setActionCommand("OK");
				buttonPane.add(btnModifier);
				getRootPane().setDefaultButton(btnModifier);
			}
			{
				btnAnnuler = new JButton("Annuler");
				btnAnnuler.setActionCommand("Cancel");
				buttonPane.add(btnAnnuler);
			}
		}	
		}
	
	private void createEvents() {
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String date1 = fmt.format(txtDateEmbauche.getDate());
					String date2 = fmt.format(txtDateNaissance.getDate());
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
	
					TempsComplet complet = new TempsComplet(txtNom.getText(),
							txtPrenom.getText(), Integer.parseInt(txtNas.getText()),
							Integer.parseInt(txtAge.getText()),
							(buttonGroup.getSelection().getActionCommand()).charAt(0),
							Integer.parseInt(txtPoste.getText()), new GregorianCalendar(y1, m1-1, d1),
							new GregorianCalendar(y2, m2-1, d2), Integer.parseInt(txtNumeroDep.getText()),
							txtNom.getText(), Integer.parseInt(txtNoCours.getText()), txtNomCours.getText(),
							Integer.parseInt(txtNbrAnneeAncien.getText()), Double.parseDouble(txtClAnnuel.getText()));

					GUI.listeEmployer.modifier(GUI.INDEXSUPPRIMER, complet);
					
					GUI.INDEXSUPPRIMER = -1;
			
					initList();
					
					GUI.complet.setVisible(false);
					
				} catch (NumberFormatException | NullPointerException e1) {
					System.err.println("Message d'erreur: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Échec de la modification");
				}
			}
		});
		
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.complet.setVisible(false);
			}
		});
		
		//Calcule l'age en fonction de la date entrée
		txtDateNaissance.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					String date2 = fmt.format(txtDateNaissance.getDate());
				
					int pos12 = date2.indexOf("-");
					int pos22 = date2.indexOf("-", pos12 + 1);
					int y2 = Integer.parseInt(date2.substring(0, pos12));
					int m2 = Integer.parseInt(date2.substring(pos12 + 1, pos22));
					int d2 = Integer.parseInt(date2.substring(pos22 + 1));
	
					LocalDate naissance = LocalDate.of(y2, m2, d2);
					LocalDate maintenant = LocalDate.now();
					long age = ChronoUnit.YEARS.between(naissance, maintenant);
					
					txtAge.setText(String.valueOf(age));
				}
				catch (NullPointerException e) {
				}
			}
		});
		
		//Calcule le nombre d'année d'anciennete en fonction de la date entrée
		txtDateEmbauche.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					String date1 = fmt.format(txtDateEmbauche.getDate());
	
					int pos1 = date1.indexOf("-");
					int pos2 = date1.indexOf("-", pos1 + 1);
					int y1 = Integer.parseInt(date1.substring(0, pos1));
					int m1 = Integer.parseInt(date1.substring(pos1 + 1, pos2));
					int d1 = Integer.parseInt(date1.substring(pos2 + 1));
	
					LocalDate embauche = LocalDate.of(y1, m1, d1);
					LocalDate maintenant = LocalDate.now();
					long annee = ChronoUnit.YEARS.between(embauche, maintenant);
					
					txtNbrAnneeAncien.setText(String.valueOf(annee));
				}
				catch (NullPointerException e) {
				}
			}
		});
	}

	//Rafraichir la liste
	private void initList() {
		GUI.liste.clear();
		GUI.lstEmployerSupprimer.setModel(GUI.liste);
		GUI.lstEmployerModifier.setModel(GUI.liste);
		for (int i = 0; i < GUI.listeEmployer.size(); i++) {
			GUI.liste.add(i, GUI.listeEmployer.lire(i));
		}
	}

	//Initialise les champs avec les valeur de la personne selectionne
	private void initChamp() {
		try {
			completChamps = (TempsComplet) GUI.personnelModifier;
			txtNom.setText(completChamps.getNom());
			txtPrenom.setText(completChamps.getPrenom());
			txtNas.setText(String.valueOf(completChamps.getNas()));
			txtAge.setText(String.valueOf(completChamps.getAge()));
			if (completChamps.getSexe() == 'm') {
				rdHomme.setSelected(true);
			}
			else if (completChamps.getSexe() == 'f') {
				rdFemme.setSelected(true);
			}
			txtPoste.setText(String.valueOf(completChamps.getPoste()));
			Calendar dateNaissance = completChamps.getDateNaissance();
			txtDateNaissance.setCalendar(dateNaissance);
			Calendar dateEmbauche = completChamps.getDateEmbauche();
			txtDateEmbauche.setCalendar(dateEmbauche);
			txtNumeroDep.setText(String.valueOf(completChamps.getNumeroDepartement()));
			txtNomDep.setText(completChamps.getNomDepartement());
			txtNoCours.setText(String.valueOf(completChamps.getNumeroCours()));
			txtNomCours.setText(completChamps.getNomCours());
			txtClAnnuel.setText(String.valueOf(completChamps.getClAnnuel()));
			txtNbrAnneeAncien.setText(String.valueOf(completChamps.getAnneeAnciennete()));
		}
		catch (NullPointerException e) {
			System.err.println("Message d'erreur: " + e);
		}		
	}
}
