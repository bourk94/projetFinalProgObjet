package pkDirection;

import java.io.Serializable;

//Alexandre Bourque 2191473
//PROJET SYTHÈSE
//CLASS DE TUTORAT

import java.util.GregorianCalendar;

public class Tutorat extends Direction implements Serializable {

	//VARIABLE
	protected int nombreEtudiantAide;
	protected int nombreSuperviseur;
	
	//CONSTRUCTEUR PAR DEFAUT
	public Tutorat() {
		super();
		nombreEtudiantAide = 0;
		nombreSuperviseur = 0;
	}
	
	//CONSTRUCTEUR PARAMETRE
	public Tutorat(String nom, String prenom, int nas, int age, char sexe, int poste, GregorianCalendar dateEmbauche, GregorianCalendar dateNaissance, int nbrPersSuperviser, String mandat ,int _nombreEtudiantAide, int _nombreSuperviseur) {
		super(nom, prenom, nas, age, sexe, poste, dateEmbauche, dateNaissance, nbrPersSuperviser, mandat);
		nombreEtudiantAide = _nombreEtudiantAide;
		nombreSuperviseur = _nombreSuperviseur;
	}

	//METHODE SET ET GET
	public int getNombreEtudiantAide() {
		return nombreEtudiantAide;
	}

	public void setNombreEtudiantAide(int _nombreEtudiantAide) {
		nombreEtudiantAide = _nombreEtudiantAide;
	}

	public int getNombreSuperviseur() {
		return nombreSuperviseur;
	}

	public void setNombreSuperviseur(int _nombreSuperviseur) {
		nombreSuperviseur = _nombreSuperviseur;
	}

	//HASHCODE
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + nombreEtudiantAide;
		result = prime * result + nombreSuperviseur;
		return result;
	}
	
	//EQUALS
	public boolean equals(Tutorat _obj) {
		return (super.equals(_obj)
				&&
				nombreEtudiantAide == _obj.getNombreEtudiantAide()
				&&
				nombreSuperviseur == _obj.getNombreSuperviseur());
	}

	//TOSTRING
	public String toString() {
		return super.toString() + "Tutorat / nombreEtudiantAide= " + nombreEtudiantAide + ", nombreSuperviseur= " + nombreSuperviseur + "\n";
	}
}
