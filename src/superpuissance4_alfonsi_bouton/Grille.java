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

//classe grille : modelise la grille de jeu de 6 lignes par 7 colonnes

public class Grille {//Attributs 
    Cellule [][] Cellules = new Cellule [6][7];
    
    Grille(){// tableau a double entree dans lequel on créé chaque cellule de la grille
            for (int i=0;i<6;i++){
                for (int j=0;j<7;j++){
                    Cellules[i][j]=new Cellule();
            }
        }
    }
    
// Methodes :
    
public boolean ajouterJetonDansColonne(Jeton par_jeton2, Joueur joueurcourant, int nbcolonne){
    if(colonneRemplie(nbcolonne)==true) {//si la colonne est remplie on ne peut pas rajouter de jeton
        return false;
    }
    int indice=5;// on ajoute le jeton dans la colonne ciblee sur la cellule vide la plus basse
    while(Cellules[indice][nbcolonne].jetonCourant!=null){
        indice--;
    }
    Cellules[indice][nbcolonne].jetonCourant=par_jeton2;
    if(Cellules[indice][nbcolonne].presenceDesintegrateur()){
        Cellules[indice][nbcolonne].recupererDesintegrateur();
        joueurcourant.obtenirDesintegrateur();// si le jeton se retrouve sur la cellule d'un desintegrateur, le joueurr le recupere
        
    }
    if(Cellules[indice][nbcolonne].presenceTrouNoir()){
        Cellules[indice][nbcolonne].activerTrouNoir();// si le jeton se retrouve sur la case d'un trou noir il disparait et la cellule devient vide
        
    }
    return true;
}

public boolean etreRemplie(){// verifie si la grille est pleine et renvoie true si c'est le cas
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            if (Cellules[i][j].jetonCourant==null){
                return false;
            }
        }
    }return true;
}

public void viderGrille(){
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            
            Cellules[i][j].jetonCourant=null;// supprime les jetons
            if (Cellules[i][j].presenceTrouNoir()==true){// supprime les trous noirs
                Cellules[i][j].trouNoir=false;
            }
            if (Cellules[i][j].presenceDesintegrateur()==true){// supprime les desintegrateurs
                Cellules[i][j].desintegrateur=false;
            } 
        }
    }
}

public void afficherGrilleSurConsole(){
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            
            if (Cellules[i][j].trouNoir==true){
                System.out.print(" T ");// represente les cases avec un trou noir dans la grille
            }
            else if (Cellules[i][j].desintegrateur==true){
                System.out.print(" D ");// represente les cases avec un desintegrateur dans la grille
            }
            else if (Cellules[i][j].jetonCourant==null){
                System.out.print(" N ");// represente les cases vides
            }
            else{
                System.out.print(Cellules[i][j].jetonCourant);// represente les cases avec les jetons rouges ou jaunes
            }
        }
        System.out.println();
    }
}
public boolean celluleOccupee(int var1,int var2){
    if (Cellules[var1][var2].jetonCourant!=null){
        return true;// la cellule de coordonnees données est occupe par un jeton
    }
        return false;

}

public String lireCouleurDuJeton(int a,int b){
    
    return Cellules[a][b].lireCouleurDuJeton();// renvoie la couleur du jeton de la cellule cible
    
}

public boolean etreGagnantePourJoueur(Joueur nom){
     
    String recup_couleur=nom.Couleur;   
    for (int i=0;i<3;i++){// 4 jetons de la meme couleur sur la meme ligne
        for (int j=0;j<7;j++){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i+1][j].lireCouleurDuJeton()) && (Cellules[i+1][j].lireCouleurDuJeton()).equals(Cellules[i+2][j].lireCouleurDuJeton()) && (Cellules[i+2][j].lireCouleurDuJeton()).equals(Cellules[i+3][j].lireCouleurDuJeton())&& Cellules[i+1][j].lireCouleurDuJeton().equals(recup_couleur)){
                return true;
            }
        }
    }
    for (int i=0;i<6;i++){// 4 jetons de la meme couleur sur la meme colonne
        for (int j=0;j<4;j++){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i][j+1].lireCouleurDuJeton()) && (Cellules[i][j+1].lireCouleurDuJeton()).equals(Cellules[i][j+2].lireCouleurDuJeton()) && (Cellules[i][j+2].lireCouleurDuJeton()).equals(Cellules[i][j+3].lireCouleurDuJeton()) && Cellules[i][j+2].lireCouleurDuJeton().equals(recup_couleur) ){
                return true;
            }
        }
    }
    for (int i=0;i<3;i++){// 4 jetons de la meme couleur en diagonal 
        for (int j=0;j<4;j++){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i+1][j+1].lireCouleurDuJeton()) && (Cellules[i+1][j+1].lireCouleurDuJeton()).equals(Cellules[i+2][j+2].lireCouleurDuJeton()) && (Cellules[i+2][j+2].lireCouleurDuJeton()).equals(Cellules[i+3][j+3].lireCouleurDuJeton())&& Cellules[i+2][j+2].lireCouleurDuJeton().equals(recup_couleur)){
                return true;
            }
        }
    }
    for (int i=0;i<3;i++){// 4 jetons de la meme couleur en diagonal
        for (int j=6;j>3;j--){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i+1][j-1].lireCouleurDuJeton()) && (Cellules[i+1][j-1].lireCouleurDuJeton()).equals(Cellules[i+2][j-2].lireCouleurDuJeton()) && (Cellules[i+2][j-2].lireCouleurDuJeton()).equals(Cellules[i+3][j-3].lireCouleurDuJeton())&&Cellules[i][j].lireCouleurDuJeton().equals(recup_couleur)){
                return true;
            } 
        }
    }
    return false;
}   

public void tasserGrille(int a,int b){
// lorsqu'un jeton est capture ou detruit, cette methode tasse la grille en decalant de une ligne les jetons situes au dessus de la cellule liberee    
    while (a>0){
        Cellules[a][b].jetonCourant=Cellules[a-1][b].jetonCourant;
        a=a-1;
         
    }
    Cellules[0][b].jetonCourant=null;
    
}

public boolean colonneRemplie(int a){
    if (Cellules[0][a].jetonCourant==null){
        return false;
    }else{
        return true;
    }
        
    
}
public boolean placerDesintegrateur(int a,int b){
    if (Cellules[a][b].presenceDesintegrateur()==false){
        Cellules[a][b].placerDesintegrateur();
        return true;// ajoute un desintegrateur a l'endroit indique s'il n'en existe pas deja un
    }
    else{
        return false;
    }
    
}
public boolean placerTrouNoir(int a,int b){
    if (Cellules[a][b].presenceTrouNoir()==false){
        Cellules[a][b].placerTrouNoir();
        return true;// ajoute un trou noir a l'endroit indique s'il n'en existe pas deja un
    }
    else{
        return false;
    }
    
}
public boolean supprimerJeton(int a,int b){
    if (Cellules[a][b].supprimerJeton()==true){
        return true;// supprime le jeton de la cellule visée
    }
    else{
        return false;
    }
}

public Jeton recupererJeton(int a, int b){
    return Cellules[a][b].recupererJeton();
}// enleve le jeton de la cellule visee et renvoie une reference vers ce jeton
}

