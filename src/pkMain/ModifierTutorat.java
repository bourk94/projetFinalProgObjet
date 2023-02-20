package pkMain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import pkDirection.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import pkDirection.DirectionEtude;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ModifierTutorat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNbrEtuAide;
	private JTextField txtNas;
	private JTextField txtAge;
	private JTextField txtPrenom;
	private JTextField txtNom;
	private JTextField txtPoste;
	private JTextField txtNbrPersSuper;
	private JTextField txtMandat;
	private JTextField txtNbrSuper;
	private DateFormat fmt = new SimpleDateFormat("yyyy-M-dd");
	protected static Tutorat tutoratChamps;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JDateChooser txtDateNaissance;
	private JDateChooser txtDateEmbauche;
	private JButton btnModifier;
	private JButton btnAnnuler;
	private JRadioButton rdHomme;
	private JRadioButton rdFemme;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModifierTutorat dialog = new ModifierTutorat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModifierTutorat() {
		initComponents();
		initChamp();
		initList();
		createEvents();
	}
	
	private void initComponents() {
		setTitle("Modification tutorat");
		setBounds(100, 100, 913, 567);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		
		txtNbrEtuAide = new JTextField();
		txtNbrEtuAide.setColumns(10);
		txtNbrEtuAide.setBounds(481, 135, 30, 20);
		panel_12.add(txtNbrEtuAide);
		
		txtNas = new JTextField();
		txtNas.setColumns(10);
		txtNas.setBounds(139, 104, 70, 20);
		panel_12.add(txtNas);
		
		txtAge = new JTextField();
		txtAge.setEditable(false);
		txtAge.setColumns(10);
		txtAge.setBounds(139, 135, 30, 20);
		panel_12.add(txtAge);
		
		rdHomme = new JRadioButton("Homme");
		buttonGroup.add(rdHomme);
		rdHomme.setSelected(true);
		rdHomme.setActionCommand("m");
		rdHomme.setBounds(139, 162, 61, 23);
		panel_12.add(rdHomme);
		
		rdFemme = new JRadioButton("Femme");
		buttonGroup.add(rdFemme);
		rdFemme.setActionCommand("f");
		rdFemme.setBounds(202, 162, 59, 23);
		panel_12.add(rdFemme);
		
		Label lblSexe = new Label("Sexe:");
		lblSexe.setBounds(91, 162, 42, 22);
		panel_12.add(lblSexe);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(139, 42, 135, 20);
		panel_12.add(txtPrenom);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(139, 11, 135, 20);
		panel_12.add(txtNom);
		
		txtPoste = new JTextField();
		txtPoste.setColumns(10);
		txtPoste.setBounds(481, 11, 70, 20);
		panel_12.add(txtPoste);
		
		Label lblNbrEtuAide = new Label("Nombre d'\u00E9tudiants aid\u00E9s:");
		lblNbrEtuAide.setBounds(337, 135, 138, 22);
		panel_12.add(lblNbrEtuAide);
		
		txtNbrPersSuper = new JTextField();
		txtNbrPersSuper.setColumns(10);
		txtNbrPersSuper.setBounds(481, 73, 30, 20);
		panel_12.add(txtNbrPersSuper);
		
		txtDateNaissance = new JDateChooser();
		txtDateNaissance.setDateFormatString("yyyy-MM-dd");
		txtDateNaissance.setBounds(139, 73, 100, 20);
		panel_12.add(txtDateNaissance);
		
		txtDateEmbauche = new JDateChooser();
		txtDateEmbauche.setDateFormatString("yyyy-MM-dd");
		txtDateEmbauche.setBounds(481, 42, 100, 20);
		panel_12.add(txtDateEmbauche);
		
		Label lblNom = new Label("Nom:");
		lblNom.setBounds(95, 11, 38, 22);
		panel_12.add(lblNom);
		
		Label lblPrenom = new Label("Pr\u00E9nom:");
		lblPrenom.setBounds(80, 42, 53, 22);
		panel_12.add(lblPrenom);
		
		Label lblNas = new Label("NAS:");
		lblNas.setBounds(94, 104, 39, 22);
		panel_12.add(lblNas);
		
		Label lblAge = new Label("\u00C2ge:");
		lblAge.setBounds(96, 135, 37, 22);
		panel_12.add(lblAge);
		
		txtMandat = new JTextField();
		txtMandat.setColumns(10);
		txtMandat.setBounds(481, 104, 180, 20);
		panel_12.add(txtMandat);
		
		Label lblPoste = new Label("Poste:");
		lblPoste.setBounds(431, 11, 44, 22);
		panel_12.add(lblPoste);
		
		Label lblDateEmbauche = new Label("Date d'embauche:");
		lblDateEmbauche.setBounds(375, 42, 100, 22);
		panel_12.add(lblDateEmbauche);
		
		Label lblDateNaissance = new Label("Date de naissance:");
		lblDateNaissance.setBounds(26, 73, 107, 22);
		panel_12.add(lblDateNaissance);
		
		Label lblNbrPersSuper = new Label("Nombre personnes supervis\u00E9:");
		lblNbrPersSuper.setBounds(311, 73, 164, 22);
		panel_12.add(lblNbrPersSuper);
		
		Label lblMandat = new Label("Mandat:");
		lblMandat.setBounds(423, 104, 52, 22);
		panel_12.add(lblMandat);
		
		txtNbrSuper = new JTextField();
		txtNbrSuper.setColumns(10);
		txtNbrSuper.setBounds(481, 166, 30, 20);
		panel_12.add(txtNbrSuper);
		
		Label lblNbrSuper = new Label("Nombre de superviseurs:");
		lblNbrSuper.setBounds(340, 162, 135, 22);
		panel_12.add(lblNbrSuper);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_12, GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_12, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
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

					Tutorat tutorat = new Tutorat(txtNom.getText(),
							txtPrenom.getText(), Integer.parseInt(txtNas.getText()),
							Integer.parseInt(txtAge.getText()),
							(buttonGroup.getSelection().getActionCommand()).charAt(0),
							Integer.parseInt(txtPoste.getText()), new GregorianCalendar(y1, m1-1, d1),
							new GregorianCalendar(y2, m2-1, d2), Integer.parseInt(txtNbrPersSuper.getText()),
							txtMandat.getText(), Integer.parseInt(txtNbrEtuAide.getText()), Integer.parseInt(txtNbrSuper.getText()));

					GUI.listeEmployer.modifier(GUI.INDEXSUPPRIMER, tutorat);
					
					GUI.INDEXSUPPRIMER = -1;
			
					initList();
					
					GUI.tutorat.setVisible(false);
					
				} catch (NumberFormatException | NullPointerException e1) {
					System.err.println("Message d'erreur: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Échec de la modification");
				}
			}
		});
		
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.tutorat.setVisible(false);
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
	//////////////////////////////////////////////////////	
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
			tutoratChamps = (Tutorat) GUI.personnelModifier;
			txtNom.setText(tutoratChamps.getNom());
			txtPrenom.setText(tutoratChamps.getPrenom());
			txtNas.setText(String.valueOf(tutoratChamps.getNas()));
			txtAge.setText(String.valueOf(tutoratChamps.getAge()));
			if (tutoratChamps.getSexe() == 'm') {
				rdHomme.setSelected(true);
			}
			else if (tutoratChamps.getSexe() == 'f') {
				rdFemme.setSelected(true);
			}
			txtPoste.setText(String.valueOf(tutoratChamps.getPoste()));
			Calendar dateNaissance = tutoratChamps.getDateNaissance();
			txtDateNaissance.setCalendar(dateNaissance);
			Calendar dateEmbauche = tutoratChamps.getDateEmbauche();
			txtDateEmbauche.setCalendar(dateEmbauche);
			txtNbrPersSuper.setText(String.valueOf(tutoratChamps.getNombrePersonneSuperviser()));
			txtMandat.setText(tutoratChamps.getMandat());
			txtNbrEtuAide.setText(String.valueOf(tutoratChamps.getNombreEtudiantAide()));
			txtNbrSuper.setText(String.valueOf(tutoratChamps.getNombreSuperviseur()));
		}
		catch (NullPointerException e) {
			System.err.println("Message d'erreur: " + e);
		}
	}	
}
