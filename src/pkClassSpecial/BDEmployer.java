package pkClassSpecial;

//Alexandre Bourque 2191473
//PROJET SYNTHESE
//CLASS DE BD EMPLOYER

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import pkDirection.*;
import pkEnseignant.*;
import pkSoutien.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import pkMembrePersonnel.*;

public class BDEmployer implements Serializable {

	protected ArrayList<MembrePersonnel> listeEmployer;

	// CONSTRUCTEUR PAR DEFAUT
	public BDEmployer() {
		listeEmployer = new ArrayList<>();
	}

	// CONSTRUCTEUR PARAMETRE
	public BDEmployer(MembrePersonnel tabEmployer[]) {
		listeEmployer = new ArrayList<>();
		for (int ctr = 0; ctr < tabEmployer.length; ctr++)
			listeEmployer.add(tabEmployer[ctr]);
	}

	// METHODE SET ET GET
	public ArrayList<MembrePersonnel> getListeEmployer() {
		return listeEmployer;
	}

	public void setListeEmployer(ArrayList<MembrePersonnel> _listeEmployer) {
		listeEmployer = _listeEmployer;
	}

	// AJOUTER UN OBJET À L'ARRAY
	public void ajouter(Object _obj) {
		MembrePersonnel unMembrePersonnel = (MembrePersonnel) _obj;
		listeEmployer.add(unMembrePersonnel);
	}

	// SUPPRIMER UN OBJET DE L'ARRAY
	public void supprimer(Object _obj) {
		MembrePersonnel unMembrePersonnel = (MembrePersonnel) _obj;
		listeEmployer.remove(unMembrePersonnel);
	}

	// SUPPRIMER UN OBJET GRACE À SA POSITION
	public void supprimer(int _position) {
		listeEmployer.remove(_position);
	}

	// MODIFIER UN OBJET À UNE POSITION
	public void modifier(int position, Object _obj) {
		MembrePersonnel unMembrePersonnel = (MembrePersonnel) _obj;
		listeEmployer.set(position, unMembrePersonnel);
	}

	// CONNAITRE LA POSITION D'UN OBJET
	public int indexOf(Object _obj) {
		MembrePersonnel unMembrePersonnel = (MembrePersonnel) _obj;
		return listeEmployer.indexOf(unMembrePersonnel);
	}

	// AFFICHER LES INFORMATIONS D'UN OBJET
	public Object lire(Object _obj) {
		MembrePersonnel unMembrePersonnel = (MembrePersonnel) _obj;
		return listeEmployer.get(indexOf(unMembrePersonnel));
	}

	// AFFICHER LES INFORMATIONS D'UN OBJET GRACE À SA POSITION
	public Object lire(int position) {
		return listeEmployer.get(position);
	}

	// RETOURNE LA LONGUEUR DE L'ARRAY
	public int size() {
		return listeEmployer.size();
	}

	// FICHIER SER
	public void sauvegarder() {
		File ficher = null;
		FileOutputStream donnees = null;
		ObjectOutputStream ecriture = null;

		try {
			ficher = new File("BDEmployer.ser");
			donnees = new FileOutputStream(ficher);
			ecriture = new ObjectOutputStream(donnees);

		}

		catch (IOException e) {
			System.err.println("Message d'erreur: " + e.getMessage());
			System.err.println("Chemin : " + ficher.getPath());

		}

		try {
			ecriture.writeObject(listeEmployer);
			ecriture.close();
		}

		catch (IOException e) {
			System.err.println("Message d'erreur: " + e.getMessage());
			System.exit(0);
		}

	}

	public void chargerSauvegarde() {
		File lectureSauvegarde = null;
		FileInputStream donneesRetournees = null;
		ObjectInputStream lecture = null;

		try {
			lectureSauvegarde = new File("BDEmployer.ser");
			donneesRetournees = new FileInputStream(lectureSauvegarde);
			lecture = new ObjectInputStream(donneesRetournees);
		}

		catch (IOException | NullPointerException e) {
			System.err.println("Message d'erreur: " + e.getMessage());
			System.err.println("Fichier: " + lectureSauvegarde.getPath());
		}

		try {
			listeEmployer = (ArrayList<MembrePersonnel>) lecture.readObject();
			lecture.close();
		}

		catch (ClassNotFoundException | IOException | NullPointerException e) {
			System.err.println("Message d'erreur: " + e.getMessage());
			System.exit(0);
		}
	}
	
