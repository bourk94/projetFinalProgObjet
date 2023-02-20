package pkSoutien;

import java.io.Serializable;

//Alexandre Bourque 2191473
//PROJET SYTHÈSE
//CLASS DE PERSONNEL DE SOUTIEN

import java.util.GregorianCalendar;

import pkMembrePersonnel.MembrePersonnel;

public class PersonnelSoutien extends MembrePersonnel implements Serializable {

	//VARIABLE
	protected String pavillon;
	protected String quartTravail;
	protected String genreTravail;
	
	//CONSTRUCTEUR PAR DEFAUT
	public PersonnelSoutien() {
		super();
		pavillon = "";
		quartTravail = "";
		genreTravail = "";
	}
	
	//CONSTRUCTEUR PARAMETRE
	public PersonnelSoutien(String _nom, String _prenom, int _nas, int _age, char _sexe, int _poste, GregorianCalendar _dateEmbauche, GregorianCalendar _dateNaissance, String _pavilon, String _quartTravail, String _genreTravail) {
		nom = _nom;
		prenom = _prenom;
		nas = _nas;
		age = _age;
		sexe = _sexe;
		poste = _poste;
		dateEmbauche = _dateEmbauche;
		dateNaissance = _dateNaissance;
		pavillon = _pavilon;
		quartTravail = _quartTravail;
		genreTravail = _genreTravail;
	}
	
	//METHODE GET ET SET
	public String getPavillon() {
		return pavillon;
	}

	public void setPavillon(String _pavillon) {
		pavillon = _pavillon;
	}

	public String getQuartTravail() {
		return quartTravail;
	}

	public void setQuartTravail(String _quartTravail) {
		quartTravail = _quartTravail;
	}

	public String getGenreTravail() {
		return genreTravail;
	}

	public void setGenreTravail(String _genreTravail) {
		genreTravail = _genreTravail;
	}

	//HASHCODE
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((genreTravail == null) ? 0 : genreTravail.hashCode());
		result = prime * result + ((pavillon == null) ? 0 : pavillon.hashCode());
		result = prime * result + ((quartTravail == null) ? 0 : quartTravail.hashCode());
		return result;
	}

	//EQUALS
	public boolean equals(PersonnelSoutien _obj) {
		return (super.equals(_obj)
				&&
				pavillon.equals(_obj.getPavillon())
				&&
				quartTravail.equals(_obj.getQuartTravail())
				&&
				genreTravail.equals(_obj.getGenreTravail()));
	}

	//TOSTRING
	public String toString() {
		return super.toString() + "PersonnelSoutien / pavillon= " + pavillon + ", quartTravail= " + quartTravail + ", genreTravail= "
				+ genreTravail + "\n";
	}
}
