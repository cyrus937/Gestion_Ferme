package modele;

/*
 * cette classe permet de créer nos différentes règles de la base de
 * connaissance*/
public class Regle {
	
	Premisse premisse ;
	String conclusion;
	
	/*
	 * constructeur de la règle à partir de la prémisse et de la conclusion*/
	public Regle (Premisse premisse, String conclusion) {
		this.conclusion = conclusion;
		this.premisse = premisse;
	}
	
	/*
	 * permet de compter le nombre de proposition dans la prémisse
	 */
	public int compteur ()
	{
		return this.premisse.nbreProposition();
	}
	
	/*
	 * permet de voir si une proposition est contenue dans la premisse
	 * */
	public boolean contient(String p)
	{
		return premisse.proposition.contains(p);
	}
	
	/*
	 * permet l'affichage de la règle sous la forme premisse => conclusion*/
	public String toString(){
		return premisse.toString()+" => "+this.conclusion;
	}
}
