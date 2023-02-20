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

import pkDirection.Tutorat;
import pkSoutien.PersonnelSoutien;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ModifierSoutien extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtGenreTravail;
	private JTextField txtNas;
	private JTextField txtAge;
	private JTextField txtPrenom;
	private JTextField txtNom;
	private JTextField txtPoste;
	private DateFormat fmt = new SimpleDateFormat("yyyy-M-dd");
	protected static PersonnelSoutien soutienChamps;
	private JRadioButton rdHomme;
	private JRadioButton rdFemme;
	private JButton btnModifier;
	private JButton btnAnnuler;
	private JDateChooser txtDateNaissance;
	private JDateChooser txtDateEmbauche;
	private JRadioButton rdScience;
	private JRadioButton rdHumanite;
	private JRadioButton rdQuartNuit;
	private JRadioButton rdQuartJour;
	private JRadioButton rdQuartSoir;
	private final ButtonGroup buttonGroupSexe = new ButtonGroup();
	private final ButtonGroup buttonGroupPavillon = new ButtonGroup();
	private final ButtonGroup buttonGroupQuartTravail = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModifierSoutien dialog = new ModifierSoutien();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModifierSoutien() {
		initComponents();
		initChamp();
		initList();
		createEvents();
	}

	private void initComponents() {
		setTitle("Modifier personnel de soutien");
		setBounds(100, 100, 846, 482);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		{
			txtGenreTravail = new JTextField();
			txtGenreTravail.setColumns(10);
			txtGenreTravail.setBounds(481, 135, 189, 20);
			panel_15.add(txtGenreTravail);
		}
		{
			txtNas = new JTextField();
			txtNas.setColumns(10);
			txtNas.setBounds(139, 104, 70, 20);
			panel_15.add(txtNas);
		}
		{
			txtAge = new JTextField();
			txtAge.setEditable(false);
			txtAge.setColumns(10);
			txtAge.setBounds(139, 135, 30, 20);
			panel_15.add(txtAge);
		}
		{
			rdHomme = new JRadioButton("Homme");
			buttonGroupSexe.add(rdHomme);
			rdHomme.setSelected(true);
			rdHomme.setActionCommand("m");
			rdHomme.setBounds(139, 162, 61, 23);
			panel_15.add(rdHomme);
		}
		{
			rdFemme = new JRadioButton("Femme");
			buttonGroupSexe.add(rdFemme);
			rdFemme.setActionCommand("f");
			rdFemme.setBounds(202, 162, 59, 23);
			panel_15.add(rdFemme);
		}
		{
			Label lblSexe = new Label("Sexe:");
			lblSexe.setBounds(91, 162, 42, 22);
			panel_15.add(lblSexe);
		}
		{
			txtPrenom = new JTextField();
			txtPrenom.setColumns(10);
			txtPrenom.setBounds(139, 42, 135, 20);
			panel_15.add(txtPrenom);
		}
		{
			txtNom = new JTextField();
			txtNom.setColumns(10);
			txtNom.setBounds(139, 11, 135, 20);
			panel_15.add(txtNom);
		}
		{
			txtPoste = new JTextField();
			txtPoste.setColumns(10);
			txtPoste.setBounds(481, 11, 70, 20);
			panel_15.add(txtPoste);
		}
		{
			Label lblGenreTravail = new Label("Genre de travail:");
			lblGenreTravail.setBounds(386, 135, 89, 22);
			panel_15.add(lblGenreTravail);
		}
		{
			txtDateNaissance = new JDateChooser();
			txtDateNaissance.setDateFormatString("yyyy-MM-dd");
			txtDateNaissance.setBounds(139, 73, 100, 20);
			panel_15.add(txtDateNaissance);
		}
		{
			txtDateEmbauche = new JDateChooser();
			txtDateEmbauche.setDateFormatString("yyyy-MM-dd");
			txtDateEmbauche.setBounds(481, 42, 100, 20);
			panel_15.add(txtDateEmbauche);
		}
		{
			Label lblNom = new Label("Nom:");
			lblNom.setBounds(95, 11, 38, 22);
			panel_15.add(lblNom);
		}
		{
			Label lblPrenom = new Label("Pr\u00E9nom:");
			lblPrenom.setBounds(80, 42, 53, 22);
			panel_15.add(lblPrenom);
		}
		{
			Label lblNas = new Label("NAS:");
			lblNas.setBounds(94, 104, 39, 22);
			panel_15.add(lblNas);
		}
		{
			Label lblAge = new Label("\u00C2ge:");
			lblAge.setBounds(96, 135, 37, 22);
			panel_15.add(lblAge);
		}
		{
			Label lblPoste = new Label("Poste:");
			lblPoste.setBounds(431, 11, 44, 22);
			panel_15.add(lblPoste);
		}
		{
			Label lblDateEmbauche = new Label("Date d'embauche:");
			lblDateEmbauche.setBounds(375, 42, 100, 22);
			panel_15.add(lblDateEmbauche);
		}
		{
			Label lblDateNaissance = new Label("Date de naissance:");
			lblDateNaissance.setBounds(26, 70, 107, 22);
			panel_15.add(lblDateNaissance);
		}
		{
			Label lblQuartTravail = new Label("Quart de travail:");
			lblQuartTravail.setBounds(387, 104, 89, 22);
			panel_15.add(lblQuartTravail);
		}
		{
			Label lblPavillon = new Label("Pavillon:");
			lblPavillon.setBounds(422, 73, 53, 22);
			panel_15.add(lblPavillon);
		}
		{
			rdScience = new JRadioButton("Sciences");
			buttonGroupPavillon.add(rdScience);
			rdScience.setSelected(true);
			rdScience.setActionCommand("Sciences");
			rdScience.setBounds(482, 70, 70, 23);
			panel_15.add(rdScience);
		}
		{
			rdHumanite = new JRadioButton("Humanit\u00E9s");
			buttonGroupPavillon.add(rdHumanite);
			rdHumanite.setActionCommand("Humanités");
			rdHumanite.setBounds(561, 70, 109, 23);
			panel_15.add(rdHumanite);
		}
		{
			rdQuartNuit = new JRadioButton("Minuit \u00E0 8h");
			buttonGroupQuartTravail.add(rdQuartNuit);
			rdQuartNuit.setSelected(true);
			rdQuartNuit.setActionCommand("Minuit à 8h");
			rdQuartNuit.setBounds(482, 103, 77, 23);
			panel_15.add(rdQuartNuit);
		}
		{
			rdQuartJour = new JRadioButton("8h \u00E0 16h");
			buttonGroupQuartTravail.add(rdQuartJour);
			rdQuartJour.setActionCommand("8h à 16h");
			rdQuartJour.setBounds(561, 103, 70, 23);
			panel_15.add(rdQuartJour);
		}
		{
			rdQuartSoir = new JRadioButton("16h \u00E0 minuit");
			buttonGroupQuartTravail.add(rdQuartSoir);
			rdQuartSoir.setActionCommand("16h à minuit");
			rdQuartSoir.setBounds(633, 103, 89, 23);
			panel_15.add(rdQuartSoir);
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(panel_15,
				GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(panel_15,
				GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));
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

					PersonnelSoutien soutien = new PersonnelSoutien(txtNom.getText(), txtPrenom.getText(),
							Integer.parseInt(txtNas.getText()), Integer.parseInt(txtAge.getText()),
							(buttonGroupSexe.getSelection().getActionCommand()).charAt(0),
							Integer.parseInt(txtPoste.getText()), new GregorianCalendar(y1, m1-1, d1),
							new GregorianCalendar(y2, m2-1, d2), buttonGroupPavillon.getSelection().getActionCommand(),
							buttonGroupQuartTravail.getSelection().getActionCommand(), txtGenreTravail.getText());

					GUI.listeEmployer.modifier(GUI.INDEXSUPPRIMER, soutien);

					GUI.INDEXSUPPRIMER = -1;

					initList();

					GUI.soutien.setVisible(false);

				} catch (NumberFormatException | NullPointerException e1) {
					System.err.println("Message d'erreur: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Échec de la modification");
				}
			}
		});

		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.soutien.setVisible(false);
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
				} catch (NullPointerException e) {
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
			soutienChamps = (PersonnelSoutien) GUI.personnelModifier;
			txtNom.setText(soutienChamps.getNom());
			txtPrenom.setText(soutienChamps.getPrenom());
			txtNas.setText(String.valueOf(soutienChamps.getNas()));
			txtAge.setText(String.valueOf(soutienChamps.getAge()));

			if (soutienChamps.getSexe() == 'm') {
				rdHomme.setSelected(true);
			} else if (soutienChamps.getSexe() == 'f') {
				rdFemme.setSelected(true);
			}

			txtPoste.setText(String.valueOf(soutienChamps.getPoste()));
			Calendar dateNaissance = soutienChamps.getDateNaissance();
			txtDateNaissance.setCalendar(dateNaissance);
			Calendar dateEmbauche = soutienChamps.getDateEmbauche();
			txtDateEmbauche.setCalendar(dateEmbauche);

			if (soutienChamps.getPavillon().equals("Sciences")) {
				rdScience.setSelected(true);
			} else if (soutienChamps.getPavillon().equals("Humanités")) {
				rdHumanite.setSelected(true);
			}

			if (soutienChamps.getQuartTravail().equals("8h à 16h")) {
				rdQuartJour.setSelected(true);
			} else if (soutienChamps.getQuartTravail().equals("16h à minuit")) {
				rdQuartSoir.setSelected(true);
			} else if (soutienChamps.getQuartTravail().equals("Minuit à 8h")) {
				rdQuartNuit.setSelected(true);
			}

			txtGenreTravail.setText(soutienChamps.getGenreTravail());
		} catch (NullPointerException e) {
			System.err.println("Message d'erreur: " + e);
		}
	}
}
