
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
    grillepuissance4.viderGrille();
    Scanner sc = new Scanner(System.in);
    Random generateurAleat = new Random();
    
    System.out.println("saisir pseudo J1 : ");
    Joueur joueur1=new Joueur(sc.nextLine());
    System.out.println("saisir pseudo J2 : ");
    Joueur joueur2=new Joueur(sc.nextLine());
    ListeJoueurs[0]=joueur1;
    ListeJoueurs[1]=joueur2;
    for (int i=1; i<4;i++){
        int ligne_aleat=generateurAleat.nextInt(5);
        int colonne_aleat=generateurAleat.nextInt(6);
        grillepuissance4.placerTrouNoir(ligne_aleat, colonne_aleat);
    }
    for (int i=0;i<5;i++){
        int ligne_aleat1=generateurAleat.nextInt(5);
        int colonne_aleat1=generateurAleat.nextInt(6);
        grillepuissance4.placerDesintegrateur(ligne_aleat1, colonne_aleat1);
    }
    attribuerCouleursAuxJoueurs();
    for (int i=0;i<21;i++){
        joueur1.ajouterJeton(new Jeton(joueur1.Couleur));
        
        joueur2.ajouterJeton(new Jeton(joueur2.Couleur));
        
        
    }
    int nbaleatoire=generateurAleat.nextInt(2);
    if (nbaleatoire==0){
        joueurCourant=joueur1;
    }
    else{
        joueurCourant=joueur2;
    }
    
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
                    System.out.println("Veuillez saisir la colonne où vous voulez ajouter le jeton");
                    int colonne = sc.nextInt();
                    while(grillepuissance4.colonneRemplie(colonne-1)){
                        System.out.println("Veuillez saisir une colonne valide");
                        colonne = sc.nextInt();
                    }
                    grillepuissance4.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1], colonne-1);
                    joueurCourant.nombreJetonsRestants=joueurCourant.nombreJetonsRestants-1;
                    System.out.println(joueurCourant.nombreJetonsRestants);
                    grillepuissance4.afficherGrilleSurConsole();
                    if (joueurCourant==ListeJoueurs[0]){
                        joueurCourant=ListeJoueurs[1];
                    }
                    else{
                        joueurCourant=ListeJoueurs[0];
                    }
                    break;  
                case 2 :
                    System.out.println("Saisir la ligne du jeton que vous voulez désintégrer");
                    int lignedesintegrer = sc.nextInt();
                    System.out.println("Saisir la colonne du jeton que vous voulez désintégrer");
                    int colonnedesintegrer = sc.nextInt();
                    grillepuissance4.supprimerJeton(lignedesintegrer-1, colonnedesintegrer-1);
                    grillepuissance4.tasserGrille(lignedesintegrer-1, colonnedesintegrer-1);
                    grillepuissance4.afficherGrilleSurConsole();
                    break;
                case 3 :
                    joueurCourant.utiliserDesintegrateur();
                    
            }
    }while (choix==1 || choix ==2 || choix==3);
}
}
