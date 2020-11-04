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
    
public boolean ajouterJetonDansColonne(Jeton par_jeton2, int nbcolonne){
    for (int i=0;i<6;i++){
        if (Cellules [i][nbcolonne]==null){
            Cellules[i][nbcolonne].affecterJeton(par_jeton2);
            return true;
        }
        
    } return false;
}

public boolean etreRemplie(){
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            if (Cellules[i][j]==null){
                return false;
            }
        }
    }return true;
}

public void viderGrille(){
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            Cellules[i][j]=null;
                
            
        }
    }
}

public void afficherGrilleSurConsole(){
    for (int i=0;i<6;i++){
        for (int j=0;j<7;j++){
            if (Cellules[i][j].desintegrateur==true){
                System.out.print("D");
            }
            else if (Cellules[i][j].trouNoir==true){
                System.out.print("TN");
            }
            else if (Cellules[i][j].jetonCourant==null){
                System.out.print("N");
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
    
    return Cellules[a][b].jetonCourant.lireCouleur();
    
}

public boolean etreGagnantePourJoueur(Joueur nom){
    for (int i=0;i<3;i++){
        for (int j=0;j<7;j++){
            if(lireCouleurDuJeton(i,j).equals(lireCouleurDuJeton(i+1,j)) && lireCouleurDuJeton(i+1,j).equals(lireCouleurDuJeton(i+2,j)) && lireCouleurDuJeton(i+2,j).equals(lireCouleurDuJeton(i+3,j))){
                return true;
            }
        }
    }
    for (int i=0;i<6;i++){
        for (int j=0;j<4;j++){
            if(lireCouleurDuJeton(i,j).equals(lireCouleurDuJeton(i,j+1)) && lireCouleurDuJeton(i,j+1).equals(lireCouleurDuJeton(i,j+2)) && lireCouleurDuJeton(i,j+2).equals(lireCouleurDuJeton(i,j+3))){
                return true;
            }
        }
    }
    for (int i=0;i<3;i++){
        for (int j=0;j<4;j++){
            if(lireCouleurDuJeton(i,j).equals(lireCouleurDuJeton(i+1,j+1)) && lireCouleurDuJeton(i+1,j+1).equals(lireCouleurDuJeton(i+2,j+2)) && lireCouleurDuJeton(i+2,j+2).equals(lireCouleurDuJeton(i+3,j+3))){
                return true;
            }
        }
    }
    for (int i=0;i<3;i++){
        for (int j=6;j>3;j--){
            if(lireCouleurDuJeton(i,j).equals(lireCouleurDuJeton(i+1,j-1)) && lireCouleurDuJeton(i+1,j-1).equals(lireCouleurDuJeton(i+2,j-2)) && lireCouleurDuJeton(i+2,j-2).equals(lireCouleurDuJeton(i+3,j-3))){
                return true;
            } 
        }
    }
    return false;
}   

public void tasserGrille(int a,int b){
    if (Cellules[a][b].activerTrouNoir()){
        while (a>0){
            Cellules[a][b]=Cellules[a-1][b];
            a=a-1;
         
        }
        Cellules[0][b]=null;
    }
}

public boolean colonneRemplie(int a){
    if (Cellules[0][a]==null){
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
    Jeton ref=Cellules[a][b].jetonCourant;
    Cellules[a][b].supprimerJeton();
    return ref;  
}
}

