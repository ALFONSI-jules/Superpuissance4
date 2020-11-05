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
public class Cellule {
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
public Cellule(){
    jetonCourant=null;
    trouNoir = false;
    desintegrateur=false;
}

public boolean affecterJeton(Jeton par_jeton1){
    if (jetonCourant !=null){
        return false;
    }else{
        jetonCourant=par_jeton1;
        return true;
    }
    
}
public Jeton recupererJeton(){
    return jetonCourant;
}

public boolean supprimerJeton(){
    if (jetonCourant == null){
        return false;
    }
    else{
        jetonCourant=null;
        return true;
    }
}
public boolean placerTrouNoir(){
    if (trouNoir==true){
        return false;
    }
    else{
        trouNoir=true;
        return true;
    }
}
public boolean placerDesintegrateur(){
    if(desintegrateur==true){
        return false;
    }
    else{
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
    if (jetonCourant==null){
        return "pas de jeton";
    }
    return jetonCourant.lireCouleur();
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
