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

// classe cellule : decrit une des 42 cases de la grille
public class Cellule {//Attributs
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
// Methodes :
    
public Cellule(){// constructeur
    jetonCourant=null;
    trouNoir = false;
    desintegrateur=false;
}

public boolean affecterJeton(Jeton par_jeton1){
    if (jetonCourant !=null){// jeton deja present
        return false;
    }else{// ajoute le jeton en parametre a la cellule
        jetonCourant=par_jeton1;
        return true;
    }   
}
public Jeton recupererJeton(){
    return jetonCourant;
}

public boolean supprimerJeton(){
    if (jetonCourant == null){// pas de jetons present
        return false;
    }
    else{// supprime le jeton
        jetonCourant=null;
        return true;
    }
}
public boolean placerTrouNoir(){
    if (trouNoir==true){// trou noir deja present
        return false;
    }
    else{// place un trou noir
        trouNoir=true;
        return true;
    }
}
public boolean placerDesintegrateur(){
    if(desintegrateur==true){// desintegrateur deja present
        return false;
    }
    else{// place un desintegrateur
        desintegrateur=true;
        return true;
    }
}
public boolean presenceTrouNoir(){
    if (trouNoir==true){
        return true;
    }else{
        return false;
    }
        
}
public boolean presenceDesintegrateur(){
    if (desintegrateur==true){
        return true;
    }else{
        return false;
    }
        
}
public String lireCouleurDuJeton(){
    if (jetonCourant==null){ // Si pas de jetons, il n'y a pas de couleurs et on renvoie "pas de jeton"
        return "pas de jeton";
    }
    return jetonCourant.lireCouleur(); //Sinon, on renvoie la couleur du jeton présent
}

public boolean recupererDesintegrateur(){
    if (desintegrateur==false){
        return false;
    }
    else{
        desintegrateur=false;
        return true;
    }
}

public boolean activerTrouNoir(){
    if (trouNoir==false){
        return false;
    }
    else{
        trouNoir=false;
        supprimerJeton();
        return true;
    }
}
}
