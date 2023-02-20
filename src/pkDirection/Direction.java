package pkDirection;

import java.io.Serializable;

//Alexandre Bourque 2191473
//PROJET SYTHÈSE
//CLASS ABSTRAITE DE DIRECTION

import java.util.GregorianCalendar;
import pkMembrePersonnel.MembrePersonnel;

public abstract class Direction extends MembrePersonnel implements Serializable {
	
	//VARIABLE
	protected int nombrePersonneSuperviser;
	protected String mandat;

	//CONSTRUCTEUR PAR DEFAUT
	public Direction() {
		super();
		nombrePersonneSuperviser = 0;
		mandat = "";
	}
	
	//CONSTRUCTEUR PARAMETRE
	public Direction(String _nom, String _prenom, int _nas, int _age, char _sexe, int _poste, GregorianCalendar _dateEmbauche, GregorianCalendar _dateNaissance, int _nbrPersSuperviser, String _mandat) {
		nom = _nom;
		prenom = _prenom;
		nas = _nas;
		age = _age;
		sexe = _sexe;
		poste = _poste;
		dateEmbauche = _dateEmbauche;
		dateNaissance = _dateNaissance;
		nombrePersonneSuperviser = _nbrPersSuperviser;
		mandat = _mandat;
	}
	
	//METHODES SET ET GET
	public int getNombrePersonneSuperviser() {
		return nombrePersonneSuperviser;
		}

	public void setNombrePersonneSuperviser(int _nombrePersonneSuperviser) {
		nombrePersonneSuperviser = _nombrePersonneSuperviser;
		}

	public String getMandat() {
		return mandat;
		}

	public void setMandat(String _mandat) {
		mandat = _mandat;
		}

	//HASHCODE
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mandat == null) ? 0 : mandat.hashCode());
		result = prime * result + nombrePersonneSuperviser;
		return result;
	}

	//EQUALS
	public boolean equals(Direction _obj) {
		return (super.equals(_obj)
				&&
				nombrePersonneSuperviser == _obj.getNombrePersonneSuperviser()
				&&
				mandat.equals(_obj.getMandat()));
	}

	//TOSTRING
	public String toString() {
		return super.toString() + "Direction / nombrePersonneSuperviser= " + nombrePersonneSuperviser + ", mandat= " + mandat + " ";
	}
}