package pkDirection;

import java.io.Serializable;

//Alexandre Bourque 2191473
//PROJET SYTHÈSE
//CLASS DE DIRECTION ETUDE

import java.util.GregorianCalendar;

public class DirectionEtude extends Direction implements Serializable {

	//VARIABLE
	protected int nombreServiceOffert;

	//CONSTRUCTEUR PAR DEFAUT
	public DirectionEtude() {
		super();
		nombreServiceOffert = 0;
	}
	
	//CONSTRUCTEUR PARAMETRE
	public DirectionEtude(String nom, String prenom, int nas, int age, char sexe, int poste, GregorianCalendar dateEmbauche, GregorianCalendar dateNaissance, int nbrPersSuperviser, String mandat ,int _nombreServiceOffert) { 
		 super(nom, prenom, nas, age, sexe, poste, dateEmbauche, dateNaissance, nbrPersSuperviser, mandat); 
		 nombreServiceOffert = _nombreServiceOffert;
	 }
	
	//METHODE SET ET GET
	public int getNombreServiceOffert() {
		return nombreServiceOffert;
	}

	public void setNombreServiceOffert(int _nombreServiceOffert) {
		nombreServiceOffert = _nombreServiceOffert;
	}

	//HASHCODE
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + nombreServiceOffert;
		return result;
	}

	//EQUALS
	public boolean equals(DirectionEtude _obj) {
		return (super.equals(_obj)
				&&
				nombreServiceOffert == _obj.getNombreServiceOffert());
	}

	//TOSTRING
	public String toString() {
		return super.toString() + "DirectionEtude / nombreServiceOffert= " + nombreServiceOffert + "\n";
	}
}
