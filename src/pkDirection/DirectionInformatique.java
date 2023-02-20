package pkDirection;

import java.io.Serializable;

//Alexandre Bourque 2191473
//PROJET SYTHÈSE
//CLASS DE DIRECTION INFORMATIQUE

import java.util.GregorianCalendar;

public class DirectionInformatique extends Direction implements Serializable {
	
	//VARIABLE
	protected int nombreDepartementDesservi;
	
	//CONSTRUCTEUR PAR DEFAUT
	public DirectionInformatique() {
		super();
		nombreDepartementDesservi = 0;
	}
	
	//CONSTRUCTEUR PARAMETRE
	 public DirectionInformatique(String nom, String prenom, int nas, int age, char sexe, int poste, GregorianCalendar dateEmbauche, GregorianCalendar dateNaissance, int nbrPersSuperviser, String mandat ,int _nombreDepartementDesservi) { 
		 super(nom, prenom, nas, age, sexe, poste, dateEmbauche, dateNaissance, nbrPersSuperviser, mandat); 
		 nombreDepartementDesservi = _nombreDepartementDesservi; 
	 }
	
	 //METHODE SET ET GET
	public int getNombreDepartementDesservi() {
		return nombreDepartementDesservi;
	}

	public void setNombreDepartementDesservi(int _nombreDepartementDesservi) {
		nombreDepartementDesservi = _nombreDepartementDesservi;
	}

	//HASHCODE
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + nombreDepartementDesservi;
		return result;
	}

	//EQUALS
	public boolean equals(DirectionInformatique _obj) {
		return (super.equals(_obj)
				&&
				nombreDepartementDesservi == _obj.getNombreDepartementDesservi());
	}

	//TOSTRING
	public String toString() {
		return super.toString() + "DirectionInformatique / nombreDepartementDesservi= " + nombreDepartementDesservi + "\n";
	}
}
