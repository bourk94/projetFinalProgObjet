package pkEnseignant;

import java.io.Serializable;

//Alexandre Bourque 2191473
//PROJET SYTHÈSE
//CLASS DE TEMPS PARTIEL

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class TempsPartiel extends Enseignant implements Serializable {
	
	//VARIABLE
	protected double clSession;
	protected String sessionActuelle;
	
	//CONSTRUCTEUR PAR DEFAUT
	public TempsPartiel() {
		super();
		clSession = 0;
		sessionActuelle = "";
	}
	
	//CONSTRUCTEUR PARAMETRE
	public TempsPartiel(String nom, String prenom, int nas, int age, char sexe, int poste, GregorianCalendar dateEmbauche, GregorianCalendar dateNaissance, int numeroDepartement, String nomDepartement, int numeroCours, String nomCours, double _clSession, String _sessionActuelle) {
		super(nom, prenom, nas, age, sexe, poste, dateEmbauche, dateNaissance, numeroDepartement, nomDepartement, numeroCours, nomCours);
		setClSession(_clSession);
		sessionActuelle = _sessionActuelle;
	}
	
	//METHODE GET ET SET
	public double getClSession() {
		return clSession;
	}

	public void setClSession(double _clSession) {
		if(_clSession <= 40)
			clSession = _clSession;
		else if(_clSession > 40) {
			clSession = 0;
			JOptionPane.showMessageDialog(null, "La charge de cours d'un professeur à temps partiel ne peut pas être plus grande que 40%, la charge a donc été remis à 0.");
		}
		else {
			clSession = 0;
			JOptionPane.showMessageDialog(null, "La charge de cours d'un professeur ne peut être un nombre négatif, la charge a donc été remis à 0.");
		}		
	}

	public String getSessionActuelle() {
		return sessionActuelle;
	}

	public void setSessionActuelle(String _sessionActuelle) {
		sessionActuelle = _sessionActuelle;
	}

	//HASHCODE
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(clSession);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sessionActuelle == null) ? 0 : sessionActuelle.hashCode());
		return result;
	}

	//EQUALS
	public boolean equals(TempsPartiel _obj) {
		return (super.equals(_obj)
				&&
				clSession == _obj.getClSession()
				&&
				sessionActuelle.equals(_obj.getSessionActuelle()));
	}

	//TOSTRING
	public String toString() {
		return super.toString() + "TempsPartiel / clSession= " + clSession + ", sessionActuelle= " + sessionActuelle + "\n";
	}
}
