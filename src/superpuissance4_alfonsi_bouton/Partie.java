
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
        System.out.println(joueurCourant.Nom+", c'est ton tour!");
        System.out.println("Il te reste "+joueurCourant.nombreJetonsRestants+" jetons");
        System.out.println("Tu as "+joueurCourant.nombreDesintegrateurs+" désintégrateurs");
        System.out.println("Que voulez vous faire?");
        System.out.println("1/ placer un jeton");
        System.out.println("2/ désintégrer un jeton");
        System.out.println("3/ récupérer un jeton ");
        choix = sc.nextInt(); 
            switch (choix) {
                case 1 :
                    
                    if (joueurCourant.nombreJetonsRestants==0){
                        System.out.println("Vous n'avez plus de jeton, veuillez saisir une autre action à effectuer");
                        break;
                    }
                    System.out.println("Veuillez saisir la colonne où vous voulez ajouter le jeton");
                    int colonne = sc.nextInt();
                    while (colonne<1||colonne>7){
                        System.out.println("Cette colonne n'existe pas, veuillez saisir une colonne valide");
                        colonne = sc.nextInt();
                    }
                    while(grillepuissance4.colonneRemplie(colonne-1)){
                        System.out.println("Cette colonne est pleine, veuillez saisir une colonne où vous pouvez jouer");
                        colonne = sc.nextInt();
                    }
                    grillepuissance4.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1], joueurCourant,colonne-1);
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
                    if (joueurCourant.nombreDesintegrateurs==0){
                        System.out.println("Vous n'avez pas de désintégrateur, veuillez saisir une autre action à effectuer");
                        break;
                    }
                    
                    System.out.println("Saisir la ligne du jeton que vous voulez désintégrer");
                    int lignedesintegrer = sc.nextInt();
                    while (lignedesintegrer<1||lignedesintegrer>6){
                        System.out.println("Cette ligne n'existe pas, veuillez saisir une colonne valide");
                        lignedesintegrer = sc.nextInt();
                    }
                    System.out.println("Saisir la colonne du jeton que vous voulez désintégrer");
                    int colonnedesintegrer = sc.nextInt();
                    while (colonnedesintegrer<1||colonnedesintegrer>7){
                        System.out.println("Cette colonne n'existe pas, veuillez saisir une colonne valide");
                        colonnedesintegrer = sc.nextInt();
                    }
                    joueurCourant.utiliserDesintegrateur();
                    grillepuissance4.supprimerJeton(lignedesintegrer-1, colonnedesintegrer-1);
                    while (grillepuissance4.supprimerJeton(lignedesintegrer-1, colonnedesintegrer-1)==false){
                        System.out.println("Veuillez saisir une cellule où un jeton est présent");
                        lignedesintegrer = sc.nextInt();
                        colonnedesintegrer = sc.nextInt();
                    }
                    grillepuissance4.tasserGrille(lignedesintegrer-1, colonnedesintegrer-1);
                    grillepuissance4.afficherGrilleSurConsole();
                    if (joueurCourant==ListeJoueurs[0]){
                        joueurCourant=ListeJoueurs[1];
                    }
                    else{
                        joueurCourant=ListeJoueurs[0];
                    }
                    break;
                case 3 :
                    if (joueurCourant.nombreJetonsRestants==21){
                        System.out.println("Vous avez tout vos jetons, veuillez saisir une autre action à effectuer");
                        break;
                    }
                    System.out.println("Saisir la ligne du jeton que vous voulez récupérer");
                    int lignederecuperation = sc.nextInt();
                    while (lignederecuperation<1||lignederecuperation>6){
                        System.out.println("Cette ligne n'existe pas, veuillez saisir une colonne valide");
                        lignederecuperation = sc.nextInt();
                    }
                    System.out.println("Saisir la colonne du jeton que vous voulez récupérer");
                    int colonnederecuperation = sc.nextInt();
                    while (colonnederecuperation<1||colonnederecuperation>7){
                        System.out.println("Cette colonne n'existe pas, veuillez saisir une colonne valide");
                        colonnederecuperation = sc.nextInt();
                    }
                    Jeton jeton_a_recuperer=grillepuissance4.recupererJeton(lignederecuperation-1, colonnederecuperation-1);
                    grillepuissance4.supprimerJeton(lignederecuperation-1, colonnederecuperation-1);
                    grillepuissance4.tasserGrille(lignederecuperation-1, colonnederecuperation-1);
                    
                    break;
                    
            }
    }while (grillepuissance4.etreGagnantePourJoueur(ListeJoueurs[0])==false&&grillepuissance4.etreGagnantePourJoueur(ListeJoueurs[1])==false&&grillepuissance4.etreRemplie()==false);
    if (grillepuissance4.etreGagnantePourJoueur(ListeJoueurs[1])==true){
        System.out.println(ListeJoueurs[1].Nom+" a gagné");
        
    }
    if (grillepuissance4.etreGagnantePourJoueur(ListeJoueurs[0])==true){
        System.out.println(ListeJoueurs[0].Nom+" a gagné");
    }
}
}
