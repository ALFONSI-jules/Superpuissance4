/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpuissance4_alfonsi_bouton;

/**
 *
 * @author jalfonsi
 */
public class Jeton {
    String Couleur;

public Jeton(String par_couleur1){
    Couleur=par_couleur1;
}    

public String lireCouleur(){
    return Couleur;
}
@Override
public String toString() {
    String chaine_a_retourner ;
    if("rouge".equals(Couleur)){
        chaine_a_retourner="\u001B[31m"+" R "+"\u001B[0m"; 
    }
    else if ("jaune".equals(Couleur)){
        chaine_a_retourner=" J ";   
    }
    else{
        chaine_a_retourner=" A ";
    }
    return chaine_a_retourner;
}
}
