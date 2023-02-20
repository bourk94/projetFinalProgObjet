package pkEnseignant;

import java.io.Serializable;

//Alexandre Bourque 2191473
//PROJET SYTHÈSE
//CLASS DE TEMPS COMPLET

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class TempsComplet extends Enseignant implements Serializable {

	//VARIABLE
	protected int anneeAnciennete;
	protected double clAnnuel;
	
	//CONSTRUCTEUR PAR DEFAUT
	public TempsComplet() {
		super();
		anneeAnciennete = 0;
		clAnnuel = 0;
	}
	
	//CONSTRUCTEUR PARAMETRE
	public TempsComplet(String nom, String prenom, int nas, int age, char sexe, int poste, GregorianCalendar dateEmbauche, GregorianCalendar dateNaissance, int numeroDepartement, String nomDepartement, int numeroCours, String nomCours, int _anneeAnciennete, double _clAnnuel) {
		super(nom, prenom, nas, age, sexe, poste, dateEmbauche, dateNaissance, numeroDepartement, nomDepartement, numeroCours, nomCours);
		anneeAnciennete = _anneeAnciennete;
		setClAnnuel(_clAnnuel);;
	}
	
	//METHODE GET ET SET
	public int getAnneeAnciennete() {
		return anneeAnciennete;
	}

	public void setAnneeAnciennete(int _anneeAnciennete) {
		anneeAnciennete = _anneeAnciennete;
	}

	public double getClAnnuel() {
		return clAnnuel;
	}

	public void setClAnnuel(double _clAnnuel) {
		if(_clAnnuel <= 80)
			clAnnuel = _clAnnuel;
		else if(_clAnnuel > 80) {
			clAnnuel = 0;
			JOptionPane.showMessageDialog(null, "La charge de cours d'un professeur à temps complet ne peut pas être plus grande que 80%, la charge a donc été remis à 0.");
		}
		else {
			clAnnuel = 0;
			JOptionPane.showMessageDialog(null, "La charge de cours d'un professeur ne peut être un nombre négatif, la charge a donc été remis à 0.");
		}	
	}
	
	//HASHCODE
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + anneeAnciennete;
		long temp;
		temp = Double.doubleToLongBits(clAnnuel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	//EQUALS
	public boolean equals(TempsComplet _obj) {
		return (super.equals(_obj)
				&&
				anneeAnciennete == _obj.getAnneeAnciennete()
				&&
				clAnnuel == _obj.getClAnnuel());
	}

	//TOSTRING
	public String toString() {
		return super.toString() + "TempsComplet / anneeAnciennete= " + anneeAnciennete + ", clAnnuel= " + clAnnuel + "\n";
	}
}