	// FICHIER TXT
	public void fichierTxt() {
		File direction = new File("direction.txt");
		File enseignant = new File("enseignant.txt");
		File soutien = new File("soutien.txt");
		FileWriter ecritureDirection = null;
		FileWriter ecritureEnseignant = null;
		FileWriter ecritureSoutien = null;

		try {
			ecritureDirection = new FileWriter(direction);
		}

		catch (IOException e) {
			System.err.println("Message d'erreur: " + e.getMessage());
			System.err.println("Fichier: " + direction.getPath());
			System.exit(0);
		}

		try {
			ecritureEnseignant = new FileWriter(enseignant);
		}

		catch (IOException e) {
			System.err.println("Message d'erreur: " + e.getMessage());
			System.err.println("Fichier: " + enseignant.getPath());
			System.exit(0);
		}

		try {
			ecritureSoutien = new FileWriter(soutien);
		}

		catch (IOException e) {
			System.err.println("Message d'erreur: " + e.getMessage());
			System.err.println("Fichier: " + soutien.getPath());
			System.exit(0);
		}

		String resultat = "";
		String resultatDirection = "Liste des membres de la direction " + new Date() + "\n";
		String resultatEnseignant = "Liste des enseignants " + new Date() + "\n";
		String resultatSoutien = "Liste du personnel de soutien " + new Date() + "\n";
		int ligne1 = 1;
		int ligne2 = 1;
		int ligne3 = 1;

		try {
			System.out.println(("Liste des employés " + new Date()));
			ecritureDirection.write("Liste de la direction " + direction.getName() + " " + new Date() + "\r\n");
			ecritureEnseignant.write("Liste des enseigants " + enseignant.getName() + " " + new Date() + "\r\n");
			ecritureSoutien.write("Liste du personnel de soutien " + soutien.getName() + " " + new Date() + "\r\n");

			for (int ctr = 0; ctr < listeEmployer.size(); ctr++) {
				MembrePersonnel unePers = (MembrePersonnel) listeEmployer.get(ctr);

				if (unePers instanceof Direction) {
					resultat = ligne1 + " - " + unePers.toString();
					ecritureDirection.write(resultat + "\r\n");
					resultatDirection += resultat + "\n";
					ligne1++;
				}

				if (unePers instanceof Enseignant) {
					resultat = ligne2 + " - " + unePers.toString();
					ecritureEnseignant.write(resultat + "\r\n");
					resultatEnseignant += resultat + "\n";
					ligne2++;
				}

				if (unePers instanceof PersonnelSoutien) {
					resultat = ligne3 + " - " + unePers.toString();
					ecritureSoutien.write(resultat + "\r\n");
					resultatSoutien += resultat + "\n";
					ligne3++;
				}
			}
			System.out.println(resultatDirection + "\n" + resultatEnseignant + "\n" + resultatSoutien);
			ecritureDirection.close();
			ecritureEnseignant.close();
			ecritureSoutien.close();
		}

		catch (IOException e) {

			System.err.print("Message d'erreur: " + e.getMessage());
			System.err.print("Erreur lors de la fermeture");

			try {
				ecritureDirection.close();
				ecritureEnseignant.close();
				ecritureSoutien.close();
			} catch (IOException e1) {
				System.err.print("Message d'erreur: " + e1.getMessage());
				System.err.print("Erreur lors de la fermeture");
			}
		}
	}

	//TRIER L'ARRAY EN ORDRE DE DATE
	public String trierListe() {
		Collections.sort(listeEmployer);
		
		String resultat = "";
		for (int ctr = 0, ligne = 1; ctr < listeEmployer.size(); ctr++) {
			MembrePersonnel membrePersonnel = (MembrePersonnel) listeEmployer.get(ctr);
			if (membrePersonnel instanceof Enseignant) {
				resultat += ligne + " - " + membrePersonnel.toString() + "\n";
				ligne++;
			}
		}
		
		resultat += "/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////" + "\n\n";
		
		for (int ctr = 0,ligne = 1; ctr < listeEmployer.size(); ctr++) {
			MembrePersonnel membrePersonnel = (MembrePersonnel) listeEmployer.get(ctr);
			if (membrePersonnel instanceof Direction) {
				resultat += ligne + " - " + membrePersonnel.toString() + "\n";
				ligne++;
			}
		}	
		
		resultat += "/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////" + "\n\n";
		
		for (int ctr = 0,ligne = 1; ctr < listeEmployer.size(); ctr++) {
			MembrePersonnel membrePersonnel = (MembrePersonnel) listeEmployer.get(ctr);
			if (membrePersonnel instanceof PersonnelSoutien) {
				resultat += ligne + " - " + membrePersonnel.toString() + "\n";
				ligne++;
			}
		}
		System.out.println(resultat);
		return resultat;
	}
	
	// TOSTRING
	public String toString() {
		return listeEmployer.toString();
	}
}
