package modele;
import java.util.*;

/*
 * cette classe permet la cr�ation des pr�misse*/
public class Premisse {

	//cette variable va contenir les diff�rente propositon contenu dans la pr�misse
	ArrayList <String> proposition = new ArrayList<String>();
	
	//constructeur de la pr�misse � partir d'une chaine de caract�re
	public Premisse (String p) {
		/*
		 * vu que la chaine vient sous la forme A&B,
		 * la fonction split("&") permet de retire le caract�re & de la chaine
		 * la fonction asList(param) me permet d'avoir une ArrayList contenant un caract�re dans chaque case*/
		this.proposition.addAll(Arrays.asList(p.split("&")));
	}
	
	//retourne le nombre de proposition de la pr�misse
	public int nbreProposition (){
		return this.proposition.size();
	}
	
	//l'affichage sous la forme A&B par exemple
	public String toString ()
	{
		int n = proposition.size();
		
		String result;
		
			result = "";
			for (String p : this.proposition) {
				if (n != 1 && n != proposition.size()) {
					result += p + " & ";
					n--;
				} 
				else if ( n == proposition.size() && n !=1)
				{
					result += p + " & ";
					n--;
				}
				else
					result += p;
			} 
			
		return result;
	}
}
