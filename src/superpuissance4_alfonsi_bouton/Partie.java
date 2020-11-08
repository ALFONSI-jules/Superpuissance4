
/*
Alfonsi Jules
Bouton Claire
TP3 
 */
package superpuissance4_alfonsi_bouton;

import java.util.Random;
import java.util.Scanner;// permet la saisi par l'utilisateur

/**
 *
 * @author jalfonsi
 */

// classe partie : lie les objets entre eux

public class Partie {//Attributs
    Joueur [] ListeJoueurs= new Joueur [2];
    Grille grillepuissance4 = new Grille() ;
    Joueur joueurCourant;
    
// Methodes :
    
public void attribuerCouleursAuxJoueurs(){// attribue des couleurs aux joueurs
    Random generateurAleat = new Random();
    int nb_couleur_aleat=generateurAleat.nextInt(2);
    if (nb_couleur_aleat==0){// l'attribution des couleurs aux joueurs est aleatoire
        ListeJoueurs[0].affecterCouleur("rouge");
        ListeJoueurs[1].affecterCouleur("jaune");
    }
    else{
        ListeJoueurs[1].affecterCouleur("rouge");
        ListeJoueurs[0].affecterCouleur("jaune");
        
    }
    
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
    int limite_desint=0;
    for (int i=0; i<5;i++){
        int ligne_aleat=generateurAleat.nextInt(5);
        int colonne_aleat=generateurAleat.nextInt(6);
        if (limite_desint<2){// place les 2 desintegrateurs cachés derrière 2 trous noirs
            if (grillepuissance4.Cellules[ligne_aleat][colonne_aleat].presenceDesintegrateur()==false){
                grillepuissance4.placerDesintegrateur(ligne_aleat, colonne_aleat);
                limite_desint=limite_desint+1;
            }
            else{
                i--;
            }
        }// place aleatoirement les trous noirs
        if (grillepuissance4.Cellules[ligne_aleat][colonne_aleat].presenceTrouNoir()==false){
            grillepuissance4.placerTrouNoir(ligne_aleat, colonne_aleat);
        }
        else{
            i--;
        }
            
        }
    for (int i=0;i<3;i++){// On place les 3 derniers desintegrateurs sur des cellules vides
        int ligne_aleat1=generateurAleat.nextInt(5);
        int colonne_aleat1=generateurAleat.nextInt(6);
        if (grillepuissance4.Cellules[ligne_aleat1][colonne_aleat1].presenceDesintegrateur()==false && grillepuissance4.Cellules[ligne_aleat1][colonne_aleat1].presenceTrouNoir()==false){
            grillepuissance4.placerDesintegrateur(ligne_aleat1, colonne_aleat1);
        }
        else{
            i--;
        }
    }
    attribuerCouleursAuxJoueurs();
    System.out.println("");
    System.out.println(joueur1.Nom+" possède les jetons de couleurs "+joueur1.Couleur);
    System.out.println(joueur2.Nom+" possède les jetons de couleurs "+joueur2.Couleur);
    System.out.println("");
    for (int i=0;i<21;i++){// creer les jetons et on les attribue aux joueurs
        joueur1.ajouterJeton(new Jeton(joueur1.Couleur));
        
        joueur2.ajouterJeton(new Jeton(joueur2.Couleur));
        
        
    }// On définit aléatoirement qui est le joueur qui commence
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
        System.out.println("");
        System.out.println(joueurCourant.Nom+", c'est ton tour!");
        System.out.println("");
        System.out.println("Il te reste "+joueurCourant.nombreJetonsRestants+" jetons");
        System.out.println("");
        System.out.println("Tu as "+joueurCourant.nombreDesintegrateurs+" désintégrateurs");
        System.out.println("");
        System.out.println("Que voulez vous faire?");
        System.out.println("1/ placer un jeton");
        System.out.println("2/ désintégrer un jeton");
        System.out.println("3/ récupérer un jeton ");
        choix = sc.nextInt(); 
            switch (choix) {// permet au joueur de choisir si il veut :
                case 1 :// placer un jeton
                    
                    if (joueurCourant.nombreJetonsRestants==0){
                        System.out.println("Vous n'avez plus de jeton, veuillez saisir une autre action à effectuer");
                        break;// le joueur ne peut pas placer de jetons si il n'en possede plus
                    }
                    System.out.println("Veuillez saisir la colonne où vous voulez ajouter le jeton");
                    int colonne = sc.nextInt();
                    while (colonne<1||colonne>7){//On vérifie que le joueur saisit une colonne qui existe
                        System.out.println("Cette colonne n'existe pas, veuillez saisir une colonne valide");
                        colonne = sc.nextInt();
                    }
                    while(grillepuissance4.colonneRemplie(colonne-1)){
                        System.out.println("Cette colonne est pleine, veuillez saisir une colonne où vous pouvez jouer");
                        colonne = sc.nextInt();
                    }// si le joueur peut placer le jeton dans la colonne choisi alors le jeton va occupé la cellule la plus basse, et non occupee par un autre jeton,de cette collone
                    grillepuissance4.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1], joueurCourant,colonne-1);
                    joueurCourant.nombreJetonsRestants=joueurCourant.nombreJetonsRestants-1;//On décrémente le nombre de jetons du joueur de 1
                    System.out.println(joueurCourant.nombreJetonsRestants);
                    grillepuissance4.afficherGrilleSurConsole();
                    if (joueurCourant==ListeJoueurs[0]){//On change le joueurCourant pour le prochain tour de jeu
                        joueurCourant=ListeJoueurs[1];
                        
                    }
                    else{
                        joueurCourant=ListeJoueurs[0];
                        
                    }
                    break;  
                case 2 :// desintegrer un jeton
                    if (joueurCourant.nombreDesintegrateurs==0){//Le joueur ne peut pas désintégrer de jeton sans désintégrateur.
                        System.out.println("Vous n'avez pas de désintégrateur, veuillez saisir une autre action à effectuer");
                        break;
                    }
                    
