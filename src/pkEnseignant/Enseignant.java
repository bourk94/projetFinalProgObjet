package pkEnseignant;

import java.io.Serializable;

//Alexandre Bourque 2191473
//PROJET SYTHÈSE
//CLASS ABSTRAITE DE ENSEIGNANT

import java.util.GregorianCalendar;

import pkMembrePersonnel.MembrePersonnel;

public abstract class Enseignant extends MembrePersonnel implements Serializable {

	//VARIABLE
	protected int numeroDepartement;
	protected int numeroCours;
	protected String nomDepartement;
	protected String nomCours;
	
	//CONSTRUCTEUR PAR DEFAUT
	public Enseignant() {
		super();
		numeroDepartement = 0;
		nomDepartement = "";
		numeroCours = 0;
		nomCours = "";
	}
	
	//CONSTRUCTEUR PARAMETRE
	public Enseignant(String _nom, String _prenom, int _nas, int _age, char _sexe, int _poste, GregorianCalendar _dateEmbauche, GregorianCalendar _dateNaissance, int _numeroDepartement, String _nomDepartement, int _numeroCours, String _nomCours) {
		nom = _nom;
		prenom = _prenom;
		nas = _nas;
		age = _age;
		sexe = _sexe;
		poste = _poste;
		dateEmbauche = _dateEmbauche;
		dateNaissance = _dateNaissance;
		numeroDepartement = _numeroDepartement;
		nomDepartement = _nomDepartement;
		numeroCours = _numeroCours;
		nomCours = _nomCours;
	}

	//METHODE SET ET GET
	public int getNumeroDepartement() {
		return numeroDepartement;
	}

	public void setNumeroDepartement(int _numeroDepartement) {
		numeroDepartement = _numeroDepartement;
	}

	public int getNumeroCours() {
		return numeroCours;
	}

	public void setNumeroCours(int _numeroCours) {
		numeroCours = _numeroCours;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String _nomDepartement) {
		nomDepartement = _nomDepartement;
	}

	public String getNomCours() {
		return nomCours;
	}

	public void setNomCours(String _nomCours) {
		nomCours = _nomCours;
	}

	//HASHCODE
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nomCours == null) ? 0 : nomCours.hashCode());
		result = prime * result + ((nomDepartement == null) ? 0 : nomDepartement.hashCode());
		result = prime * result + numeroCours;
		result = prime * result + numeroDepartement;
		return result;
	}

	//EQUALS
	public boolean equals(Enseignant _obj) {
		return (super.equals(_obj)
				&&
				numeroDepartement == _obj.getNumeroDepartement()
				&&
				nomDepartement.equals(_obj.getNomDepartement())
				&&
				numeroCours == _obj.getNumeroCours()
				&&
				nomCours.equals(_obj.getNomCours()));
	}
	
	//TOSTRING
	public String toString() {
		return super.toString() + "Enseignant / numeroDepartement= " + numeroDepartement + ", numeroCours= " + numeroCours
				+ ", nomDepartement= " + nomDepartement + ", nomCours= " + nomCours + " ";
	}
}
