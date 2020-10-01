package modele;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChainageAvant {
	
	//contindra notre base de close
	private ArrayList<String> bC = new ArrayList<String>();
	private ArrayList<Regle> baseRegles = new ArrayList<Regle>();
	private ArrayList<String> bf = new ArrayList<String>();
	private String p = new String();
	
	public static ArrayList<String> result = new ArrayList<String>();
	
	public ChainageAvant (String bC, String bf, String p)
	{
		this.bC.addAll(Arrays.asList(bC.split(",")));
		this.bf.addAll(Arrays.asList(bf.split(",")));
		this.p = p;
	}
			
	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public ArrayList<String> getbC() {
		return bC;
	}

	public void setbC(ArrayList<String> bC) {
		this.bC = bC;
	}

	public ArrayList<String> getBf() {
		return bf;
	}

	public void setBf(ArrayList<String> bf) {
		this.bf = bf;
	}
	
	/*
	 * cette methode permet d'obtenir l'ensemble des regles */
	public  void obtenirBaseRegle(){
		int n;
		
		for (String s: this.bC)
		{
			/*pour une chaine dans l'ArrayList on determine la position de l'implication > pour separer 
			 * la premisse de la conclusion et construire la regle puis l'ajouter dans la base
			*/
			if(s.length() == 1)
				this.bf.add(s);
			else
			{
				n = s.indexOf(">");
				this.baseRegles.add(new Regle(new Premisse(s.substring(0, n)),s.substring(n+1)));
			}
			
		}
	}
	
	/*
	 * la methode chainage avant proprement dite*/
	public  boolean chainageAvant()
	{
		//on initialise flag à faux
		boolean flag = false;
		boolean flag1 = false; 
		String p;
		String st = "";
		ArrayList<String> bf1 = new ArrayList<String>();
		//m représente la taille de notre base de règle
		// j va nous permettre de la parcourir
		int j=0, n, m = this.baseRegles.size();
		
		bf1.addAll(this.bf);
		//ceci represente la table de compteur
		ArrayList<Integer> nbrePropositions = new ArrayList<Integer>();
		
		//cet ArrayList me permettra d'implementer mon critère de choix
		ArrayList<Integer> critere = new ArrayList<Integer>();
		
		//cet ArrayList me permettra d'implementer mon critère de choix
		ArrayList<Integer> position = new ArrayList<Integer>();
		
		//on remplit notre table de compteur
		for (Regle r : this.baseRegles)
			nbrePropositions.add(r.compteur());
		
		critere.addAll(nbrePropositions);
		/*
		 * dans ma conception des choses je ne supprime pas les faits de la base de fait apres les avoir utilisé
		 * maintenat tant que i est inférieure à la taille de la base de fait*/
		while (!this.bf.isEmpty() && flag == false)
		{
			//on une proposition de la base de fait 
			p = this.bf.get(0);
	
			result.add("La base de fait est constituée de(s) élément(s) :"+bf.toString());
			result.add("Nous utilisons le fait "+p);
			
			//on affiche pour voir l'état de la base de fait
			System.out.println("Faits : "+this.bf);
		
			//si cette proposition est egale à q ie si q est dans la base de fait c'est gagne
			if (p.equals(this.p))
			{
				flag = true;
			}
			else
			{
				/*
				 * tant qu'on arrive pas a la derniere regle on continue*/
				while (j != m) {
					
					/*si la premisse contient p on retire cette propositionde la premisse
					 * et on décremente le niombre de proposition dans cette premisse 
					 */
					if (this.baseRegles.get(j).contient(p)) {
						n = nbrePropositions.get(j);
						nbrePropositions.set(j, n - 1);
					}
					
					/*
					 * si le nombre de proposition de la premisse est egale à zero on ajoute la conclusion
					 * dans la base de fait
					 * si ce n'est pas le cas on fait passer j à la règle suivante*/
					if (nbrePropositions.get(j) == 0) {
						flag1 = true;
						/*
						 * on l'ajoute uniquement si elle ne contient pas deja cette proposition*/
						if (!bf1.contains(this.baseRegles.get(j).conclusion)) 
						{		
							position.add(j);
						}
						
					}
					
					j++;
				}
				
				if (flag1) {
					
					int max = Max(position, critere);
					
					result.add("Nous prenons la règle :");
					
					result.add((this.baseRegles).get(max).toString());
					if (!bf1.contains(this.baseRegles.get(max).conclusion)) {
						st = st + "Nous avons la proposition " + this.baseRegles.get(max).conclusion
								+ " comme nouveau fait,";
						bf.add(this.baseRegles.get(max).conclusion);
						bf1.add(this.baseRegles.get(max).conclusion);
					}
				}
				position.clear();
			}
			//on remet j à 0 pour reparcourir notre bR apres la selection d'une nouvelle proposition dans le bF
			j = 0;
			
			//on retire le fait utilisé
			bf.remove(0);
			
			result.add(st);
			st = "";
		}
		result.add(String.valueOf(flag));
		
		//et enfin on retourne flag
		return flag;
	}
	
	/*
	 * cette fonction retourne la position de la règle comportant le plus grand nombre
	 * de prémisse*/
	public int Max(ArrayList<Integer> position, ArrayList<Integer> propositions )
	{
		int M = 0, max = 1;
		
		for(Integer pos : position)
		{
			if(max < propositions.get(pos))
			{
				max = propositions.get(pos);
				M = pos;
			}
		}
		return M;
	}
}
