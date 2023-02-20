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
import com.toedter.calendar.JDateChooser;
import pkDirection.DirectionInformatique;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ModifierInfo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField txtNbrDepDeser;
	private JTextField txtNas;
	private JTextField txtAge;
	private JTextField txtPrenom;
	private JTextField txtPoste;
	private JTextField txtNbrPersSuper;
	private JTextField txtMandat;
	private JPanel panel;
	private JTextField txtNom;
	protected static DirectionInformatique infoChamps;
	private JButton btnModifier;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdHomme;
	private JRadioButton rdFemme;
	private JDateChooser txtDateNaissance;
	private JDateChooser txtDateEmbauche;
	private DateFormat fmt = new SimpleDateFormat("yyyy-M-dd");
	private JButton btnAnnuler;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModifierInfo dialog = new ModifierInfo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModifierInfo() {
		initComponents();
		initChamp();
		initList();
		createEvents();
		}

	private void initComponents() {
		setTitle("Modification direction informatique");
		setBounds(100, 100, 909, 535);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			panel = new JPanel();
			panel.setLayout(null);
			{
				txtNbrDepDeser = new JTextField();
				txtNbrDepDeser.setColumns(10);
				txtNbrDepDeser.setBounds(481, 135, 30, 20);
				panel.add(txtNbrDepDeser);
			}
			{
				txtNas = new JTextField();
				txtNas.setColumns(10);
				txtNas.setBounds(139, 104, 70, 20);
				panel.add(txtNas);
			}
			{
				txtAge = new JTextField();
				txtAge.setEditable(false);
				txtAge.setColumns(10);
				txtAge.setBounds(139, 135, 30, 20);
				panel.add(txtAge);
			}
			{
				rdHomme = new JRadioButton("Homme");
				buttonGroup.add(rdHomme);
				rdHomme.setSelected(true);
				rdHomme.setActionCommand("m");
				rdHomme.setBounds(139, 162, 61, 23);
				panel.add(rdHomme);
			}
			{
				rdFemme = new JRadioButton("Femme");
				buttonGroup.add(rdFemme);
				rdFemme.setActionCommand("f");
				rdFemme.setBounds(202, 162, 59, 23);
				panel.add(rdFemme);
			}
			{
				Label lblSexe = new Label("Sexe:");
				lblSexe.setBounds(91, 162, 42, 22);
				panel.add(lblSexe);
			}
			{
				txtNom = new JTextField();
				txtNom.setColumns(10);
				txtNom.setBounds(139, 11, 135, 20);
				panel.add(txtNom);
			}
			{
				txtPrenom = new JTextField();
				txtPrenom.setColumns(10);
				txtPrenom.setBounds(139, 42, 135, 20);
				panel.add(txtPrenom);
			}
			{
				txtPoste = new JTextField();
				txtPoste.setColumns(10);
				txtPoste.setBounds(481, 11, 70, 20);
				panel.add(txtPoste);
			}
			{
				Label lblNbrDepDeser = new Label("Nombre d\u00E9partements desservis:");
				lblNbrDepDeser.setBounds(301, 135, 174, 22);
				panel.add(lblNbrDepDeser);
			}
			{
				txtNbrPersSuper = new JTextField();
				txtNbrPersSuper.setColumns(10);
				txtNbrPersSuper.setBounds(481, 73, 30, 20);
				panel.add(txtNbrPersSuper);
			}
			{
				txtDateNaissance = new JDateChooser();
				txtDateNaissance.setDateFormatString("yyyy-MM-dd");
				txtDateNaissance.setBounds(139, 73, 100, 20);
				panel.add(txtDateNaissance);
			}
			{
				txtDateEmbauche = new JDateChooser();
				txtDateEmbauche.setDateFormatString("yyyy-MM-dd");
				txtDateEmbauche.setBounds(481, 42, 100, 20);
				panel.add(txtDateEmbauche);
			}
			{
				Label lblNom = new Label("Nom:");
				lblNom.setBounds(91, 11, 38, 22);
				panel.add(lblNom);
			}
			{
				Label lblPrenom = new Label("Pr\u00E9nom:");
				lblPrenom.setBounds(78, 42, 53, 22);
				panel.add(lblPrenom);
			}
			{
				Label lblNas = new Label("NAS:");
				lblNas.setBounds(94, 104, 39, 22);
				panel.add(lblNas);
			}
			{
				Label lblAge = new Label("\u00C2ge:");
				lblAge.setBounds(96, 135, 37, 22);
				panel.add(lblAge);
			}
			{
				txtMandat = new JTextField();
				txtMandat.setColumns(10);
				txtMandat.setBounds(481, 104, 180, 20);
				panel.add(txtMandat);
			}
			{
				Label lblPoste = new Label("Poste:");
				lblPoste.setBounds(431, 11, 44, 22);
				panel.add(lblPoste);
			}
			{
				Label lbDateEmbauche = new Label("Date d'embauche:");
				lbDateEmbauche.setBounds(375, 42, 100, 22);
				panel.add(lbDateEmbauche);
			}
			{
				Label lblDateNaissance = new Label("Date de naissance:");
				lblDateNaissance.setBounds(26, 71, 107, 22);
				panel.add(lblDateNaissance);
			}
			{
				Label lblNbrPersSuper = new Label("Nombre personnes supervis\u00E9:");
				lblNbrPersSuper.setBounds(311, 73, 164, 22);
				panel.add(lblNbrPersSuper);
			}
			{
				Label lblMandat = new Label("Mandat:");
				lblMandat.setBounds(422, 104, 52, 22);
				panel.add(lblMandat);
			}
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
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

					DirectionInformatique info = new DirectionInformatique(txtNom.getText(),
							txtPrenom.getText(), Integer.parseInt(txtNas.getText()),
							Integer.parseInt(txtAge.getText()),
							(buttonGroup.getSelection().getActionCommand()).charAt(0),
							Integer.parseInt(txtPoste.getText()), new GregorianCalendar(y1, m1-1, d1),
							new GregorianCalendar(y2, m2-1, d2), Integer.parseInt(txtNbrPersSuper.getText()),
							txtMandat.getText(), Integer.parseInt(txtNbrDepDeser.getText()));

					GUI.listeEmployer.modifier(GUI.INDEXSUPPRIMER, info);
					
					GUI.INDEXSUPPRIMER = -1;
			
					initList();
					
					GUI.info.setVisible(false);
					
				} catch (NumberFormatException | NullPointerException e1) {
					System.err.println("Message d'erreur: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Échec de la modification");
				}
			}
		});
		
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.info.setVisible(false);
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
			infoChamps = (DirectionInformatique) GUI.personnelModifier;
			txtNom.setText(infoChamps.getNom());
			txtPrenom.setText(infoChamps.getPrenom());
			txtNas.setText(String.valueOf(infoChamps.getNas()));
			txtAge.setText(String.valueOf(infoChamps.getAge()));
			if (infoChamps.getSexe() == 'm') {
				rdHomme.setSelected(true);
			}
			else if (infoChamps.getSexe() == 'f') {
				rdFemme.setSelected(true);
			}
			txtPoste.setText(String.valueOf(infoChamps.getPoste()));
			Calendar dateNaissance = infoChamps.getDateNaissance();
			txtDateNaissance.setCalendar(dateNaissance);
			Calendar dateEmbauche = infoChamps.getDateEmbauche();
			txtDateEmbauche.setCalendar(dateEmbauche);
			txtNbrPersSuper.setText(String.valueOf(infoChamps.getNombrePersonneSuperviser()));
			txtMandat.setText(infoChamps.getMandat());
			txtNbrDepDeser.setText(String.valueOf(infoChamps.getNombreDepartementDesservi()));
		}
		catch (NullPointerException e) {
			System.err.println("Message d'erreur: " + e);
		}
		
	}
}
