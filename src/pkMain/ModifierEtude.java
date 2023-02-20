package pkMain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Label;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.toedter.calendar.JDateChooser;
import pkDirection.DirectionEtude;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ModifierEtude extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNbrServicesOfferts;
	private JTextField txtNas;
	private JTextField txtAge;
	private JTextField txtPrenom;
	private JTextField txtNom;
	private JTextField txtPoste;
	private JTextField txtNbrPersSuper;
	private JTextField txtMandat;
	private Label lblNom;
	private Label lblPoste;
	private Label lblPrenom;
	private Label lblDateEmbauche;
	private JDateChooser txtDateEmbauche;
	private Label lblDateNaissance;
	private JDateChooser txtDateNaissance;
	private Label lblNbrPersSuper;
	private Label lblNas;
	private Label lblMandat;
	private Label lblAge;
	private Label lblNbrServicesOfferts;
	private Label lblSexe;
	private JRadioButton rdHomme;
	private JRadioButton rdFemme;
	private JPanel panel;
	protected static DirectionEtude etudeChamps;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnModifier;
	private JButton btnAnnuler;
	private DateFormat fmt = new SimpleDateFormat("yyyy-M-dd");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModifierEtude dialog = new ModifierEtude();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModifierEtude() {
		initComponents();
		initChamp();
		initList();
		createEvents();
	}

private void initComponents() {
		setTitle("Modification direction \u00E9tude");
		setBounds(100, 100, 823, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			panel = new JPanel();
			{
				txtNbrServicesOfferts = new JTextField();
				txtNbrServicesOfferts.setColumns(10);
			}
			{
				txtNas = new JTextField();
				txtNas.setColumns(10);
			}
			{
				txtAge = new JTextField();
				txtAge.setEditable(false);
				txtAge.setColumns(10);
			}
			{
				rdHomme = new JRadioButton("Homme");
				buttonGroup.add(rdHomme);
				rdHomme.setSelected(true);
				rdHomme.setActionCommand("m");
			}
			{
				rdFemme = new JRadioButton("Femme");
				buttonGroup.add(rdFemme);
				rdFemme.setActionCommand("f");
			}
			{
				lblSexe = new Label("Sexe:");
			}
			{
				txtPrenom = new JTextField();
				txtPrenom.setColumns(10);
			}
			{
				txtNom = new JTextField();
				txtNom.setColumns(10);
			}
			{
				txtPoste = new JTextField();
				txtPoste.setColumns(10);
			}
			{
				txtNbrPersSuper = new JTextField();
				txtNbrPersSuper.setColumns(10);
			}
			{
				txtDateNaissance = new JDateChooser();
				txtDateNaissance.setDateFormatString("yyyy-MM-dd");
			}
			{
				txtDateEmbauche = new JDateChooser();
				txtDateEmbauche.setDateFormatString("yyyy-MM-dd");
			}
			{
				lblNom = new Label("Nom:");
			}
			{
				lblPrenom = new Label("Pr\u00E9nom:");
			}
			{
				lblNas = new Label("NAS:");
			}
			{
				lblAge = new Label("\u00C2ge:");
			}
			{
				txtMandat = new JTextField();
				txtMandat.setColumns(10);
			}
			{
				lblPoste = new Label("Poste:");
			}
			{
				lblDateEmbauche = new Label("Date d'embauche:");
			}
			{
				lblDateNaissance = new Label("Date de naissance:");
			}
			{
				lblNbrPersSuper = new Label("Nombre personnes supervis\u00E9:");
			}
			{
				lblMandat = new Label("Mandat:");
			}
			{
				lblNbrServicesOfferts = new Label("Nombre services offerts:");
			}
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(95)
						.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addGap(157)
						.addComponent(lblPoste, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(txtPoste, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addGap(246))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(80)
						.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addGap(101)
						.addComponent(lblDateEmbauche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(txtDateEmbauche, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addGap(216))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(26)
						.addComponent(lblDateNaissance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(txtDateNaissance, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGap(72)
						.addComponent(lblNbrPersSuper, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(txtNbrPersSuper, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(94)
						.addComponent(lblNas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(txtNas, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addGap(214)
						.addComponent(lblMandat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(txtMandat, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addGap(136))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(96)
						.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGap(171)
						.addComponent(lblNbrServicesOfferts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(txtNbrServicesOfferts, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(91)
						.addComponent(lblSexe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(rdHomme)
						.addGap(2)
						.addComponent(rdFemme))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(11)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPoste, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtPoste, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(9)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDateEmbauche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtDateEmbauche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(6)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblDateNaissance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(txtDateNaissance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(lblNbrPersSuper, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(txtNbrPersSuper, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(9)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtNas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblMandat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtMandat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(9)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNbrServicesOfferts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtNbrServicesOfferts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(5)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblSexe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdHomme)
							.addComponent(rdFemme)))
			);
			panel.setLayout(gl_panel);
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
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

					DirectionEtude etude = new DirectionEtude(txtNom.getText(),
							txtPrenom.getText(), Integer.parseInt(txtNas.getText()),
							Integer.parseInt(txtAge.getText()),
							(buttonGroup.getSelection().getActionCommand()).charAt(0),
							Integer.parseInt(txtPoste.getText()), new GregorianCalendar(y1, m1-1, d1),
							new GregorianCalendar(y2, m2-1, d2), Integer.parseInt(txtNbrPersSuper.getText()),
							txtMandat.getText(), Integer.parseInt(txtNbrServicesOfferts.getText()));

					GUI.listeEmployer.modifier(GUI.INDEXSUPPRIMER, etude);
					
					GUI.INDEXSUPPRIMER = -1;
			
					initList();
					
					GUI.etude.setVisible(false);
					
				} catch (NumberFormatException | NullPointerException e1) {
					System.err.println("Message d'erreur: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Échec de la modification");
				}
			}
		});
		
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.etude.setVisible(false);
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
			etudeChamps = (DirectionEtude) GUI.personnelModifier;
			txtNom.setText(etudeChamps.getNom());
			txtPrenom.setText(etudeChamps.getPrenom());
			txtNas.setText(String.valueOf(etudeChamps.getNas()));
			txtAge.setText(String.valueOf(etudeChamps.getAge()));
			if (etudeChamps.getSexe() == 'm') {
				rdHomme.setSelected(true);
			}
			else if (etudeChamps.getSexe() == 'f') {
				rdFemme.setSelected(true);
			}
			txtPoste.setText(String.valueOf(etudeChamps.getPoste()));
			Calendar dateNaissance = etudeChamps.getDateNaissance();
			txtDateNaissance.setCalendar(dateNaissance);
			Calendar dateEmbauche = etudeChamps.getDateEmbauche();
			txtDateEmbauche.setCalendar(dateEmbauche);
			txtNbrPersSuper.setText(String.valueOf(etudeChamps.getNombrePersonneSuperviser()));
			txtMandat.setText(etudeChamps.getMandat());
			txtNbrPersSuper.setText(String.valueOf(etudeChamps.getNombrePersonneSuperviser()));
			txtNbrServicesOfferts.setText(String.valueOf(etudeChamps.getNombreServiceOffert()));
		}
		catch (NullPointerException e) {
			System.err.println("Message d'erreur: " + e);
		}
	}
}
