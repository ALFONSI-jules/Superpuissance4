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
public class Joueur {
    String Nom;
    String Couleur;
    Jeton [] ListeJetons = new Jeton [21];
    int nombreDesintegrateurs;
    int nombreJetonsRestants;
            
    
public Joueur (String par_nom){
    Nom=par_nom;
}

public void affecterCouleur(String par_couleur){
    Couleur=par_couleur;   
}

public boolean ajouterJeton(Jeton par_jeton){
    if (nombreJetonsRestants >=21){
        return false;
    }
    else{
        ListeJetons[nombreJetonsRestants]=par_jeton ;
        return true;
    }
        
        
}

public void obtenirDesintegrateur(){
    nombreDesintegrateurs=nombreDesintegrateurs+1;
    
}

public boolean utiliserDesintegrateur(){
    if (nombreDesintegrateurs==0){
        return false;
    }
    else{
        nombreDesintegrateurs=nombreDesintegrateurs-1;
        return true;
    }
} 
}
