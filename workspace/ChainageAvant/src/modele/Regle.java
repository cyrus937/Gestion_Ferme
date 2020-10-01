package modele;

/*
 * cette classe permet de cr�er nos diff�rentes r�gles de la base de
 * connaissance*/
public class Regle {
	
	Premisse premisse ;
	String conclusion;
	
	/*
	 * constructeur de la r�gle � partir de la pr�misse et de la conclusion*/
	public Regle (Premisse premisse, String conclusion) {
		this.conclusion = conclusion;
		this.premisse = premisse;
	}
	
	/*
	 * permet de compter le nombre de proposition dans la pr�misse
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
	 * permet l'affichage de la r�gle sous la forme premisse => conclusion*/
	public String toString(){
		return premisse.toString()+" => "+this.conclusion;
	}
}
