/*
Alfonsi Jules
Bouton Claire
TP3 
 */
package superpuissance4_alfonsi_bouton;

/**
 *
 * @author jalfonsi
 */

//classe jeton :  décrit un jeton

public class Jeton {//Attribut
    String Couleur;
    
// Methodes :
    
public Jeton(String par_couleur1){//constructeur
    Couleur=par_couleur1;
}    

public String lireCouleur(){
    return Couleur;
}
@Override 
public String toString() {
    String chaine_a_retourner ;
    if("rouge".equals(Couleur)){// représente un jeton rouge
        chaine_a_retourner="\u001B[31m"+" R "+"\u001B[0m"; 
    }
    else if ("jaune".equals(Couleur)){//represente un jeton jaune
        chaine_a_retourner=" J ";   
    }
    else{// represente une case sans jeton 
        chaine_a_retourner=" A ";
    }
    return chaine_a_retourner;
}
}
