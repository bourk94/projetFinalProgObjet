package pkMembrePersonnel;

import java.io.Serializable;

//Alexandre Bourque 2191473
//PROJET SYTHÈSE
//CLASS ABSTRAITE DE MEMBRE DU PERSONNEL

import java.util.Comparator;
import java.util.GregorianCalendar;

public abstract class MembrePersonnel implements Comparable<Object>, Comparator<Object>, Serializable {
	
	//VARIABLE
	protected int numeroEmployer;
	protected int nas;
	protected int age;
	protected int poste;
	protected char sexe;
	protected String nom;
	protected String prenom;
	protected GregorianCalendar dateEmbauche;
	protected GregorianCalendar dateNaissance;
	static protected int INCREMENT;
	
	//VARIABLE STATIC
	static {
		INCREMENT = 0;
	}
	
	//CONSTRUCTEUR PAR DEFAUT
	public MembrePersonnel() {
		INCREMENT++;
		numeroEmployer = INCREMENT;
		nas = 0;
		age = 1;
		poste = 0;
		sexe = ' ';
		nom = "";
		prenom = "";
		dateEmbauche = new GregorianCalendar();
		dateNaissance = new GregorianCalendar();
	}

	//METHODE GET ET SET
	public int getnumeroEmployer() {
		return numeroEmployer;
	}

	public void setnumeroEmployer(int _numeroEmployer) {
		numeroEmployer = _numeroEmployer;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String _nom) {
		nom = _nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String _prenom) {
		prenom = _prenom;
	}

	public int getNas() {
		return nas;
	}

	public void setNas(int _nas) {
		nas = _nas;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int _age) {
		age = _age;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char _sexe) {
		sexe = _sexe;
	}

	public int getPoste() {
		return poste;
	}

	public void setPoste(int _poste) {
		poste = _poste;
	}

	public GregorianCalendar getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(GregorianCalendar _dateEmbauche) {
		dateEmbauche = _dateEmbauche;
	}

	public GregorianCalendar getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(GregorianCalendar _dateNaissance) {
		dateNaissance = _dateNaissance;
	}

	//HASHCODE
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((dateEmbauche == null) ? 0 : dateEmbauche.hashCode());
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + nas;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + numeroEmployer;
		result = prime * result + poste;
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + sexe;
		return result;
	}

	//EQUALS
	public boolean equals(MembrePersonnel _obj) {
		return (numeroEmployer == _obj.getnumeroEmployer()
				&&
				nom.equals(_obj.getNom())
				&&
				prenom.equals(_obj.getPrenom())
				&&
				nas == _obj.getNas()
				&&
				age == _obj.getAge()
				&&
				sexe == _obj.getSexe()
				&&
				poste == _obj.getPoste())
				&&
				dateEmbauche.equals(_obj.getDateEmbauche())
				&&
				dateNaissance.equals(_obj.getDateNaissance());
	}
	
	//COMPARETO AVEC LES NOMS SI L'ANNÉE EST LA MÊME
	private int compareToName(Object _obj) {
		MembrePersonnel unMembrePersonnel = (MembrePersonnel) _obj;
		int result = nom.compareTo(unMembrePersonnel.getNom());
		if(result == 0)
			return nom.compareTo(unMembrePersonnel.getNom());
		else
			return result;
	}
	
	//COMPARETO
	public int compareTo(Object _obj) {
		MembrePersonnel unMembrePersonnel = (MembrePersonnel) _obj;
		int result = dateEmbauche.compareTo(unMembrePersonnel.getDateEmbauche());
		if(result == 0)
			return compareToName(unMembrePersonnel);
		else
			return result;
	}

	//COMPARE
	public int compare(Object _obj1, Object _obj2) {
		MembrePersonnel unMembrePersonnel = (MembrePersonnel) _obj1;
		MembrePersonnel deuxMembrePersonnel = (MembrePersonnel) _obj2;
		return unMembrePersonnel.compareTo(deuxMembrePersonnel);
	}
	
	//TOSTRING
	public String toString() {
		return "MembrePersonnel / numeroEmployer= " + numeroEmployer + ", nom= " + nom + ", prenom= " + prenom + ", nas= "
				+ nas + ", age= " + age + ", sexe= " + sexe + ", poste = " + poste + ", dateEmbauche= " + dateEmbauche.getTime()
				+ ", dateNaissance= " + dateNaissance.getTime() + " ";
	}
}
