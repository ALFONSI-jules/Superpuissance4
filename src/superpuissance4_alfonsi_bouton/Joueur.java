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
// classe joueur : décrit un joueur

public class Joueur {//Attributs
    String Nom;
    String Couleur;
    Jeton [] ListeJetons = new Jeton [21];
    int nombreDesintegrateurs;
    int nombreJetonsRestants;
            
// Methodes :
    
public Joueur (String par_nom){// constructeur
    Nom=par_nom;
}

public void affecterCouleur(String par_couleur){
    Couleur=par_couleur;   
}

public boolean ajouterJeton(Jeton par_jeton){
    if (nombreJetonsRestants >=21){// on ne peut pas posseder plus de 21 jetons
        return false;
    }
    else{// ajoute le jeton passé en parametre a la liste des jetons
        ListeJetons[nombreJetonsRestants]=par_jeton ;
        nombreJetonsRestants++;
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
    else{//décrémente le nombre de désintégrateurs et confirme l’utilisation de ce dernier
        nombreDesintegrateurs=nombreDesintegrateurs-1;
        return true;    
    }
}

}