                    System.out.println("Saisir la ligne du jeton que vous voulez désintégrer");
                    int lignedesintegrer = sc.nextInt();
                    while (lignedesintegrer<1||lignedesintegrer>6){ //On vérifie que la ligne saisie existe
                        System.out.println("Cette ligne n'existe pas, veuillez saisir une ligne valide");
                        lignedesintegrer = sc.nextInt();
                    }
                    System.out.println("Saisir la colonne du jeton que vous voulez désintégrer");
                    int colonnedesintegrer = sc.nextInt();
                    while (colonnedesintegrer<1||colonnedesintegrer>7){//On vérifie que la colonne saisie existe
                        System.out.println("Cette colonne n'existe pas, veuillez saisir une colonne valide");
                        colonnedesintegrer = sc.nextInt();
                    }
                    joueurCourant.utiliserDesintegrateur();
                    // le joueur ne peut desintegrer qu'un jeton de la couleur advrese. On vérifie donc qu'il saisit une cellule ou un jeton adverse est présent.
                    while (joueurCourant.Couleur==grillepuissance4.lireCouleurDuJeton(lignedesintegrer-1, colonnedesintegrer-1)||grillepuissance4.supprimerJeton(lignedesintegrer-1, colonnedesintegrer-1)==false){
                        System.out.println("Veuillez saisir une cellule où un jeton adverse est présent");
                        
                        System.out.println("Saisir la ligne du jeton que vous voulez désintégrer");
                        lignedesintegrer = sc.nextInt();
                        while (lignedesintegrer<1||lignedesintegrer>6){// On revérifie que la ligne existe
                            System.out.println("Cette ligne n'existe pas, veuillez saisir une ligne valide");
                            lignedesintegrer = sc.nextInt();
                        }
                        System.out.println("Saisir la colonne du jeton que vous voulez désintégrer");
                        colonnedesintegrer = sc.nextInt();
                        while (colonnedesintegrer<1||colonnedesintegrer>7){//On revérifie que la colonne existe
                            System.out.println("Cette colonne n'existe pas, veuillez saisir une colonne valide");
                            colonnedesintegrer = sc.nextInt();
                        }
                    }// supprime le jeton et tasse la grille
                    grillepuissance4.supprimerJeton(lignedesintegrer-1, colonnedesintegrer-1);
                    grillepuissance4.tasserGrille(lignedesintegrer-1, colonnedesintegrer-1);
                    grillepuissance4.afficherGrilleSurConsole();
                    if (joueurCourant==ListeJoueurs[0]){//On change le joueurCourant pour le prochain tour
                        joueurCourant=ListeJoueurs[1];
                    }
                    else{
                        joueurCourant=ListeJoueurs[0];
                    }
                    break;
                case 3 :// recuperer un jeton
                    if (joueurCourant.nombreJetonsRestants==21){
                        System.out.println("Vous avez tout vos jetons, veuillez saisir une autre action à effectuer");
                        break;
                    }
                    System.out.println("Saisir la ligne du jeton que vous voulez récupérer");
                    int lignederecuperation = sc.nextInt();
                    while (lignederecuperation<1||lignederecuperation>6){//On vérifie que la ligne est valide
                        System.out.println("Cette ligne n'existe pas, veuillez saisir une ligne valide");
                        lignederecuperation = sc.nextInt();
                    }
                    System.out.println("Saisir la colonne du jeton que vous voulez récupérer");
                    int colonnederecuperation = sc.nextInt();
                    while (colonnederecuperation<1||colonnederecuperation>7){//On vérifie que la colonne est valide
                        System.out.println("Cette colonne n'existe pas, veuillez saisir une colonne valide");
                        colonnederecuperation = sc.nextInt();
                    }// le joueur ne peut recuperer qu'un jeton de sa couleur
                    while (grillepuissance4.lireCouleurDuJeton(lignederecuperation-1, colonnederecuperation-1)!=joueurCourant.Couleur||grillepuissance4.supprimerJeton(lignederecuperation-1, colonnederecuperation-1)==false){
                        System.out.println("Veuillez saisir une cellule contenant un de vos jetons");
                        System.out.println("Saisir la ligne du jeton que vous voulez récupérer");
                        lignederecuperation = sc.nextInt();
                        while (lignederecuperation<1||lignederecuperation>6){//On vérifie que la ligne est valide
                            System.out.println("Cette ligne n'existe pas, veuillez saisir une ligne valide");
                            lignederecuperation = sc.nextInt();
                        }
                        System.out.println("Saisir la colonne du jeton que vous voulez désintégrer");
                        colonnederecuperation = sc.nextInt();
                        while (colonnederecuperation<1||colonnederecuperation>7){//On vérifie que la colonne est valide
                            System.out.println("Cette colonne n'existe pas, veuillez saisir une colonne valide");
                            colonnederecuperation = sc.nextInt();
                        }
                    }
                    Jeton jeton_a_recuperer=grillepuissance4.recupererJeton(lignederecuperation-1, colonnederecuperation-1);
                    grillepuissance4.supprimerJeton(lignederecuperation-1, colonnederecuperation-1);
                    grillepuissance4.tasserGrille(lignederecuperation-1, colonnederecuperation-1);
                    joueurCourant.ajouterJeton(jeton_a_recuperer);
                    grillepuissance4.afficherGrilleSurConsole();
                    if (joueurCourant==ListeJoueurs[0]){//On change le joueur pour le prochain tour.
                        joueurCourant=ListeJoueurs[1];
                    }
                    else{
                        joueurCourant=ListeJoueurs[0];
                    }
                    break;
            }
    }while (grillepuissance4.etreGagnantePourJoueur(ListeJoueurs[0])==false&&grillepuissance4.etreGagnantePourJoueur(ListeJoueurs[1])==false&&grillepuissance4.etreRemplie()==false);//On répète la boucle tant qu'il n'y a pas de gagnats ou que la grille n'est pas pleine
    if (grillepuissance4.etreGagnantePourJoueur(ListeJoueurs[1])==true){
        System.out.println(ListeJoueurs[1].Nom+" a gagné");
        
    }
    if (grillepuissance4.etreGagnantePourJoueur(ListeJoueurs[0])==true){
        System.out.println(ListeJoueurs[0].Nom+" a gagné");
    }
}
}
