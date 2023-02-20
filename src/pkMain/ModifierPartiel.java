package pkMain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import pkDirection.Tutorat;
import pkEnseignant.TempsPartiel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ModifierPartiel extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DateFormat fmt = new SimpleDateFormat("yyyy-M-dd");
	private JTextField txtPoste;
	private JTextField txtNom;
	private JTextField txtAge;
	private JTextField txtNomDep;
	private JTextField txtNas;
	private JTextField txtNumeroDep;
	private JTextField txtPrenom;
	private JTextField txtNoCours;
	private JTextField txtNomCours;
	private JTextField txtClSession;
	private JTextField txtSessionActuelle;
	private JDateChooser txtDateNaissance;
	private JDateChooser txtDateEmbauche;
	private JButton btnModifier;
	private JButton btnAnnuler;
	private JRadioButton rdHomme;
	private JRadioButton rdFemme;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	protected static TempsPartiel partielChamps;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModifierPartiel dialog = new ModifierPartiel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModifierPartiel() {
		initComponents();
		initChamp();
		initList();
		createEvents();
	}
	
	private void initComponents() {
		setTitle("Modifier enseignant temps partiel");
		setBounds(100, 100, 771, 444);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		
		Label lblPoste = new Label("Poste:");
		lblPoste.setBounds(431, 11, 44, 22);
		panel_13.add(lblPoste);
		
		txtPoste = new JTextField();
		txtPoste.setColumns(10);
		txtPoste.setBounds(481, 11, 70, 20);
		panel_13.add(txtPoste);
		
		Label lblNom = new Label("Nom:");
		lblNom.setBounds(95, 11, 38, 22);
		panel_13.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(139, 11, 135, 20);
		panel_13.add(txtNom);
		
		Label lblDateEmbauche = new Label("Date d'embauche:");
		lblDateEmbauche.setBounds(375, 42, 100, 22);
		panel_13.add(lblDateEmbauche);
		
		txtDateEmbauche = new JDateChooser();
		txtDateEmbauche.setDateFormatString("yyyy-MM-dd");
		txtDateEmbauche.setBounds(481, 42, 100, 20);
		panel_13.add(txtDateEmbauche);
		
		Label lblAge = new Label("\u00C2ge:");
		lblAge.setBounds(96, 135, 37, 22);
		panel_13.add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setEditable(false);
		txtAge.setColumns(10);
		txtAge.setBounds(143, 135, 28, 20);
		panel_13.add(txtAge);
		
		Label lblNomDep = new Label("Nom d\u00E9partement:");
		lblNomDep.setBounds(375, 104, 100, 22);
		panel_13.add(lblNomDep);
		
		txtNomDep = new JTextField();
		txtNomDep.setColumns(10);
		txtNomDep.setBounds(481, 104, 176, 20);
		panel_13.add(txtNomDep);
		
		Label lblNas = new Label("NAS:");
		lblNas.setBounds(94, 104, 39, 22);
		panel_13.add(lblNas);
		
		txtNas = new JTextField();
		txtNas.setColumns(10);
		txtNas.setBounds(139, 104, 70, 20);
		panel_13.add(txtNas);
		
		txtNumeroDep = new JTextField();
		txtNumeroDep.setColumns(10);
		txtNumeroDep.setBounds(481, 73, 30, 20);
		panel_13.add(txtNumeroDep);
		
		Label lblPrenom = new Label("Pr\u00E9nom:");
		lblPrenom.setBounds(80, 42, 53, 22);
		panel_13.add(lblPrenom);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(139, 42, 135, 20);
		panel_13.add(txtPrenom);
		
		Label lblDateNaissance = new Label("Date de naissance:");
		lblDateNaissance.setBounds(26, 73, 107, 22);
		panel_13.add(lblDateNaissance);
		
		txtDateNaissance = new JDateChooser();
		txtDateNaissance.setDateFormatString("yyyy-MM-dd");
		txtDateNaissance.setBounds(139, 73, 100, 20);
		panel_13.add(txtDateNaissance);
		
		Label lblSexe = new Label("Sexe:");
		lblSexe.setBounds(91, 162, 42, 22);
		panel_13.add(lblSexe);
		
		rdHomme = new JRadioButton("Homme");
		buttonGroup.add(rdHomme);
		rdHomme.setSelected(true);
		rdHomme.setActionCommand("m");
		rdHomme.setBounds(139, 162, 61, 23);
		panel_13.add(rdHomme);
		
		rdFemme = new JRadioButton("Femme");
		buttonGroup.add(rdFemme);
		rdFemme.setActionCommand("f");
		rdFemme.setBounds(202, 162, 59, 23);
		panel_13.add(rdFemme);
		
		Label lblNoCours = new Label("num\u00E9ro du cours:");
		lblNoCours.setBounds(378, 135, 97, 22);
		panel_13.add(lblNoCours);
		
		txtNoCours = new JTextField();
		txtNoCours.setColumns(10);
		txtNoCours.setBounds(481, 135, 31, 20);
		panel_13.add(txtNoCours);
		
		Label lblNumeroDep = new Label("Num\u00E9ro d\u00E9partement:");
		lblNumeroDep.setBounds(358, 70, 117, 22);
		panel_13.add(lblNumeroDep);
		
		txtNomCours = new JTextField();
		txtNomCours.setColumns(10);
		txtNomCours.setBounds(481, 162, 176, 20);
		panel_13.add(txtNomCours);
		
		txtClSession = new JTextField();
		txtClSession.setColumns(10);
		txtClSession.setBounds(481, 193, 31, 20);
		panel_13.add(txtClSession);
		
		txtSessionActuelle = new JTextField();
		txtSessionActuelle.setColumns(10);
		txtSessionActuelle.setBounds(481, 224, 176, 20);
		panel_13.add(txtSessionActuelle);
		
		Label lblNomCours = new Label("Nom du cours:");
		lblNomCours.setBounds(395, 162, 80, 22);
		panel_13.add(lblNomCours);
		
		Label lblClSession = new Label("Cl session:");
		lblClSession.setBounds(413, 193, 62, 22);
		panel_13.add(lblClSession);
		
		Label lblSessionActuelle = new Label("Session actuelle:");
		lblSessionActuelle.setBounds(386, 224, 89, 22);
		panel_13.add(lblSessionActuelle);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
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

					TempsPartiel partiel = new TempsPartiel(txtNom.getText(),
							txtPrenom.getText(), Integer.parseInt(txtNas.getText()),
							Integer.parseInt(txtAge.getText()),
							(buttonGroup.getSelection().getActionCommand()).charAt(0),
							Integer.parseInt(txtPoste.getText()), new GregorianCalendar(y1, m1-1, d1),
							new GregorianCalendar(y2, m2-1, d2), Integer.parseInt(txtNumeroDep.getText()),
							txtNom.getText(), Integer.parseInt(txtNoCours.getText()), txtNomCours.getText(),
							Double.parseDouble(txtClSession.getText()), txtSessionActuelle.getText());

					GUI.listeEmployer.modifier(GUI.INDEXSUPPRIMER, partiel);
					
					GUI.INDEXSUPPRIMER = -1;
			
					initList();
					
					GUI.partiel.setVisible(false);
					
				} catch (NumberFormatException | NullPointerException e1) {
					System.err.println("Message d'erreur: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Échec de la modification");
				}
			}
		});
		
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.partiel.setVisible(false);
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
			partielChamps = (TempsPartiel) GUI.personnelModifier;
			txtNom.setText(partielChamps.getNom());
			txtPrenom.setText(partielChamps.getPrenom());
			txtNas.setText(String.valueOf(partielChamps.getNas()));
			txtAge.setText(String.valueOf(partielChamps.getAge()));
			if (partielChamps.getSexe() == 'm') {
				rdHomme.setSelected(true);
			}
			else if (partielChamps.getSexe() == 'f') {
				rdFemme.setSelected(true);
			}
			txtPoste.setText(String.valueOf(partielChamps.getPoste()));
			Calendar dateNaissance = partielChamps.getDateNaissance();
			txtDateNaissance.setCalendar(dateNaissance);
			Calendar dateEmbauche = partielChamps.getDateEmbauche();
			txtDateEmbauche.setCalendar(dateEmbauche);
			txtNumeroDep.setText(String.valueOf(partielChamps.getNumeroDepartement()));
			txtNomDep.setText(partielChamps.getNomDepartement());
			txtNoCours.setText(String.valueOf(partielChamps.getNumeroCours()));
			txtNomCours.setText(partielChamps.getNomCours());
			txtClSession.setText(String.valueOf(partielChamps.getClSession()));
			txtSessionActuelle.setText(partielChamps.getSessionActuelle());
		}
		catch (NullPointerException e) {
			System.err.println("Message d'erreur: " + e);
		}	
	}
}
