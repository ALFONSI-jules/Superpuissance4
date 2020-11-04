
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpuissance4_alfonsi_bouton;

import java.util.Random;

/**
 *
 * @author jalfonsi
 */
public class Partie {
    Joueur [] ListeJoueurs= new Joueur [2];
    Grille grillepuissance4 = new Grille() ;
    Joueur joueurCourant;
    
    
public void attribuerCouleursAuxJoueurs(){
    ListeJoueurs[0].affecterCouleur("rouge");
    ListeJoueurs[1].affecterCouleur("jaune");
}
public void initialiserPartie(){
    grillepuissance4.viderGrille();
    Random generateurAleat = new Random();
    
    for (int i=1; i<4;i++){
        int nbaleat1=generateurAleat.nextInt(5);
        int nbaleat2=generateurAleat.nextInt(6);
        grillepuissance4.placerTrouNoir(nbaleat1, nbaleat2);
    }
    for (int i=0;i<5;i++){
        int nbaleat1=generateurAleat.nextInt(5);
        int nbaleat2=generateurAleat.nextInt(6);
        grillepuissance4.placerDesintegrateur(nbaleat1, nbaleat2);
    }
    
    for (int i=0;i<21;i++){
        ListeJoueurs[0].ajouterJeton(new Jeton(ListeJoueurs[0].Couleur));
        ListeJoueurs[1].ajouterJeton(new Jeton(ListeJoueurs[1].Couleur));
        
    }
    grillepuissance4.afficherGrilleSurConsole();
}
public void debuterPartie(){
        
}
}
