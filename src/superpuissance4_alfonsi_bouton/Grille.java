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
public class Grille {
    Cellule [][] Cellules = new Cellule [6][7];
    
    Grille(){
            for (int i=0;i<6;i++){
                for (int j=0;j<7;j++){
                    Cellules[i][j]=new Cellule();
            }
        }
    }
public boolean ajouterJetonDansColonne(Jeton par_jeton2, Joueur joueurcourant, int nbcolonne){
    if(colonneRemplie(nbcolonne)==true) {
        return false;
    }
    int indice=5;
    while(Cellules[indice][nbcolonne].jetonCourant!=null){
        indice--;
    }
    Cellules[indice][nbcolonne].jetonCourant=par_jeton2;
    if(Cellules[indice][nbcolonne].presenceDesintegrateur()){
        Cellules[indice][nbcolonne].recupererDesintegrateur();
        joueurcourant.obtenirDesintegrateur();
        
    }
    if(Cellules[indice][nbcolonne].presenceTrouNoir()){
        Cellules[indice][nbcolonne].activerTrouNoir();
        
    }
    return true;
}

public boolean etreRemplie(){
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
            Cellules[i][j].jetonCourant=null;
                
            
        }
    }
}

public void afficherGrilleSurConsole(){
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            
            if (Cellules[i][j].trouNoir==true){
                System.out.print(" T ");
            }
            else if (Cellules[i][j].desintegrateur==true){
                System.out.print(" D ");
            }
            else if (Cellules[i][j].jetonCourant==null){
                System.out.print(" N ");
            }
            else{
                System.out.print(Cellules[i][j].jetonCourant);
            }
        }
        System.out.println();
    }
}
public boolean celluleOccupee(int var1,int var2){
    if (Cellules[var1][var2].jetonCourant!=null){
        return true;
    }
        return false;

}

public String lireCouleurDuJeton(int a,int b){
    
    return Cellules[a][b].lireCouleurDuJeton();
    
}

public boolean etreGagnantePourJoueur(Joueur nom){
     
    String recup_couleur=nom.Couleur;   
    for (int i=0;i<3;i++){
        for (int j=0;j<7;j++){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i+1][j].lireCouleurDuJeton()) && (Cellules[i+1][j].lireCouleurDuJeton()).equals(Cellules[i+2][j].lireCouleurDuJeton()) && (Cellules[i+2][j].lireCouleurDuJeton()).equals(Cellules[i+3][j].lireCouleurDuJeton())&& Cellules[i+1][j].lireCouleurDuJeton().equals(recup_couleur)){
                return true;
            }
        }
    }
    for (int i=0;i<6;i++){
        for (int j=0;j<4;j++){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i][j+1].lireCouleurDuJeton()) && (Cellules[i][j+1].lireCouleurDuJeton()).equals(Cellules[i][j+2].lireCouleurDuJeton()) && (Cellules[i][j+2].lireCouleurDuJeton()).equals(Cellules[i][j+3].lireCouleurDuJeton()) && Cellules[i][j+2].lireCouleurDuJeton().equals(recup_couleur) ){
                return true;
            }
        }
    }
    for (int i=0;i<3;i++){
        for (int j=0;j<4;j++){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i+1][j+1].lireCouleurDuJeton()) && (Cellules[i+1][j+1].lireCouleurDuJeton()).equals(Cellules[i+2][j+2].lireCouleurDuJeton()) && (Cellules[i+2][j+2].lireCouleurDuJeton()).equals(Cellules[i+3][j+3].lireCouleurDuJeton())&& Cellules[i+2][j+2].lireCouleurDuJeton().equals(recup_couleur)){
                return true;
            }
        }
    }
    for (int i=0;i<3;i++){
        for (int j=6;j>3;j--){
            if((Cellules[i][j].lireCouleurDuJeton()).equals(Cellules[i+1][j-1].lireCouleurDuJeton()) && (Cellules[i+1][j-1].lireCouleurDuJeton()).equals(Cellules[i+2][j-2].lireCouleurDuJeton()) && (Cellules[i+2][j-2].lireCouleurDuJeton()).equals(Cellules[i+3][j-3].lireCouleurDuJeton())&&Cellules[i][j].lireCouleurDuJeton().equals(recup_couleur)){
                return true;
            } 
        }
    }
    return false;
}   

public void tasserGrille(int a,int b){
    
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
        return true;
    }
    else{
        return false;
    }
    
}
public boolean placerTrouNoir(int a,int b){
    if (Cellules[a][b].presenceTrouNoir()==false){
        Cellules[a][b].placerTrouNoir();
        return true;
    }
    else{
        return false;
    }
    
}
public boolean supprimerJeton(int a,int b){
    if (Cellules[a][b].supprimerJeton()==true){
        return true;
    }
    else{
        return false;
    }
}

public Jeton recupererJeton(int a, int b){
    return Cellules[a][b].recupererJeton();
}
}

