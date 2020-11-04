
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpuissance4_alfonsi_bouton;

import java.util.Random;
import java.util.Scanner;

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
    Scanner sc = new Scanner(System.in);
    Random generateurAleat = new Random();
    
    System.out.println("saisir pseudo J1 : ");
    Joueur joueur1=new Joueur(sc.nextLine());
    System.out.println("saisir pseudo J2 : ");
    Joueur joueur2=new Joueur(sc.nextLine());
    ListeJoueurs[0]=joueur1;
    ListeJoueurs[1]=joueur2;
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
        joueur1.ajouterJeton(new Jeton(joueur1.Couleur));
        joueur2.ajouterJeton(new Jeton(joueur2.Couleur));
        
    }
    
    joueurCourant=joueur1;
    grillepuissance4.afficherGrilleSurConsole();
}
public void debuterPartie(){
    initialiserPartie();
    int choix;
    Scanner sc = new Scanner(System.in);
    do{
        System.out.println(joueurCourant.nombreJetonsRestants);
        System.out.println("Que voulez vous faire?");
        System.out.println("1/ placer un jeton");
        System.out.println("2/ désintégrer un jeton");
        System.out.println("3/ récupérer un jeton ");
        choix = sc.nextInt(); 
            switch (choix) {
                case 1 :
                    int colonne = sc.nextInt();
                   
                    grillepuissance4.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1], colonne-1);
                    joueurCourant.nombreJetonsRestants=joueurCourant.nombreJetonsRestants-1;
                    System.out.println(joueurCourant.nombreJetonsRestants);
                    grillepuissance4.afficherGrilleSurConsole();
                    break;
            }
    }while (choix==1);
}
}
